package rebuilding.day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HardAssertions {

	@Test
	public void testHardAssertion() {
		int actual1 = 5;

		String actual2 = "10";

		assertThat(actual1).isLessThan(4);

		assertThat(actual2).isEqualTo("11");
	}

}
