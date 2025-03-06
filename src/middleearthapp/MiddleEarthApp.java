package middleearthapp;

//Importing Characters for our Character Managment System
import java.util.Scanner;
import middleearthapp.characters.Dwarf;
import middleearthapp.characters.Elf;
import middleearthapp.characters.Human;
import middleearthapp.characters.MiddleEarthCharacter;
import middleearthapp.characters.Orc;
import middleearthapp.characters.Wizard;
import middleearthapp.manager.CharacterManager;
import middleearthapp.manager.MiddleEarthCouncil;
import middleearthapp.manager.AttackExecutor;


public class MiddleEarthApp {

	public static void main(String[] args) {
		
		//Retrieving Singleton instance of MiddleEarthCouncil
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		
		//Now that we have the council instance we can get our Character Manager
		CharacterManager manager = council.getCharacterManager();
		
		// Create a Scanner for user input in the console
		Scanner scanner = new Scanner(System.in);
	
		boolean exit = false;
		
		// Continously display a menu until user chooses to exit
		while (!exit) {
			System.out.println("============ Middle-Earth Menu ===========");
			System.out.println("1. Add a new character");
			System.out.println("2. View all characters.");
			System.out.println("3. Update a character");
			System.out.println("4. Delete a character");
			System.out.println("5. Execute all character's attack actions");
			System.out.println("6. Exit");
			System.out.println("==========================================");
			System.out.print("Please type a number (1-6) in the terminal to select a menu option or type ??? for the backstory: ");
			
			// First read user's input as a string to check for "???"
			String menuInput = scanner.nextLine().trim();
			
			// If user typed  ??? at the main menu, 
			if (menuInput.equals("???")) {
				printBackstory();
				continue; //goes back to the start of the while loop
			}
			
			// Otherwise, try to parse an integer from the input
			int choice = 0;
			try {
				choice = Integer.parseInt(menuInput);
			}catch (Exception e) {
				System.out.println("Invalid input; please enter a number between 1 and 6, or ??? to ");
			}
			
			// Switch on the parsed choice
			switch (choice) {
				case 1:
					addCharacters(manager, scanner);
					break;
				case 2:
					System.out.println("\n--- View All Characters ---");
					manager.displayAllCharacters();
					break;
				case 3:
					updateCharacterMenu(manager, scanner);
					break;
				case 4:
					deleteCharacterMenu(manager, scanner);
	                break;
	            case 5:
	                AttackExecutor.executeAttacks(manager);
	                break;
	            case 6:
	                System.out.println("Hope you enjoyed our application, see you next time! :)");
	                exit = true;
	                break;
	            default:
	                System.out.println("Invalid choice; please choose a number (1-6), or ??? for backstory.");
	        }
	    }
	
	    scanner.close();
	}
	
	//Prints the Middle-earth backstory. Triggered when user types "???"
	public static void printBackstory() {
		System.out.println("\nThe great realms of Middle-earth—Rohan, Gondor, Mordor, and beyond—are preparing for the coming battle. "
				+ "You have been summoned by the White Council to build a Character Management System that keeps track of heroes, villains, and mythical beings. "
				+ "The system should allow new characters to be added and existing ones to be updated, viewed, or removed as the tides of war shift. "
				+ "However, as we all know, there could be no peace in Middle-earth. "
				+ "Characters will battle and attack each other for the One ring crafted by Sauron at Mount Doom.");
	}

	/**
	 * addCharacterMenu Prompts user to create a new MiddleEarthCharacter
	 * They must specify the characters name, health, power and race.
	 * Then we add that new character to the Character Manager.
	 * Else - we tell they user they entered an invalid entry and ask them if they would like to continue or return back to main menu
	 * @param manager
	 * @param scanner
	 */
	private static void addCharacters(CharacterManager manager, Scanner scanner) {
		System.out.println("\n-- Add new Character ---");
		System.out.print("Enter Character name:" );
		
		String name = scanner.nextLine();

        double health = 0;
        double power = 0;
        try {
            System.out.print("Enter character health (number): ");
            health = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter character power (number): ");
            power = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input. Returning to main menu.");
            return;
        }
        
        System.out.print("Enter character race (Elf, Dwarf, Human, Orc, Wizard): ");
        String race = scanner.nextLine();
        MiddleEarthCharacter newChar = null;
        
        if (race.equalsIgnoreCase("Elf")) {
            newChar = new Elf(name, health, power);
        } else if (race.equalsIgnoreCase("Dwarf")) {
            newChar = new Dwarf(name, health, power);
        } else if (race.equalsIgnoreCase("Human")) {
            newChar = new Human(name, health, power);
        } else if (race.equalsIgnoreCase("Orc")) {
            newChar = new Orc(name, health, power);
        } else if (race.equalsIgnoreCase("Wizard")) {
            newChar = new Wizard(name, health, power);
        } else {
            System.out.println("Invalid race entered. Returning to main menu.");
            return;
        }
        
        boolean added = manager.addCharacter(newChar);
        if (added) {
            System.out.println("Character " + name + " added successfully!");
        } else {
            System.out.println("Failed to add character.");
        }
        
	}
	
	/**
	 * updateCharacterMenu prompts the user to update exsisting character by looking that character up by its name.
	 * They can change that characters name, health or power.
	 * They can skip each field they don't want to change by pressing enter.
	 * If the user enters incorrect values they're are prompted to try again or return to main menu.
	 * 
	 * @param manager
	 * @param scanner
	 */
	private static void updateCharacterMenu(CharacterManager manager, Scanner scanner) {
		System.out.println("\n---Update Characters ---");
		System.out.print("Enter the name of the character to update");
		String name = scanner.nextLine();
		MiddleEarthCharacter character = manager.getCharacter(name);
		
		if(character == null) {
			System.out.println("Charcter not found. Returning to main menu");
			return;
		}
		
		 System.out.print("Enter new name (or press Enter to keep '" + character.getName() + "'): ");
	        String newName = scanner.nextLine();
	        if (newName.isEmpty()) {
	            newName = character.getName();
	            }
	        
	        System.out.print("Enter new health (or press Enter to keep current health " + character.getHealth() + "): ");
	        String healthInput = scanner.nextLine();
	        int newHealth;
	        if (healthInput.isEmpty()) {
	            newHealth = (int) character.getHealth();
	        } else {
	            try {
	                newHealth = Integer.parseInt(healthInput);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid number input. Update aborted.");
	                return;
	            }
	        }
	        System.out.print("Enter new power (or press Enter to keep current power " + character.getPower() + "): ");
	        String powerInput = scanner.nextLine();
	        int newPower;
	        if (powerInput.isEmpty()) {
	            newPower = (int) character.getPower();
	        } else {
	            try {
	                newPower = Integer.parseInt(powerInput);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid number input. Update aborted.");
	                return;
	            }
	        }

	        boolean updated = manager.updateCharacter(character, newName, newHealth, newPower);
	        if (updated) {
	            System.out.println("Character updated successfully!");
	        } else {
	            System.out.println("No changes were made to the character.");
	        }
	    }
	
	/**
	 * deleteCharcterMenu prompts the user for a characters name again, locates that character and if found deletes it.
	 * If not found prompts the user that the character they searched was not found and to try again or return to main menu.
	 * 
	 * @param manager the CharacterManager that holds all characters
	 * @param scanner a Scanner for user input
	 */
	private static void deleteCharacterMenu(CharacterManager manager, Scanner scanner) {
		System.out.println("\n--- Delete Character ---");
	    System.out.print("Enter the name of the character to delete: ");
	    String name = scanner.nextLine().trim(); 

	    MiddleEarthCharacter character = manager.getCharacter(name);

	    if (character == null) {
	        System.out.println("Character not found. Returning to main menu.");
	        return;
	    }

	    boolean deleted = manager.deleteCharacter(character);
	    if (deleted) {
	        System.out.println("Character " + name + " deleted successfully!");
	    } else {
	        System.out.println("Failed to delete character.");
	    }
    }

}
