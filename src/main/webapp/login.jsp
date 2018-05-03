<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%> <%--use JSTL Standard Syntax--%>
<%--<%@ taglib prefix="s" uri="/struts-tags"%>--%>  <%-- for Struts2 --%> 
 
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
		  <%--insert css here--%>
		  <%--@import url('');--%>
	</style>
	<script>
		  <%--insert JScript here--%>
		  <%--<script src=""></script>--%>
	</script>
  </head>
  <body>  
    <form action="LoginServlet" method="post">  
        <table>  
            <tbody>  
                <tr>  
                    <td>用户名:</td>  
                    <td><input name="loginName" required="required" /></td>  
                </tr>  
                <tr>  
                    <td>密码:</td>  
                    <td><input type="password" name="password" required="required"></td>  
                </tr>  
            </tbody>  
            <tfoot>  
                <tr>  
                    <td colspan="2"><input type="submit" value="登录"></td>  
                </tr>  
            </tfoot>  
        </table>  
    </form>  
  </body>  
</html>
