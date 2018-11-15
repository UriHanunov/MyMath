import myMath.Monom;
import myMath.Polynom;
import myMath.GraphPolynom;

public class TestGraph
{

	public static void main(String[] args)
	{
		Polynom p1 = new Polynom("0.2x^4-1.5x^3+3x^2-x-5");
    	GraphPolynom frame = new GraphPolynom(p1);
        frame.setVisible(true);
        double result = p1.areaUnder(-2, 6, 0.01); //save the area above the polynom and under x-axis
        System.out.println("the area under x-axis is:" + result);
	}

}
