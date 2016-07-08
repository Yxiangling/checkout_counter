package counter.model;

import counter.model.bean.Receipt;

/**
 * Created by lizhongquan on 16-7-8.
 */
public interface CounterModelInterface {

    /**
     * Analyse items info with json which has been optimised
     *
     * @param optimisedJson json
     * @param receipt receipt
     */
    void analyseItemsInfo(Receipt receipt, String optimisedJson);
}
