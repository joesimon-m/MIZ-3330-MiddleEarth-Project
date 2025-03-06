package middleearthapp.characters;

public class Wizard extends MiddleEarthCharacter {

	/**
	 * Constructs a Wizard character with there attributes.
	 * 
	 * @param name		name of the character
	 * @param health	health value of the character
	 * @param power		power value of the character
	 */
	public Wizard(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Attacks another MiddleEarthCharacter with the following conditions:
	 * 	If the target is a Dwarf, then do 1.5x damage
	 * 	If the target is a Human or a Wizard, then do no damage
	 * 	If the target is anything else, do 1x damage
	 * 
	 * @param target	MiddleEarthCharacter to be attacked
	 * @return 			true if attack connected, and false otherwise (when doing 0x damage)
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(this.getRace().equals(target.getRace()) || target.getRace().equals("Human")) {
			return false;
		} else if(target.getRace().equals("Dwarf")) {
			target.setHealth(target.getHealth() - (this.getPower() * 1.5));
			return true;
		} else {
			target.setHealth(target.getHealth() - (this.getPower()));
			return true;
		}
	}

	/**
	 * Returns the race of the character
	 * 
	 * @return	Race of character
	 */
	@Override
	public String getRace() {
		// TODO Auto-generated method stub
		return "Wizard";
	}

}
