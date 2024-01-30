package medium;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_3 {

	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> indexes = new HashMap<>();
		char[] chars = s.toCharArray();
		int maxLength = 0;
		int windowSize = 0;
		int lastIndex = 0;
		for (int i = 0; i < chars.length; i++) {
			if (indexes.containsKey(chars[i])) {
				// 如果hashmap中有这个字符，
				// 则将这个字符对应的上一个索引位置找出来，
				// 计算i和索引之间的距离，即当前的最长串，
				// 如果 maxLength 比最长串小，则更新 maxLength
				lastIndex = Math.max(lastIndex, indexes.get(chars[i]));
				maxLength = Math.max(maxLength, windowSize);
				windowSize = i - lastIndex;
				indexes.put(chars[i], i);
			} else {
				indexes.put(chars[i], i);
				windowSize++;
			}
		}
		return Math.max(maxLength, windowSize);
	}

	public static void main(String[] args) {
		String s = "abba";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
