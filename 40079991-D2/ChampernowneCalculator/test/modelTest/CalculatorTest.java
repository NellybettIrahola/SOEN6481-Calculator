package modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Calculator;

public class CalculatorTest {
	Calculator calculator;
	@Before
	public void setUp() throws Exception {
		this.calculator=new Calculator();
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testIsOperator() {
		boolean expected=true;
		boolean result=this.calculator.isOperator('+');
		
		assertEquals(expected,result);
	}
	
	@Test
	public void testIsOperator1() {
		boolean expected=false;
		boolean result=this.calculator.isOperator('1');
		
		assertEquals(expected,result);
	}

}
