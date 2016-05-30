package testing;

import counter.Receipt;

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

}