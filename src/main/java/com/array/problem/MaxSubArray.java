package com.array.problem;

import static java.lang.Math.max;

/**
 * Find sum of max sub array in the given array having negative numbers
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int arr[] = {-1, 2, 2, -4, 2, 3, -1, 2};
        int maxSum = findSumOfMaxSubArryBruteForce(arr);

        System.out.println(maxSum);
    }

    private static int findSumOfMaxSubArryBruteForce(int arr[]) {
        int sum;
        int res = 0;
        for (int subarraysize = 1; subarraysize <= arr.length; subarraysize++) {
            for (int i = 0; i < arr.length; i++) {

                if ((subarraysize + i) <= arr.length) {
                    sum = 0;
                    for (int j = i; j < (subarraysize + i); j++) {
                        sum += arr[j];
                    }
                    res = max(res, sum);
                }
            }
        }
        return res;
    }

}
