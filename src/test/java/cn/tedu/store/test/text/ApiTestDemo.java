package cn.tedu.store.test.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


public class ApiTestDemo {

	public static void main(String[] args) throws IOException {
		//定义变量属性 后期可采用动态获取
				String dataCode = "NAFP_NWFD_SCMOC";
				String time = "201711231000";
				double minLon = 116.21;
				double maxLon = 116.45;
				double minLat = 41.17;
				double maxLat = 41.33;
				String fcstLevel = "-";
				String fcstEle = "ERH";
				int validTime = 12;
				//外接口URL路径拼接
				String urlStr = "http://api.data.cma.cn:8090/api"
							+ "?userId=Jlkj_jlkj_user"
							+ "&pwd=123456"
							+ "&interfaceId=getNafpEleGridInRectByTimeAndLevelAndValidtime"
							+ "&dataCode=" + dataCode
							+ "&time=" + time
							+ "&minLon=" + minLon
							+ "&maxLon=" + maxLon
							+ "&minLat=" + minLat
							+ "&maxLat=" + maxLat
							+ "&fcstLevel=" + fcstLevel
							+ "&fcstEle=" + fcstEle
							+ "&validTime=" + validTime
							+ "&dataFormat=json".replace(" ","");
				//链接URL  
				URL url=new URL(urlStr);
				//返回结果集
				StringBuffer document = new StringBuffer();
				//创建链接
				URLConnection conn = url.openConnection();
				//读取返回结果集
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				String line = null;
				while ((line = reader.readLine()) != null){ 
					document.append(line);
					}
				reader.close();
				JSONObject json = JSONObject.fromObject(document.toString());
				//获取json中某个对象
				String str =(String)json.get("requestParams");
				System.out.println(str);
				//由于requestParams包含全部str字符串数据,现将str转Map
				String[] strs = str.split("&");
				Map<String, String> m = new HashMap<String, String>();
				for(String s:strs){
					String[] ms = s.split("=");
					m.put(ms[0], ms[1]);
					}
				System.out.println(m.get("minlon"));
				//获取json串中具体值  后期可根据key随意调取存入数据库
				String obj = (String)json.get("requestTime");
				System.out.println(obj);

	}

}
