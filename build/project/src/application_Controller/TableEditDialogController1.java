package application_Controller;

import aa.Main2;
import aa.TableFile;
import application.ShowFood;
/*import common.Food;*/
import common.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TableEditDialogController1 {

    @FXML
    private TextField number;
    @FXML
    private Label orempty;
   /* @FXML
    private TextArea menu;*/
    @FXML
    private TextField total;
    @FXML
    private TextField orpay;
    @FXML 
    private Button but_tablecancel;
    @FXML 
    private Button but_finish;
    private Stage dialogStage;
    private Table table=new Table();
    public int sum=ShowFood.sum;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    	
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTable(Table table) {
        this.table = table;
	    number.setText(Integer.toString(table.getNumber()));
	    
    }

    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
    	String num;
        if (isInputValid()) { 
        	num=number.getText();
        	System.out.println("Integer.parseInt(num)"+Integer.parseInt(num));
        	table.setNumber(Integer.parseInt(num));
        	Main2.New(num);
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        	try {
        		Integer.parseInt(number.getText());
        	}catch(NumberFormatException e) {
        		errorMessage += "No valid postal code (must be an integer)!\n";
        	}

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}