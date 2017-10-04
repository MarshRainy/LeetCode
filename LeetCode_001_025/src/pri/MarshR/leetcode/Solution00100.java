package pri.MarshR.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 解题思路:
 * 1. 按顺序排序; O(nlogn)
 * 2. 两边向中间靠拢, 直到相加与给定值相等; O(n)
 */
public class Solution00100 {

	public int[] twoSum(final int[] nums, int target) {
		final List<Integer> position = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			position.add(i);
		}

		Collections.sort(position, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return nums[o1] - nums[o2];
			}
		});

		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			int sum = nums[position.get(i)] + nums[position.get(j)];
			if (sum > target) {
				j--;
			} else if (sum < target) {
				i++;
			} else {
				int pos1 = Math.min(position.get(i), position.get(j));
				int pos2 = Math.max(position.get(i), position.get(j));
				return new int[]{pos1, pos2};
			}
		}
		return null;
	}

}
