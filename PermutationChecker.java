//Tim Garvin

//Description: Permutation Checker accepts two strings as input from the user and determines if they are permutations of each other.

package permutationchecker;

import java.util.Scanner; //For user input

//Class that checks if two strings are permutations of each other.
public class PermutationChecker
{
	//CheckPermutation method that checks if two strings are permutations of each other
	//Returns false if they are not permutations of each other
	//Returns true if they are permutations of each other
	public boolean CheckPermutation(String word1, String word2)
	{
		int word1_index = 0; //Declares and initializes the index value for word1
		int word2_index = 0; //Declares and initializes the index value for word2
		
		boolean result = false; //Declares and initializes the result value that will be returned from this method
		
		if(word1.length() == word2.length()) //If word1 and word2 are the same length, check if they are permutations of each other (otherwise return false)
		{
			int word_lengths = word1.length(); //Declares and initializes the lengths of both words
			char current_letter; //Declares the current_letter variable to store the current letter being considered in word1 (the reference string)
			
			//Loops through each character in word1 (the reference string)
			while(word1_index < word_lengths)
			{
				current_letter = word1.charAt(word1_index); //Initializes the current letter being considered in word1 (the reference string)
				
				word2 = word2.replaceFirst(String.valueOf(current_letter), "0"); //Uses word1's current letter as a reference to replace the first matching character found in word2 with a 0 value (to mark in word2 that that value has already been considered from word1)
				word1_index++; //Increments word1's current index
			}
			
			//Loops through each character in word2 to determine if all of the values in it are zeroes (0)
			while(word2_index < word_lengths)
			{
				if(word2.charAt(word2_index) != '0') //If the current letter in word2 is NOT a 0 character
				{
					result = false; //Set result to false (not entirely necessary because result is already initialized, but does make this code read more logically)
					break; //Break out of the current while loop
				}
				
				word2_index++; //Increment word2's current index
			}
			
			if(word2_index == word_lengths) //If word2's resulting index after the loop is equal to the lengths of both strings
			{
				result = true; //Set result to true (and return true), both strings are permutations of each other
			}
		}
		
		return result; //Returns the results of whether these two strings are permutations of each other
	}
	
	//Main program execution
	public static void main(String[] args)
	{
		PermutationChecker word_pair = new PermutationChecker(); //Declares a PermutationChecker object.
		
		String first_word = "", second_word = ""; //Declares and initializes string values for user input.
		
		Scanner user_input = new Scanner(System.in); //Declares a Scanner object for reading and receiving user input.
		
		boolean permutation = false; //Declares and initializes a permutation indicator.
		
		char check_new = 'y'; //Declares and initializes the check_new variable to store user input for checking if two strings are permutations again or not.
		
		//Loops user input and results until user does not want to check if two other strings are permutations.
		while(check_new == 'y')
		{
			System.out.print("Enter the first string: "); //Prompts user for the first string input
			first_word = user_input.next().toLowerCase(); //Reads and stores user input for first string (also converts input to lowercase)
			
			System.out.print("Enter the second string: "); //Prompts user for the second string input
			second_word = user_input.next().toLowerCase(); //Reads and stores user input for second string (also converts input to lowercase)
			System.out.println(); //Prints a new line
			
			permutation = word_pair.CheckPermutation(first_word, second_word); //Calls the CheckPermutation method to determine if the two strings are permutations of each other
			
			if(permutation) //If the two strings are permutations of each other
			{
				System.out.println(first_word + " and " + second_word + " are permutations of each other."); //Print out that the two strings are permutations of each other
				System.out.println(); //Prints a new line
			}
			else //If the two strings are NOT permutations of each other
			{
				System.out.println(first_word + " and " + second_word + " are not permutations of each other."); //Print out that the two strings are permutations of each other
				System.out.println(); //Prints a new line
			}
			
			System.out.print("Check new strings? (y/n): "); //Prompts the user to see if they'd like to check if two new strings are permutations of each other
			check_new = user_input.next().charAt(0); //Stores user input to check two new strings (y) or to not (n)
			check_new = Character.toLowerCase(check_new); //Converts user input character to lowercase
			System.out.println(); //Prints a new line
		}
		
		user_input.close(); //Closes the Scanner used to read and receive user input
		System.exit(0); //Exits the current program
	}
}
