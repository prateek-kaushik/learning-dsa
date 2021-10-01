package com.prateek.learning.dsa.sorting;

public class MergeSort {
	public static void main(String args[]) {
		int[] a = { 6, 5, 7, 4, 3, 2, 8, 1 };

		MergeSort ms = new MergeSort();
		ms.mergeSort(a, 0, a.length - 1);

		for (int c : a) {
			System.out.print(c + " ");
		}
	}

	public void mergeSort(int[] a, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(a, l, mid);
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	private void merge(int[] a, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = l;
		int[] b = new int[r + 1];

		while (i <= mid && j <= r) {
			if (a[i] < a[j]) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}

		if (i > mid) {
			while (j <= r) {
				b[k] = a[j];
				j++;
				k++;
			}
		} else {
			while (i <= mid) {
				b[k] = a[i];
				i++;
				k++;
			}
		}

		for (k = l; k <= r; k++) {
			a[k] = b[k];
		}
	}
}
