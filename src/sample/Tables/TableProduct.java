package sample.Tables;

public class TableProduct {

    private String Name;

    private String Category;

    private String Manufacturer;

    private String Measure;

    public TableProduct() {
    }

    public TableProduct(String name, String category, String manufacturer, String measure) {
        Name = name;
        Category = category;
        Manufacturer = manufacturer;
        Measure = measure;
    }

    public String getName() {
        return Name;
    }

    public String getCategory() {
        return Category;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getMeasure() {
        return Measure;
    }

    @Override
    public String toString() {
        return "Наименование: "+Name+"\n"+
                "Категория: "+Category+"\n"+
                "Производитель: "+Manufacturer+"\n"+
                "Единица измерения: "+Measure;
    }
}
