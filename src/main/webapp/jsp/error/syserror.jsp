 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>System Error</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
.td1 {
	font-size: 14px;
	color: #015298;
	height: 38px;
	padding-top: 18px;
	padding-left: 34px;
}
.td2 {
	height: 261px;
	padding-top: 53px;
	padding-left: 125px;
	vertical-align: top;
}
.big1 {
	font-size: 14px;
	font-weight: bold;
	color: #015298;
	height: 30px;
}
.little1 {
	font-size: 12px;
	line-height: 22px;
	color: #015298;
}
-->
</style>
</head>

<body>
<table width="539" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="<%=request.getContextPath()%>/images/error_03.gif" class="td1">Error Information</td>
  </tr>
  <tr>
    <td height="261" background="<%=request.getContextPath()%>/images/error_05.gif" class="td2"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="big1">System error, caused by：</td>
        </tr>
        <tr>
          <td class="little1">・System busy, pls try again later。<br>
            ・Database busy, pls quit and login again。</td>
        </tr>
        <tr>
        	<td>
        		<html:errors/>
        	</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td><img src="<%=request.getContextPath()%>/images/error_06.gif" width="539" height="16"></td>
  </tr>
</table>
</body>
</html>
