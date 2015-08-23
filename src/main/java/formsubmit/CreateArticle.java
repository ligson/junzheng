package formsubmit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class CreateArticle {
	static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.14:3306/aielnbbs", "root",
					"password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static String baseUrl = "http://localhost:1680/";
	static HttpClient client = HttpClientBuilder.create().build();
	static HttpContext context = new BasicHttpContext();
	static CookieStore cookieStore = new BasicCookieStore();
	static {

		HttpPost post = new HttpPost(baseUrl + "index/checkLogin");
		try {

			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("name", "admin@admin.com"));
			formparams.add(new BasicNameValuePair("password", "password"));
			HttpEntity entity = new UrlEncodedFormEntity(formparams);
			post.setEntity(entity);
			context.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
			HttpResponse response = client.execute(post, context);
			HttpEntity entity2 = response.getEntity();
			System.out.println(response.getStatusLine());
			String content = EntityUtils.toString(entity2);
			System.out.println(content);
			System.out.println("---------------------------");

			System.out.println(Arrays.toString(response
					.getHeaders("JSESSIONID")));
			System.out.println(cookieStore);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void submit(String title, String description, long languageId,
			String tags) {
		try {
			HttpPost post = new HttpPost(baseUrl + "article/save");
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("title", title.trim()));
			formparams.add(new BasicNameValuePair("description", description));
			formparams
					.add(new BasicNameValuePair("languageId", languageId + ""));
			formparams.add(new BasicNameValuePair("tags", tags));
			HttpEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post, context);
			HttpEntity entity2 = response.getEntity();
			String content = EntityUtils.toString(entity2);
			System.out.println(content);
			System.out.println(response.getStatusLine());
			if (response.getStatusLine().getStatusCode() == 302) {
				System.out.println("--------xx");
				String location = response.getFirstHeader("location")
						.getValue();
				HttpGet httpGet = new HttpGet(location);
				HttpResponse response2 = client.execute(httpGet, context);
				System.out.println(EntityUtils.toString(response2.getEntity()));
				// System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CreateArticle article = new CreateArticle();
		PreparedStatement ps = connection
				.prepareCall("SELECT pa.aid,pa.title,pc.content FROM pre_portal_article_title pa,pre_portal_article_content pc  where pa.catid=25 and pc.aid=pa.aid");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String title = rs.getString(2);
			String content = rs.getString(3);
			System.out.println(content);
			article.submit(title, content, 7, "教学设计");
		}
	}

}
