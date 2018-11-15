package myMath;
import java.awt.Color;
import java.util.ArrayList;

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
	    public GraphPolynom(Polynom p1)
	    {
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(600,400);
	        DataTable data = new DataTable(Double.class,Double.class);
	        for(double x = -2.0; x <= 6.0; x+=0.25)
	        {
	            double y = p1.f(x);
	            data.add(x,y);
	        }
	        XYPlot plot = new XYPlot(data);
	        getContentPane().add(new InteractivePanel(plot));
	        LineRenderer lines = new DefaultLineRenderer2D();
	        plot.setLineRenderers(data, lines);
	        Color color = new Color(0.0f, 0.9f, 1.0f);
	        plot.getPointRenderers(data).get(0).setColor(color);
	        plot.getLineRenderers(data).get(0).setColor(color);
	        for(double x = -2.0; x <= 6.0; x+=0.25)
	        {
	            double y = p1.f(x);
	            boolean checkMinMax = minMaxPoint(x,y,p1);
	            if(checkMinMax)
	            {
	    	        plot.getPointRenderers(data).get(0).setColor(Color.RED);
	            }
	        }
	    }

	    public static void main(String[] args)
	    {
	    	Polynom p1 = new Polynom("0.2x^4-1.5x^3+3x^2-x-5");
	    	GraphPolynom frame = new GraphPolynom(p1);
	        frame.setVisible(true);
	    }
	    
	    private boolean minMaxPoint(double x,double y,Polynom p)
		{
			boolean minMax = false;
			double before = x-0.25;
			double after = x+0.25;
			if((y>p.f(before) && y>p.f(after)) || (y<p.f(before) && y<p.f(after)))
			{
				minMax= true;
			}
			return minMax;
		}
	}
