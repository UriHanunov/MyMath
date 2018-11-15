import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class TestPolynom {
	
	
	@Test
	public void testConstructorPolynom() throws Exception
	{
		try {
			Polynom p1 = new Polynom("jbvodw$");
		}
		catch(Exception e) //if we got Exception so the constructor is good
		{
			return;
		}
		fail("ERR: the constructor is wrong because it accept illegal string");
	}
	
	@Test
	public void testConstructorPolynom2() throws Exception
	{
		try {
			Polynom p1 = new Polynom("+-x^2");
		}
		catch(Exception e) //if we got Exception so the constructor is good
		{
			return;
		}
		fail("ERR: the constructor is wrong because it accept illegal string");
	}
	
	@Test
	public void testConstructorPolynom3() throws Exception
	{
		try {
			Polynom p1 = new Polynom("x^3+5+a");
		}
		catch(Exception e) //if we got Exception so the constructor is good
		{
			return;
		}
		fail("ERR: the constructor is wrong because it accept illegal string");
	}
	
	@Test
	public void testConstructorPolynom4() throws Exception
	{
		try {
			Polynom p1 = new Polynom("x^-5");
		}
		catch(Exception e) //if we got Exception so the constructor is good
		{
			return;
		}
		fail("ERR: the constructor is wrong because it accept illegal string");
	}
	
	@Test
	public void testFPolynom() throws Exception
	{
		Polynom p1 = new Polynom("-2x^3+5x^2+7x");
		double result = p1.f(3);
		if(result!=12)
		{
			fail("ERR: the function f is wrong");
		}
		
		p1 = new Polynom ("-6x^4+9x^2+5x^3");
		result = p1.f(2);
		if(result!=-20)
		{
			fail("ERR: the function f is wrong");
		}
	}
	
	
	@Test
	public void testAddPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("-5x^4+7x^3+3x^2-2x");
		Polynom p2 = new Polynom ("3x^5+2x^4-7x^3-6x");
		p1.add(p2);
		Polynom p3 = new Polynom ("3x^5-3x^4+3x^2-8x"); //this is the answer of p1+p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function add or equals is wrong");
		}
		
		p1 = new Polynom ("-7x^2+3x");
		p2 = new Polynom ("-3x+7x^2");
		p1.add(p2);
		p3 = new Polynom ("0"); //this is the answer of p1+p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function add or equals is wrong");
		}
		
		p1 = new Polynom ("3x^3-5x^2+7");
		p2 = new Polynom ("4x^3+x^2-6x-7");
		p1.add(p2);
		p3 = new Polynom ("7x^3-4x^2-6x"); //this is the answer of p1+p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function add or equals is wrong");
		}	
	}
	
	@Test
	public void testSubstractPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("-5x^4+7x^3+3x^2-2x");
		Polynom p2 = new Polynom ("3x^5+2x^4-7x^3-6x");
		p1.substract(p2);
		Polynom p3 = new Polynom ("-3x^5-7x^4+14x^3+3x^2+4x"); //this is the answer of p1-p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function substract or add is wrong");
		}
		
		p1 = new Polynom ("3x^3-5x^2+7");
		p2 = new Polynom ("3x^3-x^2-6x+7");
		p1.substract(p2);
	    p3 = new Polynom ("-4x^2+6x"); //this is the answer of p1-p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function substract or add is wrong");
		}	
	}
	
	@Test
	public void testMultiplyPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("3x^3+4x-5x^2");
		Polynom p2 = new Polynom ("x+1");
		p1.multiply(p2);
		Polynom p3 = new Polynom ("3x^4-2x^3-x^2+4x"); //this is the answer of p1*p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function multiply is wrong");
		}
		
		p1 = new Polynom ("-7x^3+3x^2-4");
		p2 = new Polynom ("-3");
		p1.multiply(p2);
		p3 = new Polynom ("21x^3-9x^2+12"); //this is the answer of p1*p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function multiply is wrong");
		}	
		
		p1 = new Polynom ("x+2");
		p2 = new Polynom ("x-2");
		p1.multiply(p2);
		p3 = new Polynom ("x^2-4"); //this is the answer of p1*p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function multiply is wrong");
		}
		
		p1 = new Polynom ("x+2");
		p2 = new Polynom ("0");
		p1.multiply(p2);
		p3 = new Polynom ("0"); //this is the answer of p1*p2
		if(!p1.equals(p3))
		{
			fail("ERR: the function multiply is wrong");
		}
	}
	
	@Test
	public void testCopyPolynom() throws Exception
	{
		Polynom p1 = new Polynom("3x^2+4x^6");
		Polynom p2 = new Polynom();
		p2=(Polynom)(p1.copy());
		if(!p1.equals(p2))
		{
		   fail("ERR: the function copy or equals is wrong");
		}
	}
	
	@Test
	public void testEqualsPolynom() throws Exception
	{
		Polynom p1 = new Polynom("3x^2-4x^6");
		Polynom p2 = new Polynom("-4x^6+3x^2");
		if(!p1.equals(p2))
		{
		   fail("ERR: the function equals is wrong");
		}
		
		p1 = new Polynom("3x^2-4x^6+5");
		p2 = new Polynom("-4x^6+3x^2");
		if(p1.equals(p2)) // p1 and p2 need to be different 
		{
		   fail("ERR: the function equals is wrong");
		}
	}
	
	@Test
	public void testIsZeroPolynom() throws Exception
	{
		Polynom p1 = new Polynom("0+0-0");
		boolean result = p1.isZero(); //need to be true
		if(!result)
		{
		   fail("ERR: the function isZero is wrong");
		}
		
		p1 = new Polynom("2x^2-5x");
		Polynom p2 = new Polynom ("-2x^2+5x");
		p1.add(p2);
		result = p1.isZero();
		if(!result)
		{
		   fail("ERR: the function isZero is wrong");
		}
		
		p1 = new Polynom("2x^2-5x");
		result = p1.isZero(); //need to be false
		if(result)
		{
		   fail("ERR: the function isZero is wrong");
		}
	}
	
	@Test
	public void testDerivativePolynom() throws Exception
	{
		Polynom p1 = new Polynom("5");
		Polynom p2 = new Polynom();
		p2 = (Polynom)(p1.derivative());
		Polynom p3 = new Polynom ("0"); // the derivative of p1
		if(!p2.equals(p3))
		{
			fail("ERR: the function derivative or equals is wrong");
		}
		
	    p1 = new Polynom("7x^3-5x^3+12");
		p2 = (Polynom)(p1.derivative());
		p3 = new Polynom ("21x^2-15x^2"); // the derivative of p1
		if(!p2.equals(p3))
		{
			fail("ERR: the function derivative or equals is wrong");
		}

	}
	
	@Test
	public void testRootPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("x");
		double result = p1.root(-5, 5, 0.01);
		if(!(result<=0.01 && result>=-0.01))
		{
			fail("ERR: the function root is wrong");
		}
		
		p1 = new Polynom ("x^2+3x-5");
		result = p1.root(-10, 0, 0.01);
		if(!(result<=-4.18 && result>=-4.2))
		{
			fail("ERR: the function root is wrong");
		}
		
		p1 = new Polynom ("x^2+3x-5");
		result = p1.root(-1, 4, 0.01);
		if(!(result<=1.2 && result>=1.15))
		{
			fail("ERR: the function root is wrong");
		}
	}
	
	@Test
	public void testAreaPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("x");
		double result = p1.area(0,10,0.01);
		if(!(result<=50.1 && result>=49.9))
		{
			fail("ERR: the function area is wrong");
		}
		
		p1 = new Polynom ("-x^2+3x+5");
		result = p1.area(-1, 2, 0.01);
		if(!(result<=16.6 && result>=16.4))
		{
			fail("ERR: the function area is wrong");
		}
	}
	
	@Test
	public void testAreaUnderPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("x");
		double result = p1.areaUnder(-10,0,0.01);
		if(!(result<=50.1 && result>=49.9))
		{
			fail("ERR: the function areaUnder is wrong");
		}
		
		p1 = new Polynom ("x^2+3x-5");
		result = p1.areaUnder(-6, -2, 0.01);
		if(!(result<=9.4 && result>=9.3))
		{
			fail("ERR: the function areaUnder is wrong");
		}
	}
	
	@Test
	public void testIteretorPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("x^6+4x^5-3x^3+x^2-4+6");
		int count=0; //count how many monoms there are in the polynom
		Iterator<Monom> it = p1.iteretor();
		while(it.hasNext())
		{
			Monom m1=it.next();
			count++;
		}
		if(count!=5)
		{
			fail("ERR: the function Iteretor is wrong");
		}
	}
	
	/*
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	*/

}
