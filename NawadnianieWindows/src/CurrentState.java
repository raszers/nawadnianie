import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CurrentState {
	private static CurrentState instance = new CurrentState();
	
	private byte[] mode;
	private byte[] relay;
	private byte[] sequence;
	private boolean connection;
	
	
	private CurrentState() {
		mode = new byte[3];
		relay = new byte[4];
		sequence = new byte[8];
		
		File file = new File("stan.txt");
		
		try(
				BufferedReader br = new BufferedReader(new FileReader(file));
				){
			String currentLine = new String();
			while((currentLine = br.readLine())!=null && currentLine.length()!=0) {
				if(!currentLine.startsWith("//")) {
					byte[] tmp = currentLine.getBytes();
					for(int i = 0; i < tmp.length; i++) {
						tmp[i] -= 48;
					}
					switch(tmp.length) {
					case(3):
						mode = tmp;
						break;
					case(4):
						relay = tmp;
						break;
					}
				}
			}
			
		}catch (IOException e) {
			System.out.println(e.getStackTrace());
			System.err.println(e);
		}
	}
	
	public static CurrentState getInstance() {
		return instance;
	}

	public byte[] getMode() {
		return mode;
	}
	
	public String getModeString() {
		StringBuilder returnValue = new StringBuilder();
		for(byte b : mode) {
			int i = b;
			returnValue.append(i);
		}
		System.out.println(returnValue.toString());
		return returnValue.toString();
	}

	public void setMode(byte[] mode) {
		this.mode = mode;
	}

	public byte[] getRelay() {
		return relay;
	}
	
	public String getRelayString() {
		StringBuilder returnValue = new StringBuilder();
		for(byte b : relay) {
			int i = b;
			returnValue.append(i);
		}
		System.out.println(returnValue.toString());
		return returnValue.toString();
	}

	public void setRelay(byte[] relay) {
		this.relay = relay;
	}

	public boolean isManualMode() {
		if(mode[0] == 2)
			return true;
		else return false;
	}

	public boolean isAutoMode() {
		if(mode[0] == 1)
			return true;
		else return false;
	}

	public boolean isSequenceMode() {
		if(mode[0] == 3)
			return true;
		else return false;
	}
	
	public boolean isSkipNext() {
		if(mode[1] == 1)
			return true;
		else return false;
	}
	
	public boolean isDailyDone() {
		if(mode[2] == 1)
			return true;
		else return false;
	}

	public boolean isConnection() {
		return connection;
	}

	public void setConnection(boolean connection) {
		this.connection = connection;
	}
	
	

}
