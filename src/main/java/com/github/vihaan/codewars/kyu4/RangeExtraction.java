package com.github.vihaan.codewars.kyu4;

class RangeExtraction {
	public static String rangeExtraction(int[] arr) {
		int consecutiveNumbers = 0;
		int lastConsecutive = arr[0];
		StringBuilder result = new StringBuilder(String.valueOf(arr[0]));
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] + 1 == arr[i] && (arr[i] != 0 && arr[i - 1] != 0)) {
				lastConsecutive = arr[i];
				consecutiveNumbers += 1;
			} else {
				if (consecutiveNumbers == 0) {
					result.append(",");
				}
				if (consecutiveNumbers > 0) {
					result//.append(lastConsecutive - consecutiveNumbers)
							.append("-")
							.append(lastConsecutive)
							.append(",");
					consecutiveNumbers = 0;
					lastConsecutive = 0;
				} else {
					result.append(arr[i]);
				}
			}
		}
		return result.toString();
    }
}