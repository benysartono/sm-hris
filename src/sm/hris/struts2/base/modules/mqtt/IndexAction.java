package sm.hris.struts2.base.modules.mqtt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.ParentPackage;

import sm.hris.struts2.base.SmBaseAction;
import sm.hris.struts2.base.db.Actuator;
import sm.hris.struts2.base.db.ActuatorDAO;
import sm.hris.struts2.base.db.Sensor;

@ParentPackage(value = "hris")

public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 7353477345330099548L;
	private ActuatorDAO actuatorDAO = new ActuatorDAO();
    private ArrayList<Actuator> actuators;
    private String srcParam;
    private ArrayList<String> argArray = new ArrayList<String>();
    private ArrayList<String> idActuators = new ArrayList<String>();
    private ArrayList<String> idActuatorIdRelays = new ArrayList<String>();
    private ArrayList<String> idActuatorIdRelayCmds = new ArrayList<String>();
    private String idActuatorIdRelayCmd;
    private String proc;
    private String res;
    private Actuator actuator;
	private String idActuator;
	private String IdRelay;
	private String Command;

	private String broker = "tcp://m12.cloudmqtt.com:11880";
	private Map session = ActionContext.getContext().getSession();
	private String clientid = String.valueOf(session.get("userId"));
	private char[] password = "ZI8YZa0LjRtb".toCharArray();
	//private char[] password = String.valueOf(session.get("password")).toCharArray();
	private String topic = "iotek/actuator";
	private String content;
	private MqttClient mqttClient;
	
    MemoryPersistence persistence = new MemoryPersistence();
    int qos = 2;

    //private MqttClient sampleClient = new MqttClient(broker, clientid, persistence);
    private MqttConnectOptions connOpts = new MqttConnectOptions();


    
    public String execute() throws Exception{
    	if (proc != null){
	    	if(proc.equals("Delete")){
	    		res = actuatorDelete();
	    	}
	    	if(proc.equals("OnOff")){
	    		res = actuatorOnOff();
	    	}
			if(!(proc.equals("Add")||proc.equals("Delete"))){
				//argArray = new ArrayList<String>();
				//argArray.add(e)
	    		//actuatorDAO.setArgArray(argArray);
				setActuators(actuatorDAO.searchActuator());
				res="success";
			}
	    	else if(proc.equals("Add")){
	    		System.out.println("Ada dalam add return");
	    		res= "add";
	    	}
    	}
		else {
			setActuators(actuatorDAO.searchActuator());
			res="success";
		} 
		return res;
    }
    
	public String actuatorDelete() throws Exception {
		for(int cnt=0;cnt<idActuatorIdRelays.size();cnt++){
			argArray = new ArrayList<String>();
			int iend = idActuatorIdRelays.get(cnt).indexOf(",");
			argArray.add(idActuatorIdRelays.get(cnt).substring(0 , iend));
			argArray.add(idActuatorIdRelays.get(cnt).substring(idActuatorIdRelays.get(cnt).lastIndexOf(",") + 1));
			
			System.out.println("Actuator Kode: " + idActuatorIdRelays.get(cnt).substring(0 , iend));
			System.out.println("Relay Kode: " + idActuatorIdRelays.get(cnt).substring(idActuatorIdRelays.get(cnt).lastIndexOf(",") + 1));
			actuatorDAO.setArgArray(argArray);
			actuatorDAO.actuatorDelete();
		}
		setActuators(actuatorDAO.searchActuator());
		return "success";
	}
	
	
	public String actuatorOnOff() throws Exception {
	    MqttClient publishClient = getMqttClient();
		try {
	        content = actuator.getIdActuator() + "|" + actuator.getIdRelay() + "|" + actuator.getCommand();
	        MqttMessage message = new MqttMessage(content.getBytes());
	        message.setQos(qos);
	        publishClient.publish(topic, message);
	        System.out.println("Message published");
	        //sampleClient.disconnect();
	        //System.out.println("Disconnected");
	        //System.exit(0);
	    } catch (MqttException e){
	        System.out.println("reason " + e.getReasonCode());
	        System.out.println("msg " + e.getMessage());
	        System.out.println("loc " + e.getLocalizedMessage());
	        System.out.println("cause " + e.getCause());
	        System.out.println("exxcep " + e);
	        return "error";
	    }
		actuatorDAO.setActuator(actuator);
		actuatorDAO.actuatorOnOff();
		System.out.println("Sukses lewati publish");
        return SUCCESS;
	}

	public MqttClient getMqttClient(){
	    try {
	        mqttClient = new MqttClient(broker, clientid, persistence);
	        connOpts.setCleanSession(true);
	        if (clientid != ""){
	        	connOpts.setUserName(clientid);
	        	connOpts.setPassword(password);
	        }
	        System.out.println("Connecting to broker");
	        try { 
	        	mqttClient.connect(connOpts);
	        }
	        catch (MqttException e){
	            System.out.println("reason 2 " + e.getReasonCode());
	            System.out.println("msg 2 " + e.getMessage());
	            System.out.println("loc 2 " + e.getLocalizedMessage());
	            System.out.println("cause 2 " + e.getCause());
	            System.out.println("exxcep 2 " + e);
	            //return "error";
	        }	
	        //return SUCCESS;
	    } catch (MqttException e){
	        System.out.println("reason " + e.getReasonCode());
	        System.out.println("msg " + e.getMessage());
	        System.out.println("loc " + e.getLocalizedMessage());
	        System.out.println("cause " + e.getCause());
	        System.out.println("exxcep " + e);
	        //return "error";
	    }
	    return mqttClient;

	}
	
	public ArrayList<String> getIdActuators(){
			return idActuators;
		}
			
	public void setIdActuators(ArrayList<String> idActuators){
			this.idActuators=idActuators;
		}
	
	public String getSrcParam(){
		return srcParam;
	}
	
	public void setSrcParam(String srcParam){
		this.srcParam = srcParam;
	}

	public void setProc(String proc) {
        this.proc = proc;
    }

	public void setActuators(ArrayList<Actuator> actuators){
		this.actuators = actuators;
	}
	
	public ArrayList<Actuator> getActuators(){
		return actuators;
	}

	public void setIdActuatorIdRelays(ArrayList<String> idActuatorIdRelays){
		this.idActuatorIdRelays = idActuatorIdRelays;
	}

	public void setIdActuatorIdRelayCmds(ArrayList<String> idActuatorIdRelayCmds){
		this.idActuatorIdRelayCmds = idActuatorIdRelayCmds;
	}

	public void setIdActuatorIdRelayCmd(String idActuatorIdRelayCmd){
		this.idActuatorIdRelayCmd = idActuatorIdRelayCmd;
	}

	public void setIdActuator(String idActuator){
		this.idActuator = idActuator;
	}

	public void setIdRelay(String IdRelay){
		this.IdRelay = IdRelay;
	}

	public void setCommand(String command){
		this.Command = command;
	}
	
	public Actuator getActuator(){
		return actuator;
	}
	
	public void setActuator(Actuator actuator){
		this.actuator = actuator;
	}

}
