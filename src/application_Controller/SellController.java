package application_Controller;

import aa.FILE;
import aa.Food1;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

public class SellController {
	@FXML
	private TextField money;
    public void fdd(){
    	Food1[] foods1;
    	foods1=FILE.write();
    	int sum=0;
    	for(int i=0;i<foods1.length;i++){
    		int price=foods1[i].getPriceOfFood()*foods1[i].getNumOfFood();
    		sum=sum+price;   		
    	}
    	money.setText(sum+"");
    }
	
}
