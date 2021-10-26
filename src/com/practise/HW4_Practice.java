package com.practise;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;


public class HW4_Practice {

	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader();					//CSVReader class object which provides operations for reading and writing into a CSV file
		
		List<Detail> cars = reader.readfromFile();			//All the data stored in a List format for convinient access and manipulation

		Scanner sc = new Scanner(System.in);
		int option;
		String manu, model;
		boolean flag;
		Queue<String> carWashQueue = new PriorityQueue<>();
		Stack<String> carValet = new Stack<>();
		while(true){		//start of While loop
			
			System.out.println("Choose Options: ");
			System.out.println("1. Display all Cars\n2. Search for a Particular Manufacturer Cars\n3. Search for a particular model \n4. Search for particular color \n5. Add a new Car \n6. Search by mileage range for the Car \n7. Get details by Highest and lowest price \n8. Get cars available for Sale\n9. Details of the Cars Sold\n10. Car Wash Management\n11. Valet Management \n12. Exit");

			option  = sc.nextInt();
		
			
			switch(option) {		//Start of SWITCH case
				case 1: //Displaying all of Inventory
						userDeatilsTitle2();
						for(Detail d : cars) {
							// System.out.println(d.userDetails());
							d.userDetails3();
						}
						break;
						
				case 2: //Displaying Car details of a Manufacturer
						System.out.println("Enter the name of the Car Manufacturer");
						manu = sc.next();

						boolean carManu = false;
						for(Detail d : cars) {
							if(d.getManufacturer().toLowerCase().contains(manu.toLowerCase())){
								carManu = true;
								System.out.println(d.displayDetails());
							}
						}
						if(carManu == false){
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
						if(flag == false) {
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
						if(flag == false) {
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
				case 8: System.out.println("Currently Available for Sale");
						userDeatilsTitle2();
						for(Detail currentCar : cars) {
							if(currentCar.getSold() == 0) {
								// System.out.println(currentCar.userDetails());
								currentCar.userDetails3();
							}
						}
						break;
		
				case 9: System.out.println("Following is the list of All Cars sold");
						userDeatilsTitle2();
						for(Detail currentCar : cars) {
							if(currentCar.getSold() != 0) {
								// System.out.println(currentCar.userDetails());
								currentCar.userDetails3();
							}
						}
						break;
				//This is a queing system that manages car washes. You use the case-sensitive commands to run this section.
				//There are checks to ensure the program doesn't crash because of queue underflow.
				case 10: System.out.println("Use the queueing system to manage car washes.");
						int carWashMode = 1;
						while (carWashMode == 1) {
							System.out.println("Use the commands VIEW, ADD, REMOVE, or EXIT to leave carwash.");
							String carWash = sc.next();
							switch(carWash) {
								case "VIEW":
									if(carWashQueue.isEmpty()){
									System.out.println("The carwash queue is currently empty."); break;
									} else System.out.println(carWashQueue); break;
								case "ADD" : System.out.println("What car would you like to add?"); carWash = sc.next(); carWashQueue.add(carWash); break;
								case "REMOVE" :
									if(carWashQueue.isEmpty()){
									System.out.println("The carwash queue is currently empty."); break; }
									else {
									System.out.println("Marking " + carWashQueue.peek() + " as washed."); carWashQueue.remove(); break;
									}
								case "EXIT" : carWashMode = 0; break;
							}
					}break;
				//This is a queing system that manages car valet. You use the case-sensitive commands to run this section.
				//There are checks to ensure the program doesn't crash because of stack underflow.
				case 11: System.out.println("Use the stack system to manage valet.");
						int valetMode = 1;
						while (valetMode == 1) {
							System.out.println("Use the commands VIEW, ADD, REMOVE, or EXIT to leave valet.");
							String valet = sc.next();
							switch(valet) {
								case "VIEW": 
									if(carValet.empty()){
										System.out.println("The valet stack is currently empty."); break;
									}
									else System.out.println(carValet.peek()); break;
								case "ADD" : System.out.println("What car would you like to add?"); valet = sc.next(); carValet.push(valet) ; break;
								case "REMOVE" : 
									if(carValet.empty()){
										System.out.println("The valet stack is currently empty."); break;
									}
									else {
										System.out.println("Marking " + carValet.peek() + " as removed."); carValet.pop(); break;
									}
								case "EXIT" : valetMode = 0; break;
							}
					}break;
				case 12: System.exit(0); break;
				default: System.exit(0);
			}		//End of SWITCH
		}		//End of WHILE
	}		//End of MAIN Method

	public static void userDeatilsTitle2(){
        System.out.println("|\tManufacturer\t|\tModel\t    |  Mileage \t | Owners |  Title    |  Price\n");
    }	//End of userDetailsTitle method

}		//End of Program