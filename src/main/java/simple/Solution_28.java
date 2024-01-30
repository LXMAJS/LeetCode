package simple;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class Solution_28 {

	public int strStr(String haystack, String needle) {
		int i = 0;
		int j = 0;
		for (; i < haystack.length(); ) {
			// 正在比对，则逐个进行比对即可
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
				if (j >= needle.length()) {
					return i - j + 1;
				}
			} else {
				// 比对失败，又要从当前位置开始向后比较
				j = 0;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		System.out.println(new Solution_28().strStr(haystack, needle));
	}
}
