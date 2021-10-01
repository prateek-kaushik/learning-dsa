package com.prateek.learning.dsa;

import java.util.Arrays;
import java.util.List;

public class Rough {

	public static void main(String args[]) {
		List<Integer> a = Arrays.asList(9, 5, 8);

		int total = 0;

		for (int i = 0; i < a.size(); i++) {
			a.subList(0, i + 1).sort((o1, o2) -> o1 - o2);
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += (a.get(j) * (j + 1));
			}
			total += sum;
		}
		System.out.println(total);
	}
}
