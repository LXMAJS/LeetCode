package cgbSmallPackage.code;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import util.DateHelper;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class createGraphData {

	public static void main(String[] args) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String fileName = LocalDateTime.now().format(formatter);
		String filePath = fileName + ".log";


		//创建一个新文件
		String fullPath = echartDataAnalysis.class.getClassLoader().getResource("data").getPath();
		File file = new File(fullPath + "/" + filePath);
		try {
			file.createNewFile();
			filePath = file.getPath();
			System.out.println(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 判断文件是否存在

		while(true) {
			try {
				Thread.sleep(500);

				PrintWriter out = new PrintWriter(new File(filePath));
				String line = getSessionSlot();
				System.out.println(line);
				// 写入文件
				out.write(line);
				out.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static String getSessionSlot() {
		try {
			String url = "http://127.0.0.1:9702/yicall/manage/getSessionSlot";

			RestTemplate client = new RestTemplate();
			ResponseEntity<JSONObject> result = client.exchange(url, HttpMethod.GET, null, JSONObject.class);

			JSONObject jsonObject = result.getBody();
			if(null == jsonObject) {
				return "";
			}

			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject vcm =  data.getJSONObject("172.16.30.83:9199");

			return "[\"" + DateHelper.toHH_MM_SS(LocalTime.now()) + "\", " + vcm.get("vcmCacheNum") + ", " + vcm.get("vcmRunLineNum") + "]";

		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}
}
