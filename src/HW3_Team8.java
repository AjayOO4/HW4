import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HW3_Team8 {	

	public static void main(String[] args) {
		
		SearchAlgorithms algo = new SearchAlgorithms(); 
		HW3_Team8_SelectionSort sort = new HW3_Team8_SelectionSort();
		
		long start, end, total;
		
		//ArrayList structure to read 1000 Integer-values
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		
		//Restricting list size to 1000
		while(list.size() < 1000) {
			int randInt = rand.nextInt(1000) + 1;				//adding 1 to random num generator to avoid 0.
			
			if(!list.contains(randInt)) {						//necessary step to avoid duplicate values
				list.add(randInt);
			}
		}
		
//		displayList(list);
		
		sort.selectionSort(list);
		
//		System.out.println();
		
//		displayList(list);
		 
		//Size of the Array-List
		int n = list.size();
		
//		System.out.println("\nList Size - " + n);
		
		Scanner option = new Scanner(System.in);				//Scanner object to read the inputs from the user
		
		System.out.println("Welcome to Hi-Lo Game");
		
		System.out.println("\n/***********************************************/ \n");
		System.out.println("Between 1 to 1000: Choose a Number");
		int val = option.nextInt();								//Asking user to chose a value and storing the same in val variable
		
		System.out.println("\nYou have chosen " + val + " as the number to be searched");
		
		validateTarget(val);
		
		while(true) {		
			
			System.out.println("\nChoose a method to Play Hi-Lo Search game for the value : " + val);
			System.out.println("1. Random Guess\n2. Binary Search\n3. Linear Search\n4. Enter New Target Value\n5. OR Exit");
			int methodOpt = option.nextInt();
			
			while(methodOpt < 1 || methodOpt > 5) {
				System.out.println("\nPlease select from Appropriate options only. Try again");
				System.out.println("1. Random Guess\n2. Binary Search\n3. Linear Search\n4. Enter New Target Value\n5. OR Exit");
				methodOpt = option.nextInt();
			}
			
			  switch(methodOpt) { 
			  	case 1: System.out.println("\nLet the game begin to HUNT " + val + " by Random Search\n");
			  			start = System.nanoTime();
			  			algo.randomSearch(list, val);
			  			end = System.nanoTime();
			  			
			  			total = end - start;
			  			System.out.println("Total Time taken to find "+ val +" : " + total +" nanoseconds");
			  			break;
			  
			  	case 2: System.out.println("\nLet the game begin to HUNT " + val + " by Binary Search\n");
			  			start  = System.nanoTime();								//starting a timer when the search algorithm starts
			  			int result = algo.binarySearch(list, 0, n-1, val);
			  			end  = System.nanoTime();								//Ending the timer when the search algorithm terminates
			  			
			  			if(result == -1) {
			  				System.out.println("Element not found");
			  			}else {
			  				System.out.println("The Element " + val + " is found at index: " + result);
			  			}
			  			
			  			total = end - start;
			  			System.out.println("Total time taken to find " + val + " : " + total + " nanoseconds");
			  			break;
			  
			  	case 3: System.out.println("\nLet the game begin to HUNT " + val + " by Linear Search\n");
			  			start  = System.nanoTime();
			  			int res = algo.linearSearch(list, val);
			  			end  = System.nanoTime();
			  			if(res == -1) {
			  				System.out.println("Element not found");
			  			}else {
			  				System.out.println("The Element " + val + " is found at index: " + res);
			  			}
			  			
			  			total = end - start;
			  			System.out.println("Total time taken to find " + val + " : " + total + " nanoseconds");
			  			break;
			  			
			  	case 4: System.out.println("Between 1 to 1000: Choose a Number");
			  			val = option.nextInt();
			  			validateTarget(val);
			  			break;
			  	
			  	case 5: System.out.println("See you at Next Run");
			  			System.exit(0);
			 }
		}
	}
	
	static void displayList(ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			  if(i % 10 == 0 && i > 0) { //print a new line after every 10th element 
				  System.out.println(); //of the array
			  }
		  	System.out.print(list.get(i)+ "\t"); 
		}
	}
	
	static void validateTarget(int val) {
		if(val < 1 || val > 1000) {
			System.out.println("\nThe selected target: " + val + " is out of range.\n"
					+ "The chances are that the target value will not be found");
		}
	}
	
}