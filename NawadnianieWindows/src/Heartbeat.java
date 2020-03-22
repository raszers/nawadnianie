

public class Heartbeat extends Thread {
	private boolean stop = false;

	public void run() {
		synchronized(this) {
		try {
			while(true) {
				this.wait(2500);
//				MainThread.networkThread.send("0000");
				if (stop) break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Brak po³¹czenia");
		}
		}
	}
	public void stopThread() {
		stop=true;
	}
}
		
