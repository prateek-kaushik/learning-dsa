package com.prateek.learning.dsa.sorting;

public class SelectionSort {
	public static void main(String args[]) {
		int[] arr = { 6, 5, 4, 3, 2, 1, -1, -2 };
		SelectionSort sort = new SelectionSort();
		sort.selectionSort(arr);

		for (int k = 0; k < arr.length; k++) {
			System.out.print(" " + arr[k]);
		}
	}

	public void selectionSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int temp = arr[i];
			int index = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			if (index != i) {
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}
}
