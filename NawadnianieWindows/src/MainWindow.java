import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.BoxLayout;

public class MainWindow {
	
	public static final MainWindow INSTANCE = new MainWindow();
	protected Shell shell;
	boolean val = true;
	private final int MANUAL = 2, AUTO = 1, SEQUENCE = 3;
	private Label relArr[];
	private Label rel_0;
	private Label rel_1;
	private Label rel_2;
	private Label rel_3;
	private Label lblConn;
	private List list;
	private ScrolledComposite scrolledComposite;
	private Label lblKwiaty;
	private Label lblOgrod;
	private Label lblTrawnik1;
	private Label lblTrawnik;
	private Label btnManual;
	private Label btnAuto;
	private Label btnSequence;
	private Label lblManual;
	private Label lblAuto;
	private Label lblSequence;
	private Label btnSkip;
	private Label btnDailyDone;
	private Composite composite_1;
	private Composite composite_2;
	private Composite composite_3;
	private Composite composite_4;
	private Composite composite_5;
	private Composite composite_6;
	private Composite composite_7;
	
	private MainWindow() {
	}
	
	public static MainWindow getInstance(){
		return INSTANCE;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	
	public void main(String[] args) {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dupa");
			System.out.println(e);
		}
	}


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setSize(560, 648);
		shell.setText("SWT Application");
		relArr = new Label[4];
		GridLayout gl_shell = new GridLayout(5, false);
		gl_shell.verticalSpacing = 10;
		gl_shell.horizontalSpacing = 0;
		gl_shell.marginWidth = 15;
		shell.setLayout(gl_shell);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);		
		
				lblConn = new Label(shell, SWT.NONE);
				lblConn.setVisible(false);
				lblConn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				lblConn.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/online.png"));
		{
			composite_1 = new Composite(shell, SWT.NONE);
			composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			composite_1.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			{
				btnManual = new Label(composite_1, SWT.CENTER);
				btnManual.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/manual_off.png"));
			}
			{
				lblManual = new Label(composite_1, SWT.CENTER);
				lblManual.setText("Manual");
				lblManual.setAlignment(SWT.CENTER);
			}
		}
		new Label(shell, SWT.NONE);
		{
			composite_2 = new Composite(shell, SWT.NONE);
			composite_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			composite_2.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			{
				btnAuto = new Label(composite_2, SWT.CENTER);
				btnAuto.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/auto_mode_off.png"));
			}
			{
				lblAuto = new Label(composite_2, SWT.NONE);
				lblAuto.setText("Auto");
				lblAuto.setAlignment(SWT.CENTER);
			}
		}
		new Label(shell, SWT.NONE);
		{
			composite_3 = new Composite(shell, SWT.NONE);
			composite_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			composite_3.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			{
				btnSequence = new Label(composite_3, SWT.CENTER);
				btnSequence.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/sequence_off.png"));
			}
			{
				lblSequence = new Label(composite_3, SWT.CENTER);
				lblSequence.setText("Sekwencja");
				lblSequence.setAlignment(SWT.CENTER);
			}
		}
		new Label(shell, SWT.NONE);
		{
			composite_4 = new Composite(shell, SWT.NONE);
			composite_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			composite_4.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			
			rel_0 = new Label(composite_4, SWT.NONE);
			rel_0.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
			relArr[0]=rel_0;
			{
				lblKwiaty = new Label(composite_4, SWT.NONE);
				lblKwiaty.setAlignment(SWT.CENTER);
				lblKwiaty.setText("Kwiaty");
			}
		}
		new Label(shell, SWT.NONE);
		{
			composite_6 = new Composite(shell, SWT.NONE);
			composite_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			composite_6.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			
			rel_1 = new Label(composite_6, SWT.SHADOW_NONE);
			rel_1.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
			relArr[1]=rel_1;
			{
				lblOgrod = new Label(composite_6, SWT.NONE);
				lblOgrod.setAlignment(SWT.CENTER);
				lblOgrod.setText("Ogr\u00F3d");
			}
		}
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		{
			composite_5 = new Composite(shell, SWT.NONE);
			composite_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			composite_5.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			
			rel_2 = new Label(composite_5, SWT.NONE);
			rel_2.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
			relArr[2]=rel_2;
			{
				lblTrawnik1 = new Label(composite_5, SWT.NONE);
				lblTrawnik1.setText("Trawnik #1");
				lblTrawnik1.setAlignment(SWT.CENTER);
			}
		}
		new Label(shell, SWT.NONE);
		{
			composite_7 = new Composite(shell, SWT.NONE);
			composite_7.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
					composite_7.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			
					rel_3 = new Label(composite_7, SWT.NONE);
					rel_3.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
					relArr[3]=rel_3;
					{
						lblTrawnik = new Label(composite_7, SWT.NONE);
						lblTrawnik.setText("Trawnik #2");
						lblTrawnik.setAlignment(SWT.CENTER);
					}
		}
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		{
			btnSkip = new Label(shell, SWT.CENTER);
			btnSkip.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			btnSkip.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/skip_next_off.png"));
		}
		new Label(shell, SWT.NONE);
		
		scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		list = new List(scrolledComposite, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setContent(list);
		scrolledComposite.setMinSize(list.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		new Label(shell, SWT.NONE);
		{
			btnDailyDone = new Label(shell, SWT.CENTER);
			btnDailyDone.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
			btnDailyDone.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/daily_done_off.png"));
		}
	}
	
	public void setConnection(boolean state) {
		lblConn.setVisible(state);
	}
	
	public void setSoftSettings(byte state[]) {
		int softMode = state[0];
		int skipNext = state[1];
		int dailyDone = state[2];
			
			switch (softMode) {
			case MANUAL:
				setManualMode(true);
				break;
			case AUTO:
				setAutoMode(true);
				break;
			case SEQUENCE:
				setSequenceMode(true);
				break;
			default:
				break;
		}
			if (skipNext==1) {
				setSkipNext(true);
			}
			else {
				setSkipNext(false);
			}
			
			if (dailyDone==1) {
				setDailyDone(true);
			}
			else {
				setDailyDone(false);
			}	
		
	}
	
	public void setManualMode(boolean state) {

		if (state){
			btnManual.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/manual_on.png"));
			setAutoMode(false);
			setSequenceMode(false);
		}
		else {
			btnManual.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/manual_off.png"));
		}
	}
	
	public void setAutoMode(boolean state) {
		if (state){
			btnAuto.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/auto_mode_on.png"));
			setManualMode(false);
			setSequenceMode(false);
		}
		else {
			btnAuto.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/auto_mode_off.png"));
		}
	}
	
	public void setSequenceMode(boolean state) {
		if (state){
			btnSequence.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/sequence_on.png"));
			setAutoMode(false);
			setManualMode(false);
		}
		else {
			btnSequence.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/sequence_off.png"));
		}
	}
	
	public void setSkipNext(boolean state) {
		if (state){
			btnSkip.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/skip_next_on.png"));
		}
		else {
			btnSkip.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/skip_next_off.png"));
		}
	}
	
	public void setDailyDone(boolean state) {
		if (state){
			btnDailyDone.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/daily_done_on.png"));
		}
		else {
			btnDailyDone.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/daily_done_off.png"));
		}
	}
	
	public void setRelay(boolean state) {
		if (state){
			rel_0.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
		}
		else {
			rel_0.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/on.png"));
		}
		val=state;
	}
	
	public void setRelay(byte state[]) {

		for(int i=0; i<=3;i++) {
			if(state[i]==1) {
				relArr[i].setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/on.png"));
			}
			else {
				relArr[i].setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
			}
		}
	}
	
	public void toggleRelay() {
		val=!val;
		if (val){
			rel_0.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/off.png"));
		}
		else {
			rel_0.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/test/icon/on.png"));
		}
	}
	
	public boolean getRelay() {
		return val;
	}
	
	public void addList(String string) {
		list.add(string,0);
	}
}
