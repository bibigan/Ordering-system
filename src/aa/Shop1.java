package aa;

import java.io.Serializable;

public class Shop1 implements Serializable {
	private String name;
	private int amount;
	private int price;
	
	public Shop1(){
		this("‘›Œﬁ∂©µ•œÍ«È",0,0);
	}
	public Shop1(String name,int amount,int price) {
		this.name=name;
		this.amount=amount;
		this.price=price;
		
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public String nameProperty() {
		return name;
	}
	
	public void setAmount(int amount) {
		this.amount=amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public int getPrice() {
		return this.price;
	}
	@Override
    public String toString() {
        return "Shop{" +"name=" + name + ", amount=" + amount +", price=" + price + '}';
    }
}
