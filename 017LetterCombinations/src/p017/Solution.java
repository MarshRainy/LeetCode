package p017;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		result.add("");
		if (digits == null || digits.length() == 0) {
			return new ArrayList<String>();
		}

		String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		for (int i = 0; i < digits.length(); i++) {
			char c = digits.charAt(i);
			int n = c - '0';
			List<String> value = new ArrayList<String>();
			for (String string : result) {
				for (int j = 0; j < strings[n].length(); j++) {
					char cc = strings[n].charAt(j);
					value.add(string + cc);
				}
			}
			result = value;
		}

		return result;
	}
}
