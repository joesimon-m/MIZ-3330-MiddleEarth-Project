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
		return null;
	}
	
	public boolean updateCharacter (MiddleEarthCharacter character, 
			String name, 
			int health, 
			int power) {
		return false;
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		return false;
	}
	
	public void displayAllCharacters() {
		System.out.println("N/A");
	}
	
	
}
