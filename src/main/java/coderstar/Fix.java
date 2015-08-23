package coderstar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Fix {
	static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://ouknowrepos3.3322.org:3306/csdb", "root",
					"bfrootpassword");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		if (connection != null) {
			connection.close();
		}
	}

	public static void main(String[] args) throws Exception {
		PreparedStatement ps = connection
				.prepareStatement("select a.id,a.title from article a WHERE a.id NOT in (select ac.article_id from article_category ac) and a.id>=17 and a.id<=28");
		ResultSet rs = ps.executeQuery();
		List<Article> articles = new ArrayList<Article>();
		while (rs.next()) {
			long id = rs.getLong(1);
			String title = rs.getString(2);
			Article article = new Article();
			article.id = id;
			article.name = title;
			articles.add(article);
		}
		System.out.println(articles.size());

		ps = connection
				.prepareStatement("insert into article_category(id,article_id,category_id) values(?,?,?)");
		int i = 60;
		for (Article article : articles) {
			ps.setLong(1, i++);
			ps.setLong(2, article.id);
			ps.setLong(3,1);
			ps.addBatch();
		}
		ps.executeBatch();

	}
}
