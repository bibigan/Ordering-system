package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	public static Stage stage;//������̨
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml�ļ�/1.Scene_1.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/css�ļ�/application.css").toExternalForm());
            primaryStage.setResizable(false);//���ò��ܴ��ڸı��С
            primaryStage.setTitle("�������ϵͳ");//���ñ���
            primaryStage.show();
		} catch(Exception e) {//�쳣
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
