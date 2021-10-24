package sample;

import javafx.scene.control.Alert;

public class Alerts {

    public static void Error(String str){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
    public static void Information(String str){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
}
