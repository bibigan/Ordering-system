package common;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Shop implements Serializable {
  
	private final StringProperty name;
	private final IntegerProperty amount;
	private final IntegerProperty price;
	
	public Shop(){
		this("‘›Œﬁ∂©µ•œÍ«È",0,0);
	}
	public Shop(String name,int amount,int price) {
		this.name=new SimpleStringProperty(name);
		this.amount=new SimpleIntegerProperty(amount);
		this.price=new SimpleIntegerProperty(price);
		
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public String getName() {
		return this.name.get();
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	public void setAmount(int amount) {
		this.amount.set(amount);
	}
	public int getAmount() {
		return amount.get();
	}
	public IntegerProperty amountProperty()
	{
		return amount;
	}
	public void setPrice(int price) {
		this.price.set(price);
	}
	public int getPrice() {
		return this.price.get();
	}
	public IntegerProperty priceProperty() {
		return price;
	}
	@Override
    public String toString() {
        return "Shop1{" +"name=" + name + ", amount=" + amount +", price=" + price + '}';
    }
}
