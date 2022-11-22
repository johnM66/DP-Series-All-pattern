package com.dp.series.knapsack;

/**
 *
 */
public class KnapSackTopDown {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        int i = knapSackTopDown(val, wt, W, n);
        System.out.println(i);

    }

    private static int knapSackTopDown(int[] val, int[] wt, int w, int n) {
        //base case of recursion and arrange table with data
        int tb[][] = new int[n + 1][w + 1];
        //initialization
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= w; j++)
                if (i == 0 || j == 0)
                    tb[i][j] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    tb[i][j] = max(val[i - 1] + tb[i - 1][j - wt[i - 1]], tb[i - 1][j]);
                } else {
                    tb[i][j] = tb[i - 1][j];
                }
            }


        return tb[n][w];
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
