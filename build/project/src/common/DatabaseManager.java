package common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	private Connection conn = null;
	private Statement st = null;
	public ResultSet rs = null;
	private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getSt() {
		return st;
	}
	public void setSt(Statement st) {
		this.st = st;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	/*完成数据库查询方法*/
	public void executeQuery(String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("执行executeQuery(String sql)方法出错");
			e.printStackTrace();
		}
		
	}
	
	/*关闭数据库*/
	public void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st!=null) {
				st.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e){
			System.out.println("执行close()方法出错");
			e.printStackTrace();
		}

	}
}
