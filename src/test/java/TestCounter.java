import counter.model.bean.Receipt;
import counter.model.CounterModel;
import counter.model.CounterModelInterface;
import counter.presenter.CounterPresenter;
import counter.presenter.CounterPresenterInterface;
import counter.view.CounterView;
import counter.view.CounterViewInterface;
//import org.junit.Test;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.Is.is;

public class TestCounter {

	public static void main(String[] args) {
		String testJSON1 = "['ITEM000001-10'" + "\n" + " , '  ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000003-3','ITEM000005','ITEM000005','ITEM000005-10']";
		String testJSON2 = "['ITEM000001','ITEM000001','ITEM000003-3','ITEM000005','ITEM000005']";
		String testJSON3 = "['ITEM000005-3','ITEM000004-3']";

		CounterModelInterface counterModel = new CounterModel();
		CounterViewInterface counterView = new CounterView();
		CounterPresenterInterface counterPresenter
				= new CounterPresenter(counterModel, counterView);

		Receipt receipt = new Receipt();
		counterPresenter.scanItemsInCashierDesk(receipt, testJSON1);
		counterPresenter.checkOutAndPrintReceipt(receipt);
	}


//	@Test
//	public void should_get_correct_price_for_single_item() {
//		String item = "['ITEM000001']";
//		Receipt receipt = new Receipt();
//		boolean result = receipt.analyse(receipt.replace(item));
//		assertThat(result,is(true));
//	}
//
//    @Test
//    public void should_log_in(){
//
//    }



}