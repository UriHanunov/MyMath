package myMath;
import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

/*
 * This class represents the graph of polynom
 * the code taken from:  https://github.com/eseifert/gral/wiki/xyplot
 * the jar file taken from: https://github.com/eseifert/gral/wiki/download - the first one
 */
	public class GraphPolynom extends JFrame
	{
	    public GraphPolynom()
	    {
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(600,400);
	        Polynom p1 = new Polynom("0.2x^4-1.5x^3+3x^2-x-5");
	        DataTable data = new DataTable(Double.class,Double.class);
	        for(double x = -2.0; x <= 6.0; x+=0.01)
	        {
	            double y = p1.f(x);
	            data.add(x,y);
	        }
	        XYPlot plot = new XYPlot(data);
	        getContentPane().add(new InteractivePanel(plot));
	        LineRenderer lines = new DefaultLineRenderer2D();
	        plot.setLineRenderers(data, lines);
	        Color color = new Color(0.0f, 0.3f, 1.0f);
	        plot.getPointRenderers(data).get(0).setColor(color);
	        plot.getLineRenderers(data).get(0).setColor(color);
	    }

	    public static void main(String[] args)
	    {
	    	GraphPolynom frame = new GraphPolynom();
	        frame.setVisible(true);
	    }
	}
