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
		return false;
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
