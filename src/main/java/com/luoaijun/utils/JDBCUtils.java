package com.luoaijun.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
  

/**
 * 
 * TODO JDBCUtils 相关工具类
 * 
 * @author 罗爱军
 * @date 2018年3月8日
 * @email 3191287315@qq.com
 * @package JDBCUtils-StudentInfoSystemcom.luoaijun.libraryJDBC.java
 * @describe TODO:
 * @include :
 * @category :
 */
public class JDBCUtils {
	static Statement statement = null;
	public ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	public JdbcTemplate jdbcTemplate;

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		JDBCUtils.statement = statement;
	}

	/**
	 * TODO 返回一个jdbcTmeplate
	 * 
	 * @return
	 */
	public JdbcTemplate geTemplate() {
		jdbcTemplate = context.getBean("template", JdbcTemplate.class);
		return jdbcTemplate;
	}

	/**
	 * TODO 使用prepareStatement 执行添加删除操作
	 * 
	 * @param conn
	 * @param sql
	 * @param obj
	 */
	public static int excutePreUpdate(String sql, Object... obj) {
		PreparedStatement pps = null;

		try {
			pps = getPreStatement(sql, obj);
			return pps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}

	/**
	 * TODO 使用prepareStatement 执行查询修改操作
	 * 
	 * @param conn
	 * @param sql
	 * @param obj
	 * @return resultSet
	 */
	public static ResultSet executPreQuery(String sql, Object... obj) {
		PreparedStatement pps = null;
		ResultSet resultSet = null;

		try {
			pps = getPreStatement(sql, obj);
			resultSet = pps.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * TODO 获取一个prepareStatement
	 * 
	 * @param conn
	 * @param sql
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement getPreStatement(String sql, Object... obj) throws SQLException {
		Connection conn = JDBCUtils.getConnect();
		PreparedStatement pps = null;
		pps = (PreparedStatement) conn.prepareStatement(sql);
		for (int i = 0; i < obj.length; i++) {
			pps.setObject(i + 1, obj[i]);
		}
		return pps;

	}

	/**
	 * TODO 获取一个jdbc连接
	 * 
	 * @param str
	 * @return Connection
	 * @throws Exception
	 */
	public Connection getConnection(String str) throws Exception {
		String driver = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		try {
			InputStream inStream = getClass().getClassLoader().getResourceAsStream("mysql.properties");
			Properties properties = new Properties();
			properties.load(inStream);
			driver = properties.getProperty("jbdc.driver");
			jdbcUrl = str;
			user = properties.getProperty("jbdc.user");
			password = properties.getProperty("jbdc.password");
			Class.forName(driver);// 加载驱动 Java项目中可以不加载，Javaweb中必须加载
			Connection connection = (Connection) DriverManager.getConnection(jdbcUrl, user, password);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * TODO 获取连接
	 * 
	 * @return
	 */
	public static Connection getConnect() {
		String url = "jdbc:mysql://localhost:3306/";
		try {
			return (new JDBCUtils()).getConnection(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * TODO 使用statemen 执行删除添加操作
	 * 
	 * @return 无返回
	 * @param connection
	 * @param sql
	 */
	public static void execteUpdateSql(Connection connection, String sql) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * TODO 使用statement 获取一个更新查询操作的resultSet
	 * 
	 * @param connection
	 * @param sql
	 * @return ResultSet
	 */
	public static ResultSet execteQuerySql(Connection connection, String sql) {
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * TODO 关闭jdbc相关连接
	 * 
	 * @param statement
	 * @param c
	 */
	public static void close(Statement statement, Connection c) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (c != null) {
				c.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * TODO 判断jdbc连接是否存在，并返回一个connection
	 * 
	 * @param connection
	 * @param connectionStr
	 * @return connection
	 * @throws Exception
	 */
	public Connection isConnect(Connection connection, String connectionStr) throws Exception {
		if (connection == null) {
			return connection = (new JDBCUtils()).getConnection(connectionStr);
		}
		return connection;
	}

	/**
	 * TODO 获取一个list<T>
	 * 
	 * @param connectStr
	 * @param clazz
	 * @param sql
	 * @param para
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> getBeanList(Class<T> clazz, String sql, Object... para) throws Exception {
		List<T> list = new ArrayList<T>();
		PreparedStatement pps = JDBCUtils.getPreStatement(sql, para);
		ResultSet resultSet = pps.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columCount = metaData.getColumnCount();

		while (resultSet.next()) {
			T t = clazz.newInstance();
			for (int i = 0; i < columCount; i++) {
				String columName = metaData.getColumnLabel(i + 1);
				Object values = resultSet.getObject(i + 1);
				Field field = clazz.getDeclaredField(columName);
				field.setAccessible(true);
				field.set(t, values);
			}
			list.add(t);
		}
		return list;

	}

	/**
	 * TODO 获取总列数
	 * 
	 * @param conn
	 * @param sql
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public static int getCount(ResultSet resultSet) throws SQLException {
		int count = 0;
		if (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;

	}

	public static void printSys(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			System.out.println();
		}
	}

	public static ResultSet getResultSet(Connection conn, String sql, Object... obj) throws SQLException {
		PreparedStatement pps = JDBCUtils.getPreStatement(sql, obj);
		ResultSet resultSet = pps.executeQuery();
		return resultSet;
	}

}
