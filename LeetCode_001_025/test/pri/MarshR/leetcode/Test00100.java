package pri.MarshR.leetcode;

public class Test00100 {
	public static void main(String[] args) {
		Solution00100 solution00100 = new Solution00100();
		int[] nums = new int[]{2, 7, 1, 34};
		int[] result = solution00100.twoSum(nums, 9);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
