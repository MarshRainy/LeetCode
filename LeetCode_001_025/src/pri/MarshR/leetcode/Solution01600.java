package pri.MarshR.leetcode;

import java.util.Arrays;

public class Solution01600 {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			throw new IllegalArgumentException("参数错误");
		}

		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);

		int i = -1;
		int num = 0;
		while (i + 1 < nums.length - 2) {
			i++;
			if (i != 0 && num == nums[i]) {
				continue;
			}
			num = nums[i];
			int curDiff = anoFind(target - num, nums, i + 1, nums.length - 1);
			diff = absMin(diff, curDiff);
			if (diff == 0) return target;
		}

		return target + diff;
	}

	private int anoFind(int target, int[] nums, int begin, int end) {
		int originBegin = begin;
		int originEnd = end;

		int result = Integer.MAX_VALUE;

		while (begin < end) {
			int diff = nums[begin] + nums[end] - target;
			if (diff > 0) {
				end--;
			} else if (diff < 0) {
				begin++;
			} else {
				return 0;
			}
			while (begin > originBegin && begin + 1 <= originEnd && nums[begin] == nums[begin - 1]) {
				begin++;
			}
			while (end < originEnd && end - 1 >= originBegin && nums[end] == nums[end + 1]) {
				end--;
			}

			result = absMin(result, diff);
		}

		return result;
	}

	private int absMin(int i, int j) {
		int ii = i;
		int jj = j;
		if (i < 0) {
			ii = -i;
		}
		if (jj < 0) {
			jj = -j;
		}
		if (ii > jj) {
			return j;
		} else {
			return i;
		}
	}
}
