package application_Controller;

import aa.FILE;
import aa.Food1;
import aa.Foods1;
import application.ShowFood;
import common.Food;
import common.Foods;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FoodOverviewController {
    @FXML
    private TableView<Food> foodTable;
    @FXML
    private TableColumn<Food, String> firstColumn;
    @FXML
    private TableColumn<Food, String> lastColumn;
    
    @FXML
    private Label numberLabel;
    @FXML
    private Label nameOfFoodLabel;
    @FXML
    private Label typeOfFoodLabel;
    @FXML
    private Label priceOfFoodLabel;
    @FXML
    private Label introduceOfFoodLabel;
    @FXML
    private ImageView foodPhoto;
	@FXML
	private Button but_new;
	@FXML
	private Button but_edit;
	@FXML
	private Button but_delete;
	@FXML
	private Button but_save;    
    // Reference to the main application.
    private ShowFood test;
    public static int sum=ShowFood.sum;
    public FoodOverviewController() {
    }
//加销售总额、修改密码改按钮、数量-》food的数据域
    @FXML
    private void initialize() {
        // Initialize the food table with the two columns.
        firstColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        lastColumn.setCellValueFactory(cellData -> cellData.getValue().nameOfFoodProperty());
        // Clear food details.
        showFoodDetails(null);
        // Listen for selection changes and show the person details when changed.
        foodTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showFoodDetails(newValue));
    }

    public void setTest1(ShowFood test) {
        this.test = test;
        // Add observable list data to the table
       foodTable.setItems(test.getFoodData());//获取foods
    }
    
    private void showFoodDetails(Food food) {
        if (food != null) {
            // Fill the labels with info from the person object.
            numberLabel.setText(food.getNumber());
            nameOfFoodLabel.setText(food.getNameOfFood());
            typeOfFoodLabel.setText(food.getTypeOfFood());
            priceOfFoodLabel.setText(Integer.toString(food.getPriceOfFood()));
            introduceOfFoodLabel.setText(food.getIntroduceOfFood());
            String imagePath=food.getfoodPhoto();
            Image image = new Image(imagePath, true);
    		foodPhoto.setImage(image);
        } else {
            // Person is null, remove all the text.
            numberLabel.setText("");
            nameOfFoodLabel.setText("");
            typeOfFoodLabel.setText("");
            priceOfFoodLabel.setText("");
            introduceOfFoodLabel.setText("");
        }
    }
    
    @FXML
    private void handleDeleteFood() {
        int selectedIndex = foodTable.getSelectionModel().getSelectedIndex();
        System.out.println(selectedIndex);
        if (selectedIndex >= 0) {
            foodTable.getItems().remove(selectedIndex);
            sum--;
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(test.getPrimaryStage());
            alert.setTitle("没有选择菜品！");
            alert.setHeaderText("没有选择菜品！");
            alert.setContentText("请在左侧的菜谱面板选择菜品！");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewFood() {
        Food tempFood = new Food();
        boolean okClicked = test.showFoodEditDialog(tempFood);
        if (okClicked) {
            test.getFoodData().add(tempFood);
            sum++;
        }
    }

    @FXML
    private void handleEditFood() {
        Food selectedFood = foodTable.getSelectionModel().getSelectedItem();
        if (selectedFood != null) {
            boolean okClicked = test.showFoodEditDialog(selectedFood);
            if (okClicked) {
                showFoodDetails(selectedFood);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(test.getPrimaryStage());
            alert.setTitle("没有选择菜品！");
            alert.setHeaderText("没有选择菜品！");
            alert.setContentText("请在左侧的菜谱面板选择菜品！");
            alert.showAndWait();
        }
    }
    @FXML
    private void handleSaveFood(){
    	//System.out.println(sum);
    	Food food=new Food();
    	//Food1 food1=new Food1();
    	
    	//Food[] foods;
    	Food1[] foods1;
        if (sum >= 0) {
        	//foods=Foods.creatFoods(selectedIndex1+1);
        	foods1=Foods1.creatFoods(sum);
        	for(int i=sum-1;i>=0;i--){
        		food=foodTable.getItems().get(i);
        		foods1[i].setNumber(food.getNumber());
                foods1[i].setNameOfFood(food.getNameOfFood());
                foods1[i].setTypeOfFood(food.getTypeOfFood());
                foods1[i].setPriceOfFood(food.getPriceOfFood());
                foods1[i].setIntroduceOfFood(food.getIntroduceOfFood());
                foods1[i].setfoodPhoto(food.getfoodPhoto());
                foods1[i].setNumOfFood(food.getNumOfFood());
        	}
        	FILE.read(foods1);
        	//Foods1.outPutFoods(foods1);
        }
    }

}
    