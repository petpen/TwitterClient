import exceptions.AccessAccountFailedException;

public class TwitterApp {
	
	public static void main(String[] args) {
		TwitterClient client = new TwitterClient();
		
		try {
			client.connect();
			client.followUserStatusStream();
		} catch (AccessAccountFailedException e) {
			System.out.println("Unable to connect to account. Program terminated.");
		}
	}
}