package counter.model.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import
        org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by yxiangling on 2016/7/9.
 */
public class ReceiptTest {
    @Test
    public void should_scan_single_item_successfully(){
        // given
        Receipt receipt = new Receipt();
        String items = "['ITEM000001']";

        // when
        receipt.scan(items);

        //then
        HashMap<Item,Integer> receipts = receipt.getReceiptList();
        Optional<Map.Entry<Item, Integer>> first = receipts.entrySet().stream().filter(p -> p.getKey().getBarcode().equals(("ITEM000001"))).findFirst();
        assertThat(first.isPresent(),is(true));
        Integer count = first.get().getValue();
        assertThat(count,is(1));
    }


    @Test
    public void should_scan_single_item_successfully_with_count(){
        // given
        Receipt receipt = new Receipt();
        String items = "['ITEM000001-3']";
        // when
        receipt.scan(items);

        //then
        HashMap<Item,Integer> receipts = receipt.getReceiptList();
        Optional<Map.Entry<Item, Integer>> first = receipts.entrySet().stream().filter(p -> p.getKey().getBarcode().equals(("ITEM000001"))).findFirst();
        assertThat(first.isPresent(),is(true));
        Integer count = first.get().getValue();
        assertThat(count,is(3));
    }
}