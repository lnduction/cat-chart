<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 02.04.2021
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <a class="navbar-brand" href="/welcome">Cats</a>
        <c:if test="${success == true}">
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-item">
                    <a class="nav-link">${profileName} <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/exit">Exit <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </c:if>
    </div>
</nav>
