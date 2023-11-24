package algorithms;

/**
 * 自定义整数排序算法
 */
abstract class AbstractDemoSort {

	abstract void sort(int[] nums);

	/**
	 * 交换数组中对应位置的值
	 *
	 * @param nums 数组
	 * @param x    坐标x
	 * @param y    坐标y
	 */
	void swapArray(int[] nums, int x, int y) {
		if (nums[x] == nums[y]) {
			return;
		}
		int xVal = nums[x];
		nums[x] = nums[y];
		nums[y] = xVal;
	}
}
