import counter.Receipt;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestCounter {

	public static void main(String[] args) {
		String testJSON1 = "['ITEM000001'" + "\n" + " , '  ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000003-3','ITEM000005','ITEM000005','ITEM000005']";
		String testJSON2 = "['ITEM000001','ITEM000001','ITEM000003-3','ITEM000005','ITEM000005']";
		String testJSON3 = "['ITEM000005-3','ITEM000004-3']";

		Receipt in = new Receipt();
		String input = in.replace(testJSON1);
		in.analyse(input);
		in.printReceipt();
	}


	@Test
	public void should_get_correct_price_for_single_item() {
		String item = "['ITEM000001']";
		Receipt receipt = new Receipt();
		boolean result = receipt.analyse(receipt.replace(item));
		assertThat(result,is(true));
	}

}