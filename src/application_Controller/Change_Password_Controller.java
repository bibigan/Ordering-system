package application_Controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import aa.ManagerFile;
import application.ShowTable;
import common.Manager;
import common.SystemAdim_Pane;
import javafx.event.ActionEvent;

public class Change_Password_Controller {
	@FXML
	private TextField passWordTextField;
	@FXML
	private Button but_login;
	@FXML
	private TextField passWordTextField1;
	// Event Listener on Button[#but_login].onAction
	static Stage primaryStage=new Stage();
	@FXML
	public void login() {
		// TODO Autogenerated
		Manager man=new Manager();		
		if(passWordTextField.getText().equals(passWordTextField1.getText())){
			man.setSecretNumber(passWordTextField.getText());//man的密码修改			
			ManagerFile.read(man);//把修改后的保存进文件
			System.out.println("输入的密码是："+passWordTextField.getText());
			System.out.println("修改后的密码是："+man.getSecretNumber());	
			primaryStage.close();
		}
		else {
			SystemAdim_Pane.err1();	   
		}
	}
}
