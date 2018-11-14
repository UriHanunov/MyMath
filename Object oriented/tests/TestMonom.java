
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;

public class TestMonom {
	
	@Test
	public void testAddMonom() throws Exception
	{
		Monom m1 = new Monom(3,4);
		Monom m2 = new Monom(4,4);
		Monom m3 = new Monom(4,2);
		m1.add(m2);
		if(m1.get_coefficient()!=7) //when the powers are equals
		{
			fail("ERR: the function addMonom is wrong");
		}
		m2.add(m3);
		if(m2.get_coefficient()!=4) //when the powers are not equals and the coefficient need to be like it was
		{
			fail("ERR: the function addMonom is wrong");
		}
		Monom m4 = new Monom(3,0);
		Monom m5 = new Monom(4,0);
		m4.add(m5);
		if(m4.get_coefficient()!=7) //when the powers are equals but there is just numbers
		{
			fail("ERR: the function addMonom is wrong");
		}
	}
	
	@Test
	public void testMultiplyMonom() throws Exception
	{
		Monom m1 = new Monom(3,4);
		Monom m2 = new Monom(4,2);
		m1.multiply(m2);
		if(m1.get_coefficient()!=12 || m1.get_power()!=6)
		{
			fail("ERR: the function multiplyMonom is wrong");
		}
		Monom m3 = new Monom(2,2);
		m1.multiply(m3);
		if(m1.get_coefficient()!=24 || m1.get_power()!=8)
		{
			fail("ERR: the function multiplyMonom is wrong");
		}
		Monom m4 = new Monom(0,2);
		m1.multiply(m4);
		if(m1.get_coefficient()!=0 || m1.get_power()!=10)
		{
			fail("ERR: the function multiplyMonom is wrong");
		}
		Monom m5 = new Monom(2,0);
		m3.multiply(m5);
		if(m3.get_coefficient()!=4 || m3.get_power()!=2)
		{
			fail("ERR: the function multiplyMonom is wrong");
		}
	}
	
	@Test
	public void testDerivativeMonom() throws Exception
	{
		Monom m1 = new Monom(3,4);
		Monom m2 = new Monom(3,0);
		Monom m3 = new Monom(3,1);
		Monom m4 = new Monom(0,4);
		m1.derivative();
		m2.derivative();
		m3.derivative();
		m4.derivative();
		if(m1.get_coefficient()!=12 || m1.get_power()!=3)
		{
			fail("ERR: the function derivativeMonom is wrong");
		}
		if(m2.get_coefficient()!=0 || m2.get_power()!=0)
		{
			fail("ERR: the function derivativeMonom is wrong");
		}
		if(m3.get_coefficient()!=3 || m3.get_power()!=0)
		{
			fail("ERR: the function derivativeMonom is wrong");
		}
		if(m4.get_coefficient()!=0 || m4.get_power()!=3)
		{
			fail("ERR: the function derivativeMonom is wrong");
		}
	}
	
	@Test
	public void testEqualsMonom() throws Exception
	{
		Monom m1 = new Monom(3,4);
		Monom m2 = new Monom(3,4);
		Monom m3 = new Monom(5,4);
		boolean temp = m1.equals(m2);
		boolean temp2 = m1.equals(m3);
		if(temp!=true || temp2!=false)
		{
			fail("ERR: the function equalsMonom is wrong");
		}
	}
	
	@Test
	public void testFMonom() throws Exception
	{
		Monom m1 = new Monom(3,2);
		double result = m1.f(3);
		if(result!=27)
		{
			fail("ERR: the function f is wrong");
		}
		Monom m2 = new Monom(-5,3);
		result = m2.f(2);
		if(result!=-40)
		{
			fail("ERR: the function f is wrong");
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
