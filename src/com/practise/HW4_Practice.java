package com.practise;

import java.util.List;
import java.util.Scanner;

public class HW4_Practice {

	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader();
		
//		String path = "/Practise Programs/src/com/practise/cars_data.csv";
		List<Detail> cars = reader.readfromFile();
		
		System.out.println("Choose Options: ");
		System.out.println("1. Display all Cars\n2. Search for a Particular Manufacturer Cars\n3. Search for a particular model \n4. Search for particular color \n5. Add a new Car \n6. Search by mileage range for the Car \n7. Get details by Highest and lowest price \n8. Get cars availablity (not sold)");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		String manu;
		switch(option) {
			case 1: for(Detail d : cars) {
						System.out.println(d.displayDetails());
					}
					break;
					
		case 2: System.out.println("Enter the name of the Car Manufacturer");
				manu = sc.next();
				System.out.println("Entered String : " + manu);
				for(Detail d : cars) {
					if(d.getManufacturer().contains(manu))
					System.out.println(d.displayDetails());
				}
				break;
			case 3: System.out.println("Enter the name of the Car Model");
			manu = sc.next();
			System.out.println("Entered String : " + manu);
			for(Detail d : cars) {
				if(d.getModel().contains(manu))
				System.out.println(d.displayDetails());
			}
			break;		
			case 4: System.out.println("Enter the color to search for");
			manu = sc.next();
			System.out.println("Entered String : " + manu);
			for(Detail d : cars) {
				if(d.getColor().contains(manu))
				System.out.println(d.displayDetails());
			}
			break;		
			case 5: System.out.println("Enter Manufacturer, Price and Model\n");
					String[] strArr = new String[3];
					
					for (int i = 0 ; i < strArr.length; i++ ) {
						strArr[i] = sc.next();
				    }
					for (int i = 0 ; i < strArr.length; i++ ) {
						System.out.println(strArr[i]);
				    }
					reader.writeCSV(strArr);
					
					break;
					
					//Search between mileage range
			case 6: System.out.println("Enter the starting range for the mileage :");
					boolean carFound = false;
					int startingRange = sc.nextInt();
					System.out.println("Enter the ending range for the mileage :");
					int endingRange = sc.nextInt();
					if(endingRange < startingRange) {
						System.out.println("Invalid input range.");
						break;
					}
					for(Detail d : cars) {
						if((startingRange <= d.getMilage()) && (d.getMilage() <= endingRange)) {
							carFound = true;
							System.out.println(d.displayDetails());
						}
					}
					if(carFound == false) {
						System.out.println("No such car found.");
					}
					break;
			
			// Get details of the cheapest and most expensive car 
			case 7: // base case
					Detail cheapestCar = cars.get(0);
					Detail mostExpensiveCar = cars.get(0);
					// assignment operation
					for(Detail currentCar : cars) {
						if(currentCar.getPrice() < cheapestCar.getPrice()) {
							cheapestCar = currentCar;
						}
						if(currentCar.getPrice() > mostExpensiveCar.getPrice()) {
							mostExpensiveCar = currentCar; 
						}
					} 	
					System.out.println("The cheapest car is :");
					System.out.println(cheapestCar.displayDetails());
					System.out.println("The most expensive car is :");
					System.out.println(mostExpensiveCar.displayDetails());
					break;
			// Get available cars 
			case 8: 
					for(Detail currentCar : cars) {
						if(currentCar.getSold() == 0) {
							System.out.println(currentCar.displayDetails());
						}
					}
					break;
			
			default: System.out.println("EXIT");
		}

	}
}