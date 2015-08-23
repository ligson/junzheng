package formsubmit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Replace {
	static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://121.199.58.243:3306/coderstar", "root",
					"s6sv6e6rr4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		PreparedStatement ps = connection
				.prepareCall("select id,description from article limit 0,10");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String content = rs.getString(2);
			System.out.println(id + "======" + content);
		}
		ps.close();
	}
}
