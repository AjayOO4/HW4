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
	     int price = Integer.parseInt(data[1]);
	     String model = data[2];

	     // create and return book of this metadata
	     return new Detail(manufacturer, price, model);
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