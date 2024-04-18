package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbUser = "admin";
		
		
		FileReader fr = new FileReader("D:\\dev\\auth\\oracle.properties");
		Properties prop = new Properties();
		prop.load(fr);
		String dbPw = prop.getProperty("dbPw");
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		return conn;
	}
	
	// getConnection() 메서드 디버깅용 테스트 코드
	public static void main(String[] args) throws Exception {
		Connection conn = new DBHelper().getConnection();
		System.out.println("conn : " + conn);
	}
}
