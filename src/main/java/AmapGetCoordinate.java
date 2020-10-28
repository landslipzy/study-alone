import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhongying on 2020/4/22.
 */
public class AmapGetCoordinate {
    public static void main(String[] args) {
        String httpUrl = "https://restapi.amap.com/v3/geocode/geo?key=8238115652374e54d5f5dc327643921d&city=成都";
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        JSONObject jsonObject = null;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//            connection.setRequestProperty();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            jsonObject = JSONObject.parseObject(sbf.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
