package com.practise;

public class Detail {
	
	 	private String manufacturer;
        private String model;
        private int price;
        private int milage;
        private int owners;
        private String color;
        private String title;
        private float mpg;
        private int hp;
        private int dayslisted;
        private int sold;

	
	public Detail(String manufacturer, String model, int price, int milage, int owners, String color, String title, Float mpg, int hp,
            int dayslisted, int sold) {
                this.manufacturer = manufacturer;
                this.price = price;
                this.model = model;
                this.milage = milage;
                this.owners = owners;
                this.color = color;
                this.title = title;
                this.mpg = mpg;
                this.hp = hp;
                this.dayslisted = dayslisted;
                this.sold = sold;
    }

    //setters and getters for Manufacurer
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    //setters and getters for Price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //setters and getters for Car Model
    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    //setters and getters for Title
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    //setters and getters for mileage
    public void setMilage(int milage) {
        this.milage = milage;
    }

    public int getMilage() {
        return milage;
    }

    //setters and getters for number of owners of the car
    public void setOwners(int owners) {
        this.owners = owners;
    }

    public int getOwners() {
        return owners;
    }

    //setters and getters for Color
    public void setColor (String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    //setters and getters for Miles per-gallon
    public void setMPG(Float mpg) {
        this.mpg = mpg;
    }

    public float getMPG(){
        return mpg;
    }

    //setters and getters for Horse_Power of the Car
    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHP(){
        return hp;
    }

    //setters and getters for the No.of days the Car is in the inventory
    public void setdayslisted(int dayslisted){
        this.dayslisted = dayslisted;
    }

    public int getDaysListed(){
        return dayslisted;
    }

    //setters and getters for sold cars
    public void setSold(int sold){
        this.sold = sold;
    }

    public int getSold(){
        return sold;
    }

    public String displayDetails() {
    	return "Manufacturer = " + manufacturer + ", Model = " + model + ", Price = $" + price + ", Milage = " + milage + ", Owners = " + owners + ", Color = " + color +", Title = " + title +", Mpg = " + mpg +", Horsepower = " + hp +", DaysListed = " + dayslisted +", Sold = " + sold +"\n";
    }

    public String userDetails(){
        return "Manufacturer = " + manufacturer + ", Model = " + model + ", Milage = " + milage +  ", Owners = " + owners +  ", Title = " + title + ", Price = $" + price;
    }

    public void userDetails3(){        
        // return "| %10s" + manufacturer + "%10d | %10d" + model + "%10d | \t" + milage +  ", Owners = " + owners +  ", Title = " + title + ", Price = $" + price;
        System.out.printf("| \t%-16s| \t%-11s | \t%-8s |  %-5s |  %-8s |  %-5s \n", manufacturer, model,milage,owners,title,price);
    }

}