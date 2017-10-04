package pri.MarshR.leetcode;

import p015.Solution01500;

import java.util.List;

public class Test01500 {
	public static void main(String[] args) {
		Solution01500 solution = new Solution01500();
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
