import counter.model.Response;
import counter.model.bean.Item;
import org.junit.Before;
import org.junit.Test;
import strategy.BuyXThenFreeYStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by yxiangling on 2016/7/9.
 */
public class BuyXThenFreeYStrategyTest {


    private BuyXThenFreeYStrategy buyXThenFreeYStrategy;

    @Before
    public void setUp() throws Exception {
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000001");
        buyXThenFreeYStrategy = new BuyXThenFreeYStrategy(3,1,barcodes);
    }

    @Test
    public void should_init_this_Strategy_successfully(){
          assertThat(buyXThenFreeYStrategy, is(notNullValue()));
    }

    @Test
    public void should_calculate_price_against_the_items_if_need_discount() {
        Item item = new Item("可口可乐", "瓶", 6.00, "ITEM000001");
        Response response = buyXThenFreeYStrategy.apply(item, 3);
        assertThat(response.getGeneralResponse(),is("名称：可口可乐，数量：3瓶，单价：6.0(元)，小计：12.0(元)"));
        assertThat(response.getDisCountResponse(),is("名称：可口可乐，数量：1瓶"));
    }

    @Test
    public void should_calculate_price_against_the_items_if_no_need_discount() {
        Item item = new Item("可口可乐", "瓶", 6.00, "ITEM000001");
        Response response = buyXThenFreeYStrategy.apply(item, 2);
        assertThat(response.getGeneralResponse(),is("名称：可口可乐，数量：2瓶，单价：6.0(元)，小计：12.0(元)"));
        assertThat(response.getDisCountResponse(),is(""));
    }
}
