package counter.model.bean;

public class Discount {
    private String itemName;
    private int number;
    private String unit;

    public Discount(String itemName, int number, String unit) {
        this.itemName = itemName;
        this.number = number;
        this.unit = unit;
    }

    public void showDiscountRecord() {
        System.out.println("名称：" + this.itemName + "，免单数量：" + this.number + this.unit);
    }
}
