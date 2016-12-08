package p005;


public class Solution {
	public String longestPalindrome(String s) {
		if (s == null || s.equals("")) {
			throw new IllegalArgumentException("参数为空");
		}

//		System.out.println("原字符串:" + s);

		// 重构字符串
		char[] originCharArray = s.toCharArray();
		int originLen = originCharArray.length;
		int len = 2 * originLen + 2;
		char[] charArray = new char[len];
		charArray[0] = '$';
		charArray[1] = '#';
		int q = 2;
		for (char c : originCharArray) {
			charArray[q] = c;
			charArray[q + 1] = '#';
			q += 2;
		}

//		System.out.println("修理后的字符串:\n" + new String(charArray));

		int[] result = new int[len];

		// 处理数组数据
		result[0] = 0;
		int pi = 0;
		int mx = 0;

		for (int i = 1; i < len; i++) {
			if (i < mx) {
				result[i] = ((mx - i) > result[2 * pi - i]) ? result[2 * pi - i] : (mx - i);
			} else {
				result[i] = 1;
			}
			while (i + result[i] < len && i - result[i] > 0 &&
					charArray[i + result[i]] == charArray[i - result[i]]) {
				result[i]++;
			}
			if (i + result[i] > mx) {
				pi = i;
				mx = i + result[i];
			}
		}

		// debug
//		for (int i = 0; i < len; i++) {
//			System.out.println(charArray[i] + "    " + result[i]);
//		}

		int index = 0;
		int r = 0;
		for (int i = 1; i < len; i++) {
			if (result[i] > r) {
				r = result[i];
				index = i;
			}
		}

		char[] get = new char[r - 1];
		int tt = 0;
		for (int i = index - r + 1; i < index + r; i++) {
			if (charArray[i] != '#') {
				get[tt] = charArray[i];
				tt++;
			}
		}

		return new String(get);

	}
}
