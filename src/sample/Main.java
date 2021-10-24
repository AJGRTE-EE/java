package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        MySql.Connection();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        Controller controller = fxmlLoader.getController();
        controller.Init();
        primaryStage.setTitle("ИПС склада");
        primaryStage.setScene(new Scene(root, width/2, height/2));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
