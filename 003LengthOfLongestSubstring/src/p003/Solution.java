package p003;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}

		char[] charArray = s.toCharArray();

		// 保存在列的字符集, 初始为第一个字符
		Set<Character> set = new HashSet<Character>();
		set.add(charArray[0]);

		// 历史最大的字符数
		int ans = 1;

		// i:遍历中的开始位置(包含); j:遍历中的结束位置(不包含)
		int i = 0;
		int j = 1;

		while (j < charArray.length) {
			char temp = charArray[j];

			// 清除字符集中与当前字符冲突的字符
			if (set.contains(temp)) {
				for (int index = i; i < j; index++) {
					set.remove(charArray[index]);
					if (charArray[index] == temp) {
						i = index + 1;
						break;
					}
				}
			}

			// 添加当前值
			set.add(temp);
			j++;

			// 更新结果
			if (j - i > ans) {
				ans = j - i;
			}
		}

		return ans;

	}
}
