package com.interview.dsa.array;

public class BuyAndSellStock {
// 2 4 1
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
           min = Math.min(min, prices[i]);
           profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
