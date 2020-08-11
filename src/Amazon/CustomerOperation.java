package Amazon;

import Cart.ProductDetails;
import Cart.ShoppingCart;
import Paytm.PayTM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IN22913003 on 15-07-2019.
 */
public class CustomerOperation {
    public static int totalBudget;
    public static double paymentDue, finalBudget;

    public static void main(String args[]) {
        String Name, reverse = "";
        ArrayList<String> product_names = new ArrayList<>();
        ArrayList<Double> product_values = new ArrayList<>();
        double value;
        String Option;
        ShoppingCart cart = new ShoppingCart();
        PayTM pay = new PayTM();
        Scanner scan = new Scanner(System.in);
        totalBudget = budgetCalculator(200);
        finalBudget = pay.PayTM(Double.valueOf(totalBudget));
        System.out.println("Total budget:" + totalBudget);
        Authentication.launch();
        Authentication.register();
        Authentication.login();
        do {

            System.out.println("Enter product details:");
            System.out.print("Please Enter the product Name: ");
            Name = scan.next();
            System.out.print("Please Enter the product value: ");
            value = scan.nextDouble();
            ProductDetails product_to_buy = new ProductDetails(Name, value);
            cart.addToShoppingCart(product_to_buy);
            for (ProductDetails i : cart.getItem()) {
                product_names.add(product_to_buy.getName());
                product_values.add(product_to_buy.getValue());

            }

            if (finalBudget > cart.calculateTotal()) {
                System.out.println("Do you want to add more products?: Yes/ No");
                Option = scan.next();

            } else {
                Option = "No";
                System.out.println("Budget is exhausted!");
                paymentDue = cart.calculateTotal() - finalBudget;
                if (paymentDue < 100 && paymentDue > 10) {
                    finalBudget = pay.Fund(finalBudget, paymentDue);
                }
            }
        } while (Option.equalsIgnoreCase("Yes"));
        //Enter OTP code
        //sort
        for (int i = product_values.size() - 1; i >= 0; i--) {
            double b[] = new double[product_values.size() - 1];

            // Copy elements of a[] to b[]
            for (int i = 0; i < product_values.size() - 1; i++) {
                b[i] = product_values.get(i);
                b[0]++;
            }
            double temp;
            int j;

            for (int i = 1; i < b.length; i++) {
                j = i - 1;

                if (b[i] < b[j]) {

                    temp = b[j];
                    b[j] = b[i];
                    b[i] = temp;
                    i = 1;

                }

            }
            System.out.println("Ascending order of price:" + b);
            //print content of array b


            // Change b[] to verify that b[] is different
            // from a[]

           /* int flag = 0;
            double temp;
            if(product_values.get(i)>product_values.get(i+1))
            {
                temp = product_values.get(i);
                product_values.get(i)= product_values.get(i+1).doubleValue();
                product_values.get(i+1) = temp;
                flag = 1;
            }*/
        }
        //reverse
        for (int i = product_names.get(0).length() - 1; i >= 0; i--)
            reverse = reverse + product_names.get(0).charAt(i);
        System.out.println("Reversed first element " + reverse);


        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String s = br.readLine();
            File f1 = new File("C:\\NxtGen_Navya\\Tesco Bank\\Other Files\\Java Sample\\log.txt");   //creating a new file in which u want to write contents of console
            f1.createNewFile();
            FileWriter fw = new FileWriter(f1);
            fw.write(s);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

    private static int budgetCalculator(int n) {
        if (n != 0)
            return n + budgetCalculator(n - 1);
        else
            return n;
    }
}
