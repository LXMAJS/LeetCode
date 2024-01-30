package hard;

/**
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 *
 *
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2：
 * 输入：s = "aa", p = "*"
 * 输出：true
 * 解释：'*' 可以匹配任意字符串。
 *
 * 示例 3：
 * 输入：s = "cb", p = "?a"
 * 输出：false
 * 解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 *
 * 提示：
 *
 * 0 <= s.length, p.length <= 2000
 * s 仅由小写英文字母组成
 * p 仅由小写英文字母、'?' 或 '*' 组成
 */
public class Solution_44 {

	public static boolean isMatch(String s, String p) {
		boolean inAny = false;
		char anyNext = ' ';
		int pIndex = 0, sIndex = 0;
		do {
			char pc = p.charAt(pIndex);
			if (inAny) {
				// 结束 *
				if (s.charAt(sIndex) == anyNext) {
					inAny = false;
					pIndex ++;
				}
				sIndex ++;
			} else {
				if ('*' == pc) {
					inAny = true;
					// 尝试找到除了*号外的下一个终止符号
					do {
						pIndex ++;
						if (pIndex >= p.length()) {
							return true;
						} else {
							anyNext = p.charAt(pIndex);
						}
					} while (anyNext == '*');
				} else if ('?' != pc && s.charAt(sIndex) != pc) {
					return false;
				} else {
					pIndex ++;
					sIndex ++;
				}
			}
		} while (pIndex < p.length() && sIndex < s.length());
		// 如果p和s任意一个没有遍历完，则返回false
		return pIndex >= p.length() && sIndex >= s.length();
	}

	public static void main(String[] args) {
		String s = "abcabczzzde";
		String p = "*abc???de*";
		System.out.println(isMatch(s, p));
	}
}
