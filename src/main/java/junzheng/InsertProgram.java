package junzheng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertProgram {
	static String dburl = "jdbc:mysql://ip:port/dbName?useUnicode=true&characterEncoding=utf8";
	static String user = "root";
	static String password = "password";
	static Connection connection = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertData(List<Program> programs) throws Exception {
		PreparedStatement ps = connection
				.prepareStatement("insert into program(id,version,actor,can_all_download,can_all_play,can_distribute,can_download,can_play,can_public,can_union,class_lib_id,collect_num,consumer_id,date_created,date_deleted,date_modified,date_passed,description,director,directory_id,download_num,eidtion,frequency,from_id,from_node_id,from_node_name,from_state,guid,name,now_version,other_option,out_class_id,poster_hash,poster_path,poster_type,pre_version,recommend_num,remark_num,serial_num,state,type,view_num,program_category_id,cateory,open_date,plan_count,transcode_state,first_category_id,poster_name,special_id,special_name,program_score,vertical_poster_hash,vertical_poster_name,vertical_poster_path,vertical_poster_type,recommend_state) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		int id = 1;
		long libId = 111111;
		long categoryId = 111111;
		long masterId = 1;
		for (Program program : programs) {
			ps.setLong(1, id++);
			ps.setLong(2, 0);
			ps.setString(3, program.getAuthor());
			ps.setBoolean(4, true);
			ps.setBoolean(5, true);
			ps.setBoolean(6, true);
			ps.setBoolean(7, true);
			ps.setBoolean(8, true);
			ps.setBoolean(9, true);
			ps.setBoolean(10, true);
			ps.setLong(11, libId);
			ps.setLong(12, masterId);
			ps.setDate(13, program.getDate());
			ps.setDate(14, null);
			ps.setDate(15, null);
			ps.setDate(16, null);
			ps.setString(17, program.getDescription());
			ps.setString(18, null);
			ps.setLong(19, libId);
			ps.setInt(20, 0);
			ps.setInt(21, 0);
			ps.setInt(22, 0);
			ps.setInt(23, 0);
			ps.setInt(24, 0);
			ps.setString(25, null);
			ps.setString(26, null);
			ps.setInt(27, 1);
			ps.setString(28, program.getId());
			ps.setString(29, program.getTitle());
			ps.setInt(30, 1);
			ps.setInt(31, 1);
			ps.setInt(32, 1);
			ps.setString(33, null);
			ps.setString(34, null);
			ps.setString(35, null);
			ps.setInt(36, 0);
			ps.setInt(37, 0);
			ps.setInt(38, 0);
			ps.setInt(39, 0);
			ps.setInt(40, 1);
			ps.setInt(41, 0);
			ps.setInt(42, 0);
			ps.setLong(43, categoryId);
			ps.setLong(44, categoryId);
			ps.setDate(45, null);
			ps.setInt(46, 0);
			ps.setInt(47, 1);
			ps.setLong(48, categoryId);
			ps.setString(49, null);
			ps.setLong(50, 0);
			ps.setLong(51, 0);
			ps.setString(52, null);
			ps.setFloat(53, 0);
			ps.setString(54, null);
			ps.setString(55, null);
			ps.setString(56, null);
			ps.setString(57, null);
			ps.setBoolean(58, false);

		}

	}
}
