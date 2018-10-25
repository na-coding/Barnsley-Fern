import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = -1616367561107980353L;

	private BarnsleyFern fern;
	private int centerx;
	private int centery;
	private double currentx;
	private double currenty;

	public static void main(String[] args){
		try{
			MainFrame mainFrame = new MainFrame();
			mainFrame.display();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public MainFrame() throws InterruptedException{
		setTitle("BarnsleyFern");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		getContentPane().setBackground(Color.white);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		
		int width = (int)(screen.getWidth() / 2);
		int height = (int)(screen.getHeight() / 2);
		int posx = (int)((screen.getWidth() - width) / 2);
		int posy = (int)((screen.getHeight() - height) / 2);
		
		setBounds(posx, posy, width, height);
		
		System.out.println("Width: " + width  + " Height: " + height);
		centerx= 0;
		centery = 0;
		
		fern = new BarnsleyFern(centerx, centery);
		add(fern);
	}
	
	
	private void display() throws InterruptedException {
		setVisible(true);
		
		currentx = centerx;
		currenty = centery;
		
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				double rand = Math.random();
				
				
				int toApply = 0;
				if (rand == 0.99) toApply = 1;
				else if (rand >= 0.92) toApply = 2;
				else if (rand >= 0.85) toApply = 3;
				else toApply = 4;

				updatePosition(currentx, currenty, toApply);
				fern.addPoint(new Point2D.Double(currentx, currenty));
				
				System.out.println("Rand: " + rand + ", X: " + currentx + ", Y: " + currenty);
				fern.repaint();
			}
		}, 10, 10);
	}
	
	private void updatePosition(double x, double y, int algo) {
		switch(algo) {
		case 1:
			currentx = centerx;
			currenty = (0.16 * y);
			break;
		case 2:
			currentx = ((-0.15 * x) + (0.28 * y));
			currenty = ((0.26 * x) + (0.24 * y) + 0.44);
			break;
		case 3:
			currentx = ((0.2 * x) - (0.26 * y));
			currenty = ((0.23 * x) + (0.22 * y) + 1.6);
			break;
		case 4:
			currentx = ((0.85 * x) + (0.04 * y));
			currenty = ((-0.04 * x) + (0.85 * y) + 1.6);
			break;
		default:
			System.out.println("No algo");
		}
	}
}