package pri.MarshR.leetcode;

public class Solution01400 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}

		String result = "";
		int length = Integer.MAX_VALUE;
		for (String string : strs) {
			if (string.length() < length) {
				length = string.length();
			}
		}

		for (int i = 0; i < length; i++) {
			char c = strs[0].charAt(i);
			boolean tt = false;
			for (String string : strs) {
				if (string.charAt(i) != c) {
					tt = true;
					break;
				}
			}
			if (!tt) {
				result += c;
			} else {
				break;
			}
		}

		return result;
	}
}
