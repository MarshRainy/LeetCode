package p004;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int minInt = Integer.MIN_VALUE;
		int maxInt = Integer.MAX_VALUE;

		int length1 = nums1.length;
		int length2 = nums2.length;

		boolean flag = true; // 如果相加为偶数, 为true, 如果相加为奇数, 为false
		if ((length1 + length2) % 2 == 1) {
			flag = false;
		}

		// 中心线左小右大

		int[] array1 = null;// 短
		int[] array2 = null;// 长
		if (length1 > length2) {
			array1 = nums2;
			array2 = nums1;
		} else {
			array1 = nums1;
			array2 = nums2;
		}
		int array1L = array1.length;
		int array2L = array2.length;

		int index1 = 0;
		int index2 = (array1L + array2L) / 2;

		int offset = array1L;

		while (true) {
			// 重置偏移量
			if (offset != 1) {
				offset = offset / 2;
			}

			// index附近4个数 是否符合规则
			int num1L = minInt;
			if (index1 > 0) {
				num1L = array1[index1 - 1];
			}
			int num2L = minInt;
			if (index2 > 0) {
				num2L = array2[index2 - 1];
			}
			int num1R = maxInt;
			if (index1 < array1L) {
				num1R = array1[index1];
			}
			int num2R = maxInt;
			if (index2 < array2L) {
				num2R = array2[index2];
			}

			if (num1L <= num2R && num2L <= num1R) {
				break;
			}

			if (num1L > num2R) {
				index1 -= offset;
				index2 += offset;
				continue;
			}

			if (num2L > num1R) {
				index1 += offset;
				index2 -= offset;
				continue;
			}
		}

		int num1L = minInt;
		if (index1 > 0) {
			num1L = array1[index1 - 1];
		}
		int num2L = minInt;
		if (index2 > 0) {
			num2L = array2[index2 - 1];
		}
		int num1R = maxInt;
		if (index1 < array1L) {
			num1R = array1[index1];
		}
		int num2R = maxInt;
		if (index2 < array2L) {
			num2R = array2[index2];
		}

		int maxL = (num1L > num2L) ? num1L : num2L;

		int minR = (num1R > num2R) ? num2R : num1R;

		if (flag) {
			return (maxL + minR) / 2.0;
		} else {
			return minR;
		}

	}

}
