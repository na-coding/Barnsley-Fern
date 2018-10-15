import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = -1616367561107980353L;

	BarnsleyFern fern;

	public static void main(String[] args){
		try{
			MainFrame mainFrame = new MainFrame();
			mainFrame.display();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public MainFrame(){
		setTitle("BarnsleyFern");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		
		int width = (int)(screen.getWidth() / 2);
		int height = (int)(screen.getHeight() / 2);
		int posx = (int)((screen.getWidth() - width) / 2);
		int posy = (int)((screen.getHeight() - height) / 2);
		
		setBounds(posx, posy, width, height);
		
		fern = new BarnsleyFern(width / 2, height / 2);
		add(fern);
		
	}
	
	
	private void display() throws InterruptedException {
		setVisible(true);

//		while(true) {
//			fern.repaint();
//			Thread.sleep(10);
//		}
	}
}