package temp.concurrentLearning;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	// 定义3个信号量
	private static Semaphore sa = new Semaphore(1);
	private static Semaphore sb = new Semaphore(1);
	private static Semaphore sc = new Semaphore(1);

	public static void main(String[] args) throws InterruptedException {
		try {
			sa.acquire();
			sb.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 执行线程sa，并打印 sa
		new Thread(() -> {
			while (true) {
				try {
					sa.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("A");
				sb.release();
			}
		}).start();
		// B
		new Thread(() -> {
			while (true) {
				try {
					sb.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("B");
				sc.release();
			}
		}).start();
		// C
		new Thread(() -> {
			while (true) {
				try {
					sc.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("C");
				sa.release();
			}
		}).start();
	}
}
