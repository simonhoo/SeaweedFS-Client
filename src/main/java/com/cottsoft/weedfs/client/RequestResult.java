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
 * Request Result data model.
 * @author  simon
 * @date    2015-8-12
 * @version v1.0.0
 */
public class RequestResult implements Serializable {
	private static final long serialVersionUID = 8632768117381195417L;

	//Request Stauts.
	private boolean status;
	
	//File size
	private int size;
	
	//File ID
	private String fid;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("RequestResutl:[status=");
		sb.append(status);
		sb.append(", size=");
		sb.append(size);
		sb.append(", fid=");
		sb.append(fid);
		sb.append("]");
		
		return sb.toString();
	}
}


