package counter.model.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ItemsOnSell {
    TreeMap<String, Item> barcodeDetail = new TreeMap<>();
    List<Item> items = new ArrayList<>();

    public ItemsOnSell() {
        Item g1 = new Item("可口可乐", "瓶", 6.00, "ITEM000001");
        Item g2 = new Item("羽毛球拍", "个", 78.00, "ITEM000002");
        Item g3 = new Item("苹果", "斤", 5.50, "ITEM000003");
        Item g4 = new Item("雪碧", "瓶", 3.00, "ITEM000004");
        Item g5 = new Item("羽毛球", "盒", 12.00, "ITEM000005");

        items.add(g1);
        items.add(g2);
        items.add(g3);
        items.add(g4);
        items.add(g5);
        barcodeDetail.put("ITEM000001", g1);
        barcodeDetail.put("ITEM000002", g2);
        barcodeDetail.put("ITEM000003", g3);
        barcodeDetail.put("ITEM000004", g4);
        barcodeDetail.put("ITEM000005", g5);
    }

    public Item query(String barcode) {
//		Stream<Item> filteredItems = items.stream().filter(item -> item.getBarcode().equals(barcode));
//		if (filteredItems.count() > 0) {
//		}

        return barcodeDetail.get(barcode);
    }
}
