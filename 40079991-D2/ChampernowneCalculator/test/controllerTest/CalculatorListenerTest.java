package controllerTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.CalculatorListener;
import model.ChampernowneModel;

public class CalculatorListenerTest {
	
	CalculatorListener calculator;
	
	@Before
	public void setUp(){
		ChampernowneModel model=new ChampernowneModel();
		this.calculator=new CalculatorListener(model);
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testValidateExpression() {
		int expected=-1;
		int result=this.calculator.validateExpression("((2 + 4) * 3");
		
		assertEquals(expected,result);
	}
	
	@Test
	public void testValidateExpression1() {
		int expected=0;
		int result=this.calculator.validateExpression("((2 + 4) * 3)");
		
		assertEquals(expected,result);
	}

}
