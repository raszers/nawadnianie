
public class State {
	private static State instance = new State();
	
	private String mode;
	private String relay;
	
	private State() {
	}
	
	public static State getInstance() {
		return instance;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRelay() {
		return relay;
	}

	public void setRelay(String relay) {
		this.relay = relay;
	}
	
	

}
