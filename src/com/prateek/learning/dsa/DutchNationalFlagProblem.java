package com.prateek.learning.dsa;

public class DutchNationalFlagProblem {

	public static void main(String args[]) {

		int[] arr = new int[] { 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0 };

		int mid = 0, start = 0, end = arr.length - 1;
		int pivot = 1;

		while (mid <= end) {
			if (arr[mid] < pivot) {
				int temp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = temp;

				start++;
				mid++;
			} else if (arr[mid] > pivot) {
				int temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;
				end--;
			} else {
				mid++;
			}
		}

		for (int a : arr) {
			System.out.print(a + ", ");
		}
	}
}
