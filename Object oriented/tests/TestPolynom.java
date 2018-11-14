import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class TestPolynom {
	
	
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
		Polynom p3 = new Polynom ("3x^5-3x^4+3x^2-8x");
		
		if(!p1.equals(p3))
		{
			fail("ERR: the function add or equals is wrong");
		}
		
		p1 = new Polynom ("-7x^2+3x");
		p2 = new Polynom ("-3x+7x^2");
		p1.add(p2);
		Polynom p3 = new Polynom ("0");
		
		if(!p1.equals(p3))
		{
			fail("ERR: the function add or equals is wrong");
		}
		
		p1 = new Polynom ("3x^3-5x^2+7");
		p2 = new Polynom ("4x^3+x^2-6x-7");
		p1.add(p2);
		p3 = new Polynom ("7x^3-4x^2-6x");
		
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
		Polynom p3 = new Polynom ("-3x^5-7x^4+14x^3+3x^2+4x");
		
		if(!p1.equals(p3))
		{
			fail("ERR: the function substract or add is wrong");
		}
		
		p1 = new Polynom ("3x^3-5x^2+7");
		p2 = new Polynom ("3x^3-x^2-6x+7");
		p1.add(p2);
	    p3 = new Polynom ("-4x^2+6x");
		
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
		Polynom p3 = new Polynom ("3x^4-2x^3-x^2+4x");
		
		if(!p1.equals(p3))
		{
			fail("ERR: the function multiply is wrong");
		}
		
		p1 = new Polynom ("-7x^3+3x^2-4");
		p2 = new Polynom ("-3");
		p1.multiply(p2);
		p3 = new Polynom ("21x^3-9x^2+12");
		
		if(!p1.equals(p3))
		{
			fail("ERR: the function multiply is wrong");
		}	
		
		p1 = new Polynom ("x+2");
		p2 = new Polynom ("x-2");
		p1.multiply(p2);
		p3 = new Polynom ("x^2-4");
		
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
		p1=(Polynom)(p2.copy());
		
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
	}
	
	@Test
	public void testIsZeroPolynom() throws Exception
	{
		Polynom p1 = new Polynom("0+0-0");
		boolean result = p1.isZero();
	
		if(!result)
		{
		   fail("ERR: the function isZero is wrong");
		}
		
		p1 = new Polynom("2x^2-5x"); //need to check it this ok
		Polynom p2 = new Polynom ("-2x^2+5x");
		p1.add(p2);
		result = p1.isZero();
	
		if(!result)
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
		Polynom p3 = new Polynom ("0");
		
		if(!p2.equals(p3))
		{
			fail("ERR: the function derivative or equals is wrong");
		}
		
	    p1 = new Polynom("7x^3-5x^3+12");
		p2 = new Polynom();
		p2 = (Polynom)(p1.derivative());
		p3 = new Polynom ("21x^2-15x^2");
		
		if(!p2.equals(p3))
		{
			fail("ERR: the function derivative or equals is wrong");
		}

	}
	
	@Test
	public void testRootPolynom() throws Exception
	{
		Polynom p1 = new Polynom ("x");
		double result = p1.root(-2, 10, 0.01);
		
		if(result!=0)
		{
			fail("ERR: the function root is wrong");
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
