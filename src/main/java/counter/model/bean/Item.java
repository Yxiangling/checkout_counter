package counter.model.bean;


import java.text.DecimalFormat;

public class Item {
    private String itemName;
    private String unit;
    private double price;
    private String discountName;

    private boolean isDiscount = false;

    public Item(String itemName, String unit, double price, boolean isDiscount, String barcode) {
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.isDiscount = isDiscount;

        if (isDiscount) {
            this.discountName = "买二赠一";
        } else {
            this.discountName = "优惠条件不符合";
        }

    }

    public Bill pay(int totalNum) {
        double payPrice;
        double countPrice = 0;

        Bill pay = new Bill();

        if (this.isDiscount) {
            // 买二赠一
            payPrice = price * (totalNum - (totalNum / 3));
            countPrice = price * (totalNum / 3);
            pay.setDiscountRecord(this.itemName, (totalNum / 3), this.unit);
        } else {
            payPrice = price * totalNum;
        }
        pay.setPayPrice(payPrice);
        pay.setSavePrice(countPrice);
        this.printCommoditiesList(payPrice, countPrice, totalNum);
        return pay;
    }

    /*
     * Description: 打印购买详细小单
     *
     */
    private void printCommoditiesList(double payPrice, double savePrice, int totalNumber) {
        DecimalFormat df = new DecimalFormat("0.00");
        String tempPrice = df.format(payPrice);

        if (this.isDiscount) {
            MyUtils.outPrint("名称:" + this.itemName + "，单价：" + this.price + "(元)，优惠：" + this.discountName);
        } else {
            MyUtils.outPrint("名称:" + this.itemName + "，单价：" + this.price + "(元)");
        }

        if (savePrice == 0) {
            MyUtils.outPrint("，数量：\" + totalNumber + this.unit + \",小计：\" + tempPrice + \"(元)");
        } else {
            String strSavePrice = df.format(savePrice);
            MyUtils.outPrint("，数量：" + totalNumber + this.unit + ",小计：" + tempPrice + "(元)，小计优惠：" + strSavePrice + "(元)");
        }
    }
}
