/*
Kevin Nguyen
Basic Java program to find nearest perfect squares. O(n) performance.

How to run (linux):
	1.) open command line and cd into directory folder of where this code is
	2.) type in "javac *.java" to compile java files
	3.) type in "java JavaPS"
*/

//imports
import java.io.*;
import java.util.*;

//class
class JavaPS {
	//main driver
	public static void main(String[] args) {
		//local Declarations
		int value = 1500;
		findPerfectSquare(value);
	}

	//function definitions below
	public static int findPerfectSquare(int targetValue) {
		//local declarations
		int foundTrigger = 0, temp = targetValue;
		int[] refs = new int[2];

		//initial check if targetValue is already perfect square
		if((Math.sqrt(targetValue) % 2) == 1 || (Math.sqrt(temp) % 2) == 0) {
			return 0;
		}

		//keep looping until trigger is 2 (increment/decrement after 1)
		while (foundTrigger < 2) {
			//swap for incr/decr respectively
			if(foundTrigger == 0) {
				temp++;
			}
			else {
				temp--;
			}
			//check for perfect square
			if((Math.sqrt(temp) % 2) == 1 || (Math.sqrt(temp) % 2) == 0) {
				refs[foundTrigger] = Math.abs(targetValue - temp); //store temp no negs
				foundTrigger++; //inc trigger
				temp = targetValue; //reset temp
			}
		}

		//both ref values in array -> so find closest value to targetValue
		if(refs[0] < refs[1]) {
			System.out.println("The perfect square is " + (refs[0] - targetValue) + " with steps being: " + refs[0]);
			return refs[0];
		}
		else {
			System.out.println("The perfect square is " + (targetValue - refs[1]) + " with steps being: " + refs[1]);
			return refs[1];
		}
	}	
}