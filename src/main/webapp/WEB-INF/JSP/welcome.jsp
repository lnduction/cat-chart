<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 01.04.2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>

<br>
<br>
<div class="container" style="width: 50%; min-width: 500px;">
    <div class="panel panel-primary panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
        <div class="panel-heading"><h5><i class="fas fa-external-link-alt"></i>&nbsp;Enter to your profile</h5></div>
        <div class="panel-body">
            <h5>Use your name</h5>
                <form:form action="/welcome" method="post" commandName="singInForm">
                <div class="form-group">
                    <label for="login">Name</label>
                    <input class="form-control" id="login" name="item.name" value="${singInForm.item.name}" placeholder="Name">
                    <form:errors path="item.name" cssClass="alert alert-danger" element="div" cssStyle="padding-bottom: 3px; padding-top: 3px; margin-bottom: 0px;"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="item.password" value="${singInForm.item.password}" id="password" placeholder="Password">
                    <form:errors path="item.password" cssClass="alert alert-danger" element="div" cssStyle="padding-bottom: 3px; padding-top: 3px; margin-bottom: 0px;"/>
                </div>
                <hr>
                <button type="submit" class="btn btn-success" style="float: left; width: 45%">Sing in</button>
                </form:form>
            <form:form action="/sing-up" method="get">
                <div align="right"><button type="submit" class="btn btn-primary" style="width: 45%"><i class="fas fa-user-plus"></i>&nbsp;&nbsp;&nbsp;&nbsp;Sing up</button></div>
            </form:form>
        </div>
    </div>
</div>
