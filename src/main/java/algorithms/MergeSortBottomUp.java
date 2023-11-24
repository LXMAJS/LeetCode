package algorithms;


class MergeSortBottomUp extends AbstractDemoSort {
/**
 * 自底向上的归并排序，asc
 * @param nums 待排序数组
 */
@Override
void sort(int[] nums) {
	for (int size = 1; size < nums.length; size *= 2) {
		for (int index = 0; index < nums.length; index += 2 * size) {
			int mid = Math.min(index + size - 1, nums.length - 1);
			int right = Math.min(index + 2 * size - 1, nums.length - 1);
			merge(nums, index, mid, right);
		}
	}
}
private void merge(int[] nums, int left, int mid, int right) {
	int index = left, leftIndex = 0, rightIndex = 0;
	// 拷贝数组
	int n1 = mid - left + 1;
	int n2 = right - mid;
	// 创建临时数组
	int[] leftArr = new int[n1];
	int[] rightArr = new int[n2];
	// 将数据复制到临时数组
	System.arraycopy(nums, left, leftArr, 0, n1);
	System.arraycopy(nums, mid + 1, rightArr, 0, n2);
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
}
