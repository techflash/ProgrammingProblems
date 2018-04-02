package com.general.problem;

public class ReverseWordOfString {
	public static void main(String[] args) {
		reverse("India is my country".split("\\s"), 0);
	}

	/**
	 * 
	 * @param arr
	 * @param index
	 */
	public static void reverse(String arr[], int index) {
		if (index > arr.length-1)
			return;

		reverse(arr, ++index);
		System.out.println(arr[index-1]);

	}
}
