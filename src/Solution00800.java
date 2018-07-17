public class Solution00800 {
	public int myAtoi(String str) {
		if (str == null) {
			throw new IllegalArgumentException("参数错误");
		}
		String next = str.trim();
		if (next.length() <= 0) {
			return 0;
		}

		char[] charArray = next.toCharArray();

		int start = 0;
		int end = charArray.length;
		if (charArray[0] == '+' || charArray[0] == '-') {
			start = 1;
		}

		for (int i = start; i < charArray.length; i++) {
			if (charArray[i] < '0' || charArray[i] > '9') {
				end = i;
				break;
			}
		}

		if (start >= end) {
			return 0;
		}

		String number = next.substring(start, end);

		if ((start == 0 || charArray[0] == '+') && (number.length() > 10 || (number.length() == 10 && number.compareTo("2147483647") > 0))) {
			return Integer.MAX_VALUE;
		}
		if ((start == 1 && charArray[0] == '-') && (number.length() > 10 || (number.length() == 10 && number.compareTo("2147483648") > 0))) {
			return Integer.MIN_VALUE;
		}

		if (start == 1 && charArray[0] == '-') {
			number = '-' + number;
		}

		return Integer.parseInt(number);
	}
}
