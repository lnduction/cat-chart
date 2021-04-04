<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 01.04.2021
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<div class="container" style="width: 50%; min-width: 500px;">
    <div class="panel panel-info panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
        <div class="panel-heading">
            <h5 align="center"><i class="fas fa-cat"></i>&nbsp;Hello ${profileName}!</h5>
        </div>
        <div class="panel-body" align="center">
            <h3>Begin vote?</h3>
            <br>
            <form:form action="/vote" method="get">
                <button type="submit" class="btn btn-success">BEGIN</button>
            </form:form>
        </div>
    </div>
</div>
