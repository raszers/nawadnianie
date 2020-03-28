import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.eclipse.swt.widgets.Display;

public class Controller{
	
	public void handleMsg(String line) {
    	System.out.println("Odebrano " + line);
    	int length = line.length();
    	byte values[]=line.getBytes();
    	String string;
    	
    	switch(length) {
    	case 4:
//    		RELAYS
    		updateRelay(values);
    		string = Arrays.toString(values);
    		updateList(string);
    		break;
    	case 3:
//    		MODE;
    		updateSoftSettings(values);
    		string = Arrays.toString(values);
    		updateList(string);
    		break;
    	case 1:
//    		DIAG;
    		break;
    	default:
//    		UNKNOWN;
    		break;
    	}
    	
    	//Wypisz otrzymane zdanie:
    	for(int i = 0; i < length; i++) {
    		System.out.print(values[i] + " ko");
    		}
    	System.out.print("\n");

    }
	
    public void updateSoftSettings(byte state[]) {
    	CurrentState.getInstance().setMode(state);
   	 updateStateFile();
    	updateWindow();
      }
     
     public void updateConnection(boolean state) {
    	 CurrentState.getInstance().setConnection(state);
    	 updateStateFile();
    	 updateWindow();
      }
     
     public void updateRelay(byte state[]) {
    	 CurrentState.getInstance().setRelay(state);
    	 updateStateFile();
    	 updateWindow();
     }
     
     public void updateRelay(boolean state) {
    	 MainWindow.getInstance().setRelay(state);   
    	 updateStateFile();
     }
     
     public void updateList(String string) {
//    	 MainWindow.getInstance().addList(string);
  }
     
     public void updateWindow() {

         new Thread(new Runnable() {
   		      public void run() { 		        
  		            Display.getDefault().asyncExec(new Runnable() {
   		               public void run() {
   		            	   MainWindow.getInstance().setRelay(CurrentState.getInstance().getRelay());
   		            	   MainWindow.getInstance().setConnection(CurrentState.getInstance().isConnection());
   		            	   MainWindow.getInstance().setManualMode(CurrentState.getInstance().isManualMode());
   		            	   MainWindow.getInstance().setAutoMode(CurrentState.getInstance().isAutoMode());
   		            	   MainWindow.getInstance().setSequenceMode(CurrentState.getInstance().isSequenceMode());
   		            	   MainWindow.getInstance().setSkipNext(CurrentState.getInstance().isSkipNext());
   		            	   MainWindow.getInstance().setDailyDone(CurrentState.getInstance().isDailyDone());
   		               }
   		            });
   		         }
   		   }).start();
     }
     
     public void updateStateFile(){
    	 System.out.println("dzieje sie");
    	 CurrentState cState = CurrentState.getInstance();
    	 File file = new File("stan.txt");
		 try(
		 PrintWriter pWriter = new PrintWriter(new FileWriter(file, false));
				 ){
			 file.createNewFile();
	    	 pWriter.println("//relay");
	    	 pWriter.println(cState.getRelayString());
	    	 pWriter.println("//mode");
	    	 pWriter.println(cState.getModeString());
			 
		 }catch(IOException e) {
			 System.out.println(e.getStackTrace());
			 System.err.println(e);
		 }
     }
}
