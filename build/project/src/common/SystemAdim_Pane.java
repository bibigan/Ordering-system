package common;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class SystemAdim_Pane {
	public static void err() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("密码错误！");
		warning.show();
	}
	public static void err1() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("密码填写不一致！");
		warning.show();
	}
	public static void err2() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("桌号不存在！重新输入正确桌号");
		warning.show();
	}
	public static void err3() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("该桌号客人已支付！");
		warning.show();
	}
	public static void err4() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("请选择桌子！");
		warning.show();
	}
	public static void err5() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("确认成功");
		warning.show();
	}
	public static void err6() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("请选择菜品！");
		warning.show();
	}
	public static void err7() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("订单已确认！");
		warning.show();
	}
}
