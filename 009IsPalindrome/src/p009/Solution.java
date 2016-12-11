package p009;

public class Solution {
	public boolean isPalindrome(int x) {
		try {
			if (x < 0) {
				return false;
			}

			int y = 0;
			int xx = x;
			while (xx != 0) {
				y = y * 10 + xx % 10;
				xx = xx / 10;
			}
			return x == y;
		} catch (Exception e) {
			return false;
		}
	}
}
