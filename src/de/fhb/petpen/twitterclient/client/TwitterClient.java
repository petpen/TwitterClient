package de.fhb.petpen.twitterclient.client;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import de.fhb.petpen.twitterclient.exceptions.AccessAccountFailedException;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserStream;
import twitter4j.UserStreamListener;
import de.fhb.petpen.twitterclient.util.Menu;
import de.fhb.petpen.twitterclient.util.MenuOption;

/**
 * Client for Twitter.
 * This client responses other Twitter users who mention the one that uses this client.
 * 
 * @author Peter Pensold
 */
public class TwitterClient {
	private TwitterAuthorization auth = null;
	private Twitter twitter = null;
	private String userScreenName = "";
	private GregorianCalendar startDate = null;
	private TwitterStream stream = null;
	
	/**
	 * Initializes the TwitterClient with a new instance from the {@link TwitterFactory}
	 */
	public TwitterClient() {
		twitter = new TwitterFactory().getInstance();
	}
	
	/**
	 * With {@link TwitterClient#run()} the client starts working
	 * The client will be closed if the user selects {@link MenuOption#QUIT} from the menu displayed on the OutputStream
	 */
	public void run() {
		try {
			authorize();
			greetUser();

			startDate = new GregorianCalendar();
			
			followUserStatusStream();
			startMenuLoop();
		} catch (AccessAccountFailedException e) {
			System.out.println("Unable to connect to account. You probably misspelled the PIN. Program terminated.");
		}
		
		System.out.println("Good bye");
	}

	/**
	 * Listens to the {@link UserStream} with the {@link UserStatusStreamListener}
	 */
	private void followUserStatusStream() {
		UserStreamListener listener = new UserStatusStreamListener(twitter, userScreenName, this);
		stream = new TwitterStreamFactory().getInstance();
		stream.setOAuthConsumer(auth.getOAuthConsumerKey(), auth.getOAuthConsumerSecret());
		stream.setOAuthAccessToken(auth.getAccessToken());
		stream.addListener(listener);
		stream.user();
	}

	/**
	 * A loop of the menu will be displayed to the OutputStream.
	 * 
	 * This loop will quit if the user choosed the number for
	 * {@link MenuOption#QUIT}  
	 */
	private void startMenuLoop() {
		boolean isRunning = true;
		MenuOption option = MenuOption.SHOW_MENU;
		Menu menu = new Menu();
		
		while(isRunning) {
			menu.display("Twitter Client");
			option = menu.choose();

			switch(option) {
				case QUIT:
					close();
					isRunning = false;
					break;
				case SHOW_STATS:
					displayStats();
					break;
			}
		}
	}

	/**
	 * This method will shutdown the {@link UserStream} listened by the client.
	 */
	private void close() {
		System.out.println("Shutting down stream. This may take a while");
		stream.shutdown();
		System.out.println("Done");
	}

	/**
	 * Displays the following information on the console output
	 * <ul>
	 * 	<li>Twitter Accountname</li>
	 *  <li>Time the client is running</li>
	 * </ul>
	 */
	private void displayStats() {
		SimpleDateFormat formater = new SimpleDateFormat();
		
		System.out.println();
		System.out.println("Statistic");
		System.out.println("Account: " + userScreenName);
		System.out.println("Running since: " + formater.format(startDate.getTime()));
		System.out.println();
	}

	/**
	 * Authorizes the twitter user account with
	 * a authorization procedure based in {@link TwitterAuthorization}
	 * 
	 * @throws AccessAccountFailedException
	 */
	private void authorize() throws AccessAccountFailedException {
		auth = new TwitterAuthorization(twitter);
	}

	/**
	 * Greet the user on the OutputStream
	 */
	private void greetUser() {
		try {
			userScreenName = twitter.getScreenName();
		} catch (Exception e) {
			userScreenName = "Unkown";
		}

		System.out.printf("\nYou are now logged in as: %s\n\n", userScreenName);
	}
}
