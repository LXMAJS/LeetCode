package temp.concurrentLearning;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		int size = 3;
		CountDownLatch cdl = new CountDownLatch(1);
		for (int index = 0; index < size; index ++) {
			new Thread(() -> {
				try {
					cdl.await();
					System.out.println(System.currentTimeMillis());
				} catch (InterruptedException ignored) {

				}
			}).start();
		}
		// 线程启动需要CPU时间，所以暂时休眠一下
		Thread.sleep(1000);
		cdl.countDown();
	}
}
