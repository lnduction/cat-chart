<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 01.04.2021
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>

<br>
<br>
<div class="container" style="width: 50%; min-width: 500px;">
    <div class="panel panel-success panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
        <div class="panel-heading">
            <h5><i class="fas fa-check-double"></i>&nbsp;Registration is successful</h5>
        </div>
        <div class="panel-body">
            <h3>Use name for login</h3>
            <div align="right">
                <hr>
                <form:form action="/welcome" method="get">
                    <button type="submit" href="/welcome" class="btn btn-primary">End registration</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
