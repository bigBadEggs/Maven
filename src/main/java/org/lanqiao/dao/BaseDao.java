package org.lanqiao.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
	// c3p0配置 提供私有化数据源
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	// 提供获得数据源
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	//提供获得连接
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

	Class<T> clazz;
	//反射获得clazz
	public BaseDao() {
		clazz = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	// DML
	public int executeUpdate(String sql, Object[] obj) {
		Connection conn = null;
		PreparedStatement stat = null;
		int ret = 0;
		try {
			conn = getConnection();
			// 3、创建传输对象statmemnt
			stat = conn.prepareStatement(sql);// ？不确定:类型、数量
			// 3+、绑定替换数据
			for (int i = 0; i < obj.length; i++) {
				stat.setObject(i + 1, obj[i]);
			}
			// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
			ret = stat.executeUpdate();
			// 5、如果返回rs类型的数据，需要将数据转换成list
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	// DQL
		public List<T> executeQuery(String sql, Object[] obj) {
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs = null;
			List<T> list = new ArrayList<T>();
			try {
				conn = getConnection();
				// 3、创建传输对象statmemnt
				stat = conn.prepareStatement(sql);// ？不确定:类型、数量
				// 3+、绑定替换数据
				for (int i = 0; i < obj.length; i++) {
					stat.setObject(i + 1, obj[i]);
				}
				// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
				rs = stat.executeQuery();
				// 5、如果返回rs类型的数据，需要将数据转换成list
				ResultSetMetaData rsmd = rs.getMetaData();//列名信息
				int columuCount = rsmd.getColumnCount();//列的数量
				while (rs.next()) {
					T t = (T) clazz.newInstance();//创建对象
					for (int i = 0; i < columuCount; i++) {//封装数据
						Field f = clazz.getDeclaredField(rsmd.getColumnName(i + 1));//列名->属性名->属性对象
						f.setAccessible(true);
						f.set(t, rs.getObject(i + 1));//将rs列中的值赋给属性
					}
					list.add(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// DQL
		public List<T> executeQuery(String sql) {
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs = null;
			List<T> list = new ArrayList<T>();
			try {
				conn = getConnection();
				// 3、创建传输对象statmemnt
				stat = conn.prepareStatement(sql);// ？不确定:类型、数量
				// 3+、绑定替换数据
				// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
				rs = stat.executeQuery();
				// 5、如果返回rs类型的数据，需要将数据转换成list
				ResultSetMetaData rsmd = rs.getMetaData();//列名信息
				int columuCount = rsmd.getColumnCount();//列的数量
				while (rs.next()) {
					T t = (T) clazz.newInstance();//创建对象
					for (int i = 0; i < columuCount; i++) {//封装数据
						Field f = clazz.getDeclaredField(rsmd.getColumnName(i + 1));//列名->属性名->属性对象
						f.setAccessible(true);
						f.set(t, rs.getObject(i + 1));//将rs列中的值赋给属性
					}
					list.add(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// 查询数据条数
		public int getRecordCount(String sql) {
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs = null;
			int count = 0;
			try {
				conn = getConnection();
				// 3、创建传输对象statmemnt
				stat = conn.prepareStatement(sql);// ？不确定:类型、数量
				// 3+、绑定替换数据
				// 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
				rs = stat.executeQuery();
				// 5、如果返回rs类型的数据，需要将数据转换成list
				if (rs.next()){
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
		}
}
