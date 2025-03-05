package middleearthapp.characters;

public class Orc extends MiddleEarthCharacter {

	/**
	 * 
	 * @param name
	 * @param health
	 * @param power
	 */
	public Orc(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(this.getRace().equals(target.getRace()) || target.getRace().equals("Elf")) {
			return false;
		} else if(target.getRace().equals("Human")) {
			target.setHealth(target.getHealth() - (this.getPower() * 1.5));
			return true;
		} else {
			target.setHealth(target.getHealth() - (this.getPower()));
			return true;
		}
	}

	/**
	 * 
	 */
	@Override
	public String getRace() {
		// TODO Auto-generated method stub
		return "Orc";
	}

}
