import java.util.*;
public class GameApp {

	public static void main(String[] args){
		Scanner key = new Scanner(System.in);
		Character userCharacter = new Character();
		userCharacter.printIntro(key);

		if (userCharacter.getPlaying() == true) {//if the user chooses to play, set playing to true
			String menuChoice = userCharacter.menu(key);
			/*prints the menu which prompt user if they want to create a character or load an existing one
			returns a string that has the users answer*/	
			if(menuChoice.equalsIgnoreCase("1")) {//user has chosen to create a character
					userCharacter.characterCreation(key);
					/*a switch case method in which user select from 
					 * character's race, name, or sex, to finish or leave
					 * */
					CharacterClass characterBuild = new CharacterClass(userCharacter);
					characterBuild.characterClass(key);
					
					System.out.println("Say hello to "+characterBuild.toString());
					System.out.println("Now lets check your abilities.");
					System.out.println();
					System.out.println("Manually input your ability score [1]");
					System.out.println("Randomize your ability score [2]");
					menuChoice = key.next();
					if(menuChoice.equalsIgnoreCase("1")) {// manual input ability score
						
						AbilityScore a = new AbilityScore();
						a.manualAbility(key);
						System.out.println(characterBuild.toString()+"'s ability score \n"+a.toString());
					}

					if(menuChoice.equalsIgnoreCase("2")) {//random ability score
						AbilityScore a = new AbilityScore();
						a.rollRandom();
						System.out.println(characterBuild.toString()+"'s ability score \n"+a.toString());
					}
					
			}
			else if(menuChoice.equalsIgnoreCase("2")) {//user has chosen to load an existing character
				System.out.println("please choose a character to load");
				}
			
			else {//user has made a choice that is unavailable to them and must chose anew}
				}		
		}

	}//END OF MAIN
	
	
}//END OF CLASS
