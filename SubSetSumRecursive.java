package com.dp.series.subsetsum;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumRecursive {
    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        List<Integer> list = new ArrayList<>();
        boolean flag = subSetSumRecursion(set, sum, n);
        System.out.println(flag);
    }

    private static boolean subSetSumRecursion(int[] set, int sum, int n) {
        //base case
        if (n == 0)
            return false;
        if (sum == 0)
            return true;

        //hypothesis
        if (set[n - 1] <= sum) {
            return subSetSumRecursion(set, sum - set[n - 1], n - 1) || subSetSumRecursion(set, sum, n - 1);
        }
        else{
            return subSetSumRecursion(set, sum, n - 1);
        }
    }
}
