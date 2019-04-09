/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package sm.hris.struts2.base;


import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

//import sm.hris.struts2.base.SmActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="loginx", location="/base/login", type="redirect")
@InterceptorRef(value="customStack")
@ParentPackage(value = "hris")

public class UnderConstruction extends ActionSupport {

    //private static final long serialVersionUID = 7353477345330099548L;
	//private Map<String, Object> sessionAttributes;

    public String execute() throws Exception {
        return SUCCESS;
    }
/*	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		// TODO Auto-generated method stub
		this.sessionAttributes = sessionAttr;
	}
*/
}
