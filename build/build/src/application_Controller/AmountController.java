package application_Controller;

import aa.FILE;
import aa.Food1;
import common.Food;
import common.Foods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;


public class AmountController {
	//private  static String  names1;
	private int sum;
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    
    private ObservableList<String> namesOfFood=FXCollections.observableArrayList() ;
    
    @FXML
    private void initialize() {
    	
    	Food1[] foods1;
    	Food[]  foods;
    	foods1=FILE.write();
    	sum=foods1.length;
    	foods=Foods.creatFoods(foods1.length);
    	for(int i=0;i<foods1.length;i++){//将food1传递给food
    		foods[i].setNameOfFood(foods1[i].getNameOfFood());
    	}
    	for(int i=0;i<foods.length;i++){
    		namesOfFood.add(foods[i].getNameOfFood());
    	}
       xAxis.setCategories(namesOfFood);
       
    }

   
	public void setNameData() {
        // Count the number of people having their birthday in a specific month.
		Food1[] foods1;
    	Food[]  foods;
    	foods1=FILE.write();
    	sum=foods1.length;
    	foods=Foods.creatFoods(foods1.length);
    	for(int i=0;i<foods1.length;i++){//将food1传递给food
    		foods[i].setNumOfFood(foods1[i].getNumOfFood());
    	}
        int [] namesCounter=new int [sum];
        int j=0;
        for(int i=0;i<namesCounter.length;i++) {
        	namesCounter[i]=foods[i].getNumOfFood();
        }
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for (int i = 0; i < namesCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(namesOfFood.get(i),namesCounter[i]));
        }
        barChart.getData().add(series);
    }
}