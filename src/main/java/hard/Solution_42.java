package hard;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class Solution_42 {

	public static int trap(int[] height) {
		int sum = 0;
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			if (height[left] < height[right]) {
				// leftMax < rightMax
				sum += leftMax - height[left];
				left ++;
			} else {
				// leftMax >= rightMax
				sum += rightMax - height[right];
				right--;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
