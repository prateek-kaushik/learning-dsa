	package com.prateek.learning.dsa;

public class LongestCommonSubsequenceLength {

	public static void main(String args[]) {
		String s1 = "prateek";
		String s2 = "kaushik";

		LongestCommonSubsequenceLength obj = new LongestCommonSubsequenceLength();

		System.out
				.println("LCS length of " + s1 + " and " + s2 + " is " + obj.lcsRec(s1, s2, s1.length(), s2.length()));
		System.out.println("LCS length of " + s1 + " and " + s2 + " using better is " + obj.lcsBetter(s1, s2));

	}

	public int lcsRec(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return lcsRec(x, y, m - 1, n - 1) + 1;
		}
		return Math.max(lcsRec(x, y, m, n - 1), lcsRec(x, y, m - 1, n));
	}

	public int lcsBetter(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] mat = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					mat[i][j] = 1 + mat[i - 1][j - 1];
				} else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
				}
			}
		}
		return mat[m][n];
	}
}
