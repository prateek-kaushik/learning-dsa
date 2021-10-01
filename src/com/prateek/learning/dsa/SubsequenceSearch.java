package com.prateek.learning.dsa;

public class SubsequenceSearch {

	public static void main(String[] args) {
		SubsequenceSearch obj = new SubsequenceSearch();

		String source = "Prateek";
		String target = "ee";

		try {
			System.out.println(String.format("Does %s contain %s?", source, target) + " "
					+ obj.isSubsequencePresent(source, target));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isSubsequencePresent(String source, String target) throws Exception {
		if (source == null || target == null) {
			throw new NullPointerException("Neither source or taret can be null");
		}

		int sourceLen = source.length();
		int targetLen = target.length();

		if (sourceLen == 0 || targetLen == 0) {
			throw new IllegalArgumentException("Neither source or taret can be empty");
		}

		char first = target.charAt(0);
		int end = sourceLen - targetLen;

		for (int i = 0; i <= end; i++) {
			if (first != source.charAt(i)) {
				while (++i <= end && first != source.charAt(i))
					;
			}
			if (i <= end) {
				int j = i + 1;
				int tEnd = i + targetLen;
				for (int k = 1; k < targetLen; k++) {
					if (source.charAt(j) == target.charAt(k)) {
						j++;
					} else {
						break;
					}
				}
				if (j == tEnd) {
					return true;
				}
			}
		}
		return false;
	}

}
