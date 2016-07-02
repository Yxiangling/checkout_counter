package counter;

public class Discount {
	private String name;
	private int number;
	private String unit;

	public void setDiscountRecord(String str, int num, String unit) {
		this.name = str;
		this.number = num;
		this.unit = unit;
	}

	public void showDiscountRecord() {
		System.out.println("名称：" + this.name + "，免单数量：" + this.number + this.unit);
	}
}
