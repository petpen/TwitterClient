package util;

import exceptions.MenuOptionNotFoundException;

/**
 * Enum with different options for the {@link Menu}
 * 
 * @author Peter Pensold
 */
public enum MenuOption {
	SHOW_MENU(0, "Show this menu"),
	SHOW_STATS(1, "Show statistics"),
	QUIT(2, "Quit program");
	
	private int number;
	private String title;
	
	/**
	 * @param number to choose from the menu
	 * @param title for this option
	 */
	private MenuOption(int number, String title) {
		this.number = number;
		this.title = title;
	}
	
	/**
	 * Searches all options for the one
	 * with the requested number
	 * 
	 * @param number to look for
	 * @return the corresponding MenuOption
	 * 
	 * @throws MenuOptionNotFoundException
	 */
	public static MenuOption get(int number) throws MenuOptionNotFoundException {
		MenuOption choosed = null;
		
		for(MenuOption option : MenuOption.values()) {
			if(option.getNumber() == number)
				choosed = option;
		}
		
		if(choosed == null)
			throw new MenuOptionNotFoundException();
		
		return choosed;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getTitle() {
		return this.title;
	}
}
