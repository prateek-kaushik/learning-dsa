package com.prateek.learning.dsa;

public class KadensAlgo {
	public int getMaxSubArraySum(int[] arr) {
		int max = 0, maxSoFar = 0;
		for (int c : arr) {
			max = Math.max(max + c, c);
			maxSoFar = Math.max(maxSoFar, max);
			System.out.println("max=" + max + ", maxSoFar=" + maxSoFar);
		}

		return maxSoFar;
	}

	public static void main(String args[]) {
		int[] arr = { -7, -1, 5, 2, 3, -7, -6, 1 };

		System.out.println("max=" + new KadensAlgo().getMaxSubArraySum(arr));
	}
}
