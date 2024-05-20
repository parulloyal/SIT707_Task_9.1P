package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q1Addition(String number1, String number2) {
		if ((validateNumber(number1) && validateNumber(number2))==true) {
            double result = Double.parseDouble(number1) + Double.parseDouble(number2);
            return result;
        } else {
            return Double.NaN;
        }
		
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q2Subtraction(String number1, String number2) {
		if ((validateNumber(number1) && validateNumber(number2))==true) {
			double result = Double.valueOf(number1) - Double.valueOf(number2);
            return result;
        } else {
            return Double.NaN;
        }
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q3Multiplication(String number1, String number2) {
		if ((validateNumber(number1) && validateNumber(number2))==true) {
			double result = Double.valueOf(number1) * Double.valueOf(number2);
            return result;
        } else {
            return Double.NaN;
        }
	}
	
	public static boolean validateNumber(String number) {
	    try {
	        double val = Double.parseDouble(number);
	        // If parsing succeeds, return true
	        return true;
	    } catch (NumberFormatException e) {
	        // If parsing fails for either number, return false
	        return false;
	    }
	}

}
