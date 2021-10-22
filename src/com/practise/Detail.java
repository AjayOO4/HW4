package com.practise;

public class Detail {
	
	 	private String manufacturer;
	    private int price;
	    private String model;
	
	public Detail(String manufacturer, int price, String model) {
		// TODO Auto-generated constructor stub
		 this.manufacturer = manufacturer;
	     this.price = price;
	     this.model = model;
	}
	
	public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public String displayDetails() {
    	return "\tManufacturer = " + manufacturer + ", \tPrice = $" + price + ", \tModel = " + model + "\n";
    }

}
