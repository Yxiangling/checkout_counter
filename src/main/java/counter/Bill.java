package counter;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class Bill{

    public static double totalSavePrice = 0;
    public static double totalPrice = 0;

    static Set<Discount> discounts = new HashSet<Discount>();

    public void setDiscountRecord(String itemName, int freeItemNumber, String unitPrice) {
        Discount discount = new Discount(itemName, freeItemNumber, unitPrice);
        discounts.add(discount);
    }

    public void setPayPrice(double price) {
        price = this.priceFormat(price);
        totalPrice += price;
    }

    public void setSavePrice(double price) {
        price = this.priceFormat(price);
        totalSavePrice += price;
    }

    public void showDiscountRecordSet() {
        if (discounts.size() >= 1) {
            System.out.println("买二赠一商品：");
            discounts.forEach(Discount::showDiscountRecord);
            System.out.println("---------------------------");
        }
    }

    /* double型价格保留两位小数 */
    private double priceFormat(double p) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.valueOf(df.format(p)).doubleValue();
    }
}
