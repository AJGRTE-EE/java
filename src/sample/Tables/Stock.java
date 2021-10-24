package sample.Tables;

public class Stock {

    private TableProduct Product;

    private int Count;

    public Stock() {
    }

    public Stock(TableProduct product, int count) {
        Product = product;
        Count = count;
    }

    public TableProduct getProduct() {
        return Product;
    }

    public void setProduct(TableProduct product) {
        Product = product;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

}
