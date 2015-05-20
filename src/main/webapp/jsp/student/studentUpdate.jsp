<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/updateStudent.action"
		name="studentForm" method="post">
		<table>
			<tr>
				<td>student name</td>
				<td><input type="text" value="<c:property value="studentVO.studentName"/>" name="studentVO.studentName"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="submit" onclick="submitAddStudent();">
					<input type="hidden" value="<c:property value="studentVO.studentNo"/>" name="studentVO.studentNo"/>
				</td>
			</tr>
		</table>
	</form>

	<script language="javascript">
		function submitAddStudent() {
			document.studentForm.submit();
			window.opener.location.reload();
			window.close();
		}
	</script>
</body>
</html>