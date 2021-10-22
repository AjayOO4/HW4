package com.practise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date cDate;													//Date object for Calendar class
		int countDays;												//Increment / Decrement by days
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		Scanner sc = new Scanner(System.in);						//Read input from user
		
		System.out.println("Enter a Date (in MM-DD-YYYY) : ");
		String currentDate = sc.nextLine();
		
		System.out.println("Increment (+) or Decrement (-) by how many days?");
		countDays = sc.nextInt();
		
		try {
			cDate = sdf.parse(currentDate);
			
			System.out.println("Entered Date is : " + sdf.format(cDate));
			
			System.out.println("After " + countDays + " day(s), new date is : " + 
								sdf.format(AddDays.addDays(cDate, countDays)));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
		
	}

}
