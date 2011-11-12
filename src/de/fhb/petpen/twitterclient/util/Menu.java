package de.fhb.petpen.twitterclient.util;

import de.fhb.petpen.twitterclient.exceptions.MenuOptionNotFoundException;

/**
 * Class to create a Menu on the OutputStream
 * 
 * @author Peter Pensold
 *
 */
public class Menu {
	public static final String TEXT_CHOOSE_MENU = "Please choose a number from the menu:";
	
	public Menu() {
	}
	
	/**
	 * Displays the menu with a title and all {@link MenuOption}s
	 * 
	 * @param title for the menu
	 */
	public void display(String title) {
		displayTitle(title);
		displayOptions();
	}

	/**
	 * Displays the title in the following format:<br/>
	 * {@code <title> - Menu:}
	 * 
	 * @param title for the menu
	 */
	private void displayTitle(String title) {
		System.out.println(title + " - Menu:");
		System.out.println();
	}
	
	/**
	 * Displays all values of {@link MenuOption}
	 * in the order of first occurrence in  {@link MenuOption}
	 */
	private void displayOptions() {
		for(MenuOption option : MenuOption.values()) {
			System.out.println(option.getNumber() + " - " + option.getTitle());
		}
	}
	
	/**
	 * Asks the user to choose a number from the menu.
	 * This number will be read from the InputStream<br/>
	 * Displayed text: {@link Menu#TEXT_CHOOSE_MENU}
	 * 
	 * @return the choosed {@link MenuOption}
	 */
	public MenuOption choose() {
		return choose(TEXT_CHOOSE_MENU);
	}
	
	/**
	 * Displays a custom message to the OutputStream and
	 * Asks the user to choose a number from the menu.
	 * This number will be read from the InputStream.
	 * 
	 * @return the choosed {@link MenuOption}
	 */
	public MenuOption choose(String message) {
		boolean isNoNumber = true;
		int number = 0;
		String input = "";
		MenuOption choosedOption = null;
		
		while(isNoNumber) {
			input = ConsoleReader.readLine(message);
			
			try {
				number = Integer.parseInt(input);
				isNoNumber = false;
			} catch(NumberFormatException e) {
				System.out.println("This was not a number, please try again:");
			}
			
			try {
				choosedOption = MenuOption.get(number);
			} catch (MenuOptionNotFoundException e) {
				System.out.println("This number is not part of the menu, please try again:");
				isNoNumber = true;
			}
		}
		
		return choosedOption;
	}
}
