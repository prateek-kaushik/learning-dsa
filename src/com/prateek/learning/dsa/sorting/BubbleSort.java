package com.prateek.learning.dsa.sorting;

public class BubbleSort {

	public static void main(String args[]) {
		int[] arr = { -2, -3, -5, 6, 4, 2 };
		BubbleSort obj = new BubbleSort();
		obj.bubbleSort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	public void bubbleSort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
