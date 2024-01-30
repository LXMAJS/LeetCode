package medium;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class Solution_45 {

	/**
	 * 临时数组暴力解法
	 * @param nums
	 * @return
	 */
	public static int jump1(int[] nums) {
		int[] jumpCount = new int[nums.length];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 1; j <= nums[i] && i + j <= nums.length - 1; j++) {
				if (jumpCount[i + j] <= 0) {
					jumpCount[i + j] = jumpCount[i] + 1;
				} else {
					jumpCount[i + j] = Math.min(jumpCount[i + j], jumpCount[i] + 1);
				}
			}
		}
		return jumpCount[nums.length - 1];
	}

	/**
	 * 贪心
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int jumpCount = 0;
		int currentMaxIndex = 0;
		int maxJumpDistance = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxJumpDistance = Math.max(maxJumpDistance, nums[i] + i);
			if (i == currentMaxIndex) {
				jumpCount ++;
				currentMaxIndex = maxJumpDistance;
			}
			if(currentMaxIndex > nums.length-1){
				return jumpCount;
			}
		}
		return jumpCount;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,1};
		System.out.println(jump(nums));
	}

}
