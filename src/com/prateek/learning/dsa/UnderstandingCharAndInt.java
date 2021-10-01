package com.prateek.learning.dsa;

public class UnderstandingCharAndInt {

	public static void main(String args[]) {
		String s = "123";
		
		for (char ch : s.toCharArray()) {
			int c = ch;
			System.out.println(c);
		}
		
		for (char ch : s.toCharArray()) {
			int c = ch - '0';
			System.out.println(c);
		}
	}
}
