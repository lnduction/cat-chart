<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 01.04.2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
    <h3 align="center">Top of the best kitty!!!</h3>
    <br>
    <c:forEach var="cat" items="${topCat}" varStatus="loop">
        <div class="row">
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
            <div class="col-md-10 col-sm-10 col-xs-10">
                <div class="panel panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);">
                    <div class="panel-body bg-info">
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <br><br><br><br><br><br>
                            <h1 align="center">${loop.index + 1}</h1>
                        </div>
                        <div class="col-md-4 col-sm-5 col-xs-6">
                            <div class="panel panel-info" style="margin-right: 30px; margin-left: 30px; -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);" align="center">
                                <div class="panel-body">
                                    <img class="img_wrap" style="width:100%" src="${cat.photo}">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-5 col-xs-4">
                            <br><br><br><br><br><br>
                            <h1 align="center">${cat.name}</h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
        </div>
        <br>
    </c:forEach>
</div>
