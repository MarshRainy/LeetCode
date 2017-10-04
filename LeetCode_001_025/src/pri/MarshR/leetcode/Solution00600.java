package pri.MarshR.leetcode;

public class Solution00600 {
	public String convert(String s, int numRows) {
		if (s == null || s.length() <= 0 || numRows < 1) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}

		char[] origin = s.toCharArray();
		int len = origin.length;
		char[] result = new char[len];
		int index = 0;

		for (int i = 0; i < numRows; i++) {
			int start = i;
			boolean edeg = false;
			if (i == 0 || i == numRows - 1) {
				edeg = true;
			}
			int step = (numRows - 1 - i) * 2;
			if (edeg) {
				step = numRows * 2 - 2;
			}

			while (start < len) {
				result[index] = origin[start];
				index++;

				start += step;
				if (!edeg) {
					step = numRows * 2 - 2 - step;
				}
			}
		}

		return new String(result);
	}
}
