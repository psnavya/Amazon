package Cart;

import java.util.ArrayList;

/**
 * Created by IN22913003 on 15-07-2019.
 */
public class ShoppingCart {
    double TotalCost;
    public static ArrayList<ProductDetails> productList = new ArrayList<ProductDetails>();

    public ArrayList<ProductDetails> getItem() {
        return productList;
    }

    public void addToShoppingCart(ProductDetails product_details) {
        productList.add(product_details);
    }

    public double calculateTotal() {
        for (ProductDetails i : productList) {
            TotalCost = TotalCost + i.getValue();

        }
        return TotalCost;
    }

}
