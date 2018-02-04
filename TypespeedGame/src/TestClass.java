
	
	import java.util.*;

	import java.io.*;

	public class TestClass{


	   public static void main(String[] args) throws FileNotFoundException {

	      

	      String[] correct = new String[20];

	      description();

	      fillArray(correct);

	      play(correct);

	   }

	   public static void description()

	   {

	      System.out.print("Welcome to the Word Game!\n\nHow to Play:\nA word will show up on the screen that is either spelled");

	      System.out.print(" correctly or incorrectly. \nYour job is to decide which one it is. At any point during the game");

	      System.out.print(" you can stop \nthe game by typing n for No or y for Yes to continue.\nGood Luck!\n\n");

	   }

	   public static void fillArray(String[] correct)throws FileNotFoundException

	   {

	      File correctf = new File("Correct.txt");

	      File incorrectf = new File("Incorrect.txt");

	      

	      Scanner console = new Scanner(correctf);

	      Scanner console1 = new Scanner(incorrectf);

	      

	      for (int i = 0; i < 20; i++)

	      {

	         correct[i] = console.next();

	      }

	      for (int i = 0; i < 20; i++)

	      {

	         incorrect[i] = console1.next();

	      }

	   }

	   public static void play(String[] correct)

	   {

	      Random rand = new Random();

	      Scanner console = new Scanner(System.in);

	      int inArray = rand.nextInt(20);

	      int arraySelection = rand.nextInt(2);

	      String[] combined = new String[40];

	      for (int i = 0; i < combined.length; i++)

	      {

	         combined[i] = "";

	      }

	      

	      int score = 0;

	      int fill = 0;

	      

	      String answer = "y";

	      while (fill < 40 && answer.equalsIgnoreCase("y"))

	      {

	String correctWord = correct[inArray];

	         String incorrectWord = incorrect[inArray];

	if(checkArray(combined, correctWord, incorrectWord) > 0 || checkArray(combined, correctWord, incorrectWord) == 0)

	{

	inArray = rand.nextInt(20);

	}

	         correctWord = correct[inArray];

	         incorrectWord = incorrect[inArray];

	         if (arraySelection == 0)

	         {

	            System.out.println();

	            System.out.print("Is this word spelled correctly (y/n)? " + correctWord);

	            String question = console.next();

	            

	            if (question.equalsIgnoreCase("y"))

	            {

	               score++;

	            }

	            else

	            {

	               score--;

	            }

	            combined[fill] = correctWord;

	            fill++;

	         }

	         else

	         {

	            System.out.println();

	            System.out.print("Is this word spelled correctly (y/n)? " + incorrectWord);

	            String question = console.next();

	            

	            if (question.equalsIgnoreCase("y"))

	            {

	               score--;

	            }

	            else

	            {

	               score++;

	            }

	            combined[fill] = incorrectWord;

	            fill++;

	         }

	arraySelection = rand.nextInt(2);

	         System.out.println();

	         System.out.print("Would you like to continue playing (y/n)? ");

	         answer = console.next();

	      }

	      if (score > 0)

	      {

	         System.out.println("Your final score was: " + score);

	      }

	      else

	      {

	         System.out.println("Your final score was: 0");

	      }

	   }

	public static int checkArray (String[] combined, String correctWord, String incorrectWord)

	{

	for (int i = 0; i < combined.length; i++)

	{

	if (combined[i].equals(correctWord) || combined[i].equals(incorrectWord))

	{

	return i;

	}

	}

	return -1;

	}

	}



}
