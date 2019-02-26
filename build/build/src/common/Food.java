package common;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Food implements Serializable {

    private final StringProperty number;
    private final StringProperty nameOfFood;
    private final StringProperty typeOfFood;
    private final IntegerProperty priceOfFood;
    private final IntegerProperty numOfFood;
    private final StringProperty introduceOfFood;
    private final StringProperty foodPhoto;
    public Food() {
        this(null, null);
    }

    public Food(String number, String nameOfFood) {
        this.number = new SimpleStringProperty(number);
        this.nameOfFood = new SimpleStringProperty(nameOfFood);
        // Some initial dummy data, just for convenient testing.
        this.typeOfFood = new SimpleStringProperty("ÔÁ²Ë"); 
        this.priceOfFood = new SimpleIntegerProperty(100);
        this.introduceOfFood= new SimpleStringProperty("some introduce");
        this.foodPhoto=new SimpleStringProperty("/images/Ä¬ÈÏÍ¼Ïñ.jpg");
        this.numOfFood=new SimpleIntegerProperty(0);
    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public StringProperty numberProperty() {
        return number;
    }

    public String getNameOfFood() {
        return nameOfFood.get();
    }

    public void setNameOfFood(String foodName) {
        this.nameOfFood.set(foodName);
    }

    public StringProperty nameOfFoodProperty() {
        return nameOfFood;
    }

    public String getTypeOfFood() {
        return typeOfFood.get();
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood.set(typeOfFood);
    }

    public StringProperty typeOfFoodProperty() {
        return typeOfFood;
    }

    public int getPriceOfFood() {
        return priceOfFood.get();
    }

    public void setPriceOfFood(int priceOfFood) {
        this.priceOfFood.set(priceOfFood);
    }

    public IntegerProperty priceOfFoodProperty() {
        return priceOfFood;
    }

    public String getIntroduceOfFood() {
        return introduceOfFood.get();
    }

    public void setIntroduceOfFood(String introduceOfFood) {
        this.introduceOfFood.set(introduceOfFood);
    }

    public StringProperty introduceProperty() {
        return introduceOfFood;
    }
    
    public String getfoodPhoto() {
		return foodPhoto.get();
	}
	public void setfoodPhoto(String photo) {
		this.foodPhoto.set(photo);
	}
	public StringProperty photoProperty() {
		return foodPhoto;
	}
    public int getNumOfFood() {
        return numOfFood.get();
    }

    public void setNumOfFood(int numOfFood) {
        this.numOfFood.set(numOfFood);
    }

    public IntegerProperty numOfFoodProperty() {
        return numOfFood;
    }
	@Override
    public String toString() {
        return "Food{" +"number=" + number +
                ", nameOfFood=" + nameOfFood +
                ", typeOfFood='" + typeOfFood + '\'' +
                ", priceOfFood='" + priceOfFood + '\'' +
                ", numOfFood='" + numOfFood + '\'' +
                ", introduceOfFood='" + introduceOfFood + '\'' +",foodPhoto="+foodPhoto+'\''+
                '}';
    }
    
 }