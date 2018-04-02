package com.general.problem;

public class FindNextGreaterNumber {

	public static void main(String[] args) {
		System.out.println(findNextGreater(152));
	}

	/**
	 * Finds next greater number
	 * 
	 * @param number
	 * @return
	 */
	public static long findNextGreater(long number) {
		long n = -1;
		for (long i = number + 1; i < number * 2; i++) {
			if (areDigitSame(number, i)) {
				n = i;
				break;
			}
		}
		return n;
	}

	/**
	 * Checks whether tow numbers has same digits
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean areDigitSame(long a, long b) {
		boolean flag = false;
		// Get one digit at a time from first number
		for (long i = a % 10; a > 0; a = a / 10, i = a % 10) {
			flag = false;
			long x = b;
			// Get one digit at time from second number
			for (long j = b % 10; b > 0; b = b / 10, j = b % 10) {

				if (j == i) {
					flag = true;
					break;
				}
			}

			if (!flag)
				break;
			b = x;
		}

		return flag;
	}
}
