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
    <title>我的商城 | 控制面板</title>
    <jsp:include page="../includes/header.jsp" />
    <link rel="stylesheet" href="../../assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css">
    <link rel="stylesheet" href="/assets/plugins/dropzone/dropzone.css"/>
    <link rel="stylesheet" href="/assets/plugins/dropzone/min/basic.min.css"/>
    <link rel="stylesheet" href="/assets/plugins/wangEditor-3.0.16/release/wangEditor.min.css"/>
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
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbContent.id == null ? "新增":"编辑"}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="categoryId" class="col-sm-2 control-label">父级类目</label>

                                    <div class="col-sm-10">
                                        <form:hidden id="categoryId" path="tbContentCategory.id"></form:hidden>
                                        <input id="categoryName" class="form-control" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-info" value="${tbContent.tbContentCategory.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title"  class="col-sm-2 control-label">标题</label>

                                    <div class="col-sm-10">
                                        <form:input path="title" type="text" cssClass="form-control" placeholder="标题"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="subTitle"  class="col-sm-2 control-label">子标题</label>

                                    <div class="col-sm-10">
                                        <form:input path="subTitle" type="text" cssClass="form-control" placeholder="子标题"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="titleDesc"  class="col-sm-2 control-label">标题描述</label>

                                    <div class="col-sm-10">
                                        <form:input path="titleDesc" type="text" cssClass="form-control" placeholder="标题描述"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="url"  class="col-sm-2 control-label">链接</label>

                                    <div class="col-sm-10">
                                        <form:input path="url" type="text" cssClass="form-control" placeholder="链接"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pic"  class="col-sm-2 control-label">图片1</label>

                                    <div class="col-sm-10">
                                        <form:input path="pic" type="text" cssClass="form-control" placeholder="图片1"/>
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pic2"  class="col-sm-2 control-label">图片2</label>

                                    <div class="col-sm-10">
                                        <form:input path="pic2" type="text" cssClass="form-control" placeholder="图片2"/>
                                        <div id="dropz2" class="dropzone"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">详情</label>

                                    <div class="col-sm-10">
                                        <form:hidden path="content"/>
                                        <%--<form:textarea rows="4"  path="content" type="text" cssClass="form-control" placeholder="详情"/>--%>
                                        <div id="editor">${tbContent.content}</div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="submit" id="btnSubmit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form:form>
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
    <jsp:include page="../includes/footer.jsp"/>
</div>
<sys:modal message="<ul id='myTree' class='ztree'></ul>" title="请选择"/>

<script src="/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/assets/plugins/wangEditor-3.0.16/release/wangEditor.min.js"></script>
<script>
    $(function (){
        App.initZtree("/content/category/tree/data",["id"],function (nodes) {
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $('#modal-info').modal("hide");
        });

    });
    App.WangEditor("#editor","/upload","#content");

    App.initDropzone({
        id:"#dropz",
        url:"/upload",
        init: function () {
            // 上传成功触发的事件,data为后端传过来的数据
            this.on("success", function (file, data) {
                $("#pic").val(data.fileName);
            });
        }
    });

    App.initDropzone({
        id:"#dropz2",
        url:"/upload",
        init: function () {
            // 上传成功触发的事件,data为后端传过来的数据
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });

</script>

</body>
</html>
