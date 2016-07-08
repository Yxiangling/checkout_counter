package counter.model;

import counter.model.bean.Receipt;

/**
 * Created by lizhongquan on 16-7-8.
 */
public class CounterModel implements CounterModelInterface {

    @Override
    public void analyseItemsInfo(Receipt receipt,
                                 String jsonAfterOptimised) {

        receipt.analyse(jsonAfterOptimised);
    }
}
