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
	
	/*������ݿ��ѯ����*/
	public void executeQuery(String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("ִ��executeQuery(String sql)��������");
			e.printStackTrace();
		}
		
	}
	
	/*�ر����ݿ�*/
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
			System.out.println("ִ��close()��������");
			e.printStackTrace();
		}

	}
}
