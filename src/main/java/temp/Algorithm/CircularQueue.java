package temp.Algorithm;

/**
 * 循环队列
 */
public class CircularQueue<T> {
	// 存储元素的数组
	private Object[] items;
	// 队列的容量
	private int n;
	// 队头索引
	private int head;
	// 队尾索引
	private int tail;

	/**
	 * 入队
	 * @param data 元素数据
	 * @return true表示入队成功，false表示失败
	 */
	public boolean enqueue(T data) {
		// 判断队列是否已满
		if ((tail + 1) % n == head) {
			return false;
		}
		items[tail] = data;
		tail = (tail + 1 ) % n;
		return true;
	}

	/**
	 * 出队
	 * @return 弹出一个元素
	 */
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

		System.out.println(ar.dequeue());

		System.out.println(ar.enqueue("test"));

		System.out.println(ar.dequeue());
		System.out.println(ar.dequeue());
	}
}
