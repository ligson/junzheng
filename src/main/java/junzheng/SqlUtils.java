package junzheng;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlUtils {

	/***
	 * 反射对象值
	 * 
	 * @param dbObject
	 * @return [[字段名、字段类型、字段值],[字段名、字段类型、字段值],...]
	 */
	public static List<List<Object>> fillValue(Object dbObject) {
		List<List<Object>> params = new ArrayList<>();
		Field[] fields = dbObject.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = Character.toUpperCase(field.getName().charAt(0))
					+ field.getName().substring(1);
			String getMethodName = field.getType().getName().equals("boolean") ? "is"
					+ fieldName
					: "get" + Character.toUpperCase(field.getName().charAt(0))
							+ field.getName().substring(1);
			try {
				Method method = dbObject.getClass().getDeclaredMethod(
						getMethodName);
				Object object = method.invoke(dbObject);
				List<Object> objects = new ArrayList<Object>();
				objects.add(field.getName());
				objects.add(field.getType());
				objects.add(object);
				params.add(objects);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return params;
	}

	/***
	 * 返回预编译的sql语句
	 * 
	 * @param params
	 * @param tableName
	 * @return
	 */
	public static String buildSql(List<List<Object>> params, String tableName) {
		StringBuffer fieldBuffer = new StringBuffer("");
		StringBuffer valueBuffer = new StringBuffer("");
		for (List<Object> param : params) {
			String fieldName = (String) param.get(0);
			// Class<?> fieldType = (Class<?>) param.get(1);
			// Object object = param.get(2);
			fieldBuffer.append(fieldName);
			fieldBuffer.append(",");
			valueBuffer.append("?,");
		}
		String sql = "insert into " + tableName + "("
				+ fieldBuffer.deleteCharAt(fieldBuffer.length() - 1).toString()
				+ ") values("
				+ valueBuffer.deleteCharAt(valueBuffer.length() - 1).toString()
				+ ")";
		return sql;
	}

	/***
	 * 执行sql插入
	 * 
	 * @param params
	 * @param sql
	 * @param connection
	 * @throws Exception
	 */
	public static void insert(List<List<Object>> params, String sql,
			Connection connection) throws Exception {
		PreparedStatement ps = connection.prepareStatement(sql);
		for (int i = 0; i < params.size(); i++) {
			List<Object> param = params.get(i);
			Object object = param.get(2);
			if (object == null) {
				ps.setObject(i + 1, null);
			} else {
				ps.setObject(i + 1, object);
			}
		}
		ps.executeUpdate();
	}

	/***
	 * 插入数据
	 * 
	 * @param dbObject
	 *            数据库对象
	 * @param tableName
	 *            表名
	 * @param connection
	 *            数据库连接
	 * @throws Exception
	 */
	public static void insert(Object dbObject, String tableName,
			Connection connection) throws Exception {
		List<List<Object>> params = fillValue(dbObject);
		String preSql = buildSql(params, tableName);
		insert(params, preSql, connection);
	}

	/***
	 * 查询所有的对象
	 * 
	 * @param <E>
	 * 
	 * @param dbClass
	 * @param tableName
	 * @param connection
	 * @return
	 */
	public static <E> List<E> list(Class<E> dbClass, String tableName,
			Connection connection) {
		List<E> list = new ArrayList<>();
		Field[] fields = dbClass.getDeclaredFields();
		StringBuffer buffer = new StringBuffer();
		for (Field field : fields) {
			buffer.append(field.getName() + ",");
		}
		String sql = "select " + buffer.deleteCharAt(buffer.length() - 1)
				+ " from " + tableName;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Object objectInstance = dbClass.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					Object objectValue = rs.getObject(field.getName());
					String setMethodName = "set"
							+ Character.toUpperCase(field.getName().charAt(0))
							+ field.getName().substring(1);
					Method setMethod = dbClass.getMethod(setMethodName,
							field.getType());
					setMethod.invoke(objectInstance, objectValue);
				}
				list.add((E) objectInstance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void update(Object dbObject, String tableName,
			Connection connection) {
		Field[] fields = dbObject.getClass().getFields();
		StringBuffer buffer = new StringBuffer();
		for (Field field : fields) {
			buffer.append(field.getName() + "=?,");
		}
		String preSql = "update " + tableName + " set "
				+ buffer.deleteCharAt(buffer.length() - 1);
		try {
			PreparedStatement ps = connection.prepareStatement(preSql);
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fieldName = Character.toUpperCase(field.getName()
						.charAt(0)) + field.getName().substring(1);
				String getMethodName = field.getType().getName()
						.equals("boolean") ? "is" + fieldName : "get"
						+ Character.toUpperCase(field.getName().charAt(0))
						+ field.getName().substring(1);
				Method method = dbObject.getClass().getDeclaredMethod(
						getMethodName);
				Object object = method.invoke(dbObject);
				if (object == null) {
					ps.setObject(i + 1, null);
				} else {
					ps.setObject(i + 1, object);
				}
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
