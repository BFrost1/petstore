<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<c:forEach var="category" items="${categories}">
	<a href="./shop?category=${category.id}" class='${category.icon}'> ${category.name}</a>
</c:forEach>