package Cart;

import java.util.ArrayList;

/**
 * Created by IN22913003 on 15-07-2019.
 */
public class ProductDetails {
    private String product_name, name;
    private double product_value;

    public ProductDetails(String product_name, double product_value) {
        this.product_name = product_name;
        this.product_value = product_value;

    }

    public String getProduct() {
        return product_name;
    }

    public double getValue() {
        return product_value;
    }

    public String getName() {
        return name;
    }

    public void setProduct(String product_name) {
        this.product_name = product_name;

    }

    public double setValue() {
        this.product_value = product_value;
    }

}
