package sm.hris.struts2.base.db;

public class PaymentMethod {

	private String idPaymentMethod; 									
	private String nmPaymentMethod; 				
	
	public String getIdPaymentMethod(){
		return idPaymentMethod;
	}
	
	public void setIdPaymentMethod(String idPaymentMethod) {
		this.idPaymentMethod = idPaymentMethod;
	}

	public String getNmPaymentMethod(){
		return nmPaymentMethod;
	}
	
	public void setNmPaymentMethod(String nmPaymentMethod) {
		this.nmPaymentMethod = nmPaymentMethod;
	}

}
