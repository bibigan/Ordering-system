package aa;


import java.io.Serializable;

import application.ShowShop;
import common.Shop;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Table1 implements Serializable {
	

    private int  number;
    private String orempty;
    private int total;
    private String  orpay;
    private Shop1[] shops;
    
    public Table1() {
        this(0, "¿Õ");
    }

    public Table1(int number, String orempty) {
        this.number = number;
        this.orempty =orempty;
        // Some initial dummy data, just for convenient testing.
        /*this.menu=new Food[100];*/
        this.total= 0; 
        this.orpay = "Î´Ö§¸¶";
        this.shops=null;
       
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number=number;
    }
    
    public void setOrempty(String orempty) {
    	this.orempty=orempty;
    }
    public String getOrempty() {
    	return orempty;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total=total;
    }
    public void setOrpay(String orpay) {
    	this.orpay=orpay;
    }
    public String getOrpay() {
    	return orpay;
    }
    public Shop1[] getShop(){
    	return shops;
    }
    public void setShop(Shop1[] shops){
    	this.shops=shops;
    }
    @Override
    public String toString() {
        return "Table{" +"number=" + number +
                ", orempty=" + orempty +'\'' +
                ", total='" + total + 
                ", orpay='" + orpay + '\'' +Shops1.outPutString(shops)+'}';
    }
 }