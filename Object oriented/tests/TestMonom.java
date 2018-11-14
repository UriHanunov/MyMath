
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
		m1.add(m2);
		if(m1.get_coefficient()!=7)
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
	}
	
	@Test
	public void testDerivativeMonom() throws Exception
	{
		Monom m1 = new Monom(3,4);
		m1.derivative();
		if(m1.get_coefficient()!=12 || m1.get_power()!=3)
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
			fail("ERR: the function 'f' is wrong");
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
