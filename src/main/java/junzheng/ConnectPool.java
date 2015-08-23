package junzheng;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectPool {
	// sqlServer的连接地址
	static String sqlServerUrl = "jdbc:jtds:sqlserver://192.168.1.20:1433;instance=sharepoint;DatabaseName=jfjdsxczx_db;user=sa;password=boful123$;socketTimeout=60";
	// bmc 数据库连接地址
	static String bmcDbUrl = "jdbc:mysql://192.168.1.201:3306/jzwbmc?useUnicode=true&characterEncoding=utf8&user=root&password=bfrootpassword";
	// rms 数据库连接地址
	static String rmsDbUrl = "jdbc:mysql://192.168.1.201:3306/jzw11?useUnicode=true&characterEncoding=utf8&user=root&password=bfrootpassword";

	private static Connection sqlServerConnection;
	private static Connection bmcConnection;
	private static Connection rmsConnection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			sqlServerConnection = DriverManager.getConnection(sqlServerUrl);
			bmcConnection = DriverManager.getConnection(bmcDbUrl);
			rmsConnection = DriverManager.getConnection(rmsDbUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		if (sqlServerConnection != null) {
			sqlServerConnection.close();
		}
		if (bmcConnection != null) {
			bmcConnection.close();
		}
		if (rmsConnection != null) {
			rmsConnection.close();
		}
	}

	public static Connection getSqlServerConnection() {
		return sqlServerConnection;
	}

	public static void setSqlServerConnection(Connection sqlServerConnection) {
		ConnectPool.sqlServerConnection = sqlServerConnection;
	}

	public static Connection getBmcConnection() {
		return bmcConnection;
	}

	public static void setBmcConnection(Connection bmcConnection) {
		ConnectPool.bmcConnection = bmcConnection;
	}

	public static Connection getRmsConnection() {
		return rmsConnection;
	}

	public static void setRmsConnection(Connection rmsConnection) {
		ConnectPool.rmsConnection = rmsConnection;
	}

}
