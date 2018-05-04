﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <title>Login.jsp</title>
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
  </head>
  <body class="container">  
  
  	<h1 style="color:blue;font-family:Microsoft JhengHei;">登入頁</h1><p/>
  
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post">  
        <table class="table">  
            <tbody>  
                <tr>  
                    <td width="100">用戶名:</td>  
                    <td><input name="loginName" required="required"/></td>  
                </tr>  
                <tr>  
                    <td width="100">密碼:</td>  
                    <td><input type="password" name="password" required="required"/></td>  
                </tr>  
            </tbody>  
            <tfoot>  
                <tr>  
                    <td colspan="2">
                    	<input type="submit" value="登入" class="btn btn-default btn-lg"/>
                    	<input type="hidden" name="userAction" value="doLogin"/>
                    </td>  
                </tr>  
            </tfoot>  
        </table>  
    </form>  
  </body>  
</html>
