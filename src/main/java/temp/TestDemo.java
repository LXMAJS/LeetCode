package temp;

import org.openjdk.jol.info.ClassLayout;
import org.springframework.util.CollectionUtils;
import sun.jvm.hotspot.debugger.Page;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestDemo {
	/**
	 * 逐个检查数组是否有重复值
	 *
	 * @param arr 数组
	 * @return 若重复返回true，否则返回false
	 */
	private static boolean checkRepitation(List<String> arr) {
		if (CollectionUtils.isEmpty(arr)) {
			return true;
		}
		for (int index = 0; index < arr.size(); index++) {
			String str1 = arr.get(index);
			for (int jndex = index + 1; jndex < arr.size(); jndex++) {
				String str2 = arr.get(jndex);
				if (null != str1 && str1.equals(str2)) {
					return false;
				}
			}
		}
		return true;
	}


	public static void main1(String[] args) {
		String[] items = "yes,可以,OK,试试,试试吧,明白,知道,了解,^嗯,^好,可以的行啊,那好,那行,那可以,那可以吧,行行,好好,^呃,^对,^恩,^是,^有,^能,^行,^行的,^要,^额,ok,好的,好呀,^可以,嗯嗯,好吧,可以吧,应该可以吧,我愿意,我愿意接受,我觉得可以,应该可以,可以的呀,好好好,行行行,好的呀,嗯好,恩行,哦好,嗯了,嗯吧,嗯呀,嗯呐,嗯呗,嗯呢,嗯咧,嗯哇,嗯哈,嗯哒,嗯哦,嗯哪,啊,行吧,行啊,行的,可以的,可以啊,随便你,随便啊,^好呢,好哈,^好行,好可以,好ok,嗯行吧,^嗯可以,嗯可以啊,嗯那行,嗯行,随便吧,可以可以,阔以,可以没问题,可以ok,可以好的,可以好啊,哦可以,行呀,没问题,行可以,同意,愿意".split(",");
		System.out.println(checkRepitation(Arrays.stream(items).collect(Collectors.toList())));
	}

public static void main(String[] args) {
	Object o = new Object();
	System.out.println("==== 加锁前 ==== ");
	System.out.println(ClassLayout.parseInstance(o).toPrintable());
	System.out.println("==== 加锁后 ==== ");
	synchronized (o){
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
	}
	System.out.println("==== 释放锁 ==== ");
	System.out.println(ClassLayout.parseInstance(o).toPrintable());
}
}
