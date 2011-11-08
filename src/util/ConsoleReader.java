package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reader for the InputStream
 * 
 * @author Peter Pensold
 *
 */
public class ConsoleReader {
	private static String errorMessageIO = "There was an error while reading. An empty String will be returned";
	
	/**
	 * Displays no message on the OutputStream.
	 * Reads a message from the InputStream.
	 * 
	 * @return the line entered by the user
	 */
	public static String readLine() {
		return readLine("");
	}
	
	/**
	 * Displays a given message on the OutputStream
	 * Reads a message from the InputStream
	 * 
	 * @param message - to display on the OutputStream
	 * @return the line entered by the user
	 */
	public static String readLine(String message) {
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		if(message.length() > 0)
			System.out.println(message);
		
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.out.println(errorMessageIO);
			line = "";
		}
		
		return line;
	}
}
