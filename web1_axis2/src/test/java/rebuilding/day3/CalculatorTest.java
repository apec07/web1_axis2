package rebuilding.day3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CalculatorTest {
	
	 @Test
	    public void add_5_and_10_return_15() {
	        // 1. Arrange
	        Calculator cal = new Calculator();
	        int number1 = 5;
	        int number2 = 10;
	        int expected = 15;

	        // 2. Act
	        int actual = cal.add(number1,number2);
	        // 3. Assert
	        assertThat(actual).isEqualTo(expected);
	 }

}
