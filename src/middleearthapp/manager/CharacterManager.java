package middleearthapp.manager;

import middleearthapp.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	public CharacterManager() {
		
	}
	
	public CharacterManager(MiddleEarthCharacter[] characters, int size) {
		super();
		this.characters = characters;
		this.size = size;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if (c == null) {
			return false; //makes sure that empty object isn't passed in*/
		}
		if (size >= characters.length) { //if full, copies characters to new array, doubled in length to make space
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[characters.length*2];
			for (int i = 0; i<characters.length; i++) { //copies characters over 
				newCharacters[i] = characters[i];
			}
			characters = newCharacters;
			
		}
		characters[size] = c; //size incremented to keep track of # of characters
		size++;
		
		System.out.println("Character added.");
		return true;
		//adds character to end of characters array
	}
	
	
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) { //iterates through characters until name matches given string
			if (characters[i] != null && characters[i].getName().equals(name)) {
                return characters[i]; //returns character object if name matches
            }
		}
			return null;
	}
	
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		boolean flag = false;
		
		if (character == null) {
			return flag;
		}
		
		if (!character.getName().equals(name)) {
			character.setName(name);
			flag = true;
		}
		
		if (character.getHealth() != health) {
			character.setHealth(health);
			flag = true;
		}
		
		if (character.getPower() != power) {
			character.setPower(power);
			flag = true;
		}
		
		return flag;
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		if (character == null) {
			return false; //false if no character is given
		}
		//loop through array until matching character is found
		for (int i = 0; i<size-1; i++) {
			if (characters[i].equals(character)) {
				//shift elements to left to fill gap
				for (int j = i; j<size-1; j++) {
					characters[j] = characters[j+1];
				}
				//clear info of removed character
				characters[size-1] = null;
				//decrease size counter
				size--;
				System.out.println("Removed.");
				return true;}
			}
		return false;
	}
	
	public void displayAllCharacters() {
		for(int i = 0; i<size; i++) {
			characters[i].displayInfo();
		};
	}
	
	
	
}
