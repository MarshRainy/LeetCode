package pri.MarshR.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution01500 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);

//		for (int i : nums) {
//			System.out.println(i);
//		}

		int i = -1;
		int num = 0;
		while (i + 1 < nums.length - 2) {
			i++;
			if (i != 0 && num == nums[i]) {
				continue;
			}
			num = nums[i];
			find(num, nums, i + 1, nums.length - 1, result);
		}

		return result;
	}

	private void find(int num, int[] nums, int begin, int end, List<List<Integer>> result) {
//		System.out.println("find[" + begin + "][" + end + "]");

		int originBegin = begin;
		int originEnd = end;

		while (begin < end) {
			int sum = num + nums[begin] + nums[end];
			if (sum > 0) {
				end--;
			} else if (sum < 0) {
				begin++;
			} else {
				List<Integer> value = new ArrayList<Integer>();
				value.add(num);
				value.add(nums[begin]);
				value.add(nums[end]);
				result.add(value);
				begin++;
				end--;
			}
			while (begin > originBegin && begin + 1 <= originEnd && nums[begin] == nums[begin - 1]) {
				begin++;
			}
			while (end < originEnd && end - 1 >= originBegin && nums[end] == nums[end + 1]) {
				end--;
			}
		}
	}
}
