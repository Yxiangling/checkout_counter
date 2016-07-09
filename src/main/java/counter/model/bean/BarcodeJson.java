package counter.model.bean;

/**
 * Created by yxiangling on 2016/7/9.
 */
public class BarcodeJson {

    private String barcode;

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public int getNumber() {
        return number;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BarcodeJson(String barcode, int number) {
        this.barcode = barcode;
        this.number = number;
    }
    public BarcodeJson(){}
}
