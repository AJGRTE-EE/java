package sample.Insert_Product;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Alerts;
import sample.MySql;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert_Product_Controller {

    @FXML
    private Button Button_InsertProduct2;

    @FXML
    private TextField TextField_Name;

    @FXML
    private TextField TextField_Category;

    @FXML
    private TextField TextField_Manufacturer;

    @FXML
    private TextField TextField_Unit;

    public void Init(){
        Button_InsertProduct2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(TextField_Name.getText().equals("")){
                    Alerts.Error("Поле \"Наименование товара\" не заполнено");
                }else if(TextField_Category.getText().equals("")){
                    Alerts.Error("Поле \"Категория\" не заполнено");
                }else if(TextField_Manufacturer.getText().equals("")){
                    Alerts.Error("Поле \"Производитель\" не заполнено");
                }else if(TextField_Unit.getText().equals("")){
                    Alerts.Error("Поле \"Единица измерения\" не заполнено");
                }else{
                    ResultSet rs=null;
                    try {
                        rs=MySql.stmt.executeQuery("SELECT * FROM isp.product where " +
                                "name='"+TextField_Name.getText()+"' and " +
                                "category='"+TextField_Category.getText()+"' and " +
                                "manufacturer='"+TextField_Manufacturer.getText()+"' and " +
                                "measure='"+TextField_Unit.getText()+"'");
                        if(rs.next()){

                            Alerts.Error("Данный товар уже добавлен");
                        }
                        else {
                            MySql.stmt.executeUpdate(
                                    "INSERT INTO isp.product (name, category, manufacturer, measure) " +
                                            "VALUES (\'" + TextField_Name.getText() + "\', \'" + TextField_Category.getText() + "', \'" + TextField_Manufacturer.getText() + "\', \'" + TextField_Unit.getText() + "\')"
                            );

                            Alerts.Information("Запись успешно добавленна");

                        }
                        rs.close();
                    } catch (SQLException e) {
                        Alerts.Error("Ошибка подключения к БД");
                        e.printStackTrace();
                    }
                }
            }
        });

    }


}
