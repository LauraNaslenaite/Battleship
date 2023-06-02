import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * 
 */

/**
 * A Class of creating a Board's object and calling method of a user choice from that object
 * @author Laura
 *
 */
public class Menu {

	/**
	 * Creating an object of a class and calling methods
	 * @param args
	 */
	public static void main(String[] args) {
		Menu n1 = new Menu();
		n1.usersOption();		
	}
	
	/**
	 * Displaying options for a user once he/she starts the program
	 */
	public void displayMenu()
	{
		System.out.println("Welcome to BattleShips Game!");
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("| Please, select one of the options below |");
		System.out.println("| 1. Start New Game                       |");
		System.out.println("| 2. Load Game                            |");
		System.out.println("-------------------------------------------");
	}
	
	/**
	 * Evaluating player's choices and calling methods from either Menu or Board classes based on those choices
	 */
	public void usersOption()
	{
		//creating an object of Board class to call methods from another class
		Board grid = new Board();
			
		displayMenu();
		Scanner s = new Scanner(System.in);
		
		//a method is called that evaluates user's input value
		int usersOption1=validChoice();
		
			if (usersOption1==1)
			{	
				System.out.println("NEW GAME");
				grid.displayInitialBoard();
				grid.randomShipPositioning();
				int choiceAfterFireing=0;
				int usersOption2=0;	
				do
				{	
					String coord= validCoordinates();				
					grid.fire(coord);
					grid.displayScoreUpdate();
					System.out.println("--------------");
					System.out.println("| Next move: |");
					System.out.println("| 1. Fire    |");
					System.out.println("| 2. Exit    |");
					System.out.println("--------------");
					usersOption2=validChoice();
					if (usersOption2 == 2)
					{	
						do
						{	
							System.out.println("-------------------");
							System.out.println("| Next move:      |");
							System.out.println("| 1.Display score |");
							System.out.println("| 2.Save Game     |");
							System.out.println("| 3.Leave Game    |");
							System.out.println("-------------------");

							choiceAfterFireing=validChoice1();
							
							switch (choiceAfterFireing )
							{
								case 1:
								System.out.println();
								System.out.println("Your Score:");
								grid.displayScore();
								break;
								
								case 2:
								grid.savingGame();
								System.out.println();
								System.out.println("Game Was Saved!");
								break;
								
								case 3:
								System.out.println();
								System.out.println("Thank you for playing :) !");
								return;
							}
						}while(choiceAfterFireing!=3);
					}
				}while(usersOption2==1 && choiceAfterFireing!=3);	
			} 
			
			else if (usersOption1 == 2)
			{	
				System.out.println("LOAD GAME");	
				grid.loadGame();
				int choiceAfterFireing1=0;
				int usersOption3=0;	
				
					do
					{	
						String coord= validCoordinates();				
						grid.fire(coord);
						grid.displayScoreUpdate();
						System.out.println("--------------");
						System.out.println("| Next move: |");
						System.out.println("| 1. Fire    |");
						System.out.println("| 2. Exit    |");
						System.out.println("--------------");
						usersOption3=validChoice();
						if (usersOption3 == 2)
						{	
							do
							{	
								System.out.println("-------------------");
								System.out.println("| Next move:      |");
								System.out.println("| 1.Display score |");
								System.out.println("| 2.Save Game     |");
								System.out.println("| 3.Leave Game    |");
								System.out.println("-------------------");
								choiceAfterFireing1=validChoice1();
								
								switch (choiceAfterFireing1 )
								{
									case 1:
									System.out.println();
									System.out.println("Your Score:");
									grid.displayScore();
									break;
									
									case 2:
									grid.savingGame();
									System.out.println();
									System.out.println("Game Was Saved!");
									break;
									
									case 3:
									System.out.println();
									System.out.println("Thank you for playing :) !");
									return;
									
								}
							}while(choiceAfterFireing1!=3);
						}
					}while(usersOption3==1 && choiceAfterFireing1!=3);
				}
		}
			
	/**
	 * Checking user option's validity when 2 choices are given
	 * @return int value is returned which corresponds to a player's choice
	 */
		public int validChoice()
		{
			int choice=0;
			boolean valid = false;
			Scanner s = new Scanner(System.in);
			do 
			{
				try
				{
					System.out.print("Enter your option: ");
					choice = s.nextInt();
					if(choice==1 || choice==2)
						valid=true;
					else
						System.out.println("Invalid choice! ");
				}
				catch(InputMismatchException e)
				{
					s.next();
					System.out.println("Invalid choice! ");
				}
			}while (!valid);

				return choice;
		}
		
		/**
		 * Checking user option's validity when 3 choices are given
		 * @return int value is returned which corresponds to a player's choice
		 */
		public int validChoice1()
		{
			int choice=0;
			boolean valid = false;
			Scanner s = new Scanner(System.in);
			do 
			{
				try
				{
					System.out.print("Enter your option: ");
					choice = s.nextInt();
					if(choice==1 || choice==2 || choice ==3)
						valid=true;
					else
						System.out.println("Invalid choice! ");
				}
				catch(InputMismatchException e)
				{
					s.next();
					System.out.println("Invalid choice! ");
				}
			}while (!valid);

				return choice;
		}
		
		/**
		 * Checking the validity of shooting coordinates entered by a user
		 * The pattern of coordinates to be valid: number space letter
		 */
		
		public String validCoordinates()
		{
			boolean valid1=false;
			boolean valid2=false;
			String coordinates=null;
			Scanner s1 = new Scanner(System.in);
			do 
			{
				try
				{
					System.out.print("Enter a position to hit number and letter separated by space ");
					coordinates = s1.nextLine();
					String[] parts=coordinates.split(" ");
					String[] numBoundaries= {"1","2","3","4","5","6","7","8","9","10"};
					String[] letterBoundaries= {"a","b","c","d","e","f","g","h","i","j"};
					for (int i=0; i<numBoundaries.length; i++)
					{
						if(numBoundaries[i].contains(parts[0]))
						{
							valid1=true;
							break;
						}
					}
					
					for (int j=0;j<letterBoundaries.length;j++)
					{
						if( (letterBoundaries[j].contains(parts[1].toLowerCase())|| (letterBoundaries[j].contains(parts[1].toUpperCase()))))
						{
							valid2=true;
							break;
						}
					}												
				}
				catch(InputMismatchException e)
				{
					System.out.println("Invalid coordinate position!");
				}
				catch(PatternSyntaxException e) 
				{
					System.out.println("Invalid coordinate position!");
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Invalid coordinate position!");
				}
				catch(NumberFormatException e)
				{
					System.out.println("Invalid coordinate position!");
				}
			}while(!valid1 || !valid2);
			
			return coordinates;
		}
}
