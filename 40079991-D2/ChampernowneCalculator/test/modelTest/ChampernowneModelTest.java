package modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.ChampernowneModel;

public class ChampernowneModelTest {

	ChampernowneModel champernowne;
	
	@Before
	public void setUp(){
		this.champernowne=new ChampernowneModel();
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testGetPatternPosition() {
		 int expected=3;
		 int result=this.champernowne.getPatternPosition("123", ChampernowneModel.calculate(4, 10));
		 
		 assertEquals(expected,result);
	}
	
	@Test
	public void testGetPatternPosition1() {
		 int expected=0;
		 int result=this.champernowne.getPatternPosition("999", ChampernowneModel.calculate(4, 10));
		 
		 assertEquals(expected,result);
	}

	@Test
	public void testBaseConversion() {
		String expected="11";
		String result=this.champernowne.baseConversion("3", 10, 2);
		
		 assertEquals(expected,result);
	}

	@Test
	public void testCalculate() {
		String expected="0.1234";
		String result=ChampernowneModel.calculate(4, 10);
			assertEquals(expected,result);
	}
	
	@Test
	public void testCalculateAlternative() {
		String expected="0.1234567891";
		String result=this.champernowne.calculateAlternative(10, 10);
			assertEquals(expected,result);
	}
	
	@Test
	public void testDecryptSubstitution() {
		String expected="Hola, como estas?";
		String result=this.champernowne.decryptSubstitution("Ipnb/!gprp&fzuit|", 12);
		assertEquals(expected,result);
	}

	

}
