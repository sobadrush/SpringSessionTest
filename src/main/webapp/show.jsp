<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
	<body>  
	    输出session中的值:  
	    <%  
	    if (request.getSession().getAttribute("login") == null) {  
	        response.sendRedirect(request.getContextPath() + "/login.jsp");  
	    }  
		%>  
	    <%  
	    	java.util.Enumeration<String> enumeration = request.getSession().getAttributeNames();  
	        while (enumeration.hasMoreElements()) {  
	            String key = enumeration.nextElement();  
	            Object value = request.getSession().getAttribute(key);  
	            out.println(key + " --- " + value);  
	        }  
	    %>  
	    <br>  
	    ----------------------  
	    jsessionId:<%=request.getSession().getId()%>  
	    ----------------------  
	    <%=request.getRemoteAddr()%>  
	    <%=request.getRemotePort()%>  
	    <%=request.getRemoteHost()%>  
	    <%=request.getRemoteUser()%>  
	    <%=request.getHeader("X-Real-IP")%>  
	    <%=request.getHeader("Host")%>  
	    <%=request.getHeader("X-Forwarded-For")%>  
	    <%=request.getLocalPort()%>  
	</body> 
</html>
