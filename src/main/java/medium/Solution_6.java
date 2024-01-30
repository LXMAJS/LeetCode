package medium;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Solution_6 {

	public String convert(String s, int numRows) {
		if (numRows < 2) {
			return s;
		}
		StringBuilder[] data = new StringBuilder[numRows];
		// 初始化
		for (int i = 0; i < data.length; i++) {
			data[i] = new StringBuilder();
		}
		int rows = 0, z = -1;
		char[] sc = s.toCharArray();
		for (char c : sc) {
			data[rows].append(c);
			if (rows == 0 || rows == numRows - 1) {
				// 调转方向
				z = -z;
			}
			rows += z;
		}
		// 打印最终字符串
		StringBuilder sb = new StringBuilder();
		for (StringBuilder datum : data) {
			sb.append(datum);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(new Solution_6().convert(s, 4));
	}
}
