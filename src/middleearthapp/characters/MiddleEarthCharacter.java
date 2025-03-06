package middleearthapp.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	/**
	 * Constructor for the abstract class storing each character's attributes
	 * 
	 * @param name		String name of the character
	 * @param health	Double value storing the health of the character
	 * @param power		Double value storing the power of the character
	 */
	public MiddleEarthCharacter(String name, double health, double power) {
		super();
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	public abstract boolean attack(MiddleEarthCharacter target);
	
	public abstract String getRace();
	
	/**
	 * Prints the properties of the character into console
	 */
	public void displayInfo() {
		System.out.println(getRace() + " Has properties\nName: " + name + "\nHealth: " + health + "\nPower: " + power);
	}

	/**
	 * Returns the name of the character
	 * 
	 * @return 
	 * 		String name of character
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this character to the given String parameter
	 * 
	 * @param name
	 * 		String name to be assigned to this character's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the value of this character's health
	 * 
	 * @return
	 * 		double value of this character's health
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * Sets the health of this character to the given double parameter
	 * 
	 * @param health
	 * 		double parameter health to be assigned to this character's health
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * Returns the value of this character's power
	 * 
	 * @return
	 * 		double value of this character's power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * Sets the power of this character to the given double parameter
	 * 
	 * @param power
	 * 		double parameter power to be assigned to this character's power
	 */
	public void setPower(double power) {
		this.power = power;
	}
	
}
