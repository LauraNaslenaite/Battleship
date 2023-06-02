import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileOutputStream; 
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;



/**
 * A Class for updating object's content (squares) while using various methods chosen by a player
 * @author Laura Naslenaite
 * @version 1
 */
public class Board {
	
	/**
	 * Constant number of rows (10) that does not change during the game
	 */
	private static final int ROW = 10;
	/**
	 * Constant number of columns (10) that does not change during the game
	 */
	private static final int COLUMN = 10;
	
	/**
	 * Field of a Board object 
	 */
	private String[][] squares;
	
	/**
	 * Constructor to initialise the capacity of 2-D array
	 */
	public Board()
	{
		squares = new String[ROW][COLUMN];
	}
	
	/**
	 * Method to set the values of squares
	 * @param newSquare is a 2-D String array 
	 */
	public void setSqaures(String[][] newSquare)
	{
		squares=newSquare;
	}
	
	/**
	 * Method to receive the values of squares
	 * @return is a 2-D String array 
	 */
	public String[][] getSquares()
	{
		return squares;
	}
	
	
	/**
	 * Creating a board of 10X10 squares using 2-D array and initialising array values for a new game
	 */
	public void displayInitialBoard ()
	{
		//initialising an array
		int verticalAxis = 0;
		
		//displaying horizontal axis of the grid
		System.out.println("\tA"+ "\tB" + "\tC"+ "\tD" + "\tE" + "\tF" + "\tG" + "\tH" + "\tI" + "\tJ");
		System.out.println(" ");
		
		for (int i=0; i<squares.length; i++)
		{  
			verticalAxis+=1;
			System.out.print(verticalAxis);
			for(int j=0; j<squares[i].length; j++)
			{

					squares[i][j]="O";
					System.out.print("\t" +squares[i][j]);
				
			}
			System.out.println("\n");
		}
		
	}
	
	/**
	 * Positioning ships on a grid in random order
	 */
	public void randomShipPositioning()
	{
		Random rand = new Random();
		
		int counter_4 = 0;	
		int counter_3 = 0; 
		int counter_2 = 0;
		int counter_1 = 0;
		
		//Loop for displaying 1 ship of 4 squares
		do
		{
			//Random number interval 0-6
			int num1= rand.nextInt(7)+0;
			int num2= rand.nextInt(7)+0;
			
			// If the sum of random numbers is even, horizontal position is chosen
			if( (num1+num2)%2==0 ) 
			{
				for (int i=0; i<4; i++)
				{
					squares[num1][num2+i] = "S";
				}
				
			}
			
			// If the sum of random numbers is odd, vertical position is chosen
			else if((num1+num2)%2!=0)
			{
				for (int i=0; i<4; i++)
				{
					squares[num1+i][num2] = "S";
				}
			}
			counter_4++; 
		}while(counter_4<1);
		
		//Loop for displaying 2 ships of 3 squares
		do
		{
			//Random numbers for horizontal position
			int num1= rand.nextInt(8)+1; //1-8
			int num2= rand.nextInt(6)+1; //1-6
			//Random numbers for vertical position
			int num3=rand.nextInt(6)+1;  //1-6
			int num4=rand.nextInt(8)+1; //1-8
			
			//If array items overlap previously placed ship, new numbers are generated
			while(squares[num1][num2] == "S " ||
					squares[num1][num2+1]== "S" ||
					squares[num1][num2+2]=="S" ||
					squares[num1][num2+3]=="S" ||
					squares[num1][num2-1]=="S" ||
					squares[num1+1][num2] == "S" ||
					squares[num1+1][num2+1] == "S" || 
					squares[num1+1][num2+2] == "S" || 
					squares[num1-1][num2] == "S" ||
					squares[num1-1][num2+1] == "S" || 
					squares[num1-1][num2+2] == "S" &&
					squares[num3][num4] == "S" ||
					squares[num3+1][num4] == "S" ||
					squares[num3+2][num4] == "S" ||
					squares[num3+2][num4] == "S" ||
					squares[num3+3][num4] == "S" ||
					squares[num3-1][num4] == "S" ||
					squares[num3][num4+1] == "S" ||
					squares[num3][num4-1] == "S" ||
					squares[num3+1][num4+1] == "S" ||
					squares[num3+1][num4-1] == "S" ||
					squares[num3+2][num4+1] == "S" ||
					squares[num3+2][num4-1] == "S")
			{ 
				num1= rand.nextInt(8)+1; 
				num2= rand.nextInt(6)+1; 
				num3= rand.nextInt(6)+1;  
				num4= rand.nextInt(8)+1; 
			}
			
			// If the sum of random numbers is even, horizontal position is chosen
			if((num1+num2+num3+num4)%2==0) 
			{
				for (int i=0; i<3; i++)
				{
					squares[num1][num2+i] = "S";
				}
			}
			
			// If the sum of random numbers is odd, vertical position is chosen
			else if((num1+num2+num3+num4)%2!=0)
			{
				for (int i=0; i<3; i++)
				{
					squares[num3+i][num4] = "S";
				}
			}
			
			counter_3++;
		}while(counter_3<2);
		
		//Loop for displaying 3 ships of 2 squares
		do
		{
			//Random numbers for horizontal position
			int num1= rand.nextInt(8)+1; //1-8
			int num2= rand.nextInt(7)+1; //1-7
			//Random numbers for vertical position
			int num3=rand.nextInt(7)+1;  //1-7
			int num4=rand.nextInt(8)+1; //1-8
			
			while(squares[num1][num2] == "S " ||
					squares[num1][num2+1]== "S" ||
					squares[num1][num2+2]=="S" ||
					squares[num1][num2-1]=="S" ||
					squares[num1+1][num2] == "S" ||
					squares[num1+1][num2+1] == "S" || 
					squares[num1-1][num2] == "S" ||
					squares[num1-1][num2+1] == "S" &&
					squares[num3][num4] == "S" ||
					squares[num3+1][num4] == "S" ||
					squares[num3+2][num4] == "S" ||
					squares[num3+2][num4] == "S" ||
					squares[num3-1][num4] == "S" ||
					squares[num3][num4+1] == "S" ||
					squares[num3][num4-1] == "S" ||
					squares[num3+1][num4+1] == "S" ||
					squares[num3+1][num4-1] == "S")
				{ 
					num1= rand.nextInt(8)+1; 
					num2= rand.nextInt(7)+1; 
					num3=rand.nextInt(7)+1;  
					num4=rand.nextInt(8)+1; 
				}
			if( (num1+num2+num3+num4)%2==0 ) 
			{	
				for (int i=0; i<2; i++)
				{
					squares[num1][num2+i] = "S";
				}
			}
			else if((num1+num2+num3+num4)%2!=0)
			{
				for (int i=0; i<2; i++)
				{
					squares[num3+i][num4] = "S";
				}
			}
		
			counter_2++;
		}while(counter_2<3);
		
		//Loop for displaying 3 ships of 1 square
		do
		{
			int num1= rand.nextInt(8)+1; //1-8
			int num2= rand.nextInt(8)+1; //1-8
					
			while(squares[num1][num2] == "S " ||
				squares[num1][num2+1]== "S" ||
				squares[num1][num2-1]=="S" ||
				squares[num1+1][num2] == "S" ||
				squares[num1-1][num2] == "S")
				{ 
					num1= rand.nextInt(8)+1; 
					num2= rand.nextInt(8)+1; 
				}
					
			squares[num1][num2] = "S";
					
			counter_1++;
		}while(counter_1<3);
	}
	
	/**
	 * Displaying a board that is updated with player's hits and misses
	 * No ships are seen 
	 */
	public void displayUpdatedBoard ()
	{
		int verticalAxis = 0;
		
		//Displaying horizontal axis of the grid
		System.out.println("\tA"+ "\tB" + "\tC"+ "\tD" + "\tE" + "\tF" + "\tG" + "\tH" + "\tI" + "\tJ");
		System.out.println(" ");
		
		for (int i=0; i<squares.length; i++)
		{  
			verticalAxis+=1;
			System.out.print(verticalAxis);
			for(int j=0; j<squares[i].length; j++)
			{
				if (squares[i][j].equals("S"))
				{
					System.out.print("\t"+"O");
				}
				else
				{
					System.out.print("\t" +squares[i][j]);
				}
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * Evaluating coordinates of a user by separating it into pieces (array items)
	 * The number value is considered as the position of a row
	 * The letter value is converted into corresponding integer indicating column position 
	 * @param shipPosition a String value that is taken as a player's input
	 */
	public void fire(String shipPosition)
	{
		int colNum=0;
		String[] parts = shipPosition.split(" ");
		//Converting an integer value of a user's choice into a zero-based array value 
		int rowNum = (Integer.parseInt(parts[0]))-1; 

		//Converting user's input into the numerical , zero-based column coordinates
		switch(parts[1])
		{
		case "A": case"a" :
			colNum=0;
			break;
		case "B": case"b":
			colNum=1;
			break;
		case "C": case"c":
			colNum=2;
			break;
		case "D": case"d":
			colNum=3;
			break;
		case "E": case"e":
			colNum=4;
			break;
		case "F" : case"f":
			colNum=5;
			break;
		case "G": case"g":
			colNum=6;
			break;
		case "H": case"h":
			colNum=7;
			break;
		case "I": case"i":
			colNum=8;
			break;
		case "J": case"j":
			colNum=9;
			break;
		default:
			Scanner s = new Scanner(System.in);
			System.out.print("Invalid coordinates, please reenter them( number and letter)");
		}
		
		//Comparing users coordinates with ships':
		if(squares[rowNum][colNum] == "S")
		{
			squares[rowNum][colNum]="X";
			System.out.println();
			System.out.println("You hit it!");
		}
		else
		{
			squares[rowNum][colNum]=":(";
			System.out.println();
			System.out.println("You missed it!");
		}
		displayUpdatedBoard();
	}
	
	/**
	 * Displaying a final score of a player after he/she is done playing
	 */
	public void displayScore()
	{
		int misses =0;
		int hits =0;
		
		for (int i=0; i<squares.length; i++)
		{  
			for(int j=0; j<squares[i].length; j++)
			{
				if(squares[i][j].equals(":("))
					misses++;
				
				if(squares[i][j].equals("X"))
					hits++;
			}
		}
		int moves=misses+hits;
		System.out.println("Number of hits: "+hits);
		System.out.println("Number of misses: "+misses);
		System.out.println("Number of shots: "+moves);
	}

	/**
	 * Displaying a score that is constantly updated after each shot of a player
	 */
	public void displayScoreUpdate()
	{
		int misses =0;
		int hits =0;
		for (int i=0; i<squares.length; i++)
		{  
			for(int j=0; j<squares[i].length; j++)
			{
				if(squares[i][j].equals(":("))
					misses++;
				
				if(squares[i][j].equals("X"))
					hits++;
			}
			
		}
		int hitsLeft = 19-hits;
		if(hitsLeft==0)
		{
			System.out.println("YOU WON!");
		}
		else
		{
		int moves = misses+hits;
		System.out.println(hitsLeft+" hits left to win the game!");
		System.out.println("Number of shots in total: "+moves);
		}
	}
	
	/**
	 * Writing game details to a file after player opts for Save
	 */
	
	public void savingGame()
	{
		FileOutputStream outputStream=null;
		PrintWriter printWriter=null;
		try
		{
			outputStream = new FileOutputStream("gameDetails.txt");
			printWriter = new PrintWriter(outputStream);
			
			for (int i=0; i<squares.length; i++)
			{  
				for(int j=0; j<squares[i].length; j++)
				{
					
					printWriter.print(squares[i][j]+ " ");
				}
				printWriter.println();
			}
		}
		catch(IOException e)
		{
			System.out.println("An error occurred" + e.getMessage());
		}
		finally
		{
			if(printWriter!=null)
				printWriter.close();
		}
	}
	
	/**
	 * Loading game details that were previously saved 
	 * Ships' position, hits and misses of a prior game are displayed  
	 * 
	 */
	
	public void loadGame()
	{
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		String nextLine;
		int i=0;			

		try
		{
			fileReader= new FileReader("gameDetails.txt");
			bufferedReader= new BufferedReader(fileReader);
			nextLine= bufferedReader.readLine();
			while(nextLine!=null || i<10)
			{
				String[] values = nextLine.split(" ");
				for(int j=0; j<values.length; j++) 
				{
						squares[i][j]=values[j];
				}

				nextLine= bufferedReader.readLine();
				i++;
			}
			displayUpdatedBoard();
		}
		catch(IOException e)
		{
			System.out.print("An error occurred" + e.getMessage());
		}
		finally
		{
			if (bufferedReader!=null)
			{
				try
				{
					bufferedReader.close();
				}
				catch(IOException e)
				{
					System.out.print("An error occurred" + e.getMessage());
				}
			}
		}
	}
}


