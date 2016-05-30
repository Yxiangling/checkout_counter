package counter;

import java.util.TreeMap;

public class CommoditySpecies {
	TreeMap<String, Commodities> map = new TreeMap<String, Commodities>();

	public CommoditySpecies() {
		Commodities g1 = new Commodities("可口可乐", "瓶", 6.00, false);
		Commodities g2 = new Commodities("羽毛球拍", "个", 78.00, false);
		Commodities g3 = new Commodities("苹果", "斤", 5.50, false);
		Commodities g4 = new Commodities("雪碧", "瓶", 3.00, true);
		Commodities g5 = new Commodities("羽毛球", "盒", 12.00, true);
		//Commodities g6 = new Commodities("香蕉", "斤", 4.00, true);
		//Commodities g7 = new Commodities("菠菜", "斤", 0.80, false);

		map.put("ITEM000001", g1);
		map.put("ITEM000002", g2);
		map.put("ITEM000003", g3);
		map.put("ITEM000004", g4);
		map.put("ITEM000005", g5);
		//map.put("ITEM000006", g6);
		//map.put("ITEM000007", g7);
	}

	public Commodities query(String item) {
		Commodities g = map.get(item);
		return g;
	}

}
