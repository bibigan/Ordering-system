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
		warning.setContentText("�������");
		warning.show();
	}
	public static void err1() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("������д��һ�£�");
		warning.show();
	}
	public static void err2() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("���Ų����ڣ�����������ȷ����");
		warning.show();
	}
	public static void err3() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("�����ſ�����֧����");
		warning.show();
	}
	public static void err4() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("��ѡ�����ӣ�");
		warning.show();
	}
	public static void err5() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("ȷ�ϳɹ�");
		warning.show();
	}
	public static void err6() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("��ѡ���Ʒ��");
		warning.show();
	}
	public static void err7() {
		Alert warning = new Alert(Alert.AlertType.ERROR);
		warning.setContentText("������ȷ�ϣ�");
		warning.show();
	}
}
