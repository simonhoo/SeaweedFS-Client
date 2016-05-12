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

import java.io.Serializable;

/**
 * Description：<br> 
 * SeaweedFS Assign.
 * @author  simon
 * @date    2015-8-12
 * @version v1.0.0
 */
public class WeedAssign implements Serializable{
	private static final long serialVersionUID = -7903648886453637770L;

	private int count;
	
	private String fid;
	
	private String publicUrl;
	
	private String url;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("WeedAssign:[count=");
		sb.append(count);
		sb.append(", fid=");
		sb.append(fid);
		sb.append(", publicUrl=");
		sb.append(publicUrl);
		sb.append(", url=");
		sb.append(url);
		sb.append("]");
		
		return sb.toString();
	}
	
	
}


