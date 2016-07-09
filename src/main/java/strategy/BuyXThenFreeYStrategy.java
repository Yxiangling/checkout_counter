package strategy;

import counter.model.Response;
import counter.model.bean.Item;

import java.util.List;

/**
 * Created by yxiangling on 2016/7/9.
 */
public class BuyXThenFreeYStrategy {
    private int minBuyedMount;
    private int freeMount;
    private List<String> barcodes;

    public BuyXThenFreeYStrategy(int minBuyedMount, int freeMount, List<String> barcodes) {

        this.minBuyedMount = minBuyedMount;
        this.freeMount = freeMount;
        this.barcodes = barcodes;
    }

    public Response apply(Item item, int itemMount) {
        int discountMount = itemMount / minBuyedMount * freeMount;
        double totalAmount = item.getPrice() * (itemMount - discountMount);

        String generalResponse = String.format("名称：%s，数量：%d%s，单价：%s(元)，小计：%s(元)", item.getItemName(), itemMount, item.getUnit(), item.getPrice(), totalAmount);
        String disCountResponse = "";
        if (discountMount > 0) {
            disCountResponse = "名称：" + item.getItemName() + "，数量：" + discountMount + item.getUnit();
        }

        return new Response(generalResponse, disCountResponse);
    }
}
