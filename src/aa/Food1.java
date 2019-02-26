package aa;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Food1 implements Serializable {

	private String number;
    private String nameOfFood;
    private String typeOfFood;
    private int priceOfFood;
    private String introduceOfFood;
    private String foodPhoto;
    private int numOfFood;
    public Food1() {
        this("0","ÎÞ²Ë");
    }

    public Food1(String number,String nameOfFood) {       
    	this.number =number;
        this.nameOfFood = nameOfFood;
        this.typeOfFood = "ÔÁ²Ë";
        this.priceOfFood = 100;
        this.introduceOfFood= "some introduce";
        this.foodPhoto="/images/Ä¬ÈÏÍ¼Ïñ.jpg";	
        this.numOfFood=0;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number=number;
    }
    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String foodName) {
        this.nameOfFood=foodName;
    }
    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood=typeOfFood;
    }

    public int getPriceOfFood() {
        return priceOfFood;
    }
    public void setPriceOfFood(int priceOfFood) {
        this.priceOfFood=priceOfFood;
    }
    
    public int getNumOfFood() {
        return numOfFood;
    }

    public void setNumOfFood(int numOfFood) {
        this.numOfFood=numOfFood;
    }

    public String getIntroduceOfFood() {
        return introduceOfFood;
    }

    public void setIntroduceOfFood(String introduceOfFood) {
        this.introduceOfFood=introduceOfFood;
    }
    
    public String getfoodPhoto() {
		return foodPhoto;
	}
	public void setfoodPhoto(String photo) {
		this.foodPhoto=photo;
	}
	@Override
    public String toString() {
        return "Food{" +"number=" + number +
                ", nameOfFood=" + nameOfFood +
                ", typeOfFood='" + typeOfFood + '\'' +
                ", priceOfFood='" + priceOfFood + '\'' +
                ", numOfFood='" + numOfFood + '\'' +
                ", introduceOfFood='" + introduceOfFood + '\'' +","
                		+ "foodPhoto="+foodPhoto+'\''+
                '}';
    }
    
 }