package algorithms;


import java.util.Arrays;

class MergeSort extends AbstractDemoSort {
	/**
	 * 归并排序，asc
	 * @param nums 待排序数组
	 */
	@Override
	void sort(int[] nums) {
		// 对 [0, n) 范围内的数组元素进行排序
		if (nums.length <= 1) {
			return;
		}
		// 将待排序的区间划分为2个，以mid中间值作为划分点
		int mid = nums.length / 2;
		int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
		int[] rightArr = Arrays.copyOfRange(nums, mid, nums.length);
		// 分别对两边进行排序
		sort(leftArr);
		sort(rightArr);
		// 将两个数组进行合并
		merge(nums, leftArr, rightArr);
	}

	private void merge(int[] nums, int[] leftArr, int[] rightArr) {
		int index = 0, leftIndex = 0, rightIndex = 0;
		while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
			// 对比大小，将小的那个赋值给nums
			if (leftArr[leftIndex] < rightArr[rightIndex]) {
				nums[index++] = leftArr[leftIndex++];
			} else {
				nums[index++] = rightArr[rightIndex++];
			}
		}
		// 处理剩余元素
		while (leftIndex < leftArr.length) {
			nums[index++] = leftArr[leftIndex++];
		}
		while (rightIndex < rightArr.length) {
			nums[index++] = rightArr[rightIndex++];
		}
	}

	/**
	 * 求数组中逆序对的个数
	 * @param nums 数组
	 * @return 逆序对的个数
	 */
	private int countInversions(int[] nums) {
		// 对 [0, n) 范围内的数组元素进行排序
		if (nums.length <= 1) {
			return 0;
		}
		// 创建一个临时数组用来存储归并过程中查找到的逆序对的个数
		int[] count = new int[1];
		// 开始归并
		mergeSort(nums, count);
		// 返回逆序对的个数
		return count[0];
	}

	/**
	 * 归并排序
	 * @param nums 待排序的数组
	 * @param count 临时存储逆序对个数的数组
	 */
	private void mergeSort(int[] nums, int[] count) {
		// 对 [0, n) 范围内的数组元素进行排序
		if (nums.length <= 1) {
			return;
		}
		// 将待排序的区间划分为2个，以mid中间值作为划分点
		int mid = nums.length / 2;
		int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
		int[] rightArr = Arrays.copyOfRange(nums, mid, nums.length);
		// 分别对两边进行排序
		mergeSort(leftArr, count);
		mergeSort(rightArr, count);
		// 将两个数组进行合并
		merge(nums, leftArr, rightArr, count);
	}

	/**
	 * 归并过程
	 * @param nums 数组
	 * @param leftArr 左数组
	 * @param rightArr 右数组
	 * @param count 临时存储逆序对个数的数组
	 */
	private void merge(int[] nums, int[] leftArr, int[] rightArr, int[] count) {
		int index = 0, leftIndex = 0, rightIndex = 0;
		while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
			// 对比大小，将小的那个赋值给nums
			if (leftArr[leftIndex] < rightArr[rightIndex]) {
				nums[index++] = leftArr[leftIndex++];
			} else {
				nums[index++] = rightArr[rightIndex++];
				// 【关键步骤】
				// 左边比右边大，说明左边未遍历的数组的元素，都比右边的大
				// 那么可以把计数器直接增加对应数量
				count[0] += leftArr.length - leftIndex;
			}
		}
		// 处理剩余元素
		while (leftIndex < leftArr.length) {
			nums[index++] = leftArr[leftIndex++];
		}
		while (rightIndex < rightArr.length) {
			nums[index++] = rightArr[rightIndex++];
		}
	}
}
