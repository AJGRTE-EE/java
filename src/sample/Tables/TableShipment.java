package sample.Tables;

import java.time.LocalDate;

public class TableShipment {

    private String NameProduct;
    private LocalDate DateOutput;
    private String Count;
    private int IdProduct;
    private int Id;

    public TableShipment(String nameProduct, LocalDate dateOutput, String count, int IdProduct,int id) {
        NameProduct = nameProduct;
        DateOutput = dateOutput;
        Count = count;
        this.IdProduct=IdProduct;
        this.Id=id;
    }

    public TableShipment() {
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public LocalDate getDateOutput() {
        return DateOutput;
    }

    public String getCount() {
        return Count;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public void setDateOutput(LocalDate dateOutput) {
        DateOutput = dateOutput;
    }

    public void setCount(String count) {
        Count = count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
