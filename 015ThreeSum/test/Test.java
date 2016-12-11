import p015.Solution;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> threeSum = solution.threeSum(nums);
		if (threeSum == null || threeSum.size() <= 0) {
			System.out.println("null");
		} else {
			for (List<Integer> list : threeSum) {
				String string = "";
				for (Integer integer : list) {
					string += integer + "  ";
				}
				System.out.println(string);
			}
		}
	}
}
