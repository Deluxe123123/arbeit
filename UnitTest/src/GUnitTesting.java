import static org.junit.Assert.*;

import org.junit.Test;


public class GUnitTesting {

	@Test
	public void test() {
		assertEquals(true, true);
	}
	
	@Test
	public void result_should_be_sum_of_two_numbers()
	{
		TestUnitTest testklasse = new TestUnitTest();
		int x = testklasse.addieren(3,5);
		assertEquals(x, 8);
	}
	
	@Test
	public void result_should_be_the_difference_between_two_numbers()
	{
		TestUnitTest testklasse = new TestUnitTest();
		int x = testklasse.subtract(5,3);
		assertEquals(x,2);
	}

}
