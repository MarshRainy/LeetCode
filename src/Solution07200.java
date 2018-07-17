/****************************************
 * No Copyright.
 * CreateTime: 2018/7/17
 * Author: MarshR
 ****************************************/

/**
 * <p>描述</p>
 *
 * @auth MarshR
 */
public class Solution07200 {
	public int minDistance(String word1, String word2) {
		// 初始化数据树
		int[][] dataMap = init(word1.length(), word2.length());

		// 循环获取值
		processing(dataMap, word1, word2);

		// 返回值
		return dataMap[word1.length()][word2.length()];
	}

	private int[][] init(int aLength, int bLength) {
		int[][] dataMap = new int[aLength + 1][bLength + 1];
		for (int i = 0; i <= aLength; i++)
			dataMap[i][0] = i;
		for (int i = 0; i <= bLength; i++)
			dataMap[0][i] = i;
		return dataMap;
	}

	private void processing(int[][] dataMap, String word1, String word2) {
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int value1 = min(dataMap[i][j - 1], dataMap[i - 1][j]) + 1;
				int value2 = dataMap[i - 1][j - 1] + ((word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1);
				dataMap[i][j] = min(value1, value2);
			}
		}
	}

	private int min(int a, int b) {
		return (a < b) ? a : b;
	}
}
