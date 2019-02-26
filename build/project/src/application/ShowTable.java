package application;

import java.io.IOException;

import aa.FILE;
import aa.Food1;
import aa.Shop1;
import aa.ShopFile;
import aa.Shops1;
import aa.Table1;
import aa.TableFile;
import application_Controller.TableEditDialogController;
import application_Controller.TableEditDialogController1;
import application_Controller.TableOverviewController;
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

public class ShowTable  {
	static Stage primaryStage=new Stage();
    private ObservableList<Table> tableData = FXCollections.observableArrayList();
    ObservableList<Shop> shopData = FXCollections.observableArrayList();
    public static int sum=0;//桌数
    public ShowTable() {
        // Add some sample data
        /*tableData.add(new Table(0,"空"));*/
    	//遍历所有桌子文件，把单个桌子文件的对象table搞成一个数组Tables
    	Table1[] tables1;
    	Table[]  tables;
    	tables1=TableFile.changes();
    	sum=tables1.length;
    	System.out.println("tables1.length:"+tables1.length);
    	//System.out.println("sum1:"+sum);
    	tables=Tables.creatTables(tables1.length);
    	for(int i=0;i<tables1.length;i++){
    		tables[i].setNumber(tables1[i].getNumber());
    		tables[i].setOrempty(tables1[i].getOrempty());
    		//System.out.println("tables1[i].getOrpay():"+tables1[i].getOrpay());
    		tables[i].setOrpay(tables1[i].getOrpay());
    		tables[i].setTotal(tables1[i].getTotal());
    		
    		
    		if(tables1[i].getOrempty().equals("有")){
    			ObservableList<Shop> shopData = FXCollections.observableArrayList();
    			Shop1[] shops1;
    		    Shop[] shops;
        		shops1=tables1[i].getShop();
        		shops=Shops.creatShops(shops1.length);
        		for(int j=0;j<shops1.length;j++){
        			shops[j].setAmount(shops1[j].getAmount());
        			shops[j].setName(shops1[j].getName());
        			shops[j].setPrice(shops1[j].getPrice());
        		}
        		for(int j=0;j<shops.length;j++)
        		shopData.add(shops[j]);
        		tables[i].setShop(shopData);   			
    		}
    	}
    	for(int i=0;i<tables.length;i++){
    		tableData.add(tables[i]);	    		
    	}
    }

    public ObservableList<Table> getTableData() {
        return tableData;
    }
    
    public void showTableOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowTable.class.getResource("/fxml文件/4.1.1TableOverview.fxml"));
            AnchorPane tableOverview = (AnchorPane) loader.load();
            Scene scene=new Scene(tableOverview);
            primaryStage.setTitle("桌子详情界面");
            primaryStage.setScene(scene);
            primaryStage.show();
            TableOverviewController controller = loader.getController();
            controller.setTest1(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showTableEditDialog(Table table) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowTable.class.getResource("/fxml文件/4.1.2TableEdit.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("桌子编辑界面");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the Table into the controller.
            TableEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setTable(table);
           // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showTableEditDialog1(Table table) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowTable.class.getResource("/fxml文件/4.1.2TableEdit1.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Table");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the Table into the controller.
            TableEditDialogController1 controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTable(table);
            //controller.setTable(table);
           // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
