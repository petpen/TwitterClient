import exceptions.AccessAccountFailedException;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserStream;
import twitter4j.UserStreamListener;

public class TwitterClient {
	private TwitterAuthorization auth = null;
	private Twitter twitter = null;
	private String userScreenName = "";
	private TwitterStream stream = null;
	
	public TwitterClient() {
		twitter = new TwitterFactory().getInstance();
	}
	
	/**
	 * Connects the twitter user account to this client
	 * and calls {@link TwitterClient#greetUser()} to greet the user
	 * 
	 * @throws AccessAccountFailedException
	 */
	public void connect() throws AccessAccountFailedException {
		authorize();
		greetUser();
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
	 * Greets the user on the OutputStream
	 */
	private void greetUser() {
		try {
			userScreenName = twitter.getScreenName();
		} catch (Exception e) {
			userScreenName = "Unkown";
		}

		System.out.printf("\nYou are now logged in as: %s\n\n", userScreenName);
	}

	/**
	 * Listens to the {@link UserStream} with the {@link UserStatusStreamListener}
	 */
	public void followUserStatusStream() {
		UserStreamListener listener = new UserStatusStreamListener(twitter, userScreenName);
		
		stream = new TwitterStreamFactory().getInstance();
		stream.setOAuthConsumer(auth.getOAuthConsumerKey(), auth.getOAuthConsumerSecret());
		stream.setOAuthAccessToken(auth.getAccessToken());
		stream.addListener(listener);
		stream.user();
	}

}
