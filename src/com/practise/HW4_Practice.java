package com.practise;

import java.util.List;
import java.util.Scanner;

public class HW4_Practice {

	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader();					//CSVReader class object which provides operations for reading and writing into a CSV file
		
		List<Detail> cars = reader.readfromFile();			//All the data stored in a List format for convinient access and manipulation

		Scanner sc = new Scanner(System.in);
		int option;
		String manu, model;
		boolean flag;

		while(true){		//start of While loop
			
			System.out.println("Choose Options: ");
			System.out.println("1. Display all Cars\n2. Search for a Particular Manufacturer Cars\n3. Search for a particular model \n4. Search for particular color \n5. Add a new Car \n6. Search by mileage range for the Car \n7. Get details by Highest and lowest price \n8. Get cars available for Sale\n9. Details of the Cars Sold\n10. Exit");

			option  = sc.nextInt();
		
			switch(option) {		//Start of SWITCH case
				case 1: //Displaying all of Inventory
						// userDeatilsTitle2();
						for(Detail d : cars) {
							System.out.println(d.userDetails());
							// d.userDetails3();
						}
						break;
						
				case 2: //Displaying Car details of a Manufacturer
						System.out.println("Enter the name of the Car Manufacturer");
						manu = sc.next();

						boolean carManu = false;
						for(Detail d : cars) {
							if(d.getManufacturer().contains(manu)){
								carManu = true;
								System.out.println(d.displayDetails());
							}
						}
						if(carManu){
							System.out.println("No car by " + manu + " found");
						}
						break;

				case 3: //Displaying  Car details based on Model
						System.out.println("Enter the name of the Car Model");
						model = sc.next();
						
						flag = false;

						for(Detail d : cars) {
							if(d.getModel().toLowerCase().contains(model.toLowerCase())){
								flag = true;
								System.out.println(d.displayDetails());
							}
						}
						if(flag) {
							System.out.println("No such Car Model found.");
						}
						break;

				case 4: System.out.println("Enter the color to search for");
						manu = sc.next();
						flag = false;
						for(Detail d : cars) {
							if(d.getColor().toLowerCase().contains(manu.toLowerCase())){
								flag = true;
								System.out.println(d.displayDetails());
							}
						}
						if(flag) {
							System.out.println("No Car with " + manu+ " Color found.");
						}
						break;		

				case 5: //While adding a new Car. Try to maintain the order of insertion which is as per CSV file
						System.out.println("Enter Manufacturer, Model, Price, Mileage, Owners, Color, Title, MPG, HorsePower, Days_listed, Sold\n");
						String[] strArr = new String[11];
						
						for (int i = 0 ; i < strArr.length; i++ ) {
							strArr[i] = sc.next();
						}
						reader.writeCSV(strArr);
						break;
						
						//Search between mileage range
				case 6: System.out.println("Enter the Starting & Ending range for the Mileage :");
						int startingRange = sc.nextInt();
						int endingRange = sc.nextInt();
						boolean carFound = false;
						
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
							System.out.println("There are no cars available within this Mileage range.");
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
				case 8: for(Detail currentCar : cars) {
							if(currentCar.getSold() == 0) {
								System.out.println(currentCar.userDetails());
							}
						}
						break;
		
				case 9: System.out.println("Following is the list of All Cars sold");
						for(Detail currentCar : cars) {
							if(currentCar.getSold() != 0) {
								System.out.println(currentCar.userDetails());
							}
						}
						break;
				
				case 10: System.exit(0); break;
				default: System.exit(0);
			}		//End of SWITCH
		}		//End of WHILE
	}		//End of MAIN Method

	public static void userDeatilsTitle2(){
        System.out.println("| \tManufacturer\t | \tModel\t | \tMileage\t |");
    }	//End of userDetailsTitle method

}		//End of Program