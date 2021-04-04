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
    <div class="panel panel-primary panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
        <div class="panel-heading">
            <h5><i class="fas fa-cash-register"></i>&nbsp;Enter your data</h5>
        </div>
        <div class="panel-body">
            <form:form action="/sing-up" method="post" commandName="singUpForm">
                <div class="form-group">
                    <label for="first-name">Name</label>
                    <input class="form-control" id="first-name" name="name" value="${singUpForm.name}" placeholder="Name">
                    <form:errors path="name" cssClass="alert alert-danger" element="div" cssStyle="padding-bottom: 3px; padding-top: 3px; margin-bottom: 0px;"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" value="${singUpForm.password}" id="password" placeholder="Password">
                    <form:errors path="password" cssClass="alert alert-danger" element="div" cssStyle="padding-bottom: 3px; padding-top: 3px; margin-bottom: 0px;"/>
                </div>
                <div class="form-group">
                    <label for="password-confirm">Confirm password</label>
                    <input type="password" class="form-control" name="confirmPassword" value="${singUpForm.confirmPassword}" id="password-confirm" placeholder="Confirm password">
                    <form:errors path="confirmPassword" cssClass="alert alert-danger" element="div" cssStyle="padding-bottom: 3px; padding-top: 3px; margin-bottom: 0px;"/>
                </div>
                <button type="submit" class="btn btn-success" style="float: left; width: 45%">Submit</button>
            </form:form>
            <div align="right">
                <form:form action="/welcome" method="get">
                    <button type="submit" class="btn btn-primary" style="width: 45%"><i class="fas fa-undo-alt"></i>&nbsp;&nbsp;Cancel</button>
                </form:form>
            </div>
        </div>
    </div>
</div>