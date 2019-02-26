package application_Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import application.ShowFood;
import application.ShowTable;


public class Scene_1controller {

    @FXML // fx:id="button_1"
    private Button button_0; // Value injected by FXMLLoader
	@FXML
	private ImageView iv;
    @FXML // This method is called by the FXMLLoader when initialization is complete
	static Stage stage1 = new Stage();
    static Stage stage2 = new Stage();

    
	public void systemAdim() throws IOException {//����Ա���
		
		try {
			    Stage stage1=new Stage();
	            // Load systemAdimOverview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(ShowFood.class.getResource("/fxml�ļ�/SystemAdim_0.fxml"));
	            AnchorPane systemAdimOverview = (AnchorPane) loader.load();
	            stage1.setTitle("����Ա����");
	            Scene scene=new Scene(systemAdimOverview);
	            stage1.setScene(scene);
	            stage1.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
	
	public void manu() throws IOException{//������
		try {
		    Stage stage1=new Stage();
            // Load systemAdimOverview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ShowFood.class.getResource("/fxml�ļ�/Scene_0.fxml"));
            AnchorPane systemAdimOverview = (AnchorPane) loader.load();
            stage1.setTitle("��˽���");
            Scene scene=new Scene(systemAdimOverview);
            stage1.setScene(scene);
            stage1.show();
        } catch (IOException e) {
            e.printStackTrace();
    }	
}	
}
