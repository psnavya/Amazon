package Paytm;

/**
 * Created by IN22913003 on 15-07-2019.
 */
public class PayTM {
    private static double finalBudget;
    private static double finalNewBudget;

    public static double PayTM(double totalBudget) {
        finalBudget = totalBudget + 50;
        return finalBudget;
    }

    public static double Fund(double totalBudget, double paydue) {
        finalNewBudget = paydue + Double.valueOf(totalBudget);
        return finalNewBudget;

    }

}
