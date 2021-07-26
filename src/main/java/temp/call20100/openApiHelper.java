package temp.call20100;

import com.alibaba.fastjson.JSONObject;
import javafx.util.Pair;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class openApiHelper {

	public static void main(String[] args) {
		while(true) {
			try {
				Thread.sleep(1000);
				Pair<Integer, JSONObject> result = pingUrl();
				if (null != result) {
					System.out.println(result.getKey());
				} else {
					System.out.println("Error!!!");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static Pair<Integer, JSONObject> pingUrl() {
		try {
			String url = "http://172.18.163.187:9705/yicall/api/66538/getContactinfo";

			MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
			param.add("phone", "debugCall-11-200");

			HttpHeaders header = new HttpHeaders();
			header.set("Content-Type", "application/json");

			HttpEntity<MultiValueMap> entity = new HttpEntity<>(null, header);

			RestTemplate client = new RestTemplate();
			ResponseEntity<JSONObject> result = client.exchange(url, HttpMethod.POST, entity, JSONObject.class);
			int httpStatusCode = result.getStatusCodeValue();
			JSONObject jsonObject = result.getBody();
			System.out.println("pair = " + jsonObject);
			return new Pair<>(httpStatusCode, jsonObject);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
