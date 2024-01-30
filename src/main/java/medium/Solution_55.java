package medium;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class Solution_55 {

	public static boolean canJump(int[] nums) {
		int maxReach = 0;
		// 遍历数组
		for (int i = 0; i < nums.length; i++) {
			if (maxReach < i) {
				// 如果当前遍历到的索引位置，已经超过了maxReach
				// 则表示后面的索引位置也肯定到不了，直接返回 false 即可
				return false;
			}
			// 这里计算下一个最远能到的位置
			// 如果当前位置可以跳跃的距离，能超过maxReach，则更新 maxReach 的值
			maxReach = maxReach > nums[i] + i ? maxReach : nums[i] + i;
			// 提前跳出循环
			if (maxReach > nums.length - 1) {
				return true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(canJump(nums));
	}

}
