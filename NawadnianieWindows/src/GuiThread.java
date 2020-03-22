
public class GuiThread implements Runnable {
	//public static MainWindow mainWindow;
	MainWindow window;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//window = new MainWindow();
		window = MainWindow.getInstance();
		window.main(null);
	}
	
	public void setRelay(boolean state) {
		window.setRelay(state);		
	}
	
	public void toggleRelay() {
		window.toggleRelay();		
	}

}
