package answers;

import java.util.Random;

/**
 * Generator for twitter answers
 * 
 * @author Peter Pensold
 */
public class AnswerGenerator {
	
	/**
	 * Creates a simple and random calculation for the sender.<br/>
	 * Example: @sender did you know 5 + 10 is 15?
	 * 
	 * @param senderScreenName - name of sender. will be used to address the user  
	 * 
	 * @return String containing an answer with a calculation as a question
	 */
	public static String randomMathAnswer(String senderScreenName) {
		Random random = new Random();
		String operation = ""; 
		int numberA = random.nextInt(100);
		int numberB = random.nextInt(100);
		int result = 0;
		
		if(random.nextBoolean()) {
			operation = "+";
			result = numberA + numberB;
		} else {
			operation = "-";
			result = numberA - numberB;
		}
		
		return String.format("@%s did you know %d %s %d is %d?", senderScreenName, numberA, operation, numberB, result);
	}
}
