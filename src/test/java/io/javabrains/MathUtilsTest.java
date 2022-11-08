package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;


class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Runs before all methods");
		
	}
	
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		//System.out.println("Currently running method "+testInfo.getDisplayName()+ " with tags "+testInfo.getTags());
		testReporter.publishEntry("Currently running method "+testInfo.getDisplayName()+ " with tags "+testInfo.getTags());
		mathUtils = new MathUtils();
		
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up");
	}
	
	@Nested
	@Tag("Math")
	class TestAdd{
		
		@Test
		@DisplayName("Adding two positives")
		
		void testAddPositives() {
			
			
			assertEquals(2, mathUtils.add(1,1), "should provide the right sum"); 
		}
		
		@Test
		@DisplayName("Adding two negatives")
		
		void testAddNegatives() {
			
			
			assertEquals(-2, mathUtils.add(-1,-1), "should provide the right sum"); 
		}
		
	}
	
	
	@Test
	@DisplayName("Testing Multiply method")
	@Tag("Math")
	void testMultiply() {
		
		assertAll(
			() -> assertEquals(4, mathUtils.multiply(2,2)),
			() -> assertEquals(0, mathUtils.multiply(2,0)),
			() -> assertEquals(-2, mathUtils.multiply(2,-1)));		
		}
	
	
	
	@Test
	@Tag("Math")
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
	}
	
	@RepeatedTest(3)
	@Tag("Circle")
	void testAreaCircle(RepetitionInfo repInfo) {
		int rep=repInfo.getCurrentRepetition();
		if(rep == 3) {
			System.out.println("This is the last rep");
		}
		
		assertEquals(314.1592653589793, mathUtils.areaCircle(10), "The area should be calculated accurately");
	}
	
	@Test
	@Disabled
	void testToFail() {
		fail("Fail Test");
	}
	
	

}
