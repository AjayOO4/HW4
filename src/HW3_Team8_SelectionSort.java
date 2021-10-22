import java.util.ArrayList;

public class HW3_Team8_SelectionSort {
	
	public ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
            // find position of smallest number between (i + 1)th element and last element
            int pos = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(pos))
                    pos = j;
            }
            // Swap minimum (smallest number) to current position on array
            int min = arr.get(pos);
            arr.set(pos, arr.get(i));
            arr.set(i, min);
            
        }
		return arr;
	}
}
