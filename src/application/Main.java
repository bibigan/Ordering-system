package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	public static Stage stage;//设置舞台
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml文件/1.Scene_1.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/css文件/application.css").toExternalForm());
            primaryStage.setResizable(false);//设置不能窗口改变大小
            primaryStage.setTitle("餐厅点餐系统");//设置标题
            primaryStage.show();
		} catch(Exception e) {//异常
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
