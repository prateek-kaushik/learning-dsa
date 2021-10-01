package com.prateek.learning.dsa.sorting;

public class QuickSort {
	public static void main(String args[]) {
		int[] arr = { 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public void sort(int[] arr, int left, int right) {

		if (left >= right) {
			return;
		}

		int pi = partition(arr, left, right);

		sort(arr, left, pi - 1);

		sort(arr, pi + 1, right);
	}

	public int partition(int[] arr, int left, int right) {
		int pivot = arr[right];

		int i = left - 1;

		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[right];
		arr[right] = temp;

		return i;
	}
}
