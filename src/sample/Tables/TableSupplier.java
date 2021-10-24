package sample.Tables;

import java.time.LocalDate;

public class TableSupplier {

    private String NameProduct;
    private LocalDate DateInput;
    private String Count;
    private String Price;
    private String Supplier;
    private int IdProduct;
    private int Id;

    public TableSupplier() {
    }

    public TableSupplier(String nameProduct, LocalDate dateInput, String count, String price, String supplier,int IdProduct,int id) {
        NameProduct = nameProduct;
        DateInput = dateInput;
        Count = count;
        Price = price;
        Supplier = supplier;
        this.IdProduct=IdProduct;
        this.Id=id;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public int getId() {
        return Id;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public LocalDate getDateInput() {
        return DateInput;
    }

    public String getCount() {
        return Count;
    }

    public String getPrice() {
        return Price;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public void setDateInput(LocalDate dateInput) {
        DateInput = dateInput;
    }

    public void setCount(String count) {
        Count = count;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public int getIdProduct() {
        return this.IdProduct;
    }

    public void setId(int IdProduct) {
        this.IdProduct = IdProduct;
    }
}
