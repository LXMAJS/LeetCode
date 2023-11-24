package algorithms;

/**
 * 冒泡排序
 */
class BubbleSort extends AbstractDemoSort {

	@Override
	void sort(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		for (int index = 0; index < nums.length - 1; index++) {
			for (int jndex = 0; jndex < nums.length - 1 - index; jndex++) {
				if (nums[jndex] > nums[jndex + 1]) {
					swapArray(nums, jndex, jndex + 1);
				}
			}
		}
	}
}
