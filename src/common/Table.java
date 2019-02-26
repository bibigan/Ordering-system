package common;


import common.Shop;
import application.ShowShop;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Table {
	

    private final IntegerProperty  number;
    private final StringProperty orempty;
    /*private Food[]  menu;final*/
    private final IntegerProperty total;
    private final StringProperty  orpay;
    /*private final File file;*/
    private ObservableList<Shop> shop;
    private ShowShop showshop=new ShowShop();
    
    public Table() {
        this(0, "¿Õ");
    }

    public Table(int number, String orempty) {
        this.number = new SimpleIntegerProperty(number);
        this.orempty = new SimpleStringProperty(orempty);
        // Some initial dummy data, just for convenient testing.
        /*this.menu=new Food[100];*/
        this.setShop(new ShowShop().getShopData());
        this.shop.addAll(showshop.getShopData());
        
        this.total= new SimpleIntegerProperty(1); 
        this.orpay = new SimpleStringProperty("Î´Ö§¸¶");
        
    }

    public int getNumber() {
        return number.get();
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public IntegerProperty numberProperty() {
        return number;
    }
    
    public void setOrempty(String orempty) {
    	this.orempty.set(orempty);
    }
    public String getOrempty() {
    	return orempty.get();
    }
    public StringProperty oremptyProperty() {
    	return orempty;
    }  

    public int getTotal() {
        return total.get();
    }

    public void setTotal(int total) {
        this.total.set(total);
    }

    public IntegerProperty totalPorperty() {
        return total;
    }

    public void setOrpay(String orpay) {
    	this.orpay.set(orpay);
    }
    public String getOrpay() {
    	return orpay.get();
    }
    public StringProperty orpayProperty() {
    	return orpay;
    }
	public ObservableList<Shop> getShop() {
		return shop;
	}

	public void setShop(ObservableList<Shop> shop) {
		this.shop = shop;
	}
    
    
 }