import java.util.ArrayList;
import java.util.Random;


public class SearchAlgorithms {
	
	int counter = 0;
	
	public int binarySearch(ArrayList<Integer> arr, int left, int right, int val) 
    { 	
        if (right >= left)
        { 
            int mid = left + (right - left) / 2;
         
            // If the element is present at the middle itself 
			
			  if (arr.get(mid) == val) { 
				  counter++; 
				  System.out.println("The number of Searches occured: " + counter);
				  counter = 0;
				  return mid;
			  
			  }
			 
            // If element is smaller than mid, then it can only be present in left sub-array 
            if (arr.get(mid) > val) {
            	counter++;
//            	System.out.println(counter);
                return binarySearch(arr, left, mid - 1, val); 
            }
  
            // Else the element can only be present in right sub-array
            else {
            	counter++;
//            	System.out.println(counter);
            	return binarySearch(arr, mid + 1, right, val); 
            }
           
        } 
		System.out.println("The number of Searches occured: " + counter);
        // We reach here when element is not present
        return -1; 
    }
	
	public int linearSearch(ArrayList<Integer> arr, int val)
	   {
		int j;
	     for (j = 0; j < arr.size(); j++)		
	     {
	       if (arr.get(j) == val)				//Comparing element by element until the value is found
	       {
	    	   System.out.println("The number of Searches occured: " + j);
	    	   return j;							//return the target value once found
	       }
	     }
	     System.out.println("The number of Searches occured: " + j);
	     return -1;								//We reach here when the element is not found
	   }
	
	public void randomSearch(ArrayList<Integer> list, int val) {
		 int timeComplexity = 0, guessInt;
		 
		 if(val < 1 || val > 1000) {
			 System.out.println("Not a suitable method to guess the Number which is outside the defined range."
			 		+ "\nNever ending execution"
			 		+ "\nChoose a new value");
		 }else {
			 Random rand = new Random();
			 do {
				 guessInt = list.get(rand.nextInt(999) + 1);
				 System.out.println("Guessing value " + guessInt + ".");
				 timeComplexity++;
				 if(!(guessInt == val)) {
					 System.out.println("That was an incorrect guess. Choosing a new value.");
				 }
			 } while(!(guessInt == val)) ;
			
			 System.out.println("Correctly guessed the value. It took " + timeComplexity + " guesses to pick correctly.");
		 }
	}
}
