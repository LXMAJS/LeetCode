package temp.code;

import com.alibaba.fastjson.JSONObject;
import javafx.util.Pair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import util.DateHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class createTestData {

	public static void main(String[] args) {
		for (int index = 1; index <= 100; index ++) {
			System.out.println("current " + index);
			createOpenCall(index);
		}
	}

	private static Pair<Integer, JSONObject> createOpenCall(int index) {
		try {
			String url = "http://172.16.30.83:9705/yicall/api/33768/createOpenCall";

			HttpEntity<JSONObject> entity = new HttpEntity<>(getContext(index));
			RestTemplate client = new RestTemplate();
			System.out.println("url = " + url);
			ResponseEntity<JSONObject> result = client.exchange(url, HttpMethod.POST, entity, JSONObject.class);

			int httpStatusCode = result.getStatusCodeValue();
			JSONObject jsonObject = result.getBody();
			System.out.println("pair = " + jsonObject);
			return new Pair<>(httpStatusCode, jsonObject);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	private static JSONObject getContext(int index) {
		String data = "{\"seqNo\":\"SeqNo-[seqNo]\",\"data\":{\"strategy\":{\"outTaskId\":\"[outTaskId]\",\"outTaskName\":\"[outTaskName]\",\"templateId\":\"1001-1004-169\",\n" +
				"\"voiceTemplateName\":\"\",\"mainCalloutNumber\":\"[mainCalloutNumber]\",\"telNumPrefix\":\"\",\"startCallTime\":\"[startCallTime]\",\"autoStopTime\":\"[autoStopTime]\",\n" +
				"\"recallNum\":\"0\",\"calloutLineCount\":\"[calloutLineCount]\",\"ttsSupplier\":{\"ttsSupplierId\":\"mock\",\"voiceId\":\"default\",\"speed\":\"1\",\"volume\":\"1\",\n" +
				"\"playMode\":\"playPureTts\"}},\"customer\":{\"caseId\":\"[caseId]\",\"telNum\":\"[telNum]\",\"calloutScheduleTime\":\"[calloutScheduleTime]\",\"telId\":\"55\"}}}";

		String startCallTime = DateHelper.nowYYYY_MM_DD_HH_MM_SS();
		String autoStopTime = DateHelper.getTodayEndTime();

		Random r = new Random();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, new Date().getHours());
		c.set(Calendar.MINUTE, new Date().getMinutes() + r.nextInt(5));
		c.set(Calendar.SECOND, 0);
		String calloutScheduleTime = DateHelper.toYYYY_MM_DD_HH_MM_SS(c.getTime());
		String outTaskId = System.currentTimeMillis() + "";
		String caseId = System.currentTimeMillis() + "";
		String outTaskName = "小包-" + index + "-" + DateHelper.toYYYYMMDDHHMMSS(new Date());
		String mainCalloutNumber = "5666";
		String telNum = "13578907" + index;

		data = data.replace("[seqNo]", System.currentTimeMillis() + "")
				.replace("[outTaskId]", outTaskId)
				.replace("[outTaskName]", outTaskName)
				.replace("[mainCalloutNumber]", mainCalloutNumber)
				.replace("[startCallTime]", startCallTime)
				.replace("[autoStopTime]", autoStopTime)
				.replace("[caseId]", caseId)
				.replace("[telNum]", telNum)
				.replace("[calloutScheduleTime]", calloutScheduleTime)
				.replace("[calloutLineCount]", "1000");
		return JSONObject.parseObject(data);
	}
}
