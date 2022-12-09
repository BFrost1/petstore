<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@include file="/WEB-INF/views/components/header.jsp"%>
	<main>
		Hello, ${sessionScope.user.firstName} 
	</main>
<%@include file="/WEB-INF/views/components/footer.jsp"%>