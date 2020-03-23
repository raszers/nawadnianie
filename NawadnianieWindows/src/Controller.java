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
    	updateWindow();
      }
     
     public void updateConnection(boolean state) {
    	 CurrentState.getInstance().setConnection(state);
    	 updateWindow();
      }
     
     public void updateRelay(byte state[]) {
    	 CurrentState.getInstance().setRelay(state);
    	 updateWindow();
     }
     
     public void updateRelay(boolean state) {
    	 MainWindow.getInstance().setRelay(state);   
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
}
