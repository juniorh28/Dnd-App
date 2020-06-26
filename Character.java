import java.util.*;
public class Character {// main class
    private String name;
    private String race;
    private String sex;
    private boolean playing=false;
    public Character (){}
    public Character (String name, String race, String sex){
        this.name = name;
        this.race = race;
        this.sex = sex;
    }
    public void setName(String name) {this.name = name;}
    public void setRace(String race) {this.race= race;}
    public void setSex(String sex) {this.sex = sex;}
    public void setPlaying(boolean playing) {this.playing = playing;}
    public String getName() {return name;}
    public String getRace() {return race;}
    public String getSex() {return sex;}
    public Boolean getPlaying() {return playing;}
    
    public boolean turnOn() {
    	if(playing == false) { 
    		playing=true;
    		return playing;}
    	else {
    		playing = false;
    		return playing;}
    }
    
    public boolean equals (Character other) {return (name.equals(other.name)&&(race.equals(other.race))
    		&&(sex.equals(other.sex)));}
    
    public String toString() {return name + " the " + sex + " " + race;}
    
  
    /**
     * printIntro method
     * a void returning method that prints a message prompting user to make a (char) selection
     */
    public void printIntro(Scanner keyboard) {
    	System.out.println("Welcome to DnD! What would you like to play? Yes or No?");
    	String choice = keyboard.next(); 
    	if(choice.equalsIgnoreCase("yes")) 
    		turnOn();
    	else 
    		System.out.println("Good bye!");
    }
    
    public String menu(Scanner keyboard) {
    	System.out.println("Create a character: press: 1");
    	System.out.println("Load a character: press: 2");
    	String choice = keyboard.next();
    	if(choice.equalsIgnoreCase("1")) {
    		System.out.println("You chosen to create a new character\n");
    		return choice;}
    	
    	else if(choice.equalsIgnoreCase("2")) {
    		System.out.println("You chosen to load an existing character");
    		return choice;
    	}
    	else {
    		System.out.println("Please select 1 or 2 from the choice above\n");
    		printIntro(keyboard);
    		return null;
    	}
    }
    
    /**
     * characterCreation method
     * a void returning method that prompts the user to select between 
     * a character's name, sex, and race
     * case sensitivity don't matter
     * @param keyboard
     */
    public void characterCreation(Scanner keyboard) {
    	characterCreationMenu();
        char choice=keyboard.next().toUpperCase().charAt(0);
        boolean play = true;
        do{
        	switch(choice) {
                case 'S':
                    sex=sexSelection(keyboard);
                    characterCreationMenu();
                    break;
                case 'R':
                    race=raceSelection(keyboard);
                    characterCreationMenu();
                    break;
                case 'N':
                    System.out.print("Enter your name: ");
                    name = keyboard.next();
                    characterCreationMenu();
                    break;
                case 'D':
                    if(name != null && race != null && sex != null) {
                        Character character = new Character(name,race,sex);
                        System.out.println("Awesome! You made a character!");
                        System.out.println(character.toString());
                        System.out.println("Now lets make you a class");
                        play=false;
                        System.out.println("press any button to leave");
                        break;}
                    else
                        System.out.println("please select a name, race, and sex first");
                    break;
                    
                case 'Q':
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("please choose from one of the avaliable options");
                    characterCreationMenu();
                    break;
            }
            choice=keyboard.next().toUpperCase().charAt(0);
           // System.out.println("still in the switch case");
        }while(play);  	
       // System.out.println("i have left the switch case");
    }
    
    /**
     * characterCreationMenu method
     * prints out the menu for the character creation screen
     */
    public void characterCreationMenu() {
	    System.out.println("press 'R' to select a playable race");
	    System.out.println("press 'S' to select character's sex");
	    System.out.println("press 'N' to select character name");
	    System.out.println("press 'D' once you chosen a name, sex, and race");
	    System.out.println("press 'Q' to quit");}
    
    /**
     * raceSelection method
     * a void returning method that prompts user to select a race
     */
    public static String raceSelection(Scanner key) {
        System.out.println("Select a race: ");
        int i=0;
        String[] races = {"Human","Elf","Orc","Dwarf","Dragonborn","Half-Elf","Halfling","Gnome","Half-Orc","Tiefling"};
        for(i = 0; i<races.length;i++) {
        	System.out.println(("["+(i)+"] ")+races[i]);}
        
        while(true) {
        	int choice = key.nextInt();
        	if(choice < 0 || choice >= 10) 
        		System.out.println("please choose from the avaliable options");
        	else {
        		System.out.println("you chose: "+races[choice]);
        		return races[choice];}
        }
    }
    /**
     * sexSelection method
     * prompt user to select a sex, for loop to have them keep trying till they selected F or M
     * @param key - the scanner for input
     * @return the sex of the character
     */
    public static String sexSelection(Scanner key) {
        System.out.println("press 'M' for male");
        System.out.println("press 'F' for female");
        while(true) {
            char sex = key.next().toUpperCase().charAt(0);
            if(sex == 'M') {
            	System.out.println("you chose: male");
            	return "male";}
            else if(sex == 'F') {
            	System.out.println("you chose: female");
            	return "female";}
            else System.out.println("please choose again");
        }
    }
    
}//END OF CHARACTER CLASS
