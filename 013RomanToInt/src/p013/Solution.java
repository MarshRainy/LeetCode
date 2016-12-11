package p013;

public class Solution {
	public int romanToInt(String s) {
		char[] charArray = s.toCharArray();

		int result = 0;

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			char d = '\0';
			boolean hasNext = false;
			if (i < charArray.length - 1) {
				hasNext = true;
				d = charArray[i + 1];
			}

			switch (c) {
				case 'M':
					result += 1000;
					break;
				case 'D':
					result += 500;
					break;
				case 'C':
					if (hasNext && (d == 'D' || d == 'M')) {
						result -= 100;
					} else {
						result += 100;
					}
					break;
				case 'L':
					result += 50;
					break;
				case 'X':
					if (hasNext && (d == 'L' || d == 'C')) {
						result -= 10;
					} else {
						result += 10;
					}
					break;
				case 'V':
					result += 5;
					break;
				case 'I':
					if (hasNext && (d == 'X' || d == 'V')) {
						result -= 1;
					} else {
						result += 1;
					}
					break;
			}
		}

		return result;
	}
}
