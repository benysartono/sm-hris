package sm.hris.struts2.base.db;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;

public class BuyerSpec {

	private String idBuyer; 									
	private String idSpec; 				
	
	
	public String getIdBuyer(){
		return idBuyer;
	}
	
	public void setIdBuyer(String idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getIdSpec(){
		return idSpec;
	}
	
	public void setIdSpec(String idSpec) {
		this.idSpec = idSpec;
	}

	
}
