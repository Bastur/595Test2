import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@Test
	void test() {
		HelloWorld test = new HelloWorld();
		assertNotNull(test); //checks to see if this is null or not
	}

}
