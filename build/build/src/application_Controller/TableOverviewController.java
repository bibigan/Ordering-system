package application_Controller;

import java.io.IOException;

import aa.Main2;
import aa.Table1;
import aa.TableFile;
import application.ShowFood;
import application.ShowTable;
import common.Food;
import common.Shop;
import common.SystemAdim_Pane;
import common.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TableOverviewController {
    @FXML
    private TableView<Table> table;
    @FXML
    private TableColumn<Table, Number> firstColumn;
    @FXML
    private TableColumn<Table,String> lastColumn;
    private ObservableList<Table> tableData = FXCollections.observableArrayList();
    @FXML
    private TextField number;
    @FXML
    private Label orempty;
   /* @FXML
    private TextArea menu;*/
    @FXML
    private TableView<Shop> shopTable;
    @FXML
    private TableColumn <Shop,String>name;
    @FXML
    private TableColumn <Shop,Number>amount;
    @FXML
    private TableColumn <Shop,Number>price;
    @FXML
    private TextField total;
    @FXML
    private TextField orpay;
	@FXML
	private Button but_payYes;
    private ShowTable test;
    public int sum=ShowTable.sum;
    public static String num;
    // Reference to the main application.
    /*private ShowTable test;*/
    
    public TableOverviewController() {
    }
    @FXML
    private void initialize() {
    	//System.out.println("sum2:"+sum);
        // Initialize the Table table with the two columns.
        firstColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        lastColumn.setCellValueFactory(cellData -> cellData.getValue().oremptyProperty());
        // Clear Table details.
        name.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        amount.setCellValueFactory(cellData->cellData.getValue().amountProperty());
        price.setCellValueFactory(cellData->cellData.getValue().priceProperty());
    
        
        showTableDetails(null);
        // Listen for selection changes and show the Table details when changed.
        table.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showTableDetails(newValue));
    }

    public void setTest1(ShowTable test) {
        this.test = test;
        // Add observable list data to the table
       table.setItems(test.getTableData());
    }
    
    private void showTableDetails(Table table) {
        if (table!= null) {
            number.setText(Integer.toString(table.getNumber()));
            orempty.setText(table.getOrempty());
            /*menu.setText(table.getMenu());*/
            shopTable.setItems(table.getShop());
            total.setText(Integer.toString(table.getTotal()));
            orpay.setText(table.getOrpay());
        } else {
            // Table is null, remove all the text.
            number.setText("");
            orempty.setText("");
            /*menu.setText("");*/
            shopTable.setItems(null);
            total.setText("");
            orpay.setText("");
        }
    }
    
    @FXML
    private void handleDeleteTable() {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String num;
            num=table.getSelectionModel().getSelectedItem().getNumber()+"";
            //System.out.println("num:"+num);
            TableFile.deleteFile(num);
            table.getItems().remove(selectedIndex);
            sum--;
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(test.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Table Selected");
            alert.setContentText("Please select a Table in the table.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewTable() {
        Table tempTable=new Table();
        boolean okClicked = test.showTableEditDialog1(tempTable);
        if (okClicked) {
            test.getTableData().add(tempTable);
            System.out.println("tempTable:"+tempTable.getNumber());
            sum++;
        }
    }
    @FXML
    private void handlerefreshTable(){//全部重新读取文件内容,放到面板里
      
    	ShowTable showtable=new ShowTable();
    	showtable.getPrimaryStage().close();
    	showtable.showTableOverview();
    }
	@FXML
    private void okPay(){
    	Table selectedTable = table.getSelectionModel().getSelectedItem();
    	if(selectedTable!=null){
            boolean okClicked = test.showTableEditDialog(selectedTable);
            if (okClicked) {
                //showTableDetails(selectedTable);
            num=selectedTable.getNumber()+"";
            TableFile.clearFile(num);//清空
            Main2.New(num);//初始化
            showTableDetails(selectedTable);
	
    	}
     }
    	else SystemAdim_Pane.err4();
        }   	
}
    