package application_Controller;

import java.awt.Button;
import java.io.IOException;

import aa.FILE;
import aa.Food1;
import aa.Foods1;
import aa.Shop1;
import aa.ShopFile;
import aa.Shops1;
import aa.Table1;
import aa.TableFile;
import application.ShowFood;
import application.ShowShop;
import common.Food;
import common.Shop;
import common.SystemAdim_Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class orderController {
	
	//菜单信息
	@FXML
    private TableView<Food> orderTable;
    @FXML
    private TableColumn<Food, String> number;
    @FXML
    private TableColumn<Food, String> image;
    @FXML
    private TableColumn<Food,String> name;
    @FXML
    private TableColumn<Food,Number> price;
    @FXML
    private TableColumn<Food,String> type;
    @FXML
    private TableColumn<Food,String>introduce;
    @FXML
    private TableColumn<Food,Number>num;
    
    //桌子类的信息
    @FXML
    private TextField number1;//加入数量
    @FXML
    private Label numberOfTable;//桌子的桌号
    @FXML
    private Label totalOfTable;//总价
    //购物车信息
    @FXML
    private TableView<Shop>shopTable;//购物车栏
    @FXML
    private TableColumn<Shop,String>nameOfFood;//购物车菜品
    @FXML
    private TableColumn<Shop,Number>amountOfFood;//购物车每道菜的数量
    @FXML
    private TableColumn<Shop,Number>priceOfShop;//购物每道菜的总价
    @FXML
    private Button but_yess;
    
    private ShowFood showfood;
    private ShowShop showshop=new ShowShop();
    private int sum=0;
    int s=0;//菜品总数
    int or=0;//确认订单的状态
    
    static Stage primaryStage=new Stage();
    public orderController() {
    	
    }
    //初始化两个TableView
    @FXML
    private void initialize() {
    	//orderTable
    	numberOfTable.setText(Scene_0Controller.tableNum+"");//桌号
        number.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameOfFoodProperty());
        price.setCellValueFactory(cellData->cellData.getValue().priceOfFoodProperty());
        num.setCellValueFactory(cellData->cellData.getValue().numOfFoodProperty());
        type.setCellValueFactory(cellData->cellData.getValue().typeOfFoodProperty());
        image.setCellValueFactory(cellData->cellData.getValue().photoProperty());
        introduce.setCellValueFactory(cellData->cellData.getValue().introduceProperty());
        //shopTable
        nameOfFood.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceOfShop.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        amountOfFood.setCellValueFactory(cellData->cellData.getValue().amountProperty());
    
    }
    //设置点单界面的菜单数据
	public void setShowFood(ShowFood showfood) {
		 this.setShowfood(showfood);
	        // Add observable list data to the table
	       orderTable.setItems(showfood.getFoodData());//获取foods
    }
	//减少数量
	@FXML
	public void reduce() {
		int number=Integer.parseInt(number1.getText());
		if(number>0) {
			number1.setText(Integer.toString(number-1));

		}
		else{
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("数量为零！");
            alert.setHeaderText("暂时无数量！");
            alert.setContentText("请重新选择菜品！");
            alert.showAndWait();
		}
        
	}
	//增加数量
	@FXML
	public void add() {
		int number=Integer.parseInt(number1.getText());
			number1.setText(Integer.toString(number+1));
	}
	//加入购物车
	@FXML
	public void doShop() {
		int selectedIndex = orderTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex>=0) {
			int amount=Integer.parseInt(number1.getText());
			int price1=(price.getCellData(orderTable.getSelectionModel().getSelectedIndex())).intValue()*amount;
			String name1=name.getCellData(orderTable.getSelectionModel().getSelectedIndex());
			//处理出现点同一个名字的情况;
			int flag=0,k=0;
			Shop shop1=new Shop();
			String [] names = new String[s];
			for(int i=0;i<s;i++)
			{
				shop1=shopTable.getItems().get(i);
				names[i]=shop1.getName();
			}
			for(int i=0;i<names.length;i++) {
				if(name1.equals(names[i])) {
					k=i;
					flag=1;break;
				}
				else
					flag=0;
			}
			if(flag==0){
				Shop shop=new Shop(name1,amount,price1);
				showshop.getShopData().add(shop);
				shopTable.setItems(showshop.getShopData());
				sum=price1+sum;
				totalOfTable.setText(Integer.toString(sum));
		        s++;
			}
			else {
				    int amount1=showshop.getShopData().get(k).getAmount();
				    showshop.getShopData().get(k).setAmount(amount+amount1);
				    int price2=showshop.getShopData().get(k).getPrice();
				    showshop.getShopData().get(k).setPrice(price2+price1);
				    shopTable.setItems(showshop.getShopData());
				    sum=price1+sum;
				    totalOfTable.setText(Integer.toString(sum));
			}
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("无法加入购物车！");
            alert.setHeaderText("没有选择菜品！");
            alert.setContentText("请在上方的菜单面板选择菜品！");
            alert.showAndWait();
		}
	}
	//付款
	@FXML
	public void orpayOfTable() {
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(orderController.class.getResource("/fxml文件/6.1Pay.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            //添加控制器并且传送
            PayController controller = loader.getController();
            controller.setTotal(sum);
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Pay Food");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	//删除购物车的菜品
	@FXML
	public void delete() {
		 int selectedIndex = shopTable.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            shopTable.getItems().remove(selectedIndex);
	            s--;	            	            
	            /*sum--;*/
	        } else {
	            // Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("没有选择菜品！");
	            alert.setHeaderText("没有选择菜品！");
	            alert.setContentText("请在上方的购物车面板选择菜品！");
	            alert.showAndWait();
	        }
	}
	@FXML
	public void okOrder(){//相当于保存当前桌号的所有菜品信息到对应桌号的文件里
		Shop1[] shops1;
		Shop shop=new Shop();
		String name1;
		if(s>=0){
			if(or==0){
				for(int i=0;i<s;i++){
					for(int j=0;j<FoodOverviewController.sum;j++){
						name1=shopTable.getItems().get(i).getName();
						if(orderTable.getItems().get(j).getNameOfFood().equals(name1)){
							int num1=orderTable.getItems().get(j).getNumOfFood();
							orderTable.getItems().get(j).setNumOfFood(shopTable.getItems().get(i).getAmount()+num1);
							break;
						}
					}
				}	
        Food food=new Food();
		    	Food1[] foods1;
		        	foods1=Foods1.creatFoods(FoodOverviewController.sum);
		        	System.out.println(FoodOverviewController.sum);
		        	for(int i=FoodOverviewController.sum-1;i>=0;i--){
		        		food=orderTable.getItems().get(i);
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

				
				
				or=1;
				shops1=Shops1.creatShops(s);
				for(int i=s-1;i>=0;i--){
					shop=shopTable.getItems().get(i);
					shops1[i].setAmount(shop.getAmount());
					shops1[i].setName(shop.getName());
					shops1[i].setPrice(shop.getPrice());
				}
				ShopFile.clearFile(numberOfTable.getText());
				ShopFile.read(numberOfTable.getText(), shops1);
				
				TableFile.clearFile(Scene_0Controller.tableNum+"");
				Table1 table=new Table1(1,"空");
				table.setNumber(Scene_0Controller.tableNum);
				table.setShop(ShopFile.write(table.getNumber()+""));
				table.setOrempty("有");
				table.setTotal(sum);
				table.setOrpay("未支付");
				TableFile.read(table.getNumber()+"", table);//将table写入00桌号文件
				
				Table1 table1;
				table1=TableFile.write(table.getNumber()+"");//将00号文件内容给table1
				System.out.println("table1:"+table1);
			}
			else SystemAdim_Pane.err7();
		}
		else SystemAdim_Pane.err6();
	}
	
	/***********************************Setter&&Getter***************************/
	public ShowFood getShowfood() {
		return showfood;
	}
	public void setShowfood(ShowFood showfood) {
		this.showfood = showfood;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
