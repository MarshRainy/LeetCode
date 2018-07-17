import java.util.*;

/**
 * CreateDate: 2017/01/01</br>
 * Author: MarshR</br>
 * <p>
 * 描述:
 * 生成所有的匹配.
 * 例如: n=3
 * 输出:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * </p>
 */
public class Solution02200 {
	public List<String> generateParenthesis(int n) {
		if (n <= 0) {
			return new ArrayList<String>();
		}

		List<String> result = generate(n, n);
		return result;

	}

	private List<String> generate(int begin, int end) {
		if (begin <= 0 && end <= 0) {
			List<String> result = new ArrayList<String>();
			result.add("");
			return result;
		}

		List<String> result = new ArrayList<String>();
		if (begin > 0) {
			List<String> generate = generate(begin - 1, end);
			for (String string : generate) {
				result.add("(" + string);
			}
		}
		if (end > begin) {
			List<String> generate = generate(begin, end - 1);
			for (String string : generate) {
				result.add(")" + string);
			}
		}
		return result;
	}
}
