package sample.Update_Product;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Alerts;
import sample.MySql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Update_Product_Controller {

    @FXML
    private Button Button_UpdateProduct;

    @FXML
    private TextField TextField_Name;

    @FXML
    private TextField TextField_Category;

    @FXML
    private TextField TextField_Manufacturer;

    @FXML
    private TextField TextField_Unit;

    private int id;


    public Update_Product_Controller() {


    }

    public void Init(String Name, String Category, String Manufacturer, String Unit) {

        this.TextField_Name.setText(Name);
        this.TextField_Category.setText(Category);
        this.TextField_Manufacturer.setText(Manufacturer);
        this.TextField_Unit.setText(Unit);
        ResultSet rs = null;
        try {
            rs = MySql.stmt.executeQuery("SELECT * FROM isp.product where " +
                    "name='" + Name + "' and " +
                    "category='" + Category + "' and " +
                    "manufacturer='" + Manufacturer + "' and " +
                    "measure='" + Unit + "'");
            rs.next();
            id = rs.getInt("id");
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button_UpdateProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (TextField_Name.getText().equals("")) {
                    Alerts.Error("Поле \"Наименование товара\" не заполнено");
                } else if (TextField_Category.getText().equals("")) {
                    Alerts.Error("Поле \"Категория\" не заполнено");
                } else if (TextField_Manufacturer.getText().equals("")) {
                    Alerts.Error("Поле \"Производитель\" не заполнено");
                } else if (TextField_Unit.getText().equals("")) {
                    Alerts.Error("Поле \"Единица измерения\" не заполнено");
                } else {
                    //////////
                    ResultSet rs = null;
                    try {
                        rs = MySql.stmt.executeQuery("SELECT * FROM isp.product where " +
                                "name='" + TextField_Name.getText() + "' and " +
                                "category='" + TextField_Category.getText() + "' and " +
                                "manufacturer='" + TextField_Manufacturer.getText() + "' and " +
                                "measure='" + TextField_Unit.getText() + "'");
                        if (rs.next()) {

                            Alerts.Error("Данный товар уже существует");
                        } else {

                            MySql.stmt.executeUpdate(
                                    "UPDATE `isp`.`product` SET `category` = '"+TextField_Category.getText()+"', `manufacturer` = '"+TextField_Manufacturer.getText()+"', `measure` = '"+TextField_Unit.getText()+"', `name` = '"+TextField_Name.getText()+"' WHERE (`id` = '"+id+"')"
                            );
                            /*MySql.stmt.executeUpdate(
                                    "UPDATE `isp`.`product` SET `category` = '"+TextField_Category.getText()+"' WHERE (`id` = '"+id+"')"
                            );*/
                            Alerts.Information("Запись успешно обновленна");

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
