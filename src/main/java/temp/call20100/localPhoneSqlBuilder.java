package temp.call20100;

import org.springframework.util.StringUtils;
import temp.code.echartDataAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class localPhoneSqlBuilder {

	static String sqlHeader = "INSERT INTO `yicall_local_phone` VALUES ";

	// ('130','1300000','山东','济南','联通','250000','0531','370100\r',NULL)
	static String sqlTemplate = "('{pref}','{phone}','{province}','{city}','{isp}','{postCode}','{cityCode}','',NULL)";

	static String filePath = "data/localPhone.txt";

	public static void main(String[] args) {

	}

	public class LocalPhone {
		public String pref;
		public String phone;
		public String province;
		public String city;
		public String isp;
		public String postCode;
		public String cityCode;
	}

	public static List<LocalPhone> serializeLocalPhone() {
		InputStreamReader inputStream = null;
		List<LocalPhone> phones = new ArrayList<>();
		int dataCount = 6; // 按逗号切割后的行数
		try {
			inputStream = new InputStreamReader(Objects.requireNonNull(echartDataAnalysis.class.getClassLoader().getResourceAsStream(filePath)));
			BufferedReader bufferedReader = new BufferedReader(inputStream);

			String str = null;
			while((str = bufferedReader.readLine()) != null)
			{
				if (StringUtils.isEmpty(str)) {
					continue;
				}
				String[] dataArray = str.split(",");
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return phones;
	}
}
