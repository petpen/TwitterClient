package de.fhb.petpen.twitterclient;

import de.fhb.petpen.twitterclient.client.TwitterClient;

public class TwitterApp {
	
	public static void main(String[] args) {
		TwitterClient client = new TwitterClient();
		client.run();
	}
}