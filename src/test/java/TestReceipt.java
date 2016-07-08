import org.junit.Test;
import counter.model.bean.Receipt;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yxiangling on 2016/7/9.
 */
public class TestReceipt {
    @Test
    public void should_get_correct_price_for_single_item() {
        String item = "['ITEM000001']";
        Receipt receipt = new Receipt();
        boolean result = receipt.analyse(receipt.replace(item));
        assertThat(result,is(true));
    }

    @Test
    public void replace_test(){
        String testString = "['IT EM0 000 0 1']";
        String targetString = "['ITEM000001']";
        Receipt receipt = new Receipt();
        String result = receipt.replace(testString);
        assertEquals(result,targetString);
    }
}
