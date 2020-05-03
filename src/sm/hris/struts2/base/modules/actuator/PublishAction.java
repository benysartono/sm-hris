package sm.hris.struts2.base.modules.mqtt;

import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import com.opensymphony.xwork2.ActionSupport;

import sm.hris.struts2.base.SmBaseAction;

public class PublishAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//String topic = "iot/iot";
    //String content = "Hello";
    //String broker = "tcp://192.168.43.1:1883";
    //String clientid = "PCPub";
    //String message;

	String topic;
    String content;
    String broker;
    String clientid;
    String userName = "ptgijdgb";
    char[] password = "ZI8YZa0LjRtb".toCharArray();

    MemoryPersistence persistence = new MemoryPersistence();
    int qos = 2;
    
    public String execute() throws Exception{
    if(broker == null){
    	return SUCCESS;
    } else {
    try {
    	
        MqttClient sampleClient = new MqttClient(broker, clientid, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        if (userName != ""){
        	connOpts.setUserName(userName);
        	connOpts.setPassword(password);
        	System.out.println("Pwd nya: " + password);
        	
        }
        System.out.println("Connecting to broker");
        
    	
    	//MqttClient sampleClient = new MqttClient(broker, "Lenovo1", persistence);

    	//SSLContext sslContext = SSLContext.getInstance("SSL");
    	//TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    	//KeyStore keyStore = readKeyStore();
    	//KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    	//trustManagerFactory.init(keyStore);
    	//sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

    	//MqttConnectOptions connOpts = new MqttConnectOptions();
    	//connOpts.setSocketFactory(sslContext.getSocketFactory());

    	//sampleClient.connect(connOpts);
    	
        try { 
        	sampleClient.connect(connOpts);
        }
        catch (MqttException e){
            System.out.println("reason 2 " + e.getReasonCode());
            System.out.println("msg 2 " + e.getMessage());
            System.out.println("loc 2 " + e.getLocalizedMessage());
            System.out.println("cause 2 " + e.getCause());
            System.out.println("exxcep 2 " + e);
            return "error";
        }		
        System.out.println("connected 3");
        System.out.println("Connection3: " + broker + " " + clientid + " " + topic);
        System.out.println("Publishing message: " + content);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        sampleClient.publish(topic, message);
        System.out.println("Message published");
        //sampleClient.disconnect();
        return SUCCESS;
        //System.out.println("Disconnected");
        //System.exit(0);
    } catch (MqttException e){
        System.out.println("reason " + e.getReasonCode());
        System.out.println("msg " + e.getMessage());
        System.out.println("loc " + e.getLocalizedMessage());
        System.out.println("cause " + e.getCause());
        System.out.println("exxcep " + e);
        return "error";
    }}
    }
    //}
    
    public void setTopic(String topic){
    	this.topic = topic;
    }
    
    public String getTopic (){
    	return topic;
    }
    
    public void setContent(String content){
    	this.content = content;
    }
    
    public String getContent(){
    	return content;
    }
    
    public void setBroker(String broker){
    	this.broker = broker;
    }
    
    public String getBroker(){
    	return broker;
    }
    
    public void setClientid(String clientid){
    	this.clientid = clientid;
    }
    
    public String getClientid(){
    	return clientid;
    }
    
    public void setUserName(String userName){
    	this.userName = userName;
    }
    
    public String getUserName(){
    	return userName;
    }

    public void setPassword(char[] password){
    	this.password = password;
    }
    
    public char[] getPassword(){
    	return password;
    }

    

}
