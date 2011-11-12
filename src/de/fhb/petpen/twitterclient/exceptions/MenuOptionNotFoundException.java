package de.fhb.petpen.twitterclient.exceptions;

public class MenuOptionNotFoundException extends Exception {
	private static final long serialVersionUID = -1440437442947345165L;

	public MenuOptionNotFoundException() {
		super("This option does not exist.");
	}
	
	public MenuOptionNotFoundException(String string) {
		super(string);
	}

}
