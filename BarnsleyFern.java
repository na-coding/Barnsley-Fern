import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class BarnsleyFern extends JPanel{
	private static final long serialVersionUID = 8320182863233274022L;
	
	private Point p;

	public BarnsleyFern(int pos_x, int pos_y) {
		p = new Point(pos_x, pos_y);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setStroke(new BasicStroke(10));
		g2D.drawLine(p.x, p.y, p.x, p.y);
	}
}