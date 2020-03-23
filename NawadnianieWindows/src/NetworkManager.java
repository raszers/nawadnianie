

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkManager extends Thread {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InetSocketAddress endPoint;
    private OutputStream out;
    private BufferedReader in;
    private String inputLine;
    private Heartbeat heartbeat;
	MainWindow window;
	private Controller controller;
	
	public void run() 
	    { 
	        try
	        { 	          
	            this.start(20555);
	            //serverSocket.b
	            	 
	        } 
	        catch (Exception e) 
	        { 
	            // Throwing an exception
	            System.err.println (e);
	            System.err.println("Roz³¹czono");
	            CurrentState.getInstance().setConnection(false);
	            try 
	            {
	            	this.terminate();
	            	this.stopHearbeat();
	            }
	            catch (Exception err)
	            {
	            	System.err.println(err);
	            	System.out.println("nieudane zatrzymanie");
	            }
	            
	        } 
	    } 
    
    public void start(int port) throws IOException {
    	
    	controller = new Controller();
        serverSocket = new ServerSocket();
        String ip  = InetAddress.getLocalHost().getHostAddress();
        endPoint = new InetSocketAddress(ip, port);
        serverSocket.bind(endPoint);
        clientSocket = serverSocket.accept();
        CurrentState.getInstance().setConnection(true);
        System.out.println("Po³¹czono");
        controller.updateWindow();
        //
        out = clientSocket.getOutputStream();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //
        heartbeat = new Heartbeat();
        heartbeat.start();
        while(true){ //Echo
	        inputLine = in.readLine();

	        controller.handleMsg(inputLine);
	        sendState();
	        
	        if(inputLine.equals("end")) {
	        	this.terminate();
	        	this.stopHearbeat();
	        	break;
	        }
        }
    }
    
    public void sendBeat() {
    	byte[] line = {0,0,0,0};
    	try{
    		out.write(line);
    		System.out.println("beat done");
    	}catch(IOException e) {
    		System.err.println("Heartbeat error " + e);
    	}
    }
    
    public void sendState() {
    	byte[] relay = new byte[5];
    	byte[] mode = new byte[4];
    	
    	for(int i = 0; i< CurrentState.getInstance().getRelay().length; i++)
    		relay[i] = CurrentState.getInstance().getRelay()[i];
    	
    	for(int i = 0; i < CurrentState.getInstance().getMode().length; i++)
    		mode[i] = CurrentState.getInstance().getMode()[i];
    	
    	relay[relay.length-1] = 10;
    	mode[mode.length-1] = 10;
    	try{
    		out.write(relay);
    		out.write(mode);
//    		System.out.println("Wyslano " + Arrays.toString(relay));
//    		System.out.println(Arrays.toString(mode));
    	}catch(IOException e) {
    		System.err.println(e);
    	}
    	
    }
    
    private void stopHearbeat()
    {
    	heartbeat.stopThread();
    }

    public void terminate() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    
    
    

}
