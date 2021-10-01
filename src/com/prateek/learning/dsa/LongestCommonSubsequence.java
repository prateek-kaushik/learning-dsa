package com.prateek.learning.dsa;

public class LongestCommonSubsequence {
	public static void main(String args[]) {
		String s1 = "prateek";
		String s2 = "prashik";

		LongestCommonSubsequence obj = new LongestCommonSubsequence();

		System.out.println("LCS of " + s1 + " and " + s2 + " is " + obj.lcsRec(s1, s2, s1.length(), s2.length()));

		System.out.println("LCS of " + s1 + " and " + s2 + " using better is " + obj.lcsBetter(s1, s2));
	}

	public String lcsRec(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return "";
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return lcsRec(x, y, m - 1, n - 1) + x.charAt(m - 1);
		}

		String s1 = lcsRec(x, y, m, n - 1);
		String s2 = lcsRec(x, y, m - 1, n);

		return s1.length() > s2.length() ? s1 : s2;
	}

	public String lcsBetter(String x, String y) {
		int m = x.length();
		int n = y.length();
		String[][] mat = new String[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					if (mat[i - 1][j - 1] == null) {
						mat[i - 1][j - 1] = "";
					}
					mat[i][j] = mat[i - 1][j - 1] + x.charAt(i - 1);
				} else {
					String s1 = mat[i - 1][j];
					String s2 = mat[i][j - 1];
					if (s1 == null) {
						s1 = "";
					}
					if (s2 == null) {
						s2 = "";
					}
					if (s1.length() < s2.length()) {
						mat[i][j] = s2;
					} else {
						mat[i][j] = s1;
					}
				}
			}
		}

		return mat[m][n];
	}
}
