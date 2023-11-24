package temp;

public class Preface {

	/**
	 * 验证字符串是否是回文
	 * @param s 字符串
	 * @return
	 */
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left ++;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right --;
			}
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}
			left ++;
			right --;
		}
		return true;
	}
}
