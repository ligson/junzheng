package bcms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Submit {
	static String baseUrl = "http://42.62.52.40:8000/";
	static HttpClient client = HttpClientBuilder.create().build();
	static HttpContext context = new BasicHttpContext();

	public static void login() throws Exception {
		HttpPost post = new HttpPost(baseUrl + "login");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", "superadmin");
		params.put("password", "superadmin");
		JSONObject jsonObject = new JSONObject(params);
		StringEntity stringEntity = new StringEntity(jsonObject.toString(),
				"UTF-8");
		post.setEntity(stringEntity);
		HttpResponse response = client.execute(post, context);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, "UTF-8");
		System.out.println(content);

	}

	public static void list() throws Exception {
		HttpGet get = new HttpGet(baseUrl + "/department/page/1");
		HttpResponse response = client.execute(get, context);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, "UTF-8");
		System.out.println(content);
	}

	public static void main(String[] args) throws Exception {
		login();
		list();
	}
}
