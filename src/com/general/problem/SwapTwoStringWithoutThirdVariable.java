package com.general.problem;

public class SwapTwoStringWithoutThirdVariable {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "xyz";
		
		
		System.out.println(" Before swap");
		System.out.println( "s1 = " + s1);
		System.out.println( "s2 = " + s2);
		s2 = s1 + s2;
		s1 = s2.substring(s1.length());
		s2 = s2.substring(0, s2.indexOf(s1));
		
		System.out.println("After Swap");
		System.out.println( "s1 = " + s1);
		System.out.println( "s2 = " + s2);
		
		
	}
}
