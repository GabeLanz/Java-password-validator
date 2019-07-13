// Gabe Lanz

/*
 * Write a program that asks for a password, and then asks again to confirm it (you can use the scanner or JOptionPane).  
 * Pass those two Strings to a method called validatePassword( ).  Your validatePassword( ) should return a boolean - true 
 * if the passwords pass validation and false if the passwords do not pass validation.

If the passwords don’t meet validation rules, prompt again.  If the passwords meet validation rules, return “Password changed” and exit the program.

Your validatePassword( ) method will check to see if the two passwords passed in are valid.  All of the checks should happen in the method.

Right off the bat in your method, you should automatically return false if the passwords are not the same.

Again, if they are less than 8, then you can immediately return false too.

If the passwords are the same, then begin your checks listed above.  You could use booleans variables as flags to keep track whether you've found an 
uppercase, lowercase and digit.

You can use isUpperCase(), isLowerCase(), isDigit() to check to see if something is a digit, uppercase or lowercase in the String.

After looking at the string, if all of your boolean variables are true (meaning you've found them), then you know your passwords are good.

Is there a reason to compare both passwords if they are the same?  No.  So just run your checks through one variable.

Again: use a boolean as your return type in the method.  If any of the components are not met, change the boolean to false.  Once the boolean is set to false, 
you know the password was not valid and you can return that to your main method as false for the re-prompting to happen again (probably in a loop of some kind).
 */

import java.util.Scanner;

public class PasswordValidationLanz {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String pw1 = "";
		String pw2 = " ";
		boolean control = false;

		while (!control) {

			System.out.print("Please enter a password, it must have at least 8 characters: 2 Uppercase, 2 Lowercase, and 2 Numbers : ");
			pw1 = in.nextLine();

			System.out.print("Please enter the password again: ");
			pw2 = in.nextLine();

			control = validatePassword(pw1, pw2);
		}
		System.out.println("Password changed.");
		in.close();
	}

	public static boolean validatePassword(String a, String b) {
		boolean finalVerdict = false;
		final int MIN_LENGTH = 8;
		final int MIN_UPCASE = 2;
		int upCaseCount = 0;
		final int MIN_LOWCASE = 2;
		int lowCaseCount = 0;
		final int MIN_NMBR = 2;
		int minNmbrCount = 0;

		while (!finalVerdict) {

			if (a.length() < MIN_LENGTH) {
				System.out.println("The password must be 8 characters long at a minimum, please try again.");
				finalVerdict = false;
				break;
			}
			if (!a.equals(b)) {
				System.out.println("Your passwords don't match, please try again.");
				finalVerdict = false;
				break;
			}
			for(int i = 0; i<a.length();i++) {			//this for loop runs for the duration of the password length
				String sub = a.substring(i, i+1);		//this assigns the current character to 'sub'
				if(Character.isUpperCase(sub.charAt(0))){		//this checks if the current character is Upper case, if it is, adds 1 to upper
					upCaseCount++;
				}
				if(Character.isLowerCase(sub.charAt(0))){		//this checks if the current character is Lower case, if it is, adds 1 to lower
					lowCaseCount++;
				}
				if(Character.isDigit(sub.charAt(0))){			//this checks if the current character is a Number, if it is, adds 1 to number
					minNmbrCount++;
				}
			}
			if(upCaseCount<MIN_UPCASE) {				//if the amount of capital letters is <1, returns false and ends method
				System.out.println("\nThere must be AT LEAST ONE capital letter. Try again.\n");
				finalVerdict= false;
				break;
			}
			if(lowCaseCount<MIN_LOWCASE) {				//if the amount of lower case letters is <1, returns false and ends method
				System.out.println("\nThere must be AT LEAST ONE lowercase letter. Try again.\n");
				finalVerdict = false;
				break;
			}
			if(minNmbrCount<MIN_NMBR) {				//if the amount of numbers is <1, returns false and ends method
				System.out.println("\nThere must be AT LEAST ONE number. Try again.\n");
				finalVerdict = false;
				break;
			}
			finalVerdict = true;			//if the method reaches here, all tests have been passed so the method can return true
		}
		//return the value of same
		return finalVerdict;
	}
}

			