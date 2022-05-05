package rebuilding.day4;

import org.junit.Test;
import org.assertj.core.api.SoftAssertions;

public class SoftAssert {
	@Test
	public void testHardAssertion() {

		int actual1 = 5;
		String actual2 = "10";

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(actual1).isLessThan(4);

		softAssertions.assertThat(actual2).isEqualTo("11");

		softAssertions.assertAll();
	}

}
