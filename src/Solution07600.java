/****************************************
 * No Copyright.
 * CreateTime: 2018/7/17
 * Author: MarshR
 ****************************************/

import java.util.*;
/**
 * <p>描述</p>
 *
 * @auth MarshR
 */
public class Solution07600 {
	public String minWindow(String s, String t) {
		// 初始化数据
		String result = "";
		HashMap<Character, List<Integer>> indexMap = new HashMap<>();
		HashMap<Character, Integer> countMap = new HashMap<>();
		TreeSet<Integer> indexSeq = new TreeSet<>();
		int allCount = t.length();
		for (char c : t.toCharArray()) {
			if (countMap.containsKey(c)) {
				countMap.put(c, countMap.get(c) + 1);
			} else {
				countMap.put(c, 1);
				indexMap.put(c, new ArrayList<>());
			}
		}

		// 找配对
		int index = 0;
		for (; index < s.length(); index++) {
			char curc = s.charAt(index);
			if (!countMap.containsKey(curc))
				continue;
			// System.out.println("index:" + index + "; char:" + curc + ";");
			List<Integer> indexs = indexMap.get(curc);
			indexs.add(index);
			indexSeq.add(index);
			if (indexs.size() > countMap.get(curc)) {
				int lastIndex = indexs.get(indexs.size() - countMap.get(curc) - 1);
				indexSeq.remove(lastIndex);
				// System.out.println("删除Index:" + lastIndex);
			} else {
				allCount--;
			}
			if (allCount == 0) {
				int minIndex = indexSeq.first();
				int maxIndex = indexSeq.last();
				if (result.length() <= 0 || maxIndex - minIndex + 1 < result.length()) {
					result = s.substring(minIndex, maxIndex + 1);
					// System.out.println("更新了result:" + result);
				}
			}
		}

		return result;
	}
}
