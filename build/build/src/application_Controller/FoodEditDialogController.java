package application_Controller;
import java.io.File;

import common.Food;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FoodEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameOfFoodField;
    @FXML
    private TextField priceOfFoodField;
    @FXML
    private TextField typeOfFoodField;
    @FXML
    private TextField introduceOfFoodField;
    @FXML
	private ImageView iv;

    private Stage dialogStage;
    private Food food;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFood(Food food) {
        this.food = food;
        
	    numberField.setText(food.getNumber());
	    nameOfFoodField.setText(food.getNameOfFood());
	    priceOfFoodField.setText(Integer.toString(food.getPriceOfFood()));
	    typeOfFoodField.setText(food.getTypeOfFood());
	    introduceOfFoodField.setText(food.getIntroduceOfFood());
	    Image image=new Image(food.getfoodPhoto(),true);
	    iv.setImage(image);
    }

  //上传图片
  	@FXML
  	public void onUploadImage() {
  		try {
  			FileChooser fc = new FileChooser();
  			fc.setTitle("选择图片");
  			fc.getExtensionFilters().addAll(
  					new FileChooser.ExtensionFilter("JPG", "*.jpg"),
  					new FileChooser.ExtensionFilter("GIF", "*.gif"),
  					new FileChooser.ExtensionFilter("BMP", "*.bmp"),
  					new FileChooser.ExtensionFilter("PNG", "*.png")
  					);
  			
  			File file = new File("fc.getSelectedExtensionFilter()");
  			file = fc.showOpenDialog(new Stage());
  			if (file != null) {
  				food.setfoodPhoto("file:///" + file.getPath());	//存入头像路径
  				Image image = new Image(food.getfoodPhoto(), true);
  				iv.setImage(image);
  			}
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		
  	}

    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (isInputValid()) { 
        	food.setNumber(numberField.getText());
        	food.setNameOfFood(nameOfFoodField.getText());
            food.setTypeOfFood(typeOfFoodField.getText());
            food.setPriceOfFood(Integer.parseInt(priceOfFoodField.getText()));
            food.setIntroduceOfFood(introduceOfFoodField.getText());
			Image image = new Image(food.getfoodPhoto(), true);
			iv.setImage(image);
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

        if (numberField.getText() == null || numberField.getText().length() == 0) {
            errorMessage += "No valid number of food e!\n"; 
        }
        if (nameOfFoodField.getText() == null || nameOfFoodField.getText().length() == 0) {
            errorMessage += "No valid name of food e!\n"; 
        }
        if (typeOfFoodField.getText() == null || typeOfFoodField.getText().length() == 0) {
            errorMessage += "No valid type of food !\n"; 
        }

        if (priceOfFoodField.getText() == null || priceOfFoodField.getText().length() == 0) {
            errorMessage += "No valid price of food!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(priceOfFoodField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }

        if (introduceOfFoodField.getText() == null ||introduceOfFoodField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
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