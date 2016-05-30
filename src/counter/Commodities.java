package counter;


import java.text.DecimalFormat;

public class Commodities {
	private String name;
	private String unitprice;
	private double price;
	private String discountName;

	private boolean promotion2for1 = false;


	public Commodities(String name, String unit, double price, boolean pro2for1) {
		this.name = name;
		this.unitprice = unit;
		this.price = price;
		this.promotion2for1 = pro2for1;

		if (pro2for1) {
			this.discountName = "买二赠一";
		} 
		else {
			this.discountName = "优惠条件不符合";
		}

	}

	public Bill pay(int num) {
		double payPrice = 0;
		double countPrice = 0;

		Bill pay = new Bill();

		if (this.promotion2for1) {
			// 买二赠一
			payPrice = price * (num - (num / 3));
			countPrice = price * (num / 3);
			pay.setDiscountRecord(this.name, (num / 3), this.unitprice);
		} else {
			payPrice = price * num;
		}
		pay.setPayPrice(payPrice);
		pay.setSavePrice(countPrice);
		this.printCommoditiesList(payPrice, countPrice, num);
		return pay;
	}
	
	/*
	 * Description: 打印购买详细小单
	 * 
	 */
	private void printCommoditiesList(double payPrice, double savePrice, int num) {
		DecimalFormat df = new DecimalFormat("0.00");
		String strPrice = df.format(payPrice);

		if (this.promotion2for1 ) { 
			System.out.print("名称:" + this.name + "，单价：" + this.price + "(元)，优惠：" + this.discountName);
		} else {
			System.out.print("名称:" + this.name + "，单价：" + this.price + "(元)");
		}
		if (savePrice == 0) {
			System.out.println("，数量：" + num + this.unitprice + ",小计：" + strPrice + "(元)");
		} else {
			String strSavePrice = df.format(savePrice);
			System.out.println("，数量：" + num + this.unitprice + ",小计：" + strPrice + "(元)，小计优惠：" + strSavePrice + "(元)");
		}
	}

}
