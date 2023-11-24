import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{ 4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


//    public static String getMD5ToKefuApi(TreeMap<String, String> data) {
//        try {
//            StringBuilder buffer = new StringBuilder();
//            for (String k : data.keySet()) {
//                if (data.get(k) != null) {
//                    String v = data.get(k).toString();
//                    if (!StringUtils.isEmpty(v)) {
//                        buffer.append(k + "=" + v + "&");
//                    }
//                }
//            }
////            buffer.append("ak=" + ak);
//            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
//            byte[] array = md.digest(buffer.toString().getBytes(Charset.forName("utf-8")));
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < array.length; ++i) {
//                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
//            }
//            return sb.toString();
//        } catch (java.security.NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        TreeMap<String, String> data = new TreeMap<>();
//        data.put("driverPhone", "17612011092");
//        data.put("aId", "100");
//        data.put("ak", "1yFUIk0f");
//
//        System.out.println(getMD5ToKefuApi(data));
//    }
}
