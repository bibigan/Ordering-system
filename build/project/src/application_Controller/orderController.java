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
	
	//�˵���Ϣ
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
    
    //���������Ϣ
    @FXML
    private TextField number1;//��������
    @FXML
    private Label numberOfTable;//���ӵ�����
    @FXML
    private Label totalOfTable;//�ܼ�
    //���ﳵ��Ϣ
    @FXML
    private TableView<Shop>shopTable;//���ﳵ��
    @FXML
    private TableColumn<Shop,String>nameOfFood;//���ﳵ��Ʒ
    @FXML
    private TableColumn<Shop,Number>amountOfFood;//���ﳵÿ���˵�����
    @FXML
    private TableColumn<Shop,Number>priceOfShop;//����ÿ���˵��ܼ�
    @FXML
    private Button but_yess;
    
    private ShowFood showfood;
    private ShowShop showshop=new ShowShop();
    private int sum=0;
    int s=0;//��Ʒ����
    int or=0;//ȷ�϶�����״̬
    
    static Stage primaryStage=new Stage();
    public orderController() {
    	
    }
    //��ʼ������TableView
    @FXML
    private void initialize() {
    	//orderTable
    	numberOfTable.setText(Scene_0Controller.tableNum+"");//����
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
    //���õ㵥����Ĳ˵�����
	public void setShowFood(ShowFood showfood) {
		 this.setShowfood(showfood);
	        // Add observable list data to the table
	       orderTable.setItems(showfood.getFoodData());//��ȡfoods
    }
	//��������
	@FXML
	public void reduce() {
		int number=Integer.parseInt(number1.getText());
		if(number>0) {
			number1.setText(Integer.toString(number-1));

		}
		else{
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("����Ϊ�㣡");
            alert.setHeaderText("��ʱ��������");
            alert.setContentText("������ѡ���Ʒ��");
            alert.showAndWait();
		}
        
	}
	//��������
	@FXML
	public void add() {
		int number=Integer.parseInt(number1.getText());
			number1.setText(Integer.toString(number+1));
	}
	//���빺�ﳵ
	@FXML
	public void doShop() {
		int selectedIndex = orderTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex>=0) {
			int amount=Integer.parseInt(number1.getText());
			int price1=(price.getCellData(orderTable.getSelectionModel().getSelectedIndex())).intValue()*amount;
			String name1=name.getCellData(orderTable.getSelectionModel().getSelectedIndex());
			//������ֵ�ͬһ�����ֵ����;
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
            alert.setTitle("�޷����빺�ﳵ��");
            alert.setHeaderText("û��ѡ���Ʒ��");
            alert.setContentText("�����Ϸ��Ĳ˵����ѡ���Ʒ��");
            alert.showAndWait();
		}
	}
	//����
	@FXML
	public void orpayOfTable() {
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(orderController.class.getResource("/fxml�ļ�/6.1Pay.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            //��ӿ��������Ҵ���
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
	//ɾ�����ﳵ�Ĳ�Ʒ
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
	            alert.setTitle("û��ѡ���Ʒ��");
	            alert.setHeaderText("û��ѡ���Ʒ��");
	            alert.setContentText("�����Ϸ��Ĺ��ﳵ���ѡ���Ʒ��");
	            alert.showAndWait();
	        }
	}
	@FXML
	public void okOrder(){//�൱�ڱ��浱ǰ���ŵ����в�Ʒ��Ϣ����Ӧ���ŵ��ļ���
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
				Table1 table=new Table1(1,"��");
				table.setNumber(Scene_0Controller.tableNum);
				table.setShop(ShopFile.write(table.getNumber()+""));
				table.setOrempty("��");
				table.setTotal(sum);
				table.setOrpay("δ֧��");
				TableFile.read(table.getNumber()+"", table);//��tableд��00�����ļ�
				
				Table1 table1;
				table1=TableFile.write(table.getNumber()+"");//��00���ļ����ݸ�table1
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
