<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 01.04.2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
    <div class="panel panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
        <div class="panel-body bg-info">
            <br>
            <div class="col-md-1 col-sm-1 col-xs-1" ></div>
            <div class="col-md-4 col-sm-4 col-xs-4" align="center">
                <div class="panel panel-success" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
                    <div class="panel-body">
                        <img class="img_wrap" style="width:100%" src="${firstCat.photo}">
                    </div>
                </div>
                <form:form action="/vote?win=${firstCat.id}&lose=${secondCat.id}" method="post">
                    <div align="center"><button type="submit" class="btn btn-success" style="width: 45%">${firstCat.name}</button></div>
                </form:form>
            </div>
            <div class="col-md-2 col-sm-2 col-xs-2"></div>
            <div class="col-md-4 col-sm-4 col-xs-4" align="center">
                <div class="panel panel-success" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
                    <div class="panel-body">
                        <img class="img_wrap" style="width:100%" src="${secondCat.photo}">
                    </div>
                </div>
                    <form:form action="/vote?win=${secondCat.id}&lose=${firstCat.id}" method="post">
                        <div align="center"><button type="submit" class="btn btn-success" style="width: 45%">${secondCat.name}</button></div>
                    </form:form>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
        </div>
    </div>
    </div>
    <div class="col-md-1 col-sm-1 col-xs-1"></div>
</div>
<br>
<div class="row">
<h3 align="center">Chose the best kitty!</h3>
</div>