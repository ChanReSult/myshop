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
                <li class="active">用户列表</li>
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

                        <div class="box box-info box-info-search" style="display:none">
                            <div class="box-header">
                                <h3 class="box-title">高级搜索</h3>
                            </div>

                            <form:form cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-4 control-label">姓名</label>

                                                <div class="col-sm-8">
                                                    <form:input path="username" cssClass="form-control" placeholder="姓名" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="phone" class="col-sm-4 control-label">手机号</label>

                                                <div class="col-sm-8">
                                                    <form:input path="phone" cssClass="form-control" placeholder="手机号" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-4 control-label">邮箱</label>

                                                <div class="col-sm-8">
                                                    <form:input path="email" cssClass="form-control" placeholder="邮箱" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="box-footer">
                                    <button type="submit" class="btn btn-info pull-right"><i class="fa fa-fw fa-search"></i>搜索</button>
                                </div>
                            </form:form>
                        </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>

                        <div class="box-dody">
                                <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-plus"></i>新增</a>
                                <button type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/user/deleteMulti')"><i class="fa fa-fw fa-trash"></i>删除</button>
                                <a href="" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-download"></i>导入</a>
                                <a href="" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-upload"></i>导出</a>
                                <button type="button" class="btn  btn-sm btn-info " onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class="fa fa-fw fa-search"></i>搜索</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>编辑</th>
                                </tr>
                                </thead>
                                <tbody>
                               <%-- <c:forEach items="${tbUsers}" var="tbUser">
                                    <tr>
                                        <td><input id="${tbUser.id}" type="checkbox" class="minimal" /></td>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td>${tbUser.email}</td>
                                        <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                        <td>
                                            <button type="button" class="btn  btn-default" onclick="App.showDetail('/user/detail?id='+${tbUser.id})"><i class="fa fa-fw fa-search"></i>查看</button>
                                            <a href="/user/form?id=${tbUser.id}" type="button" class="btn  btn-primary"><i class="fa fa-fw fa-edit"></i>编辑</a>
                                            <button type="button" class="btn  btn-danger" onclick="App.deteleInfo('/user/delete?id='+${tbUser.id})"><i class="fa fa-fw fa-trash"></i>删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>--%>
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
    var DTcolumns = [
        {
            data: function ( row, type, val, meta ) {
                return '<input id="' + row.id +'" type="checkbox" class="minimal" />';
                console.log(row.id);
            }
        },
        { data: 'id' },
        { data: 'username' },
        { data: 'phone' },
        { data: 'email' },
        { data: 'created' },
        {
            data: function ( row, type, val, meta ) {
                var detailURL = "/user/detail?id=" + row.id;
                var deleteURL = "/user/delete?id=" + row.id;
                return '<button type="button" class="btn  btn-default" onclick="App.showDetail(\'' + detailURL + '\')"><i class="fa fa-fw fa-search"></i>查看</button>\n' +
                    '<a href="/user/form?id= '+ row.id + '" type="button" class="btn  btn-primary"><i class="fa fa-fw fa-edit"></i>编辑</a>\n' +
                    '<button type="button" class="btn  btn-danger" onclick="App.deteleInfo(\'' + deleteURL + '\')"><i class="fa fa-fw fa-trash"></i>删除</button>';
            }
        }
    ];

    App.dataTable("/user/page",DTcolumns);

</script>
</body>
</html>
