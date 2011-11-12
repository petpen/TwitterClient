package de.fhb.petpen.twitterclient.client;
import de.fhb.petpen.twitterclient.answers.AnswerGenerator;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserStreamAdapter;
import twitter4j.UserStreamListener;

/**
 * Listener <b>only</b> for activities on the user status and mentions of this bound twitter account
 * 
 * @author Peter Pensold
 */
public class UserStatusStreamListener extends UserStreamAdapter implements UserStreamListener {
	
	/** Format for the answer which will be displayed inside the console */
	private final static String ANSWER_FORMAT = "> Request from %s: %s\n\tAnswer: %\n";
	
	private Twitter twitter;
	private String userScreenName = "";
	
	public UserStatusStreamListener(Twitter twitterInstance, String userScreenName, TwitterClient client) {
		this.twitter = twitterInstance;
		this.userScreenName = userScreenName;
	}
	
	/**
	 * Called when the account bound to the client receives a status change.
	 * This includes the own status and mentions of the bound twitter account.
	 * 
	 * @param status - status to which the client will respond
	 */
	public void onStatus(Status status) {
		String answer = "";
		User sender = status.getUser();

		if(senderIsNotUser(sender.getScreenName())) {
			answer = AnswerGenerator.randomMathAnswer(sender.getScreenName());
			
			answerSender(sender, status.getText(), answer);
		}
	}

	/**
	 * Checks if the screen name of the bound twitter account is the
	 * sender or not.
	 * 
	 * @param senderName - screen name of the message sender
	 *  
	 * @return true if user is not the sender and false if sender is user
	 */
	private boolean senderIsNotUser(String senderName) {
		return (senderName.equals(userScreenName) == false);
	}

	/**
	 * Sends the given answer to the given sender
	 * and logs this request to the OutputStream.
	 * Errors will be logged to the console too.
	 * 
	 * @param sender - data of the sender to which the answer should be sent to
	 * @param request - the request message from the sender
	 * @param answer - the answer that should be sent to the sender
	 * 
	 * @return - true if the sending was successful or false if not
	 */
	private boolean answerSender(User sender, String request, String answer) {
		boolean sendSuccessful = false;
		
		try {
			twitter.updateStatus(answer);
			sendSuccessful = true;
			
			//I don't know why printf or String.format() doesn't work. This is just a workaround for the line thereunder
			System.out.println("> Request from " + sender.getScreenName() + ": " + request + "\n\tAnswer: " + answer);
			//System.out.printf(ANSWER_FORMAT, sender.getScreenName(), request, answer);
		} catch (TwitterException ex) {
			sendSuccessful = false;

			if(ex.getStatusCode() == 403)
				System.out.println("Can't answer again. I answered this before");
			else
				System.out.println("Something went wrong with Twitter...");
				ex.printStackTrace();
		}
		
		return sendSuccessful;
	}
}
