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
import java.io.InputStream;


/**
 * Description：<br> 
 * SeaweedFS HTTP Client.
 * @author  simon
 * @date    2015-8-12
 * @version v1.0.0
 */
public class WeedfsClient {
	
	/**
	 * Description：<br> 
	 * Cache local file to WeedFS Server
	 * @version v1.0.0
	 * @param path
	 * @return
	 */
	public RequestResult cache(String path){
		RequestResult result = null;
		
		if (path == null || path.length() == 0) {
			throw new IllegalArgumentException("Path cannot be empty");
		}
		
		//TODO HTTP REQUEST
		
		return result;
	}
	
	/**
	 * Description：<br> 
	 * Get file from WeedFS Server
	 * @version v1.0.0
	 * @param fid
	 * @param path
	 * @return
	 */
	public RequestResult read(String fid, String path) {
		RequestResult result = null;
		
		if (fid == null || fid.length() == 0) {
			throw new IllegalArgumentException("FID cannot be empty");
		}
		
		if (path == null || path.length() == 0) {
			throw new IllegalArgumentException("Path cannot be empty");
		}
		
		//TODO HTTP REQUEST
		
		return result;
	}
	
	/**
	 * Description：<br> 
	 * This is overwrite method, Get file from WeedFS Server, return input stream.
	 * @version v1.0.0
	 * @param fid
	 * @param path
	 * @return
	 */
	public InputStream read(String fid) {
		BufferedReader in = null;
		if (fid == null || fid.length() == 0) {
			throw new IllegalArgumentException("FID cannot be empty");
		}
		
		//TODO HTTP REQUEST
		
		return null;
	}
	
	/**
	 * Description：<br> 
	 * Delete file from WeedFS Server
	 * @version v1.0.0
	 * @param fid
	 * @return
	 */
	public RequestResult delete(String fid) {
		RequestResult result = null;
		
		if (fid == null || fid.length() == 0) {
			throw new IllegalArgumentException("FID cannot be empty");
		}
		
		//TODO HTTP REQUEST
		
		return result;
	}

}


