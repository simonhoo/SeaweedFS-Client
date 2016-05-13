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

/**
 * Description：<br>
 * Test
 * @author simon
 * @date 2015-8-12
 * @version v1.0.0
 */
public class TestCache {

	public static void main(String[] args) {
		
		// These lines configuration with spring beans;
		WeedfsClient client = new WeedfsClient();
		client.setAssign("dir/assign");
		client.setMasterHost("10.50.130.79");
		client.setMasterPort(9333);
		
		RequestResult result = client.cache("/Users/simon/Documents/qrcode_for_gh_b13e31519b38_1280.jpg");
		
		System.out.println(result.toString());

	}

}


