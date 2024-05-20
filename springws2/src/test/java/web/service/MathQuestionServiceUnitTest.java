package web.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathQuestionServiceUnitTest {	
	@Test
    public void testValidInputsValidResultForQ1() {
        assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
    }

    @Test
    public void testInvaidNum12ForQ1() {
    	assertEquals(MathQuestionService.q1Addition("Invalid", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testValidNum1InValidNumber2ForQ1() {
    	assertEquals("Stay on q1 page", MathQuestionService.q1Addition("1", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testInvaidNum1ValidNumber2ForQ1() {
    	assertEquals("Stay on q1 page", MathQuestionService.q1Addition("Invalid", "2"), Double.NaN, 0);
    }
    
	@Test
    public void testValidInputsValidResultForQ2() {
        assertEquals(MathQuestionService.q2Subtraction("6", "2"), 4, 0);
    }

    @Test
    public void testInvaidNum12ForQ2() {
    	assertEquals(MathQuestionService.q2Subtraction("Invalid", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testValidNum1InValidNumber2ForQ2() {
    	assertEquals("Stay on q1 page", MathQuestionService.q2Subtraction("1", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testInvaidNum1ValidNumber2ForQ2() {
    	assertEquals("Stay on q1 page", MathQuestionService.q2Subtraction("Invalid", "2"), Double.NaN, 0);
    }
    
	@Test
    public void testValidInputsValidResultForQ3() {
        assertEquals(MathQuestionService.q3Multiplication("9", "2"), 18, 0);
    }

    @Test
    public void testInvaidNum12ForQ3() {
    	assertEquals(MathQuestionService.q3Multiplication("Invalid", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testValidNum1InValidNumber2ForQ3() {
    	assertEquals("Stay on q1 page", MathQuestionService.q3Multiplication("1", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testInvaidNum1ValidNumber2ForQ3() {
    	assertEquals("Stay on q1 page", MathQuestionService.q3Multiplication("Invalid", "2"), Double.NaN, 0);
    }

}
