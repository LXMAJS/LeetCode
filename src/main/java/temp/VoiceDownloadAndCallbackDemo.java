package temp;

import org.springframework.util.StringUtils;
import temp.code.echartDataAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VoiceDownloadAndCallbackDemo {

	static String filePath = "dialog.info.0718.log";


	public static class LogItem {
		private String date;
		private String time;

		public LogItem(String date, String time) {
			this.date = date;
			this.time = time;
		}
	}

	public static List<LogItem> serializeLogItem() {
		InputStreamReader inputStream = null;
		List<LogItem> logList = new ArrayList<>();
		try {
			inputStream = new InputStreamReader(Objects.requireNonNull(echartDataAnalysis.class.getClassLoader().getResourceAsStream(filePath)));
			BufferedReader bufferedReader = new BufferedReader(inputStream);
			String str = null;
			while((str = bufferedReader.readLine()) != null)
			{
				if (StringUtils.isEmpty(str)) {
					continue;
				}
				String[] dataArray = str.split(" ");
				String ms = dataArray[2].substring(7, dataArray[2].length()-3);
				LogItem logItem = new LogItem(dataArray[1], ms);
				logList.add(logItem);
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logList;
	}



	public static void main(String[] args) {
		StringBuilder date = new StringBuilder();
		StringBuilder count = new StringBuilder();
		List<LogItem> logItems = serializeLogItem();
		for (LogItem logItem : logItems) {
			date.append("'" + logItem.date + "',");
			count.append(logItem.time + ",");
		}
		System.out.println(date.substring(0, date.length() - 1).toString());
		System.out.println(count.substring(0, count.length() - 1).toString());

	}
}
