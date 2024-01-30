package simple;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Solution_14 {

	public String longestCommonPrefix(String[] strs) {
		int minLength = Integer.MAX_VALUE;
		// 先找到最短的字符串
		for (String str : strs) {
			if (str.length() < minLength) {
				minLength = str.length();
			}
		}
		// 使用二分法，从 [0, minLength - 1] 的 mid 开始，
		// 比对所有字符串中 [0, mid] 是否相等，如果相等，表示最长公共前缀在 [mid + 1, minLength - 1] 之间，然后继续使用二分法
		int left = 0, right = minLength;
		while (left < right) {
			// 取中间值
			int mid = (right + 1 - left) / 2 + left;
			if (allStartWith(strs, mid)) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return strs[0].substring(0, left);
	}

	public boolean allStartWith(String[] strs, int mid) {
		char[] prefix = strs[0].toCharArray();
		// 逐个循环比对所有的字符串第n位与prefix是否相等
		for (int i = 0; i < mid; i++) {
			for (String str : strs) {
				char p = prefix[i];
				char s = str.charAt(i);
				if (p != s) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] strs = new String[] {"flower","flow","flight"};
		System.out.println(new Solution_14().longestCommonPrefix(strs));
	}
}
