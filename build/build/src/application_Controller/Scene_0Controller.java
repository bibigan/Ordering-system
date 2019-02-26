package application_Controller;

import java.io.IOException;

import aa.TableFile;
import application.ShowFood;
import common.SystemAdim_Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene_0Controller {
	@FXML
	private Button but_yes;
	@FXML
	private TextField tableNumber;    
	public static int tableNum;
	public void f(){//读取所有桌子文件数组，搜索输入的桌号是否存在在数组里
		if(TableFile.findFiles1(tableNumber.getText())){
			 String errorMessage = "";
        	try {
        		tableNum=Integer.parseInt(tableNumber.getText());
        		//System.out.println("tableNum:"+tableNum);
        	}catch(NumberFormatException e) {
        		errorMessage += "No valid postal code (must be an integer)!\n";
        	}
			//tableNum=tableNumber.getText();
    		ShowFood showFood=new ShowFood();
    		showFood.showOrder();	
		}
		else SystemAdim_Pane.err2();
		
	}
}
