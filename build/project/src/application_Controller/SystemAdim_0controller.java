package application_Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import aa.ManagerFile;
import application.Main;
import application.ShowFood;
import common.SystemAdim_Pane;
import common.DatabaseManager;
import common.Food;
import common.Manager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SystemAdim_0controller {
	@FXML
	private Button but_login;
	@FXML
	private TextField passWordTextField;
	@FXML
	private Text actiontarget;
    @FXML
    private TableView<Food> foodTable;
	public static  Stage stage3 = new Stage();
	//private BorderPane rootLayout;
	Parent tp;
	public void login() throws IOException, SQLException {	//密码的值
				String passWord = passWordTextField.getText();
				Manager man;//初始密码
				man=ManagerFile.write();//从文件读取密码
				try {
					if(passWord.equals(man.getSecretNumber())) {
				    Stage stage2=new Stage();
				    Change_Password_Controller men=new Change_Password_Controller();				    
		            // Load table overview.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(ShowFood.class.getResource("/fxml文件/3.SystemAdim_1.fxml"));
		            AnchorPane change_passwordOverview = (AnchorPane) loader.load();
		            stage2.setTitle("管理员界面");
		            Scene scene=new Scene(change_passwordOverview);
		            stage2.setScene(scene);
		            stage2.show();
		            }
					else{
						//actiontarget.setText("登陆失败");
						SystemAdim_Pane.err();
					}
				}
				catch (IOException e) {
		            e.printStackTrace();
		        }
             }
	}
	
