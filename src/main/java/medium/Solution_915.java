package medium;

/**
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 *
 * 用例可以保证存在这样的划分方法。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 *
 * 示例 2：
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 */
public class Solution_915 {

	/**
	 * 分割
	 * @param nums
	 * @return
	 */
	public static int partitionDisjoint(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return -1;
		}
		int leftMax = nums[0];
		int minIndex = 0;
		for (int index = 1; index < nums.length; index++) {

		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(partitionDisjoint(null));
	}

}
