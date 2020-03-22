

public class MainThread {
	public static int a=0, b=50;
	public static NetworkManager networkThread;
	public static GuiThread gui;
	//public static GuiThread guiThread;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		networkThread = new NetworkManager();
		gui = new GuiThread();
		Thread guiThread = new Thread(gui);
		guiThread.start();
		
		//guiThread

		System.out.println("poszlo");
		while(a<b) {
			if(!networkThread.isAlive()) {
				a++;
				networkThread = new NetworkManager();
				networkThread.start();
				}
			}
		}
}


