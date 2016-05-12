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

import java.util.List;

/**
 * Description：<br> 
 * SeaweedFS Server Locations pool.
 * @author  simon
 * @date    2015-8-12
 * @version v1.0.0
 */
public class LocationPool {
	private List<Location> locationPool;

	public List<Location> getLocationPool() {
		return locationPool;
	}

	public void setLocationPool(List<Location> locationPool) {
		this.locationPool = locationPool;
	}
	
	public String getDefaultPublicUrl() throws WeedfsClientException{
		if(this.locationPool!=null && this.locationPool.size()>0){
			return this.locationPool.get(0).getPublicUrl();
		}else{
			throw new WeedfsClientException("The no Location in pool.");
		}
	}
}


