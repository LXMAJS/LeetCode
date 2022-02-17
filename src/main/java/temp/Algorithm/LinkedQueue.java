package temp.Algorithm;

/**
 * 链式队列
 * @param <T>
 */
public class LinkedQueue<T> {
	// 队头
	private Node<T> head;
	// 队尾
	private Node<T> tail;

	/**
	 * 构造方法，初始化队列
	 */
	public LinkedQueue() {
		this.head = null;
		this.tail = head;
	}

	/**
	 * 入队
	 * @param data 队列元素
	 */
	public void enqueue(T data) {
		Node node = new Node(data);
		// 处理头节点
		if (null == this.head) {
			this.head = node;
			this.tail = this.head;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
	}

	/**
	 * 出队
	 * @return 具体的数据
	 */
	public T dequeue() {
		// 队列为空
		if (null == this.head) {
			return null;
		}
		// 将头结点临时存储
		T h = this.head.getData();
		this.head = this.head.next;
		return h;
	}

	/**
	 * 定义队列的节点
	 * @param <E>
	 */
	public class Node<E> {
		// 当前节点的数据
		public Object data;
		// 下一个节点的指针
		public Node next;
		// 构造方法
		public Node(E d) {
			this.data = d;
			this.next = null;
		}
		// 获得具体的数据内容
		public T getData() {
			return (T) data;
		}
	}

	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedQueue<String> ar = new LinkedQueue();
		ar.enqueue("lxmajs");
		ar.enqueue("ddd");
		ar.enqueue("test");

		System.out.println(ar.dequeue());
		System.out.println(ar.dequeue());
		System.out.println(ar.dequeue());
	}
}
