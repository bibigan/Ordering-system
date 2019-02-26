package application_Controller;

import java.io.IOException;

import application.ShowFood;
import application.ShowTable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SystemAdim_1controller {
	@FXML
	private Button but_condition;
	@FXML
	private Button but_hot;
	@FXML
	private Button but_change;
	@FXML
	private Button but_sell;
	@FXML
	private Hyperlink change_password;
	
	public void table()  {//查看情况入口	
            ShowTable showtable=new ShowTable();
            showtable.showTableOverview();
	}
	
	public void hot() {
		try {
		    Stage stage2=new Stage();
            // Load table overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml文件/4.2Hot.fxml"));
            AnchorPane hotOverview = (AnchorPane) loader.load();
            AmountController controller=loader.getController();
            controller.setNameData();
            Scene scene=new Scene(hotOverview);
            stage2.setTitle("菜品热度界面");
            stage2.setScene(scene);
            stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
			
	public void change() {
		ShowFood showfood=new ShowFood();
		showfood.showFoodOverview();
	}
	
	public void sell() {
		try {
		    Stage stage2=new Stage();
            // Load table overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml文件/4.4Sell.fxml"));
            AnchorPane sellOverview = (AnchorPane) loader.load();
            SellController controller=loader.getController();
            controller.fdd();
            stage2.setTitle("销售额界面");
            Scene scene=new Scene(sellOverview);
            stage2.setScene(scene);
            stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void change_password() {//更改密码	
		try {
		    Stage stage2=new Stage();
            // Load table overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml文件/4.5Change_Password.fxml"));
            AnchorPane change_passwordOverview = (AnchorPane) loader.load();
            Scene scene=new Scene(change_passwordOverview);
            stage2.setScene(scene);
            stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
