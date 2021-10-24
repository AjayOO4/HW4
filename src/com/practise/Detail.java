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

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public int getMilage() {
        return milage;
    }

    public void setOwners(int owners) {
        this.owners = owners;
    }

    public int getOwners() {
        return owners;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setMPG(Float mpg) {
        this.mpg = mpg;
    }

    public float getMPG(){
        return mpg;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHP(){
        return hp;
    }

    public void setdayslisted(int dayslisted){
        this.dayslisted = dayslisted;
    }

    public int getDaysListed(){
        return dayslisted;
    }

    public void setSold(int sold){
        this.sold = sold;
    }

    public int getSold(){
        return sold;
    }

    
    
    public String displayDetails() {
    	return "Manufacturer = " + manufacturer + ", Model = " + model + ", Price = $" + price + ", Milage = " + milage + ", Owners = " + owners + ", Color = " + color +", Title = " + title +", Mpg = " + mpg +", Horsepower = " + hp +", DaysListed = " + dayslisted +", Sold = " + sold +"\n";
    }

}
