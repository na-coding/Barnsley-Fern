import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BarnsleyFern extends JPanel{
	private static final long serialVersionUID = 8320182863233274022L;
	
	private List<Point2D.Double> points;

	public BarnsleyFern(double pos_x, double pos_y) {
		points = new ArrayList<Point2D.Double>();
		addPoint(new Point2D.Double(pos_x, pos_y));
	}
	
	public void addPoint(Point2D.Double p) {
		points.add(p);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
//		g2D.translate(683, 384);
		g2D.translate(getWidth() / 2,getHeight() / 2);
		g2D.setStroke(new BasicStroke(5));
		
		Line2D.Double line;
		for (Point2D.Double p : points) {
			line = new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY());
			g2D.draw(line);
		}
	}
}