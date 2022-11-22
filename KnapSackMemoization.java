package com.dp.series.knapsack;

/**
 *
 */
public class KnapSackMemoization {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println(knapSackMemoizaion(val, wt, W, n));
    }

    private static int knapSackMemoizaion(int[] val, int[] wt, int w, int n) {
        //base case
        if (n == 0 || w == 0)
            return 0;
        //initialization
        int tb[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= w; j++) {
                tb[i][j] = -1;
            }
        if (wt[n - 1] <= w) {
            tb[n][w] = max(val[n - 1] + knapSackMemoizaion(val, wt, w - wt[n - 1], n - 1), knapSackMemoizaion(val, wt, w, n - 1));
        } else {
            tb[n][w] = knapSackMemoizaion(val, wt, w, n - 1);
        }

        return tb[n][w];
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
