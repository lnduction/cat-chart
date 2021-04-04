<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 01.04.2021
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cats" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/static/css/font-awesome.css">
    <link rel="stylesheet" href="/static/css/all.css">
    <link rel="stylesheet" href="/static/css/fileinput.css">
    <link rel="stylesheet" href="/static/css/styles/progress-tracker.css">
    <link rel="stylesheet" href="/static/css/styles/site.css">
    <link rel="icon" type="image/png" href="/icon.png">

</head>
<head>
    <title>Cats</title>
    <cats:head/>
</head>
<body>

<section class="main">
    <sitemesh:write property='body'/>
</section>

<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/all.js"></script>
<script src="/static/js/fileinput.js"></script>

</body>
</html>
