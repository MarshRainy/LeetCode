package pri.MarshR.leetcode;

public class Solution01000 {
	public boolean isMatch(String s, String p) {
		// System.out.println("比较:" + s + "|" + p);
		// 边界条件
		int b1 = 0;
		int b2 = 0;
		if (p == null || p.equals("")) {
			b1 = 1;
		}
		if (s == null || s.equals("")) {
			b2 = 1;
		}
		if (b1 + b2 == 2) {
			return true;
		} else if (b2 == 0 && b1 == 1) {
			return false;
		}
		if (s == null) {
			s = "";
		}
		// p一定不为空, 但s可能为空

		// 获取第一个匹配值
		char curChar = p.charAt(0);
		if (curChar == '*') {
			throw new IllegalArgumentException("解析错误");
		}
		boolean some = false;
		int start = 1;
		if (p.length() > 1 && p.charAt(1) == '*') {
			some = true;
			start = 2;
		}
		String nextP = p.substring(start);

		// 循环匹配
		if (some) {
			int i = 0;
			do {
				if (i > 0 && curChar != '.' && s.charAt(i - 1) != curChar) {
					break;
				}
				if (isMatch(s.substring(i), nextP)) {
					return true;
				}
				i++;
			} while (i <= s.length());
			return false;
		} else {
			if (s.length() > 0 && (curChar == '.' || s.charAt(0) == curChar)) {
				return isMatch(s.substring(1), nextP);
			} else {
				return false;
			}
		}
	}
}
