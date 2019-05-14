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
<html>
<head>
    <title>我的商城 | 控制面板</title>
    <jsp:include page="../includes/header.jsp" />
    <link rel="stylesheet" href="../../assets/plugins/treeTable/themes/vsStyle/treeTable.min.css">
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
                用户管理
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
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>

                            <div class="row" style="margin-top: 20px">
                                <div class="col-xs-12">
                                    <a href="/content/category/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-plus"></i>新增</a>
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-download"></i>导入</a>
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-fw fa-upload"></i>导出</a>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>排序</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                    <tr id="${tbContentCategory.id}" pId="${tbContentCategory.parentTbContentCategory.id}">
                                        <td>${tbContentCategory.id}</td>
                                        <td>${tbContentCategory.name}</td>
                                        <td>${tbContentCategory.sortOrder}</td>
                                        <td>
                                            <a href="/content/category/form?id=${tbContentCategory.id}" type="button" class="btn  btn-primary"><i class="fa fa-fw fa-edit"></i>编辑</a>
                                            <a href="#" type="button" class="btn  btn-danger"><i class="fa fa-fw fa-trash"></i>删除</a>
                                            <a href="/content/category/form?parentTbContentCategory.id=${tbContentCategory.id}&parentTbContentCategory.name=${tbContentCategory.name}" type="button" class="btn  btn-default"><i class="fa fa-fw fa-plus"></i>新增下级菜单</a>
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
<script src="/assets/plugins/treeTable/jquery.treeTable.min.js"></script>

<script>
    $(function () {
        //根据id初始化
        $("#treeTable").treeTable({
            column:1,
            expandLevel : 2,

        });
    });
</script>
</body>
</html>
