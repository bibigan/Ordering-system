package application;


import aa.FILE;
import aa.Food1;
import aa.Shop1;
import aa.ShopFile;
import aa.Table1;
import aa.TableFile;
import common.Food;
import common.Foods;
import common.Shop;
import common.Shops;
import common.Table;
import common.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ShowShop {
    static Stage primaryStage=new Stage();
    private ObservableList<Shop> shopData = FXCollections.observableArrayList();
    
    public ShowShop() {
        
}
    
   
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public ObservableList<Shop> getShopData() {
		// TODO Auto-generated method stub
	 return shopData;
	}

}
