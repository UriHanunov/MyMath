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
	        DataTable dataPoints = new DataTable(Double.class,Double.class); //save the extreme points in data table 
	        int i = 1; //count the extreme points
	        for(double x = -2.0; x <= 6.0; x+=0.25)
	        {
	            double y = p1.f(x);
	            boolean checkMinMax = minMaxPoint(x,y,p1); //send to function that check if the point is a extreme point
	            if(checkMinMax)
	            {
	            	dataPoints.add(x,y); //add to the tablePoints
	            	System.out.println("extreme point number " + i + " is:");
	            	i++;
	            	System.out.println(x + "," + y); //print the extreme point
	            }
	            data.add(x,y); ////add to the original table
	        }
	        XYPlot plot = new XYPlot(data,dataPoints); //plot that include the tables: data and dataPoints
	        getContentPane().add(new InteractivePanel(plot));
	        LineRenderer lines = new DefaultLineRenderer2D();
	        plot.setLineRenderers(data, lines);
	        plot.getPointRenderers(data).get(0).setColor(Color.YELLOW); //paint all points in blue
	        plot.getLineRenderers(data).get(0).setColor(Color.YELLOW); //paint all lines in blue
	        plot.getPointRenderers(dataPoints).get(0).setColor(Color.RED); //paint just the extreme points in red
	    }
	    
	    //check if this point is extreme point
	    private boolean minMaxPoint(double x,double y,Polynom p)
		{
			boolean minMax = false; //there is not extreme point
			double before = x-0.25; //the point before
			double after = x+0.25; //the point after
			if((y>p.f(before) && y>p.f(after)) || (y<p.f(before) && y<p.f(after))) //check if the y values before and after this point are bigger or smaller than this point
			{
				minMax= true; ////there is extreme point
			}
			return minMax;
		}
	}
