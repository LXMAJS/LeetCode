package simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *  
 *
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为 无重复元素 的 升序 排列数组
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_35 {
	/**
	 * 搜索插入的位置
	 * @param nums 数组
	 * @param target 目标值
	 * @return 下标
	 */
	public static int searchInsert(int[] nums, int target) {
		if (nums.length <= 0 ) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0] > target ? 0 : 1;
		}
		return searchInsert(nums, target, 0, nums.length - 1);
	}

	/**
	 * 搜索插入的位置，递归本体
	 * @param nums 数组
	 * @param target 目标值
	 * @param left 左下表
	 * @param right 右下标
	 * @return
	 */
	public static int searchInsert(int[] nums, int target, int left, int right) {
		// 有且仅有2个元素，需要判断target应该在哪个位置上
		if (right - left == 1) {
			if (nums[left] >= target) {
				return left;
			} else if (nums[right] >= target) {
				return right;
			} else {
				return right + 1;
			}
		}
		// 都不在，那么计算一个中间值
		int mid = (right - left) / 2 + left;
		if (nums[mid] == target) {
			return mid;
		}
		return nums[mid] > target ? searchInsert(nums, target, left, mid) : searchInsert(nums, target, mid, right);
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3};
		int target = 1;
		System.out.println(searchInsert(nums, target));
	}
}
