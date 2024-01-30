package algorithms;

/**
 * 最大堆
 */
public class MaxHeapSort extends AbstractDemoSort {

	private static final int DEFAULT_CAPACITY = 1000;
	/**
	 * 堆存储的数据
	 */
	private int[] data;
	/**
	 * 堆当前的大小
	 */
	private int count;

	/**
	 * 构造方法
	 */
	public MaxHeapSort() {
		this.data = new int[0];
		this.count = 0;
	}
	public MaxHeapSort(Integer capacity) {
		this.data = new int[capacity != null ? capacity : DEFAULT_CAPACITY];
		this.count = 0;
	}

	/**
	 * Heapify
	 *
	 * @param nums 待排序的数组
	 */
	public MaxHeapSort(int[] nums) {
		this.count = nums.length;
		this.data = new int[this.count];
		System.arraycopy(nums, 0, this.data, 0, nums.length);
		if (this.count > 0) {
			for (int index = this.count / 2; index > 1; index--) {
				shiftDown(index);
			}
		}
	}

	/**
	 * 堆是否为空
	 *
	 * @return 若不为空，返回 true，反之返回 false
	 */
	public boolean isEmpty() {
		return this.count == 0;
	}

	/**
	 * 返回堆的大小
	 *
	 * @return 堆的大小，整数
	 */
	public int size() {
		return this.count;
	}

	/**
	 * 插入新元素
	 *
	 * @param item 新元素
	 */
	public void insert(int item) {
		// todo: 数组越界，需要额外空间
		assert this.count + 1 > DEFAULT_CAPACITY;
		this.data[++this.count] = item;
		shiftUp(this.count);
	}

	/**
	 * 向上比较并交换
	 *
	 * @param index 需要交换的索引
	 */
	private void shiftUp(int index) {
		while (index > 1 && this.data[index] > this.data[index / 2]) {
			swapArray(this.data, index, index / 2);
			index /= 2;
		}
	}

	/**
	 * 从堆顶推出最大值
	 *
	 * @return 最大值
	 */
	public int popMax() {
		if (this.count < 0) {
			return -1;
		}
		int rootVal = this.data[1];
		this.data[1] = this.data[this.count--];
		shiftDown(1);
		return rootVal;
	}

	/**
	 * 向下交换位置
	 *
	 * @param index 需要交换的索引值
	 */
	private void shiftDown(int index) {
		// 如果它有左孩子，则一直循环，在循环内部增加 break 条件
		while (2 * index <= this.count) {
			// 额外增加一个临时变量，记录左右孩子中较大的那个
			int maxChildIndex = 2 * index;
			if (maxChildIndex + 1 <= this.count
					&& this.data[maxChildIndex] < this.data[maxChildIndex + 1]) {
				// 如果右孩子子比较大，则将较大的坐标更新为右孩子
				maxChildIndex += 1;
			}
			// 判断当前节点是否比孩子大：
			// 如果比较小，则交换位置，如果已经比孩子大了，则break即可
			if (this.data[index] > this.data[maxChildIndex]) {
				break;
			} else {
				swapArray(this.data, index, maxChildIndex);
				index = maxChildIndex;
			}
		}
	}

	/**
	 * 对外部数组进行 ShiftDown
	 *
	 * @param nums   数组
	 * @param length 数组边界 [index, length]
	 * @param index  需要ShiftDown的索引位置
	 */
	private void shiftDown(int[] nums, int length, int index) {
		// 如果它有左孩子，则一直循环，在循环内部增加 break 条件
		while ((2 * index + 1) < length) {
			// 额外增加一个临时变量，记录左右孩子中较大的那个
			int maxChildIndex = 2 * index + 1;
			if (maxChildIndex + 1 < length
					&& nums[maxChildIndex] < nums[maxChildIndex + 1]) {
				// 如果右孩子子比较大，则将较大的坐标更新为右孩子
				maxChildIndex += 1;
			}
			// 判断当前节点是否比孩子大：
			// 如果比较小，则交换位置，如果已经比孩子大了，则break即可
			if (nums[index] > nums[maxChildIndex]) {
				break;
			} else {
				swapArray(nums, index, maxChildIndex);
				index = maxChildIndex;
			}
		}
	}

	@Override
	void sort(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		// Heapify
		for (int index = (nums.length - 2) / 2; index >= 0; index--) {
			shiftDown(nums, nums.length, index);
		}
		// 排序
		for (int index = nums.length - 1; index > 0; index--) {
			swapArray(nums, index, 0);
			shiftDown(nums, index, 0);
		}
	}
}
