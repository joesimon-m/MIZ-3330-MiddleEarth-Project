package middleearthapp.manager;

import middleearthapp.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;

	/**
	 * default constructor initializing default values for characters and size
	 */
	public CharacterManager() {
		 this.characters = new MiddleEarthCharacter[10]; 
	     this.size = 0;
	}
	
	/**
	 * @param characters Array of characters
	 * @param size	number of characters in the array
	 */
	public CharacterManager(MiddleEarthCharacter[] characters, int size) {
		super();
		this.characters = characters;
		this.size = size;
	}
	
	/**
	 * addCharacter adds a new character, and doubles the size of the array if the array is full
	 * @param c new character to be added
	 * @return	Returns true if addCharacter function is successful
	 */
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
		characters[size] = c; //adds character to end of characters array
		size++; //size incremented to keep track of # of characters
		
		System.out.println("Character added.");
		return true; //indicates success
		
	}
	
	/**
	 * Search for a character by name, return that character
	 * @param name Name to be searched for within characters
	 * @return Returns character object if name matches, returns null if no match is found
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) { //iterates through characters until name matches given string
			if (characters[i] != null && characters[i].getName().equals(name)) {
                return characters[i]; //returns character object if name matches
            }
		}
			return null; //indicates failure to find character
	}
	
	/**
	 * Updates the character's attributes.
	 * @param character The character that will be updated. 
	 * @param name New name for the character.
	 * @param health Updated health value.
	 * @param power Updated power value.
	 * @return true if update was made, false if not
	 */
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		boolean flag = false; //flag to verify if character is updated or not 
		
		if (character == null || name == null) {
			return flag; //returns false if null character or name is given
		}
		
		if (!character.getName().equals(name)) { //updates name given new name
			character.setName(name);
			flag = true;
		}
		
		if (character.getHealth() != health) { //updates health given new health
			character.setHealth(health);
			flag = true;
		}
		
		if (character.getPower() != power) { //updates power given new power
			character.setPower(power);
			flag = true;
		}
		
		return flag; //return flag, will be false if no change made, true if change is made
	}
	
	/**
	 * Deletes a given character.
	 * @param character Character to be deleted
	 * @return false if character not deleted, true otherwise
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
	    if (character == null) {
	        return false; // false if no character is given
	    }
	    // Loop through entire array up to current size.
	    for (int i = 0; i < size; i++) {
	        if (characters[i].equals(character)) {
	            // Shift elements left from position i onward.
	            for (int j = i; j < size - 1; j++) {
	                characters[j] = characters[j + 1];
	            }
	            // Clear the last element and decrease the size counter.
	            characters[size - 1] = null;
	            size--;
	            System.out.println("Removed.");
	            return true;
	        }
	    }
	    return false; 
	}
	
	
	/**
	 * Displays all characters using displayInfo();
	 */
	public void displayAllCharacters() {
		for(int i = 0; i<size; i++) { //iterates through each character and prints out display of that character.
			characters[i].displayInfo();
		};
	} 
	
	/**
	 * Returns the number of characters currently stored in the array.
	 *
	 * @return the current size (number of characters)
	 */
	public int getSize() {
	    return size;
	}

	/**
	 * Returns the character at the specified index.
	 *
	 * @param index the index from which to retrieve the character
	 * @return the MiddleEarthCharacter at that index, or null if the index is out of bounds
	 */
	public MiddleEarthCharacter getCharacterAt(int index) {
	    if (index < 0 || index >= size) {
	        return null;
	    }
	    return characters[index];
	}
	
}
