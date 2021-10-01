package com.prateek.learning.dsa;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static void main(String args[]) {
		LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
		System.out.println("wobgrovw=" + obj.lengthOfLongestSubstring("wobgrovw"));
	}

	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int l1 = 0, l2 = 0;
		String str = "";
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (set.contains(ch)) {
				for (int j = 0; j < str.length(); j++) {
					if (ch == str.charAt(j)) {
						str = str.substring(j + 1, str.length()) + ch;
						l1 = str.length();
						break;
					} else {
						set.remove(str.charAt(j));
					}
				}
				set.remove(ch);
			} else {
				str = str + ch;
				l1++;
			}
			set.add(ch);
			l2 = Math.max(l2, l1);
		}
		return l2;
	}
}
