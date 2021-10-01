package com.prateek.learning.dsa.sorting;

public class PerformanceCal {

	public static void main(String args[]) {
		int size = 50000;
		int[] sample = new int[size];
		resetArray(sample, size);

		long start = System.currentTimeMillis();
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(sample);
		long end = System.currentTimeMillis();
		System.out.println("Bubble sort took " + (end - start) + "ms");


		resetArray(sample, size);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		start = System.currentTimeMillis();
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.insertionSort(sample);
		end = System.currentTimeMillis();
		System.out.println("Insertion sort took " + (end - start) + "ms");


		resetArray(sample, size);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		start = System.currentTimeMillis();
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.selectionSort(sample);
		end = System.currentTimeMillis();
		System.out.println("Selection sort took " + (end - start) + "ms");


		resetArray(sample, size);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		start = System.currentTimeMillis();
		QuickSort quickSort = new QuickSort();
		quickSort.sort(sample, 0, sample.length - 1);
		end = System.currentTimeMillis();
		System.out.println("Quick sort took " + (end - start) + "ms");
	}
	
	private static void resetArray(int[] arr, int size) {
		int count = size;
		int i = 0;
		while (i < size) {
			arr[i] = count;
			i++;
			count--;
		}
	}

}
