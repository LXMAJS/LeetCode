package cgbSmallPackage.code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class echartDataAnalysis {

	static String filePath = "data/1.log";

	public static void main(String[] args) {
		InputStreamReader inputStream = null;
		List<String> times = new ArrayList<String>();
		List<Integer> caches = new ArrayList<Integer>();
		List<Integer> runnings = new ArrayList<Integer>();
		List<Integer> sum = new ArrayList<Integer>();
		try {

			inputStream = new InputStreamReader(echartDataAnalysis.class.getClassLoader().getResourceAsStream(filePath));
			BufferedReader bufferedReader = new BufferedReader(inputStream);

			String str = null;
			while((str = bufferedReader.readLine()) != null)
			{
				JSONArray array = JSON.parseArray(str);
				if(null != array) {
					// 这里硬性规定数组的元素是3个
					times.add(array.getString(0));
					int cache = array.getInteger(1);
					int running = array.getInteger(2);
					caches.add(cache);
					runnings.add(running);
					sum.add((cache + running));
				}
			}
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		if(sum.size() > 0) {
			String timeStr = JSON.toJSONString(times);
			String cacheStr = JSON.toJSONString(caches);
			String runningStr = JSON.toJSONString(runnings);
			String sumStr = JSON.toJSONString(sum);

//			System.out.println(timeStr);
//			System.out.println(cacheStr);
//			System.out.println(runningStr);
//			System.out.println(sumStr);

			String graph = getTemplate()
					.replace("${times}", timeStr)
					.replace("${caches}", cacheStr)
					.replace("${runnings}", runningStr)
					.replace("${sum}", sumStr);

			System.out.println(graph);
		}

	}

	static String getTemplate() {
		return "option = {\n" +
				"  xAxis: {\n" +
				"    type: 'category',\n" +
				"    data: ${times}\n" +
				"  },\n" +
				"  yAxis: {\n" +
				"    type: 'value'\n" +
				"  },\n" +
				"  series: [{\n" +
				"    data: ${caches},\n" +
				"    type: 'line'\n" +
				"  },{\n" +
				"    data: ${runnings},\n" +
				"    type: 'line'\n" +
				"  },{\n" +
				"    data: ${sum},\n" +
				"    type: 'line'\n" +
				"  }]\n" +
				"};\n";
	}
}

