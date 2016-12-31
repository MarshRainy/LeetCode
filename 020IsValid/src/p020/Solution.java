package p020;

import java.util.Stack;

/**
 * 描述:
 * <p>
 *     问题:
 *     匹配三种括号, 分别是
 * </p>
 *
 * @author MarshR
 */
public class Solution {
	public boolean isValid(String s) {
		char[] charset = new char[128];
		charset[')'] = '(';
		charset[']'] = '[';
		charset['}'] = '{';
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case '(':
				case '{':
				case '[':
					stack.push(c);
					break;

				case ')':
				case '}':
				case ']':
					if (stack.empty() || stack.peek() != charset[c]) {
						return false;
					}
					stack.pop();
					break;

				default:
					break;
			}
		}

		if (stack.empty()) {
			return true;
		} else {
			return false;
		}
	}
}
