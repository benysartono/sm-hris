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


import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.ParentPackage;

import sm.hris.struts2.base.db.Menu;



@ParentPackage(value = "hris")

public class IndexAction extends SmBaseAction {

    private static final long serialVersionUID = 7353477345330099548L;
	private String userRole;
	private ArrayList<Menu> menus = new ArrayList<Menu>();

    public String execute() throws Exception {
    	super.listMenu();
    	menus = super.getMenus();
        //addActionError("A sample Action Error Message!!!");
        //addActionMessage("A sample Action Message.!!!");
        //addFieldError("error", "A sample Field Error!!!");
        return SUCCESS;
    }


	public ArrayList<Menu> getMenus(){
		return menus;
	}
    
    
    /*	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		// TODO Auto-generated method stub
		this.sessionAttributes = sessionAttr;
	}
*/
}
