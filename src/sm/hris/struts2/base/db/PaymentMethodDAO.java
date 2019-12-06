package sm.hris.struts2.base.db;
 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import sm.hris.struts2.base.db.PaymentMethod;
import sm.hris.struts2.base.db.SmBaseDAO;

public class PaymentMethodDAO extends SmBaseDAO{
 
	private ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
	private PaymentMethod paymentMethod;
    private String idPaymentMethod;
    private ArrayList<String> argArray = new ArrayList<String>();

    public ArrayList<PaymentMethod> searchPaymentMethod() throws SQLException{
        ResultSet rs = this.runQuery("searchPaymentMethod");
        while (rs.next()) {
        	PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setIdPaymentMethod(rs.getString("idPaymentMethod"));
            paymentMethod.setNmPaymentMethod(rs.getString("nmPaymentMethod"));
            paymentMethods.add(paymentMethod);
        } 
        if(rs != null){
     	   try {
     	   rs.close();
     	   } catch (SQLException e) {
     	        System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return paymentMethods;
        
    }

	public ArrayList<PaymentMethod> searchPaymentMethodById() throws SQLException{
		ResultSet rs = this.runQuery("searchPaymentMethodById", argArray);
        while (rs.next()) {
        	PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setIdPaymentMethod(rs.getString("idPaymentMethod"));
            paymentMethod.setNmPaymentMethod(rs.getString("nmPaymentMethod"));
            paymentMethods.add(paymentMethod);
        } 
        if(rs != null){
     	   try {
     		   rs.close();
     	   } catch (SQLException e) {
     		   System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return paymentMethods;
    }

	public ArrayList<PaymentMethod> searchPaymentMethodByAnyLike() throws SQLException{
		ResultSet rs = this.runQuery("searchPaymentMethodByAnyLike", argArray);
        while (rs.next()) {
        	PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setIdPaymentMethod(rs.getString("idPaymentMethod"));
            paymentMethod.setNmPaymentMethod(rs.getString("nmPaymentMethod"));
            paymentMethods.add(paymentMethod);
        } 
        if(rs != null){
     	   try {
     		   rs.close();
     	   } catch (SQLException e) {
     		   System.out.println("Exception while closing result set: " + e);
     	   }
     	}
        closeConnection();
        return paymentMethods;
    }

	public void paymentMethodDelete() throws SQLException{
		for(int i=0;i<argArray.size();i++) {
			idPaymentMethod = argArray.get(i);
			this.run("paymentMethodDelete", idPaymentMethod);
			//closeConnection();
		}
    }

	public void paymentMethodAdd() throws SQLException {
		argArray.add(0, paymentMethod.getIdPaymentMethod());
		argArray.add(1, paymentMethod.getNmPaymentMethod());
		this.run("paymentMethodAdd", argArray);
		closeConnection();
    }
	
	public void paymentMethodEdit() throws SQLException{
		argArray.add(0, paymentMethod.getIdPaymentMethod());
		argArray.add(1, paymentMethod.getNmPaymentMethod());
		argArray.add(2, paymentMethod.getIdPaymentMethod());
		this.run("paymentMethodEdit", argArray);
		closeConnection();
	}

	
	public void setArgArray(ArrayList<String> argArray){
		this.argArray = argArray;
	}
	public ArrayList<String> getArgArray(){
		return argArray;
	}
	public String getIdPaymentMethod(){
		return idPaymentMethod;
	}
	public void setIdPaymentMethod(String idPaymentMethod){
		this.idPaymentMethod = idPaymentMethod;
	}
	public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods){
		this.paymentMethods = paymentMethods;
	}
	public ArrayList<PaymentMethod> getPaymentMethods(){
		return paymentMethods;
	}

	public PaymentMethod getPaymentMethod(){
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod){
		this.paymentMethod = paymentMethod;
	}
}