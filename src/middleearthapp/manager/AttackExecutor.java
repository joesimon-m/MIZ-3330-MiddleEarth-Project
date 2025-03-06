package middleearthapp.manager;

import middleearthapp.characters.MiddleEarthCharacter;
/**
 * This class handles the attack rounds between all characters.
 * Instead of a single pass, it keeps looping rounds until only one character is alive.
 * Once only one stands, it declares that character's race as the winner.
 */
public class AttackExecutor {
	
	/**
     * Executes a full battle where characters attack each other until only one is left standing.
     * Each round, every alive character (attacker) tries to attack every other alive character (target).
     * Attack outcomes are printed to the console. When a target's health drops to zero or below,
     * a defeat message is printed.
     * 
     * After each round, the method checks how many characters are still alive.
     * The battle continues until only one character remains. If that happens, the winner's
     * race is declared.
     *
     * @param manager The CharacterManager containing all the characters.
     */
	
	public static void executeAttacks(CharacterManager manager) {
         //Keeping tack of how many rounds have passed.	
		int round = 1;
		while (true) {
			System.out.println("\n==== Round " + round + " ====");
			
			// Make each alive player attack every other alive player eactly once.
			executeSingleRound(manager);
			
			//count how many are still standing after each round 
			int aliveCount = 0;
			MiddleEarthCharacter lastStanding = null;
			
			for (int i = 0; i < manager.getSize(); i++) {
                MiddleEarthCharacter c = manager.getCharacterAt(i);
                if (c != null && c.getHealth() > 0) {
                    aliveCount++;
                    lastStanding = c; 
                }
			}
			// If 1 or 0 left, end the battle.
            if (aliveCount <= 1) {
                if (aliveCount == 1) {
                    System.out.println("\nThe battle is over! " + lastStanding.getName() 
                        + " the " + lastStanding.getRace() + " is the last one standing!");
                } else {
                    System.out.println("\nThe battle is over! No one is left standing.");
                }
                break;  // Exit the while loop
            }

            // If we still have multiple fighters, move on to the next round
            round++;
		}
	}
	
	/**
     * Executes a single round of attacks: each alive character attacks every other
     * alive character exactly once. Prints out the result of each attack.
     * 
     * @param manager the CharacterManager containing the characters
     */
    private static void executeSingleRound(CharacterManager manager) {
        int size = manager.getSize();

        // Outer loop: attacker
        for (int i = 0; i < size; i++) {
            MiddleEarthCharacter attacker = manager.getCharacterAt(i);
            if (attacker == null || attacker.getHealth() <= 0) {
                continue; // skip if this slot is null or dead
            }

            // Inner loop: target
            for (int j = 0; j < size; j++) {
                // skip attacking self
                if (i == j) {
                    continue;
                }
                MiddleEarthCharacter target = manager.getCharacterAt(j);
                if (target == null || target.getHealth() <= 0) {
                    continue; // skip if dead or empty slot
                }

                // Attempt the attack
                boolean success = attacker.attack(target);
                if (success) {
                    System.out.println(attacker.getName() + " (" + attacker.getRace() + ") attacked " 
                            + target.getName() + " (" + target.getRace() + ") -- " 
                            + target.getName() + " is now at " + target.getHealth() + " health.");
                    // If target died from this hit, announce it.
                    if (target.getHealth() <= 0) {
                        System.out.println(">>> " + target.getName() + " has been defeated!");
                    }
                } else {
                    System.out.println(attacker.getName() + " (" + attacker.getRace() + ") tried to attack " 
                            + target.getName() + " (" + target.getRace() + ") but it was ineffective.");
                }
            }
        }
    }
}
