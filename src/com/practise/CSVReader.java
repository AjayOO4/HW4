package com.practise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader{

	String path = "src/com/practise/cars_data.csv";
	Detail detail = null;
	
	public List<Detail> readfromFile(){
		List<Detail> cars = new ArrayList<>();
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while( (line = br.readLine()) != null) {
				String[] val = line.split(",");
				
				detail = createCar(val);
				cars.add(detail);
				
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return cars;
	}

	private static Detail createCar(String[] data) {
		 String manufacturer = data[0];
		 String model = data[1];
	     int price = Integer.parseInt(data[2]);
		 int milage = Integer.parseInt(data[3]);
		 int owners = Integer.parseInt(data[4]);
		 String color = data[5];
		 String title = data[6];
		 float mpg = Float.parseFloat(data[7]);
		 int hp = Integer.parseInt(data[8]);
		 int dayslisted = Integer.parseInt(data[9]);
		 int sold = Integer.parseInt(data[10]);




	     // create and return book of this metadata
	     return new Detail(manufacturer, model, price, milage, owners, color, title, mpg, hp, dayslisted, sold);
	}
	
	public void writeCSV(String[] userData) throws Exception {
		FileWriter fstream = new FileWriter(path, true);
		BufferedWriter out = new BufferedWriter(fstream);
		
		for(int i = 0; i < userData.length; i++) {
			out.write(userData[i]);
			out.append(",");
		}
		out.newLine();
 
		//close buffer writer
		out.close();
		System.out.println("Done");
	}
}