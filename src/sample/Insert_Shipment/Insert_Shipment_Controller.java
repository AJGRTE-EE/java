package sample.Insert_Shipment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import sample.Alerts;
import sample.MySql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Insert_Shipment_Controller {

    @FXML
    private TextField TextField_Count;

    @FXML
    private Button Button_InsertShipment;

    @FXML
    private ChoiceBox ChoiceBox_Product;

    @FXML
    private DatePicker DataPicker_Data;

    private ObservableList<String> Products = FXCollections.observableArrayList();

    public void Init(){

        ResultSet rs=null;
        try {
            rs= MySql.stmt.executeQuery("SELECT * FROM isp.product");
            while (rs.next()){
                String str = "id:"+rs.getInt("id")+"\n"+"Наименование: "+rs.getString("name")+"\n"+
                        "Категория: "+rs.getString("category")+"\n"+
                        "Производитель: "+rs.getString("manufacturer")+"\n"+
                        "Единица измерения: "+rs.getString("measure");
                Products.add(str);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ChoiceBox_Product.getItems().setAll(Products);

        Button_InsertShipment.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(TextField_Count.getText().equals("")){
                    Alerts.Error("Не указано количество");
                }else if(DataPicker_Data.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE).equals("")){
                    Alerts.Error("Не выбрана дата");
                }else if (((String)ChoiceBox_Product.getValue()).equals("")){
                    Alerts.Error("Не выбран товар");
                }else {
                    try {
                        String idrpoduct = (((String)ChoiceBox_Product.getValue()).split("\n"))[0].split(":")[1];
                        MySql.stmt.executeUpdate(
                                "INSERT INTO `isp`.`shipment` (`idproduct`, `data`, `number`) VALUES ('"+idrpoduct+"', '"+DataPicker_Data.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"', '"+TextField_Count.getText()+"')"
                        );
                        Alerts.Information("Запись успешно добавленна");
                    } catch (SQLException e) {
                        Alerts.Error("Ошибка подключения к БД");
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
