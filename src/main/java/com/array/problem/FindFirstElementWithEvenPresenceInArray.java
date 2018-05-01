package com.array.problem;

/**
 * Find the first element in given array with even number of repetition
 */
public class FindFirstElementWithEvenPresenceInArray {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 20, 30, 40, 40};

        System.out.println("First element with even repetition : " + findFirstElementWithEvenRepetition(arr));

    }

    private static int findFirstElementWithEvenRepetition(int[] arr) {

        for (int x : arr
                ) {

            if (findRepetition(x, arr) % 2 == 0) {
                return x;
            }

        }
        return -1;
    }

    private static int findRepetition(int element, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) count++;
        }
        return count;
    }

}
