package counter.model.bean;

public class Item {
    private String itemName;
    private String unit;
    private double price;
    private String barcode;

    public Item(String itemName, String unit, double price, String barcode) {
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.barcode = barcode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }
}
