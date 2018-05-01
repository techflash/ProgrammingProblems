package com.general.problem;

public class CountWordsInString {
	public static void main(String[] args) {
		String str = "OneTwoThreeFourFive"; // .split("");
		int i = 0;
		int wc = 0;
		boolean state = true;
		
		while (str.length() > i) {
			if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90) {
				state = true;

			} else if (state) {
				state = false;
				wc++;
			}

			++i;
		}

		System.out.println("No of words  = " + wc);

	}
}
