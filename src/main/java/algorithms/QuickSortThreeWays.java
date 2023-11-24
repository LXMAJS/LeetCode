package algorithms;

import java.util.Random;

public class QuickSortThreeWays extends AbstractDemoSort {
	/**
	 * 快速排序，asc
	 *
	 * @param nums 数组
	 */
	@Override
	public void sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	/**
	 * 对 nums[left, right] 区间内的元素进行快速排序
	 *
	 * @param nums  数组
	 * @param left  左下标
	 * @param right 右下标
	 */
	private void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		// partition
		// 随机交换一个坐标的值到最左端
		Random random = new Random();
		int randomIndex = random.nextInt(right - left) + left;
		swapArray(nums, left, randomIndex);
		// 选一个标定元素
		int temp = nums[left];
		// 初始化游标
		int lt = left;
		int gt = right + 1;
		int i = left + 1;
		// nums[left + 1, lt] < temp, nums[lt + 1, i) = temp, nums[gt, right] > temp
		while (i < gt) {
			if (nums[i] < temp) {
				swapArray(nums, lt + 1, i);
				lt++;
				i++;
			} else if (nums[i] > temp) {
				swapArray(nums, gt - 1, i);
				gt--;
			} else {
				i++;
			}
		}
		swapArray(nums, left, lt);
		// 递归
		quickSort(nums, left, lt - 1);
		quickSort(nums, gt, right);
	}
}
