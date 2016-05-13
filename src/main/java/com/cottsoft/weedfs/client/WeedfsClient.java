/*
 * Copyright 2005-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 **************************************************************************
 * Date:       	    by:    		    Reason:   
 * 
 * 2015-8-12     	Simon.Hoo		Initial Version.
 *************************************************************************
 */
package com.cottsoft.weedfs.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * Description：<br>
 * SeaweedFS HTTP Client.
 * 
 * @author simon
 * @date 2015-8-12
 * @version v1.0.0
 */
public class WeedfsClient {
	private String masterHost = "127.0.0.1";
	private int masterPort = 9333;
	private String assign ="dir/assign";
	
	/**
	 * Description：<br>
	 * Cache local file to WeedFS Server
	 * 
	 * @version v1.0.0
	 * @param file
	 * @return
	 */
	public RequestResult cache(File file) {
		RequestResult result = null;
		Gson gson = new Gson();
		
		if (!file.exists()) {
			throw new IllegalArgumentException("File doesn't exist");
		}

		// HTTP REQUEST begin
		result = new RequestResult();
		WeedAssign assignedInfo = null;

		

		BufferedReader in = null;

		// 1. Send assign request and get fid
		try {
			StringBuffer host = new StringBuffer();
			host.append("http://");
			host.append(this.masterHost);
			host.append(":");
			host.append(this.masterPort);
			host.append("/");
			
			//HttpUtil.request("http://" + this.masterHost + ":" + this.masterPort+ "/", "dir/assign", "GET")
			in = new BufferedReader(new InputStreamReader(HttpUtil.request(host.toString(), assign, EHttpMethod.GET)));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			// format HTTP Response to Assigned Info.
			assignedInfo = gson.fromJson(response.toString(),WeedAssign.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				// close input stream.
				if (in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// 2. Send cache file request on volume server      
        FileBody fileBody = new FileBody(file, "text/plain");
        HttpClient client = new DefaultHttpClient();
        
        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        
        StringBuffer uri = new StringBuffer();
        uri.append("http://");
        uri.append(assignedInfo.getPublicUrl());
        uri.append("/");
        uri.append(assignedInfo.getFid());
        HttpPost post = new HttpPost(uri.toString());
        
        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        
        entity.addPart("fileBody", fileBody);
        post.setEntity(entity);
        
        try {
            // Add File char.
            String response = EntityUtils.toString(client.execute(post).getEntity(),"UTF-8");
            client.getConnectionManager().shutdown();
            
            FileResult fileResult = gson.fromJson(response, FileResult.class);
            
            result.setFid(assignedInfo.getFid());
            result.setSize(fileResult.getSize());
            result.setStatus(true);
            result.setFileUrl(uri.toString());
            return result;
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException(e.toString());
        }
	}
	
	/**
	 * Description：<br>
	 * Cache local file to WeedFS Server
	 * 
	 * @version v1.0.0
	 * @param path
	 * @return
	 */
	public RequestResult cache(String path) {
		if (path == null || path.length() == 0) {
			throw new IllegalArgumentException("Path cannot be empty");
		}

		// HTTP REQUEST begin
		File file = new File(path);
		
		if (!file.exists()) {
			throw new IllegalArgumentException("File doesn't exist");
		}else{
			return this.cache(file);
		}
	}

	/**
	 * Description：<br>
	 * Get file from WeedFS Server
	 * 
	 * @version v1.0.0
	 * @param fid
	 * @param path
	 * @return
	 */
	public RequestResult get(String fid) {
		RequestResult result = null;

		if (fid == null || fid.length() == 0) {
			throw new IllegalArgumentException("FID cannot be empty");
		}

		// HTTP REQUEST
		String volumnId = fid.split(",")[0];
		Location location = null;
        
        BufferedReader in = null;
        
        // 1. Get Volume address
        try {
        	//HttpUtil.request("http://" + this.masterHost + ":" + this.masterPort + "/","dir/assign?volumeId=" + volumnId, "GET")
        	StringBuffer host = new StringBuffer();
        	host.append("http://");
        	host.append(this.masterHost);
        	host.append(":");
        	host.append(this.masterPort);
        	host.append("/");
        	
        	StringBuffer requestURI = new StringBuffer();
        	requestURI.append(this.assign);
        	requestURI.append("?volumeId=");
        	requestURI.append(volumnId);
        	
            in = new BufferedReader(new InputStreamReader(HttpUtil.request(host.toString(), requestURI.toString(), EHttpMethod.GET)));
            
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            Gson gson = new Gson();
            location = gson.fromJson(response.toString(), Location.class);
            
            StringBuffer fileUrl = new StringBuffer();
            fileUrl.append("http://");
            fileUrl.append(location.getPublicUrl());
            fileUrl.append("/");
            fileUrl.append(fid);
            
            result = new RequestResult();
            
            result.setFid(fid);
            result.setStatus(true);
            result.setFileUrl(fileUrl.toString());
            
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
            	if(in!=null){
            		in.close();
            	}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		return result;
	}
	
	/**
	 * Description：<br>
	 * Get file from WeedFS Server, retunr input stream
	 * 
	 * @version v1.0.0
	 * @param fid
	 * @return
	 */
	public InputStream getInputStream(String fid) {
		RequestResult result = this.get(fid);
		return HttpUtil.request(result.getFileUrl(), EHttpMethod.GET);
	}

	
	/**
	 * Description：<br>
	 * Delete file from WeedFS Server
	 * 
	 * @version v1.0.0
	 * @param fid
	 * @return
	 */
	public RequestResult delete(String fid) {
		RequestResult result =  null;
		
        // Delete File from Volume Server
        try {
        	RequestResult fileGetResult = this.get(fid);
            HttpUtil.request(fileGetResult.getFileUrl(), EHttpMethod.DELETE);
            
            result = new RequestResult();
            result.setFid(fid);
            result.setFileUrl(fileGetResult.getFileUrl());
            result.setSize(fileGetResult.getSize());
            result.setStatus(true);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }

		return result;
	}

	public String getMasterHost() {
		return masterHost;
	}

	public void setMasterHost(String masterHost) {
		this.masterHost = masterHost;
	}

	public int getMasterPort() {
		return masterPort;
	}

	public void setMasterPort(int masterPort) {
		this.masterPort = masterPort;
	}

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

}
