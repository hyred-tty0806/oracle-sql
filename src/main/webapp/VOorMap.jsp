<%@page import="java.util.HashMap"%>
<%@page import="vo.Dept"%>
<%@page import="dao.DeptDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.DBHelper"%>
	<!-- Controller(컨트롤러) -->
<% 
	ArrayList<Dept> list = DeptDAO.selectDeptList();
 	ArrayList<HashMap<String, Object>> listMap = DeptDAO.selectDeptOnOffList();
%>

<!-- View(뷰) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dept VO List</h1>
<table border="1">
<% for(Dept d : list){ %>
	<tr>
		<th><%=d.deptNo %></th>
		<th><%=d.dname %></th>
		<th><%=d.loc %></th>
		<th><%=d.onOff %></th>
	</tr>
<%} %>
<h1>Dept MAP List</h1>
<table border="1">
<% for(HashMap<String, Object> m : listMap){ %>
	<tr>
		<th><%=m.get("deptNo") %></th>
		<th><%=m.get("dname") %></th>
		<th><%=m.get("loc") %></th>
		<th><%=m.get("onOff") %></th>
	</tr>
<%} %>
</table>
</body>
</html>