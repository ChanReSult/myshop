/**
* @Description: 函数对象App
* @Param:
* @return:
* @Author: ReSult
* @Date: 2019/4/26
*/
var App = function () {

    //iCheck
    var _mastercheakbox;
    var _cheakbox;

    //deleteMulti
    var _idArray;

    //默认的DropZone参数
    var defaultDropzoneOpts = {
        url: "", // 文件提交地址
        method: "post",  // 也可用put
        paramName: "dropFile", // 默认为file
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        //previewsContainer:"#preview", // 上传图片的预览窗口
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传"+ this.maxFiles +"个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
    };

    /**
    * @Description: 初始化Ztree 
    * @Param:  
    * @return:  
    * @Author: ReSult
    * @Date: 2019/4/26 
    */
    var handlerInitZtree = function (url,autoParam,callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url:url,
                autoParam:autoParam,
            }
        };
        $.fn.zTree.init($("#myTree"), setting);
        $("#btnModalOk").bind("click",function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            nodes = zTree.getSelectedNodes();
            //未选择节点
            if (nodes.length == 0) {
                alert("请先选择一个父节点");
            }
            //否则
            else{
                callback(nodes)
            }
        })
    };
    
    /** 
    * @Description: 初始化iCheck 
    * @Param:  
    * @return:  
    * @Author: ReSult
    * @Date: 2019/4/26 
    */ 
    var handlerInitCheckBox = function () {
        //激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })

        //获取控制端 CheckBox
        _mastercheakbox = $('input[type="checkbox"].minimal.icheck_master');

        //获取全部 CheckBox
        _cheakbox = $('input[type="checkbox"].minimal');
    };


    /**
     * CheckBox全选功能
     */
    var handlerCheckboxAll = function () {
        _mastercheakbox.on("ifClicked",function (e) {
            //返回true，表示未选中
            if (e.target.checked == true){
                _cheakbox.iCheck("uncheck");
            }

            //否则，返回false,表示选中
            else {
                _cheakbox.iCheck("check");
            }

        })
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        //定义一个存放id数组
        _idArray = new Array();
        //遍历
        _cheakbox.each(function () {
            var _id = $(this).attr("id");
            //将选择的元素ID放进数组中
            if (_id != null && _id != "undefined" && $(this).is(":checked")){
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0){
            $("#modal-message").html("您还没有选择任何数据，请至少选择一项！");
        }
        else {
            $("#modal-message").html("您确认删除数据项？");
        }
        $('#modal-info').modal("show");

        $("#btnModalOk").bind("click",function () {
            del();
        });
        function del() {
            $('#modal-info').modal("hide");
            if(_idArray.length === 0){

            }
            else {
                setTimeout(function () {
                    $.ajax({
                        url : url,
                        type:"POST",
                        data:{"ids":_idArray.toString()},
                        dataType:"JSON",
                        //请求成功后，将html页面显示在模态框
                        success : function(data){
                            $("#btnModalOk").unbind("click");
                            if (data.status === 200) {
                                $("#btnModalOk").bind("click",function () {
                                    window.location.reload();
                                });
                            }
                            else {
                                $("#btnModalOk").bind("click",function () {
                                    $('#modal-info').modal("hide");
                                });
                            }
                            $("#modal-message").html(data.message);
                            $('#modal-info').modal("show");
                        }
                    })
                },500)
            }
        }
    };

    var handlerInitDropzone = function (opts) {
        //关闭Dropzone自动发现功能
        Dropzone.autoDiscover = false;
        //defaultDropzoneOpts继承opts
        $.extend(defaultDropzoneOpts,opts);
        var myDropzone = new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    };

    /**
     * 查看操作
     * @param url
     */
    var handlerShowDetail = function (url) {
        //用户列表查看操作：ajax执行请求，modelattribute会先执行查询操作，返回html页面
        $.ajax({
            url : url,
            type:"get",
            dataType:"html",
            //请求成功后，将html页面显示在模态框
            success : function(data){
                $('#modal-info').modal("show");
                $("#modal-message").html(data);
                $("#btnModalOk").bind("click",function () {
                    $('#modal-info').modal("hide");
                })

            }
        })
    };

    /**
     * 删除操作
     */
    var handlerDeteleInfo = function (url) {
        $("#modal-message").html("您确定删除数据项吗?");
        $('#modal-info').modal("show");
        //点击模态框确认按钮后，ajax执行删除请求:放回JSON数据
        $("#btnModalOk").bind("click",function () {
            $.ajax({
                url : url,
                type:"GET",
                dataType:"JSON",
                //删除请求成功后，执行页面刷新操作，并且提示删除是否成功信息
                success : function(data){
                    //解绑
                    $("#btnModalOk").unbind("click");
                    if (data.status == 200){
                        $("#btnModalOk").bind("click",function () {
                            window.location.reload();
                        });
                    }
                    else {
                        $("#btnModalOk").bind("click",function () {
                            $('#modal-info').modal("hide");
                        });
                    }
                    $("#modal-message").html(data.message);
                    $('#modal-info').modal("show");
                }
            })
        })
    };

    /**
     * 富文本编辑器
     * @param editorID：
     * @param url：
     * @param contentID：
     */
    var handlerWangEditor = function (editorID,url,contentID) {
        var E = window.wangEditor;
        var editor = new E(editorID);
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = url;
        editor.customConfig.uploadFileName = 'editorFile';
        editor.create();
        $("#btnSubmit").bind("click",function () {
            var contentHTML = editor.txt.html();
            $(contentID).val(contentHTML);
        })
    };
    
    var hangdlerDataTable = function (url,columns) {
        $("#dataTable").DataTable({
            //是否开启本地分页
            "paging":true,
            //控制是否显示表格左下角的信息
            "info": true,
            //是否允许用户改变表格每页显示的记录数
            "lengthChangeOpti":false,
            //是否允许Datatables开启排序
            "ordering":false,
            //是否显示处理状态(
            "processing":true,
            //是否开启服务器模式
            "serverSide":true,
            //控制Datatables的延迟渲染，可以提高初始化的速度
            "deferRender":true,
            //去掉搜索框
            "searching": false,
            //去掉显示多少项结果
            "bLengthChange": false,
            "ajax": {
                "url": url,
            },
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function( settings ) {
                handlerInitCheckBox();
                handlerCheckboxAll();
            },
            columns: columns,
        });
    }
    
    return{
        /**
        * 初始化Ztree
        */
        initZtree: function (url,autoParam,callback) {
            handlerInitZtree(url,autoParam,callback);
        },

        /**
         * 初始化checkbox
         */
        init: function(){
            handlerInitCheckBox();
            handlerCheckboxAll();
        },

        /**
         * 暴露_cheakbox
         * @returns {*}
         */
        getCheckbox:function () {
            return _cheakbox;
        },

        /**
         * 删除
         * @param url
         */
        deleteMulti:function (url) {
            handlerDeleteMulti(url);
        },

        /**
         * 图片上传
         * @param opts
         */
        initDropzone:function (opts) {
            handlerInitDropzone(opts);
        },

        /**
         * 查看
         * @param url
         */
        showDetail: function (url) {
            handlerShowDetail(url);
        },

        /**
         * 删除操作
         */
       deteleInfo: function(url){
            handlerDeteleInfo(url);
        },

        /**
         * wangEditor
         */
        WangEditor: function (editorID,url,contentID) {
            handlerWangEditor(editorID,url,contentID);
        },

        dataTable:function (url,columns) {
            hangdlerDataTable(url,columns);
        }
    }
}();


$(document).ready(function () {
    App.init();
});