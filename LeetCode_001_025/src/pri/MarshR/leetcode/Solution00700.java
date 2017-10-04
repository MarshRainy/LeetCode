package pri.MarshR.leetcode;

public class Solution00700 {
	public int reverse(int x) {
		boolean right = true;
		if (x < 0) {
			right = false;
			x = -x;
		}

		String string = Integer.toString(x);
		if (!right) {
			string = string + '-';
		}

		StringBuffer stringBuffer = new StringBuffer(string);
		stringBuffer.reverse();

		try {
			return Integer.parseInt(stringBuffer.toString());
		} catch (NumberFormatException e) {
			return 0;
		}

	}
}
