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
public class Solution06800 {
	public List<String> fullJustify(String[] words, int maxWidth) {
		ArrayList<String> result = new ArrayList<>();
		int index = 0;
		while (index < words.length) {
			ArrayList<String> curList = getCurList(words, index, maxWidth);
			index += curList.size();
			boolean end = false;
			if (index == words.length)
				end = true;
			else
				end = false;
			String string = generateString(curList, maxWidth, end);
			result.add(string);
		}
		return result;
	}

	private ArrayList<String> getCurList(String[] words, int index, int maxWidth) {
		ArrayList<String> result = new ArrayList<>();
		int curIndex = index;
		int length = 0;
		while (curIndex < words.length && length + words[curIndex].length() <= maxWidth) {
			result.add(words[curIndex]);
			length += words[curIndex].length() + 1;
			curIndex++;
		}
		return result;
	}

	private String generateString(ArrayList<String> curList, int maxWidth, boolean end) {
		if (curList.size() == 1) {
			String string = curList.get(0);
			string = addSpace(curList.get(0), maxWidth - string.length());
			return string;
		} else if (end) {
			String result = "";
			for (String string : curList) {
				result = result + string + " ";
			}
			result = result.substring(0, result.length() - 1);
			result = addSpace(result, maxWidth - result.length());
			return result;
		} else {
			int curLength = 0;
			for (int i = 0; i < curList.size(); i++) {
				curLength += curList.get(i).length();
			}
			int minLength = (maxWidth - curLength) / (curList.size() - 1);
			int partIndex = (maxWidth - curLength) % (curList.size() - 1);
			String result = "";
			for (int i = 0; i < curList.size() - 1; i++) {
				result = result + curList.get(i);
				if (i < partIndex)
					result = addSpace(result, minLength + 1);
				else
					result = addSpace(result, minLength);
			}
			result = result + curList.get(curList.size() - 1);
			return result;
		}
	}

	private String addSpace(String in, int num) {
		for (int i = 0; i < num; i++) {
			in = in + " ";
		}
		return in;
	}

}
