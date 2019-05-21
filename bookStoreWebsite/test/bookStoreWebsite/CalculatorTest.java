package bookStoreWebsite;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalculate() {
		Calculator calc = new Calculator();
		int a=1234;
		int b=5678;
		
		int res=calc.calculate(a, b);
		
		int expected = 6912;
		//fail("Not yet implemented");
		assertEquals(expected, res);
	
	
	}

}
