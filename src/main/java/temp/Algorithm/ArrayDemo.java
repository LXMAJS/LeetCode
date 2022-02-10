package temp.Algorithm;

import java.util.ArrayList;

public class ArrayDemo {
public static void main(String[] args) {
	long beginTime = System.currentTimeMillis();
	System.out.println("Begin : " + beginTime);
	// ArrayList<Integer> arr = new ArrayList<>(); // 未指定大小
	ArrayList<Integer> arr = new ArrayList<>(1000000); // 指定大小
	for (int index = 0; index < 1000000; index ++) {
		arr.add(index);
	}
	long endTime = System.currentTimeMillis();
	System.out.println("End : " + endTime);
	System.out.println("Gap : " + (endTime - beginTime));
}
}
