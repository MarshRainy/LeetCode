import p017.Solution;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> letterCombinations = solution.letterCombinations("23");
		for (String string : letterCombinations) {
			System.out.println(string);
		}
	}
}
