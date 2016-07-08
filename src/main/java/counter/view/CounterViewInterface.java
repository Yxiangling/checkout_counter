package counter.view;

import counter.model.bean.Receipt;

/**
 * Created by lizhongquan on 16-7-8.
 */
public interface CounterViewInterface {

    /**
     * Show the result of check-out
     *
     * @param receipt receipt
     */
    void showResult(Receipt receipt);
}
