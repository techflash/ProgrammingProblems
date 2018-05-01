package com.general.problem;

/**
 * Find missing number in unsorted array, if array contain numbers in a given
 * range say the range is from 1 to 100. Program needs to find the number which
 * has been replaced by any other number greater than 100
 * 
 * @author Sunil
 *
 */
public class FindMissingNumberInArray {
	public static void main(String[] args) {
		// array
		int a[] = new int[100];
		int sum = 0;

		// insert 1 to 100
		for (int i = 0; i < 100; i++) {
			a[i] = i + 1;
		}

		// Overwrite some value to any random array index
		a[50] = 101;

		// Find the sum of all the numbers
		for (int i = 0; i < a.length; i++) {
			int j = a[i];
			sum = sum + j;
		}

		// Now we have some of all numbers. Now since sum of all numbers 
		// from 1 to a given number can be represented as (N*(N+1))/2 
		// we can substract sum of current array elements with sum of total 
		// elements in the range from 1 to given number. As follows
		System.out.println(((a.length * (a.length + 1)) / 2) - (sum - 101));

	}
}
