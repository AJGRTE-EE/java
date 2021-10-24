package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import sample.Insert_Product.Insert_Product_Controller;
import sample.Insert_Shipment.Insert_Shipment_Controller;
import sample.Insert_Supplier.Insert_Supplier_Controller;
import sample.Tables.Stock;
import sample.Tables.TableProduct;
import sample.Tables.TableShipment;
import sample.Tables.TableSupplier;
import sample.Update_Shipment.Update_Shipment_Controller;
import sample.Update_Supplier.Update_Supplier_Controller;
import sample.Update_Product.Update_Product_Controller;

public class Controller {

    @FXML
    private Button ButtonInsertProduct;

    @FXML
    private Button ButtonInsertSupplier;

    @FXML
    private Button ButtonInsertShipment;

    @FXML
    private Button Button_Refresh1;

    @FXML
    private Button Button_Refresh2;

    @FXML
    private Button Button_Refresh3;

    @FXML
    private Button Button_Search1;

    @FXML
    private Button Button_Search2;

    @FXML
    private Button Button_Search3;

    @FXML
    private Button Button_Search4;

    @FXML
    private DatePicker DatePickerDataSearch1;

    @FXML
    private DatePicker DataPricker_Filter1;

    @FXML
    private DatePicker DataPricker_Filter2;

    @FXML
    private ChoiceBox ChoiceBox_CategoryProduct;

    @FXML
    private ChoiceBox ChoiceBox_Supplier;

    @FXML
    private TextField TextField_NameProduct1;

    @FXML
    private TextField TextField_NameProduct2;

    @FXML
    private TextField TextField_NameProduct3;

    @FXML
    private TableView<TableProduct> TableViewProduct;

    @FXML
    private TableView<TableSupplier> TableViewSupplier;

    @FXML
    private TableView<TableShipment> TableViewShipment;

    @FXML
    private TableView<Stock> TableViewStock;

    /////Колонки для таблицы товаров
    @FXML
    private TableColumn<TableProduct,String> TableColumn1;

    @FXML
    private TableColumn<TableProduct,String> TableColumn2;

    @FXML
    private TableColumn<TableProduct,String> TableColumn3;

    @FXML
    private TableColumn<TableProduct,String> TableColumn4;


    /////Колонки для таблицы поставок
    @FXML
    private TableColumn<TableSupplier,String> TableColumn5;

    @FXML
    private TableColumn<TableSupplier,String> TableColumn6;

    @FXML
    private TableColumn<TableSupplier,String> TableColumn7;

    @FXML
    private TableColumn<TableSupplier,String> TableColumn8;

    @FXML
    private TableColumn<TableSupplier,String> TableColumn9;

    /////Колонки для таблицы откгрузки
    @FXML
    private TableColumn<TableShipment,String> TableColumn10;

    @FXML
    private TableColumn<TableShipment,String> TableColumn11;

    @FXML
    private TableColumn<TableShipment,String> TableColumn12;

    /////Колонки для Склада
    @FXML
    private TableColumn<Stock,String> TableColumn13;

    @FXML
    private TableColumn<Stock,String> TableColumn14;



    private ObservableList<TableProduct> TablesProduct = FXCollections.observableArrayList();

    private ObservableList<TableSupplier> TablesSupplier = FXCollections.observableArrayList();

    private ObservableList<TableShipment> TablesShipment = FXCollections.observableArrayList();

    private ObservableList<Stock> TablesStock = FXCollections.observableArrayList();

    public void Init(){

        TableColumn1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn2.setCellValueFactory(new PropertyValueFactory<>("Category"));
        TableColumn3.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        TableColumn4.setCellValueFactory(new PropertyValueFactory<>("Measure"));

        TableColumn5.setCellValueFactory(new PropertyValueFactory<>("NameProduct"));
        TableColumn6.setCellValueFactory(new PropertyValueFactory<>("DateInput"));
        TableColumn7.setCellValueFactory(new PropertyValueFactory<>("Count"));
        TableColumn8.setCellValueFactory(new PropertyValueFactory<>("Price"));
        TableColumn9.setCellValueFactory(new PropertyValueFactory<>("Supplier"));

        TableColumn10.setCellValueFactory(new PropertyValueFactory<>("NameProduct"));
        TableColumn11.setCellValueFactory(new PropertyValueFactory<>("DateOutput"));
        TableColumn12.setCellValueFactory(new PropertyValueFactory<>("Count"));

        TableColumn13.setCellValueFactory(new PropertyValueFactory<>("Product"));
        TableColumn14.setCellValueFactory(new PropertyValueFactory<>("Count"));


        TableViewProduct.getColumns().setAll(TableColumn1,TableColumn2,TableColumn3,TableColumn4);
        TableViewSupplier.getColumns().setAll(TableColumn5,TableColumn6,TableColumn7,TableColumn8,TableColumn9);
        TableViewShipment.getColumns().setAll(TableColumn10,TableColumn11,TableColumn12);
        TableViewStock.getColumns().setAll(TableColumn13,TableColumn14);

        ButtonInsertProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Insert_Product/Insert_Product.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage=new Stage();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                Insert_Product_Controller controller = fxmlLoader.getController();
                controller.Init();

                primaryStage.setTitle("Добавление товара");
                primaryStage.setScene(new Scene(root, width/2, height/2));
                primaryStage.show();

            }
        });

        ButtonInsertSupplier.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Insert_Supplier/Insert_Supplier.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage=new Stage();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                Insert_Supplier_Controller controller = fxmlLoader.getController();
                controller.Init();

                primaryStage.setTitle("Добавление поставок");
                primaryStage.setScene(new Scene(root, width/2, height/2));
                primaryStage.show();
            }
        });

        ButtonInsertShipment.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Insert_Shipment/Insert_Shipment.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage=new Stage();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                Insert_Shipment_Controller controller = fxmlLoader.getController();
                controller.Init();

                primaryStage.setTitle("Добавление откгрузки");
                primaryStage.setScene(new Scene(root, width/2, height/2));
                primaryStage.show();
            }
        });

        Button_Refresh1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                RefreshTableProduct();
            }
        });

        Button_Refresh2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                DataPricker_Filter1.setValue(null);
                DataPricker_Filter2.setValue(null);
                TextField_NameProduct2.setText("");
                RefreshTableSupplier();
            }
        });

        Button_Refresh3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                RefreshTableShipment();
            }
        });

        Button_Search1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                TablesProduct.clear();
                TableViewProduct.getItems().clear();

                ResultSet rs=null;
                try {
                    rs=MySql.stmt.executeQuery("SELECT * FROM isp.product");
                    while (rs.next()){
                        String s1=rs.getString("name");
                        String s2=rs.getString("category");
                        String s3=rs.getString("manufacturer");
                        String s4=rs.getString("measure");
                        if(s1.contains(TextField_NameProduct1.getCharacters()))
                            TablesProduct.add(new TableProduct(s1,s2,s3,s4));
                    }
                    TableViewProduct.getItems().addAll(TablesProduct);
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Button_Search2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                String category = (String)ChoiceBox_CategoryProduct.getValue();

                String supplier = (String)ChoiceBox_Supplier.getValue();

                if(TextField_NameProduct2.getText().equals("")&&category.equals("All")&&supplier.equals("All")&&DataPricker_Filter1.getValue()==null&&DataPricker_Filter2.getValue()==null){
                    RefreshTableSupplier();
                    return;
                }

                TablesSupplier.clear();
                TableViewSupplier.getItems().clear();

                ResultSet rs=null;

                try {

                    String select = "SELECT * FROM isp.supply";

                    if(DataPricker_Filter1.getValue()==null&&DataPricker_Filter2.getValue()!=null){

                        select+=" where data <= '"+DataPricker_Filter2.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"'";

                    }else if(DataPricker_Filter1.getValue()!=null&&DataPricker_Filter2.getValue()==null){

                        select+=" where data <= '"+DataPricker_Filter1.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"'";

                    }else if(DataPricker_Filter1.getValue()!=null&&DataPricker_Filter2.getValue()!=null){

                        select+=" where data between '"+DataPricker_Filter1.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"' AND '"+DataPricker_Filter2.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"'";
                    }
					
					if(!supplier.equals("All")){
						if(select.contains("where".subSequence(0,5))){
					
							select+=" AND supplier = '"+supplier+"'";
							
						}else{
							
							select+=" where supplier = '"+supplier+"'";
							
						}
					}
					

                    rs=MySql.stmt.executeQuery(select);

                    while (rs.next()){
                        int i = rs.getInt("idproduct");
                        String s1=rs.getString("data");
                        String s2=rs.getString("number");
                        String s3=rs.getString("price");
                        String s4=rs.getString("supplier");
                        TablesSupplier.add(new TableSupplier(i+"",LocalDate.parse(s1.subSequence(0,s1.length())),s2,s3,s4,i,rs.getInt("id")));
                    }
                    rs.close();
                    for(int i=0;i<TablesSupplier.size();i++){
                        int q=Integer.parseInt(TablesSupplier.get(i).getNameProduct());
						
						String select2= "SELECT * FROM isp.product Where id="+q;
						
						if(!category.equals("All")){
							select2+=" AND category = '"+category+"'";
						}

						
                        rs=MySql.stmt.executeQuery(select2);

                        if(rs.next()){
                            String name=rs.getString("name");
                            System.out.println(TextField_NameProduct2.getCharacters());
                            System.out.println(name);
                            System.out.println(name.contains(TextField_NameProduct2.getCharacters()));
                            if(name.contains(TextField_NameProduct2.getCharacters())&&!TextField_NameProduct2.getText().equals("")){
                                String str = "Наименование: "+name+"\n"+
                                        "Категория: "+rs.getString("category")+"\n"+
                                        "Производитель: "+rs.getString("manufacturer")+"\n"+
                                        "Единица измерения: "+rs.getString("measure");
                                TablesSupplier.get(i).setNameProduct(str);
                            }else{
                                TablesSupplier.remove(i--);
                            }

                        }else{
                           TablesSupplier.remove(i--);
                        }

                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                TableViewSupplier.getItems().addAll(TablesSupplier);
            }
        });

        Button_Search3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                TablesShipment.clear();
                TableViewShipment.getItems().clear();
                ResultSet rs=null;
                try {
                    rs=MySql.stmt.executeQuery("SELECT * FROM isp.shipment");
                    while (rs.next()){
                        int i = rs.getInt("idproduct");
                        String s1=rs.getString("data");
                        String s2=rs.getString("number");

                        TablesShipment.add(new TableShipment("",LocalDate.parse(s1.subSequence(0,s1.length())),s2,i,rs.getInt("idshipment")));
                    }
                    rs.close();
                    for(int i=0;i<TablesShipment.size();i++){
                        int q=TablesShipment.get(i).getId();
                        rs=MySql.stmt.executeQuery("SELECT * FROM isp.product Where id="+q);
                        rs.next();
                        String str = "Наименование: "+rs.getString("name")+"\n"+
                                "Категория: "+rs.getString("category")+"\n"+
                                "Производитель: "+rs.getString("manufacturer")+"\n"+
                                "Единица измерения: "+rs.getString("measure");
                        if(rs.getString("name").contains(TextField_NameProduct3.getCharacters()))
                            TablesShipment.get(i).setNameProduct(str);
                        else
                            TablesShipment.remove(i--);
                        rs.close();
                    }

                    TableViewShipment.getItems().addAll(TablesShipment);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Button_Search4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                TablesStock.clear();
                TableViewStock.getItems().clear();
                ResultSet rs=null;
                try {
                    rs=MySql.stmt.executeQuery("SELECT idproduct, number FROM isp.supply WHERE data <= '"+DatePickerDataSearch1.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"'");
                    Map<Integer,Integer> StockMap = new HashMap<>();
                    while (rs.next()){
                        int idproduct = rs.getInt("idproduct");
                        int number = rs.getInt("number");
                        Integer number2 = StockMap.remove(idproduct);
                        if(number2!=null){
                            StockMap.put(idproduct,number2+number);
                        }else{
                            StockMap.put(idproduct,number);
                        }
                    }
                    rs.close();
                    rs=MySql.stmt.executeQuery("SELECT idproduct, number FROM isp.shipment WHERE data <= '"+DatePickerDataSearch1.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE)+"'");
                    while (rs.next()){
                        int idproduct = rs.getInt("idproduct");
                        int number = rs.getInt("number");
                        Integer number2 = StockMap.remove(idproduct);
                        if(number2!=null){
                            StockMap.put(idproduct,number2-number);
                        }else{
                            StockMap.put(idproduct,-1*number);
                        }
                    }
                    rs.close();
                    rs=MySql.stmt.executeQuery("SELECT * FROM isp.product");
                    Integer count=null;
                    while (rs.next()){
                        if((count = (StockMap.remove(rs.getInt("id"))))!=null){
                            TablesStock.add(new Stock(new TableProduct(rs.getString("name"),rs.getString("category"),rs.getString("manufacturer"),rs.getString("measure")),count));

                        }
                    }
                    rs.close();
                    TableViewStock.getItems().setAll(TablesStock);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        LoadContextMenuTableViewProduct();

        LoadContextMenuTableSupplier();

        LoadContextMenuTableShipment();

        RefreshTableProduct();

        RefreshTableSupplier();

        RefreshTableShipment();

    }

    private void LoadContextMenuTableViewProduct(){

        ContextMenu contextMenu = new ContextMenu();

        MenuItem item1 = new MenuItem("Редактировать запись");
        MenuItem item2 = new MenuItem("Удалить запись");


        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Update_Product/Update_Product.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage=new Stage();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                Update_Product_Controller controller = fxmlLoader.getController();

                TableView.TableViewSelectionModel<TableProduct> selectionModel =TableViewProduct.getSelectionModel();
                TableProduct table=selectionModel.getSelectedItem();

                controller.Init(table.getName(),table.getCategory(),table.getManufacturer(),table.getMeasure());

                primaryStage.setTitle("Обновление записи о товаре");
                primaryStage.setScene(new Scene(root, width/2, height/2));
                primaryStage.show();
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView.TableViewSelectionModel<TableProduct> selectionModel =TableViewProduct.getSelectionModel();
                TableProduct table=selectionModel.getSelectedItem();
                try {
                    MySql.stmt.executeUpdate("DELETE FROM isp.product WHERE (name = '"+table.getName()+"' and " +
                            "category = '"+table.getCategory()+"' and " +
                            "manufacturer = '"+table.getManufacturer()+"' and " +
                            "measure = '"+table.getMeasure()+"')");
                    RefreshTableProduct();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        contextMenu.getItems().addAll(item1,item2);

        TableViewProduct.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(TableViewProduct, event.getScreenX(), event.getScreenY());
            }
        });
    }

    private void LoadContextMenuTableSupplier(){

        ContextMenu contextMenu = new ContextMenu();

        MenuItem item1 = new MenuItem("Редактировать запись");
        MenuItem item2 = new MenuItem("Удалить запись");


        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Update_Supplier/Update_Supplier.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage=new Stage();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                Update_Supplier_Controller controller = fxmlLoader.getController();

                TableView.TableViewSelectionModel<TableSupplier> selectionModel =TableViewSupplier.getSelectionModel();
                TableSupplier table=selectionModel.getSelectedItem();

                controller.Init(table);

                primaryStage.setTitle("Обновление записи о поставке");
                primaryStage.setScene(new Scene(root, width/2, height/2));
                primaryStage.show();
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView.TableViewSelectionModel<TableSupplier> selectionModel =TableViewSupplier.getSelectionModel();
                TableSupplier table=selectionModel.getSelectedItem();
                try {
                    MySql.stmt.executeUpdate("DELETE FROM `isp`.`supply` WHERE (`id` = '"+table.getId()+"')");
                    RefreshTableSupplier();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        contextMenu.getItems().addAll(item1,item2);

        TableViewSupplier.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(TableViewSupplier, event.getScreenX(), event.getScreenY());
            }
        });
    }

    private void LoadContextMenuTableShipment(){
        ContextMenu contextMenu = new ContextMenu();

        MenuItem item1 = new MenuItem("Редактировать запись");
        MenuItem item2 = new MenuItem("Удалить запись");


        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Update_Shipment/Update_Shipment.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage=new Stage();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                Update_Shipment_Controller controller = fxmlLoader.getController();

                TableView.TableViewSelectionModel<TableShipment> selectionModel =TableViewShipment.getSelectionModel();
                TableShipment table=selectionModel.getSelectedItem();

                controller.Init(table);

                primaryStage.setTitle("Обновление записи об отгрузке");
                primaryStage.setScene(new Scene(root, width/2, height/2));
                primaryStage.show();
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView.TableViewSelectionModel<TableShipment> selectionModel =TableViewShipment.getSelectionModel();
                TableShipment table=selectionModel.getSelectedItem();
                try {
                    MySql.stmt.executeUpdate("DELETE FROM `isp`.`shipment` WHERE (`idshipment` = '"+table.getId()+"')");
                    RefreshTableShipment();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        contextMenu.getItems().addAll(item1,item2);

        TableViewShipment.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(TableViewShipment, event.getScreenX(), event.getScreenY());
            }
        });
    }

    private void RefreshTableProduct()  {
        TablesProduct.clear();
        TableViewProduct.getItems().clear();
        ResultSet rs=null;
        try {
            rs=MySql.stmt.executeQuery("SELECT * FROM isp.product");
            while (rs.next()){
                String s1=rs.getString("name");
                String s2=rs.getString("category");
                String s3=rs.getString("manufacturer");
                String s4=rs.getString("measure");
                TablesProduct.add(new TableProduct(s1,s2,s3,s4));
            }
            TableViewProduct.getItems().addAll(TablesProduct);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void RefreshTableSupplier(){

        ChoiceBox_CategoryProduct.getItems().clear();
        ChoiceBox_CategoryProduct.getItems().add("All");
        ChoiceBox_CategoryProduct.getSelectionModel().select(0);

        ChoiceBox_Supplier.getItems().clear();
        ChoiceBox_Supplier.getItems().add("All");
        ChoiceBox_Supplier.getSelectionModel().select(0);


        TablesSupplier.clear();
        TableViewSupplier.getItems().clear();
        ResultSet rs=null;

        try {

            rs=MySql.stmt.executeQuery("SELECT category FROM isp.product");
            while (rs.next()){
                String category = rs.getString("category");
                if(!ChoiceBox_CategoryProduct.getItems().contains(category)){
                    ChoiceBox_CategoryProduct.getItems().add(category);
                }
            }
            rs.close();

            rs=MySql.stmt.executeQuery("SELECT * FROM isp.supply");
            while (rs.next()){
                int i = rs.getInt("idproduct");
                String s1=rs.getString("data");
                String s2=rs.getString("number");
                String s3=rs.getString("price");
                String s4=rs.getString("supplier");
                if(!ChoiceBox_Supplier.getItems().contains(s4)){
                    ChoiceBox_Supplier.getItems().add(s4);
                }
                TablesSupplier.add(new TableSupplier("",LocalDate.parse(s1.subSequence(0,s1.length())),s2,s3,s4,i,rs.getInt("id")));
            }
            rs.close();


            for(int i=0;i<TablesSupplier.size();i++){
                int q=TablesSupplier.get(i).getIdProduct();
                rs=MySql.stmt.executeQuery("SELECT * FROM isp.product Where id="+q);
                rs.next();
                String str = "Наименование: "+rs.getString("name")+"\n"+
                        "Категория: "+rs.getString("category")+"\n"+
                        "Производитель: "+rs.getString("manufacturer")+"\n"+
                        "Единица измерения: "+rs.getString("measure");
                TablesSupplier.get(i).setNameProduct(str);
                rs.close();
            }

            TableViewSupplier.getItems().addAll(TablesSupplier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void RefreshTableShipment(){
        TablesShipment.clear();
        TableViewShipment.getItems().clear();
        ResultSet rs=null;
        try {
            rs=MySql.stmt.executeQuery("SELECT * FROM isp.shipment");
            while (rs.next()){
                int i = rs.getInt("idproduct");
                String s1=rs.getString("data");
                String s2=rs.getString("number");

                TablesShipment.add(new TableShipment("",LocalDate.parse(s1.subSequence(0,s1.length())),s2,i,rs.getInt("idshipment")));
        }
            rs.close();
            for(int i=0;i<TablesShipment.size();i++){
                int q=TablesShipment.get(i).getIdProduct();
                rs=MySql.stmt.executeQuery("SELECT * FROM isp.product Where id="+q);
                rs.next();
                String str = "Наименование: "+rs.getString("name")+"\n"+
                        "Категория: "+rs.getString("category")+"\n"+
                        "Производитель: "+rs.getString("manufacturer")+"\n"+
                        "Единица измерения: "+rs.getString("measure");
                TablesShipment.get(i).setNameProduct(str);
                rs.close();
            }

            TableViewShipment.getItems().addAll(TablesShipment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
