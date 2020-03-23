
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
		
		//testing
//		mode[0] = 1;
//		mode[1] = 0;
//		mode[2] = 1;
//		relay[0] = 0;
//		relay[1] = 0;
//		relay[2] = 1;
//		relay[3] = 0;
	}
	
	public static CurrentState getInstance() {
		return instance;
	}

	public byte[] getMode() {
		return mode;
	}

	public void setMode(byte[] mode) {
		this.mode = mode;
	}

	public byte[] getRelay() {
		return relay;
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
