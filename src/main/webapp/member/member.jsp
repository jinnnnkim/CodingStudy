<%@page import="java.util.List"%>
<%@page import="kr.co.loginDB.MemberVO"%>
<%@page import="kr.co.loginDB.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
	
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	
	MemberVO memberVO = new MemberVO(id, pwd, name, tel);
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(memberVO);
	List<MemberVO> membersList = memberDAO.listMembers();
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 목록 출력</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#CEE3F6">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">전화번호</td>
			<td width="5%">가입일</td>
		</tr>
		<%
			if(membersList.size() == 0) {
		%>
			<tr>
				<td colspan="5">
					<p align="center">
						<b><span style="font-size: 9pt">등록된 회원이 없습니다.</span></b>
				</td>
			</tr>
		<%
			}
			else {
				for(int i = 0; i<membersList.size(); i++) {
					MemberVO bean = membersList.get(i);
		%>
					<tr align="center">
						<td><%=bean.getId() %></td>
						<td><%=bean.getPwd() %></td>
						<td><%=bean.getName() %></td>
						<td><%=bean.getTel() %></td>
						<td><%=bean.getRegDate() %></td>
					</tr>
		<%
				}
			}
		%>
					<tr height="1" bgcolor="#CEE3F6">
						<td colspan="5"></td>
					</tr>
	</table>
</body>
</html>