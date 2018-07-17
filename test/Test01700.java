import java.util.List;

public class Test01700 {
	public static void main(String[] args) {
		Solution01700 solution = new Solution01700();
		List<String> letterCombinations = solution.letterCombinations("23");
		for (String string : letterCombinations) {
			System.out.println(string);
		}
	}
}
