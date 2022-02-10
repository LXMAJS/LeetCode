package temp.Algorithm;

/**
 * 自定义顺序栈
 * @param <T> 数据类型
 */
public class ArrayStack<T> {
	// 数据存储对象数组
	private Object[] items;
	// 栈中的元素总数
	private int count;
	// 栈的容量大小
	private int n;

	/**
	 * 初始化栈
	 */
	public ArrayStack (int n) {
		this.items = new Object[n];
		this.n = n;
		this.count = 0;
	}

	/**
	 * 插入元素
	 * @param item 数据
	 * @return 成功与否
	 */
	public boolean push(Object item) {
		// 如果数量超过容量，则直接返回false
		if (count >= n) {
			return false;
		}
		// 插入一个新元素
		items[count] = item;
		count++;
		return true;
	}

	/**
	 * 弹出一个元素
	 * @return 元素
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		if (count == 0) {
			return null;
		}
		count--;
		return (T) items[count];
	}

	// 测试方法
	public static void main(String[] args) {
		ArrayStack<String> as = new ArrayStack<>(2);
		System.out.println(as.push("lxmajs"));
		System.out.println(as.push("ddd"));
		System.out.println(as.push("123"));
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
	}
}
