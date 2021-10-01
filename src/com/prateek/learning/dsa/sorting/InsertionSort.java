package com.prateek.learning.dsa.sorting;

public class InsertionSort {
	public static void main(String args[]) {
		int[] arr = { 6, 5, 4, 3, 2, 1, -1, -2 };
		InsertionSort sort = new InsertionSort();
		sort.insertionSort(arr);

		for (int k = 0; k < arr.length; k++) {
			System.out.print(" " + arr[k]);
		}
	}

	public void insertionSort(int[] arr) {
		int len = arr.length;

		for (int i = 1; i < len; i++) {
			int j = i - 1;
			int temp = arr[i];
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
