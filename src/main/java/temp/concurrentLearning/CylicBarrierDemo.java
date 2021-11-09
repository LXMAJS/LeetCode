package temp.concurrentLearning;

import java.util.concurrent.CountDownLatch;

public class CylicBarrierDemo {
	// 定义公共资源，并保证其线程可见性
	static volatile int ticket = 1;

	public static void main(String[] args) {
		// 定义线程 t1，让他公共资源满足条件时，执行业务逻辑
		Thread t1 = new Thread(() -> {
			while(true) {
				if (ticket == 1) {
					System.out.println("t1 is running;");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 将公共资源的条件修改为满足 t2 线程的执行要求
					ticket = 2;
					return;
				}
			}
		});
		Thread t2 = new Thread(() -> {
			while(true) {
				if (ticket == 2) {
					System.out.println("t2 is running;");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 将公共资源的条件修改为满足 t3 线程的执行要求
					ticket = 3;
					return;
				}
			}
		});
		Thread t3 = new Thread(() -> {
			while(true) {
				if (ticket == 3) {
					System.out.println("t3 is running;");
					return;
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}
}
