public class Solution01200 {
	public String intToRoman(int num) {
		String[] s1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String[] s2 = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] s3 = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] s4 = {"M", "MM", "MMM"};

		String[][] ss = new String[4][];

		ss[0] = s4;
		ss[1] = s3;
		ss[2] = s2;
		ss[3] = s1;

		String result = "";
		int i = 3;
		while (num != 0) {
			int index = num % 10;
			num = num / 10;
			i--;
			if (index == 0) {
				continue;
			}
			result = ss[i + 1][index - 1] + result;
		}

		return result;
	}
}
