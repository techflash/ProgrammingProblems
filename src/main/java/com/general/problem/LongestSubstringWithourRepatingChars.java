package com.general.problem;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithourRepatingChars {
	public static void main(String[] args) {

		String str = "bbbbbb";
		int l = 0;
		int count = 0;
		int maxCount = count;
		StringBuffer sb = new StringBuffer();
		StringBuffer ans = new StringBuffer();
		Map<Character, Integer> map = new HashMap<>();
		while (l < str.length()) {
			if (map.containsKey(str.charAt(l))) {
				map.clear();
				if (count > maxCount) {
					maxCount = count;
					ans = sb;
					count = 0;
					sb = new StringBuffer();
				}
			}
			count++;
			map.put(str.charAt(l), null);
			sb.append(str.charAt(l));
			l++;

		}

		System.out.println("Ans : " + ans + " length : " + maxCount);

	}
}
