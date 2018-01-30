//Tim Garvin

//Description: Permutation Checker accepts two strings as input from the user and determines if they are permutations of each other.

package permutationchecker;

import java.util.Scanner; //For user input

//Class that checks if two strings are permutations of each other.
public class PermutationChecker
{
	//CheckPermutation method that checks if two strings are permutations of each other
	//Returns true if they are permutations of each other
	//Returns false if they are not permutations of each other
	public boolean CheckPermutation(String str1, String str2)
	{
		int str1_index = 0; //Declares and initializes the index value for str1
		int str2_index = 0; //Declares and initializes the index value for str2
		
		boolean result = false; //Declares and initializes the result value that will be returned from this method
		
		if(str1.length() == str2.length()) //If str1 and str2 are the same length, check if they are permutations of each other (otherwise return false)
		{
			int str_lengths = str1.length(); //Declares and initializes the lengths of both strings
			char current_letter; //Declares the current_letter variable to store the current letter being considered in str1 (the reference string)
			
			//Loops through each character in str1 (the reference string)
			while(str1_index < str_lengths)
			{
				current_letter = str1.charAt(str1_index); //Sets the current letter being considered in str1 (the reference string)
				
				if(current_letter != '.') //If current letter is NOT a '.'
				{
					str2 = str2.replaceFirst(String.valueOf(current_letter), "0"); //Uses str1's current letter as a reference to replace the first matching character found in str2 with a 0 value (marks that value as already found in str1)
				}
				else //If current letter is a '.'
				{
					//Special case for the '.' character: '.' needs to be defined as a literal value for the replaceFirst() method to find it
					//Uses str1's current letter as a reference to replace the first matching character found in str2 with a 0 value (marks that value as already found in str1)
					str2 = str2.replaceFirst(String.valueOf("\\" + current_letter), "0");
				}
				
				str1_index++; //Increments str1's current index
			}
			
			//Loops through each character in str2 to determine if all of the values in it are zeroes (0)
			while(str2_index < str_lengths)
			{
				if(str2.charAt(str2_index) != '0') //If the current letter in str2 is NOT a 0 character
				{
					result = false; //Set result to false (not entirely necessary because result is already initialized, but does make this code read more logically)
					break; //Break out of the current while loop
				}
				
				str2_index++; //Increment str2's current index
			}
			
			if(str2_index == str_lengths) //If str2's resulting index after the loop is equal to the lengths of both strings
			{
				result = true; //Set result to true (and return true), both strings are permutations of each other
			}
		}
		
		return result; //Returns the results of whether these two strings are permutations of each other
	}
	
	//Main program execution
	public static void main(String[] args)
	{
		PermutationChecker check_permutation = new PermutationChecker(); //Declares a PermutationChecker object.
		
		String first_str = "", second_str = ""; //Declares and initializes string values for user input.
		
		Scanner user_input = new Scanner(System.in); //Declares a Scanner object for reading and receiving user input.
		
		boolean permutation = false; //Declares and initializes a permutation indicator.
		
		char check_new = 'y'; //Declares and initializes the check_new variable to store user input for checking if two strings are permutations again or not.
		
		//Loops user input and results until user does not want to check if two other strings are permutations.
		while(check_new == 'y')
		{			
			System.out.print("Enter the first string: "); //Prompts user for the first string input
			first_str = user_input.nextLine().toLowerCase(); //Reads and stores user input for first string (also converts input to lowercase)
			
			System.out.print("Enter the second string: "); //Prompts user for the second string input
			second_str = user_input.nextLine().toLowerCase(); //Reads and stores user input for second string (also converts input to lowercase)
			System.out.println(); //Prints a new line
			
			permutation = check_permutation.CheckPermutation(first_str, second_str); //Calls the CheckPermutation method to determine if the two strings are permutations of each other
			
			if(permutation) //If the two strings are permutations of each other
			{
				System.out.println("\"" + first_str + "\" and \"" + second_str + "\" are permutations of each other."); //Print out that the two strings are permutations of each other
				System.out.println(); //Prints a new line
			}
			else //If the two strings are NOT permutations of each other
			{
				System.out.println("\"" + first_str + "\" and \"" + second_str + "\" are not permutations of each other."); //Print out that the two strings are permutations of each other
				System.out.println(); //Prints a new line
			}
			
			System.out.print("Check new strings? (y/n): "); //Prompts the user to see if they'd like to check if two new strings are permutations of each other
			check_new = user_input.next().charAt(0); //Stores user input to check two new strings (y) or to not (n) - uses charAt(0) to ignore the newline character ('\n')
			check_new = Character.toLowerCase(check_new); //Converts user input character to lowercase
			System.out.println(); //Prints a new line
			
			user_input.nextLine(); //Skips unread newline character for new prompts.
		}
		
		user_input.close(); //Closes the Scanner used to read and receive user input
		System.exit(0); //Exits the current program
	}
}
