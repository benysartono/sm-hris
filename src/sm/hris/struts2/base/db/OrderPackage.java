package sm.hris.struts2.base.db;

import java.util.Date;
import java.io.File;
import org.apache.commons.codec.digest.DigestUtils;

public class OrderPackage {

	private String label; 									
	private String tag; 				
	private String innerBox; 				
	private String cardBoard; 									
	private String wrap; 				
	private String ctBox; 				
	private String smallBox; 				
	private String style; 				
	private String DSTN; 									
	private String idPO; 				

	
	
	public String getIdPO(){
		return idPO;
	}
	
	public void setIdPO(String idPO) {
		this.idPO = idPO;
	}

	public String getLabel(){
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}


	public String getInnerBox(){
		return innerBox;
	}
	
	public void setInnerBox(String innerBox) {
		this.innerBox = innerBox;
	}


	public String getCardBoard(){
		return cardBoard;
	}
	
	public void setCardBoard(String cardBoard) {
		this.cardBoard = cardBoard;
	}

	public String getWrap(){
		return wrap;
	}
	
	public void setWrap(String wrap) {
		this.wrap = wrap;
	}


	public String getCtBox(){
		return ctBox;
	}
	
	public void setCtBox(String ctBox) {
		this.ctBox = ctBox;
	}

	public String getSmallBox(){
		return smallBox;
	}
	
	public void setSmallBox(String smallBox) {
		this.smallBox = smallBox;
	}

	public String getStyle(){
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}


	public String getDSTN(){
		return DSTN;
	}
	
	public void setDSTN(String DSTN) {
		this.DSTN = DSTN;
	}
	
}
