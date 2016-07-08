package counter.view;

import counter.model.bean.Receipt;

/**
 * Created by lizhongquan on 16-7-8.
 */
public class CounterView implements CounterViewInterface {

    @Override
    public void showResult(Receipt receipt) {
        receipt.printReceipt();
    }
}
