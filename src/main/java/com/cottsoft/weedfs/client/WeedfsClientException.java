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
/**
 * Description：<br> 
 * SeaweedFS Client Exception.
 * @author  simon
 * @date    2015-8-12
 * @version v1.0.0
 */
public class WeedfsClientException extends Exception {
	private static final long serialVersionUID = -4541906285866843575L;

	public WeedfsClientException() {
		super();
	}

	public WeedfsClientException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WeedfsClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeedfsClientException(String message) {
		super(message);
	}

	public WeedfsClientException(Throwable cause) {
		super(cause);
	}
	
}


