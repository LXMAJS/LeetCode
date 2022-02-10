package temp.Algorithm;

/**
 * 链式栈
 * @param <T> 数据存储对象
 */
public class LinkedStack<T> {
	// 数据存储对象链表
	private LinkedStackNode<T> top;

	/**
	 * 构造方法
	 */
	public LinkedStack() {
		this.top = null;
	}

	/**
	 * 入栈
	 * @param data 数据内容
	 */
	@SuppressWarnings("unchecked")
	public void push(Object data) {
		LinkedStackNode node = new LinkedStackNode(data, null);
		if (null == this.top) {
			// 栈内无元素
			this.top = node;
		} else {
			node.next = this.top;
			this.top = node;
		}
	}

	/**
	 * 出栈
	 * @return 数据内容
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		if (null == this.top) {
			return null;
		}
		T data = this.top.getData();
		this.top = this.top.next;
		return data;
	}

	/**
	 * 实现一个打印所有栈内元素的方法
	 */
	public void printAll() {
		if (null == this.top) {
			System.out.println("Stack is empty.");
		}
		LinkedStackNode node = this.top;
		while (null != node) {
			System.out.println(node.getData());
			node = node.next;
		}
	}

	/**
	 * 定义链表结构
	 * @param <E>
	 */
	private class LinkedStackNode<E> {
		// 数据本体
		private Object data;
		// 下一个节点的指针
		private LinkedStackNode next;

		/**
		 * 构造方法
		 * @param data 数据本体
		 * @param next 下一个节点
		 */
		public LinkedStackNode(Object data, LinkedStackNode next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * 获取数据内容
		 * @return 数据内容
		 */
		@SuppressWarnings("unchecked")
		public E getData() {
			return (E) data;
		}
	}

	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<>();
		ls.push("lxmajs");
		ls.push("ddd");
		ls.printAll();
		System.out.println(ls.pop());
		System.out.println(ls.pop());
	}
}
