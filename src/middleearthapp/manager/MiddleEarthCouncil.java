package middleearthapp.manager;


public class MiddleEarthCouncil {
	// Private static instance of the same class
	private static MiddleEarthCouncil instance;
	
	private CharacterManager characterManager;
	
	// Private constructor prevents instantiation from other classes
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	// Public method to provide access to the instance
	public static MiddleEarthCouncil getInstance() {
			if (instance == null) {
				instance = new MiddleEarthCouncil();
			}
			return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return characterManager;
	}
}
