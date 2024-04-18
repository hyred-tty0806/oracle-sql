package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Emp;

public class EmpDAO {
	public static ArrayList<HashMap<String, Object>> selectEmpAndDeptList() throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT"
				+ " emp.empno empNo, emp.ename ename,"
				+ " dept.deptno deptNo, dept.dname dname "
				+ " FROM emp INNER JOIN dept"
				+ " ON emp.deptno = dept.deptno";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		HashMap<String, Object> m = new HashMap<>();
		while(rs.next()) {
			m.put("empNo", rs.getInt("empNo"));
			m.put("ename", rs.getInt("ename"));
			m.put("dname", rs.getInt("dname"));
			list.add(m);
		}
		
		return list;
	}
	
	// VO 사용
	public ArrayList<Emp> selectDeptList() throws Exception{
		ArrayList<Emp> list = new ArrayList<>();
		
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT"
				+ " empno empNo, ename, sal"
				+ " FROM emp";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Emp e = new Emp();
		while(rs.next()) {
			e.empno = rs.getInt("empNo");
			e.ename = rs.getString("ename");
			e.sal = rs.getDouble("sal");
			list.add(e);
		}
		return list;
	}
}
