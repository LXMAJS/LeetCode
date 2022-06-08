package medium;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_34 {

	/**
	 * 找到目标值在数组中的第一个位置
	 * @param nums 数组
	 * @param target 目标元素
	 * @return 目标元素的第一个索引位置
	 */
	private static int firstIndexOf(int[] nums, int target) {
		return firstIndexOf(nums, target, 0, nums.length - 1);
	}

	/**
	 * 递归本体
	 * @param nums 数字
	 * @param target 目标元素
	 * @param left 左值
	 * @param right 右值
	 * @return 下标
	 */
	private static int firstIndexOf(int[] nums, int target, int left, int right) {
		// 如果仅剩2个或1个元素，那么判断一下
		if (right - left <= 1) {
			// 仅剩2个元素，分别判断一下
			if (nums[left] == target) {
				// 左值匹配，则返回左下标
				return left;
			} else if (nums[right] == target) {
				// 右值匹配，则返回右下标
				return right;
			} else {
				// 都不匹配，返回 -1
				return -1;
			}
		}
		// 元素的个数大于1，则进行一次二分
		int mid = (right - left) / 2 + left;
		return nums[mid] >= target ? firstIndexOf(nums, target, left, mid) : firstIndexOf(nums, target, mid, right);
	}

	/**
	 * 找到目标值在数组中的最后一个位置
	 * @param nums 数组
	 * @param target 目标元素
	 * @return 目标元素的第一个索引位置
	 */
	private static int lastIndexOf(int[] nums, int target) {
		return lastIndexOf(nums, target, 0, nums.length - 1);
	}

	/**
	 * 递归本体
	 * @param nums 数字
	 * @param target 目标元素
	 * @param left 左值
	 * @param right 右值
	 * @return 下标
	 */
	private static int lastIndexOf(int[] nums, int target, int left, int right) {
		// 如果仅剩2个或1个元素，那么判断一下
		if (right - left <= 1) {
			// 仅剩2个元素，分别判断一下
			if (nums[right] == target) {
				// 左值匹配，则返回左下标
				return right;
			} else if (nums[left] == target) {
				// 右值匹配，则返回右下标
				return left;
			} else {
				// 都不匹配，返回 -1
				return -1;
			}
		}
		// 元素的个数大于1，则进行一次二分
		int mid = (right - left) / 2 + left;
		return nums[mid] > target ? lastIndexOf(nums, target, left, mid) : lastIndexOf(nums, target, mid, right);
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[]{-1, -1};
		if (nums.length == 0) {
			return res;
		} else if (nums.length == 1) {
			if (nums[0] == target) {
				res = new int[] {0, 0};
			}
			return res;
		}
		res[0] = firstIndexOf(nums, target);
		res[1] = lastIndexOf(nums, target);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1};
		int target = 1;

		int[] res = searchRange(nums, target);
		System.out.println("[" + res[0] + "," + res[1] + "]");
	}
}
