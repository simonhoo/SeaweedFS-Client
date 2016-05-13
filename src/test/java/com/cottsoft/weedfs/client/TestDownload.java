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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description：<br>
 * Test
 * @author simon
 * @date 2015-8-12
 * @version v1.0.0
 */
public class TestDownload {

	public static void main(String[] args) {
		
		// These lines configuration with spring beans;
		WeedfsClient client = new WeedfsClient();
		client.setAssign("dir/assign");
		client.setMasterHost("10.50.130.79");
		client.setMasterPort(9333);
		
		InputStream in = null;
		BufferedOutputStream wr = null;
		String outPath = "/Users/simon/Documents/111.jpg";
		try{
			in = client.getInputStream("12,1af7e3749f");
			
			File output = new File(outPath);
			
			output.createNewFile();
            wr =  new BufferedOutputStream(new FileOutputStream(output));

            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                wr.write(buffer, 0 , len);
            }
		}catch(Exception e){
			e.printStackTrace();
		}finally {
            try {
                if (in != null && wr != null) {
                    in.close();
                    wr.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

	}

}


