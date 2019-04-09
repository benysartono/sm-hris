package sm.hris.struts2.base;


import java.io.File;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
//import com.opensymphony.xwork2.ActionSupport;

@Result(name="loginx", location="/base/login", type="redirect")
@InterceptorRef(value="customStack")
@ParentPackage(value = "hris")

public class SmFileUploadAction extends SmBaseAction{
    	private static final long serialVersionUID = 7353477345330099548L;

		private File userImage;

		private String userImageContentType;

		private String userImageFileName;

		public String execute()
		{
			return SUCCESS;
		}

		public File getUserImage() {
			return userImage;
		}

		public void setUserImage(File userImage) {
			this.userImage = userImage;
		}

		public String getUserImageContentType() {
			return userImageContentType;
		}

		public void setUserImageContentType(String userImageContentType) {
			this.userImageContentType = userImageContentType;
		}

		public String getUserImageFileName() {
			return userImageFileName;
		}

		public void setUserImageFileName(String userImageFileName) {
			this.userImageFileName = userImageFileName;
		}

	}