package com.practise;

import java.util.List;
import java.util.Scanner;

public class HW4_Practice {

	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader();
		
//		String path = "/Practise Programs/src/com/practise/cars_data.csv";
		List<Detail> cars = reader.readfromFile();
		
		System.out.println("Choose Options: ");
		System.out.println("1. Display all Cars\n2. Search for a Particular Manufacturer Cars\n3. Search for a particular model \n4. Search for particular color \n5. Add a new Car");
		
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
					
			default:	System.out.println("EXIT");
		}

	}
}