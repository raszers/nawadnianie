

public class Heartbeat extends Thread {
	private boolean stop = false;

	public void run() {
		synchronized(this) {
		try {
			while(true) {
				this.wait(2500);
				MainThread.networkThread.sendBeat();
				if (stop) break;
			}
		}
		catch (Exception e)
		{
			System.err.println(e);
			System.err.println("Brak po³¹czenia");
		}
		}
	}
	public void stopThread() {
		stop=true;
	}
}
		
