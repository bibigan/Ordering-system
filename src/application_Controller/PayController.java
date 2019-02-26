package application_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PayController {

	@FXML 
	private Label total;
	
	public void setTotal(int sum) {
		total.setText(Integer.toString(sum));
	}
	
}
