import myMath.Monom;
import myMath.Polynom;

/**
 * this calss is a test to the classes monom and polynom
 * @author Uri Hanunov and Olga Mazo
 */

public class Test
{
	public static void main(String[] args)
	{
		// check for monom
		Monom m1 = new Monom(4,1);
		Monom m2 = new Monom(3,4);
		Monom m3 = new Monom(3,4);
		double checkMonomF=m1.f(3);
		System.out.println("the result need to be 12, the result that the function return=" + checkMonomF);
		System.out.println("the result need to be true, the result is:" + m2.equals(m3));
		System.out.println("the result need to be true, the result is:" + m2.equals(m3));
		m2.add(m3);
		System.out.println("the result need to be 6*x^4, the result that the function return=" + m2);
		m1.multiply(m3);
		System.out.println("the result need to be 12*x^5, the result that the function return=" + m1);
		m1.derivative();
		System.out.println("the result need to be 60*x^4, the result that the function return=" + m1);
		
		
		//check for polynom
		Polynom p1 = new Polynom("3x^3+2x^2-2x^3+x-5-4x^2");
		System.out.println(p1); //check for toString
		
		
		//check the function area
		Polynom p2 = new Polynom("x^2-8");
		double checkArea = p2.area(-6,6,0.01);
		System.out.println("the result need to be clost to 50, the result that the function return=" + checkArea);
		
		
		//check the function multiply
		Polynom p3 = new Polynom("3x^3+4x-5x^2");
		Polynom p4 = new Polynom("x+1");
		p3.multiply(p4);
		System.out.println("the result need to be 3*x^4-2*x^3-x^2+4*x, the result that the function return="+p3);
		
		
		//check the function add
		Polynom p5 = new Polynom("4x^2-3x+4");
		Polynom p6 = new Polynom("6x^3-2x^2+5x");
		p5.add(p6);
		System.out.println("the result need to be 6*x^3+2*x^2+2*x+4, the result that the function return="+p5);
		
		
		//check the function derivative
		Polynom p7 = new Polynom("3x^2+4x^6");
		Polynom p8 = new Polynom();
		p8=(Polynom)(p7.derivative());
		System.out.println("the original polynom is " + p7);
		System.out.println("the derivative need to be 24*x^5+6*x, the result that the function return="+p8);
		
		//check the function copy
		Polynom p9 = new Polynom("3x^2+4x^6");
		Polynom p10 = new Polynom();
		p10=(Polynom)(p9.copy());
		System.out.println("the original polynom is " + p9);
		System.out.println("the result of the copy is " + p10);
		
		////check the function equals
		System.out.println("the result need to be true, the function return:" + p9.equals(p10));
		
		//check the function substract
		Polynom p11 = new Polynom("6*x^4-5*x^2+3*x^3");
		Polynom p12 = new Polynom("7*x^2-9*x^4+3*x");
		p11.substract(p12);
		System.out.println("the result need to be 15*x^4+3*x^3-12*x^2-3*x, the result that the function return="+p11);
		
		//check the function isZero
		Polynom p13 = new Polynom("0x+0");
		System.out.println("the result need to be true, the function return:"+p13.isZero());
		
		//check the function root
		Polynom p14 = new Polynom("x^2-4");
		double root = p14.root(-3, 1, 0.1);
		System.out.println("the result need to be clost to -2, the result that the function return="+root);
		
		Polynom p16 = new Polynom ("0.2x^4-1.5x^3+3x^2-x-5");
		double result = p16.areaUnder(-2, 6, 0.01);
		System.out.println(result);
		
		
		
		
	}
}