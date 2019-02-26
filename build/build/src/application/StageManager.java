package application;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/** Stage管理类 */
public class StageManager {
    private Map<String, Stage> stageMap = new HashMap<>();//存放所有的Stage实例

    public void addStage(String name, Stage stage){
        stageMap.put(name, stage);
    }

    public Stage getStage(String name){
        return stageMap.get(name);
    }

    public void closeStage(String name){
        stageMap.get(name).close();
    }

    //实现Stage的跳转，从currentStage跳转到targetStage
    public void jump(String currentStageName, String targetStageName){
        stageMap.get(currentStageName).close();
        stageMap.get(targetStageName).show();
    }

    public void release(String name){
        stageMap.remove(name);
    }
}
