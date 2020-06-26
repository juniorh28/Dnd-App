import java.util.*;
public class CharacterClass extends Character {
	private Character character;
	private String charClass;
	//private int level;
	
	private String[] build = {"Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue",
				"Sorcerer","Warlock","Wizard"};
	public CharacterClass() {}
	public CharacterClass(Character character){
		this.character = character;
	}
	
	//public void setLevel(int level) {this.level = level;}
	public void setCharClass(String CharClass) {this.charClass = CharClass;}
	//public int getLevel(){retrun level;}
	public String getCharClass() {return charClass;}
	
	public void characterClass(Scanner key) {
		boolean a=true;
		System.out.println("Please select a class");
	    int i=0;
	    for(i = 0; i<build.length;i++) {
	    	System.out.println(("["+(i)+"] ")+build[i]);
	    	}
	    while(a) {
	    	int choice = key.nextInt();
	        if(choice < 0 || choice >= 12) 
	        	System.out.println("please choose from the avaliable options");
	        else {
	        	System.out.println("you have chosen to be a: "+build[choice]);
	        	setCharClass(build[choice]);
	        	System.out.println(toString());
	        	a=false;
	        }
	    }	
	}
	
	public boolean equals(CharacterClass other) {return super.equals(other)&& build.equals(other.build);}
	public String toString() {return character.toString() + " " + getCharClass();}

}
