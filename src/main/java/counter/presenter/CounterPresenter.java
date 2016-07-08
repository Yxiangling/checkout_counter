package counter.presenter;

import counter.model.bean.Receipt;
import counter.model.CounterModelInterface;
import counter.view.CounterViewInterface;

/**
 * Created by lizhongquan on 16-7-8.
 */
public class CounterPresenter implements CounterPresenterInterface {

    /**
     * Model layer
     */
    private CounterModelInterface counterModel;

    /**
     * View layer
     */
    private CounterViewInterface counterView;

    public CounterPresenter(CounterModelInterface counterModel,
                            CounterViewInterface counterView){
        this.counterModel = counterModel;
        this.counterView = counterView;
    }

    @Override
    public void scanItemsInCashierDesk(Receipt receipt, String json) {

        // Optimise json
        String optimisedJson = receipt.replace(json);

        // Analyse items info with json which has been optimised
        counterModel.analyseItemsInfo(receipt, optimisedJson);
    }

    @Override
    public void checkOutAndPrintReceipt(Receipt receipt) {
        counterView.showResult(receipt);
    }
}
