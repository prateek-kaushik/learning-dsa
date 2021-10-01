package com.prateek.learning.dsa;

public class KnapsackProblem {

	public static void main(String args[]) {
		KnapsackProblem kp = new KnapsackProblem();
		int maxWeight = 10;
		int weights[] = { 2, 3, 7, 9 };
		int profits[] = { 50, 30, 100, 60 };
		int[][] dp = new int[weights.length + 1][maxWeight + 1];
		System.out.println("maxProfit=" + kp.maxProfit(maxWeight, weights, profits, dp));
		System.out.println("weights used=" + kp.listOfWeigthsUsed(maxWeight, weights, dp));
	}

	public int maxProfit(int maxWeight, int[] weights, int[] profits, int[][] dp) {
		for (int i = 1; i <= weights.length; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				if (weights[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], profits[i - 1] + dp[i - 1][j - weights[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[weights.length][maxWeight];
	}

	public String listOfWeigthsUsed(int maxWeight, int[] weights, int[][] dp) {
		String res = "";
		int r = dp.length - 1;
		int c = dp[0].length - 1;
		int rem = maxWeight;

		while (r > 0 && rem > 0) {
			if (dp[r][c] != dp[r - 1][c]) {
				res = res + weights[r - 1] + ", ";
				rem = maxWeight - weights[r - 1];
				c = rem;
			}
			r--;
		}

		return res;
	}
}
