package sample.Update_Supplier;

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
import sample.Tables.TableSupplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Update_Supplier_Controller {

    @FXML
    private TextField TextField_Count;

    @FXML
    private TextField TextField_Price;

    @FXML
    private TextField TextField_Supplier;

    @FXML
    private Button Button_UpdateSupplier;

    @FXML
    private ChoiceBox ChoiceBox_Product;

    @FXML
    private DatePicker DataPicker_Data;

    private ObservableList<String> Products = FXCollections.observableArrayList();

    public void Init(TableSupplier table){

        this.TextField_Count.setText(table.getCount());
        this.TextField_Price.setText(table.getPrice());
        this.TextField_Supplier.setText(table.getSupplier());


        ResultSet rs=null;
        int index=0;
        try {
            rs= MySql.stmt.executeQuery("SELECT * FROM isp.product");
            int i=0;
            while (rs.next()){
                String str = "id:"+rs.getInt("id")+"\n"+"Наименование: "+rs.getString("name")+"\n"+
                        "Категория: "+rs.getString("category")+"\n"+
                        "Производитель: "+rs.getString("manufacturer")+"\n"+
                        "Единица измерения: "+rs.getString("measure");
                if(str.equals(table.getNameProduct())){
                    index=i;
                }
                i++;
                Products.add(str);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ChoiceBox_Product.getItems().setAll(Products);
        ChoiceBox_Product.getSelectionModel().select(index);
        DataPicker_Data.setValue(table.getDateInput());

        Button_UpdateSupplier.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(TextField_Count.getText().equals("")){
                    Alerts.Error("Не указано количество");
                }else if(TextField_Price.getText().equals("")){
                    Alerts.Error("Не указана цена");
                }else if(TextField_Supplier.getText().equals("")){
                    Alerts.Error("Не указан поставщик");
                }else if(DataPicker_Data.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE).equals("")){
                    Alerts.Error("Не выбрана дата");
                }else if (((String)ChoiceBox_Product.getValue()).equals("")){
                    Alerts.Error("Не выбран товар");
                }else {
                    try {
                        String idrpoduct = (((String)ChoiceBox_Product.getValue()).split("\n"))[0].split(":")[1];

                        MySql.stmt.executeUpdate(
                                "UPDATE isp.supply SET `idproduct` = '"+idrpoduct+"', `data` = '"+DataPicker_Data.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"', `number` = '"+TextField_Count.getText()+"', `price` = '"+TextField_Price.getText()+"', `supplier` = '"+TextField_Supplier.getText()+"' WHERE (`id` = '"+table.getId()+"')"
                        );

                        Alerts.Information("Запись успешно обновленна");
                    } catch (SQLException e) {
                        Alerts.Error("Ошибка подключения к БД");
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
