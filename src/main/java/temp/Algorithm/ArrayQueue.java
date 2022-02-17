package temp.Algorithm;

/**
 * 顺序队列
 */
public class ArrayQueue<T> {
	// 存储元素的数组
	private Object[] items;
	// 队列的容量
	private int n;
	// 队头索引
	private int head;
	// 队尾索引
	private int tail;

	/**
	 * 构造方法
	 * @param capacity 初始容量
	 */
	public ArrayQueue(int capacity) {
		this.items = new Object[capacity];
		this.n = capacity;
		this.head = 0;
		this.tail = 0;
	}

	/**
	 * 入队操作
	 * @param data 入队的数据
	 * @return true则成功，false则失败
	 */
	public boolean enqueue(T data) {
		// 队列已满
		if (tail == n) {
			// 判断head是否在队头，若不是，表示有空间进行数据搬移
			if (head == 0) {
				return false;
			}
			// 搬移数据
			for (int index = head; index < tail; index++) {
				items[index - head] = items[head];
			}
			// 设置游标
			tail = n - head;
			head = 0;
		}
		items[tail] = data;
		tail ++;
		return true;
	}

	/**
	 * 出队
	 * @return 队列中的元素
	 */
	@SuppressWarnings("unchecked")
	public T dequeue() {
		// 队头等于队尾，表示没有元素
		if (head == tail) {
			return null;
		}
		Object data = items[head];
		head ++;
		return (T) data;
	}

	/**
	 * 测试方法
	 * @param args 参数
	 */
	public static void main(String[] args) {
		ArrayQueue<String> ar = new ArrayQueue(2);
		System.out.println(ar.enqueue("lxmajs"));
		System.out.println(ar.enqueue("ddd"));
		System.out.println(ar.enqueue("test"));

		System.out.println(ar.dequeue());
		System.out.println(ar.dequeue());
		System.out.println(ar.dequeue());
	}
}
