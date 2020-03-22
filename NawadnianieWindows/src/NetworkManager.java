

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import org.eclipse.swt.widgets.Display;

public class NetworkManager extends Thread {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InetSocketAddress endPoint;
    private OutputStream out;
    private BufferedReader in;
    private String inputLine;
    private Heartbeat heartbeat;
    private final int MODE=3, RELAYS=4, DIAG=1, UNKNOWN=0;
	MainWindow window;
	
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
	            System.out.println (e);
	            System.out.println("Roz³¹czono");
	            updateConnection(false);
	            try 
	            {
	            	this.terminate();
	            	this.stopHearbeat();
	            }
	            catch (Exception err)
	            {
	            	System.out.println(err);
	            	System.out.println("nieudane zatrzymanie");
	            }
	            
	        } 
	    } 
    
    public void start(int port) throws IOException {
    	
        serverSocket = new ServerSocket();
        String ip  = InetAddress.getLocalHost().getHostAddress();
        endPoint = new InetSocketAddress(ip, port);
        serverSocket.bind(endPoint);
        clientSocket = serverSocket.accept();
        updateConnection(true);
        System.out.println("Po³¹czono");
        //
        out = clientSocket.getOutputStream();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //
        heartbeat = new Heartbeat();
        heartbeat.start();
        while(true){ //Echo
	        inputLine = in.readLine();
	        
	        handleMsg(inputLine);
	        if(inputLine.equals("end")) {
	        	this.terminate();
	        	this.stopHearbeat();
	        	break;
	        }
        }
    }
    
    private void handleMsg(String line) {
    	System.out.println("Odebrano " + line);
    	int length = line.length();
    	byte values[]=line.getBytes();
    	int msgType;
    	String string;
    	
    	switch(length) {
    	case 4:
    		msgType = RELAYS;
    		break;
    	case 3:
    		msgType = MODE;
    		break;
    	case 1:
    		msgType = DIAG;
    		break;
    	default:
    		msgType = UNKNOWN;
    	}
    	
    	switch(msgType) {
    	case RELAYS:
    		updateRelay(values);
    		send(values);
    		string = Arrays.toString(values);
    		updateList(string);
    		break;
    	case MODE:
    		updateSoftSettings(values);
    		send(values);
    		string = Arrays.toString(values);
    		updateList(string);
    		break;
    	
    	default:
    		break;
    		
    	}
    	//Wypisz otrzymane zdanie:
    	for(int i=0;i<=length-1;i++) {
    		System.out.print(values[i]);
    		}
    	System.out.print("\n");

    }
    
//    public void send(String data)
//    {
//    	try {
//    		out.println("1234");
//    		System.out.println("siema");
//    		
//
//    	}
//    	catch (Exception e) {
//    		//System.out.println(e);
//    	}
//    }
    
    public void send(byte[] data) {
    	System.out.println("wykonalo sie");
    	byte[] newLine = new byte[data.length+1];
    	for(int i = 0; i<data.length; i++)
    		newLine[i] = data[i];
    	newLine[data.length] = 10;
    	try{
    		out.write(newLine);
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
    
    private void updateSoftSettings(byte state[]) {
  	   new Thread(new Runnable() {
  		      public void run() { 		        
 		            Display.getDefault().asyncExec(new Runnable() {
  		               public void run() {
  		            	   MainWindow.getInstance().setSoftSettings(state);
  		               }
  		            });
  		         }
  		   }).start();
     }
    
    private void updateConnection(boolean state) {
  	   new Thread(new Runnable() {
  		      public void run() { 		        
 		            Display.getDefault().asyncExec(new Runnable() {
  		               public void run() {
  		            	   MainWindow.getInstance().setConnection(state);
  		               }
  		            });
  		         }
  		   }).start();
     }
    
    private void updateRelay(byte state[]) {
 	   new Thread(new Runnable() {
 		      public void run() { 		        
		            Display.getDefault().asyncExec(new Runnable() {
 		               public void run() {
 		            	   MainWindow.getInstance().setRelay(state);
 		               }
 		            });
 		         }
 		   }).start();
    }
    
    private void updateRelay(boolean state) {
    	   new Thread(new Runnable() {
    		      public void run() { 		        
  		            Display.getDefault().asyncExec(new Runnable() {
    		               public void run() {
    		            	   MainWindow.getInstance().setRelay(state);
    		               }
    		            });
    		         }
    		   }).start();	   
    }
    private void updateList(String string) {
 	   new Thread(new Runnable() {
 		      public void run() { 		        
		            Display.getDefault().asyncExec(new Runnable() {
 		               public void run() {
 		            	   MainWindow.getInstance().addList(string);
 		               }
 		            });
 		         }
 		   }).start();	   
 }
    
    

}
