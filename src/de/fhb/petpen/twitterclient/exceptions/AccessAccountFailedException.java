package de.fhb.petpen.twitterclient.exceptions;
import twitter4j.TwitterException;

public class AccessAccountFailedException extends TwitterException {

	private static final long serialVersionUID = 2330378404184348272L;

	public AccessAccountFailedException(String message) {
		super(message);
	}
}
