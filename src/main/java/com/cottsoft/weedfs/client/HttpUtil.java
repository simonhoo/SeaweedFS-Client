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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description：<br>
 * SeaweedFS HTTP Client.
 * 
 * @author simon
 * @date 2015-8-12
 * @version v1.0.0
 */
public class HttpUtil {
	
	/**
	 * Description：<br> 
	 * HTTP Request
	 * @author  simon
	 * @date    2016年5月13日
	 * @version v1.0.0
	 * @param host
	 * @param method
	 * @return
	 */
	public static InputStream request(String hostUrl, EHttpMethod method) {
		try {
			HttpURLConnection con = null;
			URL requestUrl = new URL(hostUrl);
			con = (HttpURLConnection) requestUrl.openConnection();

			// optional default is GET
			con.setRequestMethod(method.value());

			// add request header
			con.setRequestProperty("User-Agent", "");
			//int responseCode = con.getResponseCode();

			return con.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static InputStream request(String host, String requestURI, EHttpMethod method) {
		StringBuffer sb = new StringBuffer();
		sb.append(host.trim());
		sb.append(requestURI);
		return request(sb.toString(), method);
	}
}
