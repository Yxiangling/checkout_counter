package counter;

import java.util.HashMap;
import java.util.Iterator;

public class Receipt {

    public final String SEPARATOR = "-";

    ItemsOnSell commoditySpecies = new ItemsOnSell();

    HashMap<String, Integer> discountMap = new HashMap<>();
    Bill countPay = new Bill();

    public String replace(String str) {
        return str.replaceAll("\\s*|\t|\r|\n", "");
    }

    public boolean analyse(String str) {

        if (!this.checkFormat(str, '[', ']')) {
            return false;
        }

        str = str.substring(1, str.length() - 1);
        String strArray[] = str.split(",");

        String itemArray[];
        int payNum;
        for (String item : strArray) {
            if (!this.checkFormat(item, '\'', '\'')) {
                return false;
            }
            item = item.substring(1, item.length() - 1);

            if (item.contains(SEPARATOR)) {
                itemArray = item.split(SEPARATOR);
                item = itemArray[0];
                payNum = Integer.parseInt(itemArray[1]);
                this.compute(item, payNum);

            } else {
                this.compute(item, 1);
            }
        }
        return true;
    }


    private boolean checkFormat(String str, char cPrev, char cNext) {
        if (str.charAt(0) != cPrev || str.charAt(str.length() - 1) != cNext) {
            System.out.println("输入错误");
            return false;
        }
        return true;
    }


    private void compute(String item, int payNum) {
        int mCount;

        if (discountMap.get(item) != null) {
            mCount = discountMap.get(item);
            mCount += payNum;
            discountMap.put(item, mCount);
        } else {
            discountMap.put(item, payNum);
        }


    }

    public void printReceipt() {

        System.out.println("***ThoughtWork超市购物小票***");
        @SuppressWarnings("rawtypes")
        Iterator iter = discountMap.entrySet().iterator();
        while (iter.hasNext()) {
            @SuppressWarnings("rawtypes")
            HashMap.Entry entry = (HashMap.Entry) iter.next();
            Object key = entry.getKey();
            Item g = commoditySpecies.query(key.toString());
            countPay = g.pay(this.getPayNum(key.toString()));
        }
        System.out.println("-----------------------------");
        countPay.showDiscountRecordSet();
        System.out.println("总计：" + Bill.totalPrice + "(元)");
        if (Bill.totalSavePrice > 0) {
            System.out.println("节省：" + Bill.totalSavePrice + "(元)");
        }
        System.out.println("*****************************");
    }

    private int getPayNum(String str) {
        return discountMap.get(str);
    }

}
