<%--
  Created by IntelliJ IDEA.
  User: 程伟钊
  Date: 2019/4/17
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>我的商城 | 控制面板</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body table-responsive no-padding">
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>标题</th>
            <th>子标题</th>
            <th>标题描述</th>
            <th>链接</th>
        </tr>
        <tr>
            <td>${tbContent.id}</td>
            <td>${tbContent.title}</td>
            <td>${tbContent.subTitle}</td>
            <td>${tbContent.titleDesc}</td>
            <td>${tbContent.url}</td>
        </tr>
    </table>
</div>

</body>
</html>
