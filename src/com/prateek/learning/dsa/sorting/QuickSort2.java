package com.prateek.learning.dsa.sorting;

public class QuickSort2 {

	public static void main(String args[]) {
		int a[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		QuickSort2 sort = new QuickSort2();
		sort.quickSort(a, 0, a.length - 1);

		System.out.println("quicksort result");
		for (int c : a) {
			System.out.print(c + " ");
		}
	}

	public void quickSort(int[] a, int start, int end) {
		if (start < end) {
			int partition = partition(a, start, end);
			quickSort(a, start, partition - 1);
			quickSort(a, partition + 1, end);
		}
	}

	private int partition(int[] a, int start, int end) {
		int pivot = a[start];
		int i = start;

		for (int j = start; j <= end; j++) {
			if (a[j] <= pivot) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		i--;
		int temp = a[start];
		a[start] = a[i];
		a[i] = temp;
		return i;
	}
}
