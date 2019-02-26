package application;

import java.io.IOException;

import aa.FILE;
import aa.Food1;
import application_Controller.FoodEditDialogController;
import application_Controller.FoodOverviewController;
import application_Controller.orderController;
import common.Food;
import common.Foods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ShowFood  {
	static Stage primaryStage=new Stage();
   
    private ObservableList<Food> foodData = FXCollections.observableArrayList();
    public static int sum=0;
    public ShowFood() {
        // Add some sample data
    	//用数组读取文件，然后循环add数组元素
    	Food1[] foods1;
    	Food[]  foods;
    	foods1=FILE.write();
    	sum=foods1.length;
    	foods=Foods.creatFoods(foods1.length);
    	for(int i=0;i<foods1.length;i++){//将food1传递给food
    		foods[i].setNumber(foods1[i].getNumber());
    		foods[i].setNameOfFood(foods1[i].getNameOfFood());
    		foods[i].setTypeOfFood(foods1[i].getTypeOfFood());
    		foods[i].setPriceOfFood(foods1[i].getPriceOfFood());
    		foods[i].setIntroduceOfFood(foods1[i].getIntroduceOfFood());
    		foods[i].setfoodPhoto(foods1[i].getfoodPhoto());
    		foods[i].setNumOfFood(foods1[i].getNumOfFood());
    	}
    	for(int i=0;i<foods.length;i++){
    		foodData.add(foods[i]);//所有文件
    	 }
    	}

    public ObservableList<Food> getFoodData() {
        return foodData;
    }
   
    public void showOrder() {
    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml文件/2.Menu.fxml"));
            AnchorPane foodOverview = (AnchorPane) loader.load();
            Scene scene=new Scene(foodOverview);
            primaryStage.setTitle("点菜界面");
            primaryStage.setScene(scene);
            primaryStage.show();
            orderController controller = loader.getController();
            controller.setShowFood(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFoodOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml文件/4.3.1FoodOverview.fxml"));
            AnchorPane foodOverview = (AnchorPane) loader.load();
            Scene scene=new Scene(foodOverview);
            primaryStage.setTitle("修改菜单界面");
            primaryStage.setScene(scene);
            primaryStage.show();
            FoodOverviewController controller = loader.getController();
            controller.setTest1(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showFoodEditDialog(Food food) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml文件/4.3.2FoodEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("菜单编辑");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the food into the controller.
            FoodEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFood(food);
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
