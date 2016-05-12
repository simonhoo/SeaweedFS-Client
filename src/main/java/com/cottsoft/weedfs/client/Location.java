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
 * SeaweedFS Server Location data model.
 * @author  simon
 * @date    2015-8-12
 * @version v1.0.0
 */
public class Location implements Serializable{
	private static final long serialVersionUID = 552796864024183189L;

	private String publicUrl;
	
	private String url;
	
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
}


