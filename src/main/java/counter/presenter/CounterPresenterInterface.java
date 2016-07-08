package counter.presenter;

import counter.model.bean.Receipt;

/**
 * Created by lizhongquan on 16-7-8.
 */
public interface CounterPresenterInterface {

    /**
     * Scan barcodes of items and analyse them
     *
     * @param receipt receipt
     * @param json json
     */
    void scanItemsInCashierDesk(Receipt receipt, String json);

    /**
     * Check out
     * @param receipt receipt
     */
    void checkOutAndPrintReceipt(Receipt receipt);
}
