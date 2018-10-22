import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BarnsleyFern extends JPanel{
	private static final long serialVersionUID = 8320182863233274022L;
	
	private List<Point> points;

	public BarnsleyFern(int pos_x, int pos_y) {
		points = new ArrayList<Point>();
		addPoint(new Point(pos_x, pos_y));
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
//		g2D.translate(683, 384);
		g2D.translate(683,0);
		g2D.setStroke(new BasicStroke(10));
		
		for (Point p : points) {
			g2D.drawLine(p.x, p.y, p.x, p.y);
		}
	}
}