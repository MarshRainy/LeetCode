public class Solution01100 {
	public int maxArea(int[] height) {
		if (height.length < 2) {
			return 0;
		}

		int i = 0;
		int j = height.length - 1;
		int maxSize = 0;
		while (j > i) {
			int size = min(height[i], height[j]) * (j - i);
			if (size > maxSize) {
				maxSize = size;
			}
			if (height[i] > height[j]) {
				j--;
			} else {
				i++;
			}
		}

		return maxSize;
	}

	private int min(int i1, int i2) {
		return (i1 > i2) ? i2 : i1;
	}
}
