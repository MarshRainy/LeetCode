/****************************************
 * No Copyright.
 * CreateTime: 2018/7/17
 * Author: MarshR
 ****************************************/

import java.util.List;
/**
 * <p>描述</p>
 *
 * @auth MarshR
 */
public class Test06800 {
	public static void main(String[] args) {
		// String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		// int maxWidth = 16;
		// String[] words = {"What","must","be","acknowledgment","shall","be"};
		// int maxWidth = 16;
		String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
				"to","a","computer.","Art","is","everything","else","we","do"};
		int maxWidth = 20;
		List<String> strings = new Solution06800().fullJustify(words, maxWidth);
		for (String string : strings) {
			System.out.println("\"" + string + "\"");
		}
	}
}
