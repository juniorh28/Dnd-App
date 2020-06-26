
import java.util.Scanner;
public class AbilityScore {
	private int strength;
	private int wisdom;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int charisma;
	//private CharacterClass charClass;
	private int modifier;
	public AbilityScore() {}
	//public AbilityScore(CharacterClass charClass) {this.charClass = charClass;}

	public void setStr(int str) {this.strength = str;}
	public void setWis(int wis) {this.wisdom = wis;}
	public void setDex(int dex) {this.dexterity = dex;}
	public void setCon(int con) {this.constitution = con;}
	public void setInt(int intel) {this.intelligence = intel;}
	public void setCha(int cha) {this.charisma = cha;}
	
	public int getStr(int str) {return strength;}
	public int getWis(int wis) {return wisdom;}
	public int getDex(int dex) {return dexterity;}
	public int getCon(int con) {return constitution;}
	public int getInt(int intel) {return intelligence;}
	public int getCha(int cha) {return charisma;}
	
	public void modifier() {
		//strength modifier
		
		
	}
	
	public void manualAbility(Scanner key) {
		System.out.println("Enter your strength: ");
		setStr(abilityNot21(key));
		System.out.println("Enter your wisdom: ");
		setWis(abilityNot21(key));
		System.out.println("Enter your dexterity: ");
		setDex(abilityNot21(key));
		System.out.println("Enter your constitution: ");
		setCon(abilityNot21(key));
		System.out.println("Enter your intelligence: ");
		setInt(abilityNot21(key));
		System.out.println("Enter your charmisa: ");
		setCha(abilityNot21(key));
	}
	
	public int abilityNot21(Scanner key) {
		int ability = key.nextInt();
		while(ability>20) {
			System.out.println("please enter a score less than or equal to 20.");
			ability = key.nextInt();
		}
		return ability;
	}
	
	
	
	
	public int randomWithRange(){//user choose to get random ability

		int[] diceRolls = new int[4];//roll four 6-sided dices
		int range;
		for(int i = 0; i<diceRolls.length;i++) {
			//add each dice i rolled into an array
			range = 6;
			diceRolls[i] = (int)(Math.random() * range) + 1;//assign a number btw 1-6
		}
		int smallest=diceRolls[0];
		for(int i = 1; i<diceRolls.length; i++) {//will check for the smallest rolled dice
			if(diceRolls[i]<smallest) 
				smallest=diceRolls[i];		
		}
		int sum=0;
		for(int i = 0; i<diceRolls.length;i++) {//adds up all the sum
			sum = sum+diceRolls[i];
		}
		return sum-smallest;//subtract by the smallest dice from the sum
	}
	
	
	
	public void rollRandom() {
		// range is from 1 to 20 
		this.strength = randomWithRange();
		this.wisdom  = randomWithRange();
		this.dexterity = randomWithRange();
		this.constitution = randomWithRange();
		this.intelligence = randomWithRange();
		this.charisma = randomWithRange();
	}
	
	public String toString() {return 
			"Strength of: "+Integer.toString(strength)+
			"\nWisdom of: "+Integer.toString(wisdom)+
			"\nDexterity: "+Integer.toString(dexterity)+
			"\nConstitution: "+Integer.toString(constitution)+
			"\nIntelligence: "+Integer.toString(intelligence)+
			"\nCharisma: "+Integer.toString(charisma);
	}
}
