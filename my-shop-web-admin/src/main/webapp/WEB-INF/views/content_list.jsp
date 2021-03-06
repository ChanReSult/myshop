<%--
  Created by IntelliJ IDEA.
  User: 程伟钊
  Date: 2019/4/17
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- /.sidebar -->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div id="baseResult" class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <font>${baseResult.message}</font>
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容列表</h3>

                            <div class="row" style="margin-top: 20px">
                                <div class="col-xs-12">
                                    <a href="/content/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-plus"></i>新增</a>
                                    <a href="" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-download"></i>导入</a>
                                    <a href="" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-upload"></i>导出</a>
                                    <button type="button" class="btn  btn-sm btn-info " onclick="f('searchDiv')"><i class="fa fa-fw fa-search"></i>搜索</button>
                                </div>
                            </div>

                            <div class="row" style="margin-top: 20px" >
                                <form:form cssClass="form-horizontal" action="/tbContent/search" method="post" modelAttribute="tbContent">
                                    <div class="row" id="searchDiv" style="display:none">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="title" class="col-sm-3 control-label">用户名</label>

                                                <div class="col-sm-8">
                                                    <form:input path="title" cssClass="form-control" placeholder="用户名" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="subTitle" class="col-sm-3 control-label">手机号</label>

                                                <div class="col-sm-8">
                                                    <form:input path="subTitle" cssClass="form-control" placeholder="手机号" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="titleDesc" class="col-sm-3 control-label">邮箱</label>

                                                <div class="col-sm-8">
                                                    <form:input path="titleDesc" cssClass="form-control" placeholder="邮箱" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <div class="col-sm-8" style="margin-right: -30px">
                                                    <button type="submit" class="btn btn-block pull-right">搜索</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" style="white-space:nowrap">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal" /></th>
                                    <th>ID</th>
                                    <th>所属分类</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题描述</th>
                                    <th>链接</th>
                                    <th>图片1</th>
                                    <th>图片2</th>
                                    <th>变更时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbContents}" var="tbContent">
                                    <tr>
                                        <td><input type="checkbox" class="minimal" /></td>
                                        <td>${tbContent.id}</td>
                                        <td>${tbContent.tbContentCategory.name}</td>
                                        <td>${tbContent.title}</td>
                                        <td>${tbContent.subTitle}</td>
                                        <td>${tbContent.titleDesc}</td>
                                        <td><a href="${tbContent.url}" target="_blank">查看</a></td>
                                        <td><a href="${tbContent.pic}" target="_blank">查看</a></td>
                                        <td><a href="${tbContent.pic2}" target="_blank">查看</a></td>
                                        <td><fmt:formatDate value="${tbContent.updated}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                        <td>
                                            <button type="button" class="btn  btn-default" onclick="App.showDetail('/content/detail?id='+ ${tbContent.id})"><i class="fa fa-fw fa-search"></i>查看</button>
                                            <a href="/content/form?id=${tbContent.id}" type="button" class="btn  btn-primary"><i class="fa fa-fw fa-edit"></i>编辑</a>
                                            <button type="button" class="btn  btn-danger" onclick="App.deteleInfo('/content/delete?id='+ ${tbContent.id})"><i class="fa fa-fw fa-trash"></i>删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<!-- 自定义模态框 -->
<sys:modal/>
<script>


</script>
</body>
</html>
