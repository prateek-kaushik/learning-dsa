package com.prateek.learning.dsa;

public class GetFactorial {

	public static void main(String args[]) {
		System.out.println(new GetFactorial().factorialRecursively(5));
		System.out.println(new GetFactorial().factorialLooply(5));
	}

	public int factorialRecursively(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorialRecursively(n - 1);
	}

	public int factorialLooply(int n) {
		int result = 1;
		while (n > 0) {
			result = result * n--;
		}
		return result;
	}
}