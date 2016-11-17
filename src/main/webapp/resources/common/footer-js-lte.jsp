<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<%--<script src="${jsPath}/bootstrap/ie-emulation-modes-warning.js"></script>--%>
<%--<script src="${jsPath}/bootstrap/ie8-responsive-file-warning.js"></script>--%>
<script src="${jsPath}/jquery/2.0.2/jquery.min.js"></script>
<script src="${jsPath}/bootstrap/bootstrap.min.js"></script>
<%--<script src="${jsPath}/bootstrap/bootstrapValidator.min.js"></script>--%>
<%--<script src="${jsPath}/bootstrap/locales/bootstrapValidator.zh_CN.js"></script>--%>
<script src="${jsPath}/bootstrap/bootstrap-datetimepicker.min.js"></script>
<script src="${jsPath}/bootstrap/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${jsPath}/AdminLTE/app.js"></script>
<script language="JavaScript">
    $(function() {
        openPage('<%=MenuEnum.TREE_ID_CAROUSEL_LIST.getCode()%>','<%=MenuEnum.TREE_ID_CAROUSEL_LIST.getUrl()%>');
    });
    var ajaxbg = $("#cover,#backgroundprogressBar");
    function showLoading(){
        ajaxbg.show();
    }
    function hideLoading(){
        ajaxbg.hide();
    }

    function openPage(treeID,url){
        showLoading();
        $(".content").load('${ctxPath}'+url,function(){
            $(".treeview-menu li").removeClass("active");
            $("#"+treeID).parent().addClass("active");
//            $(".content-header h1").text($("#"+treeID).children("span").text());
            $(".content-header h1").text($("#"+treeID).parent().parent().prev("a").children("span").text());
            $(".breadcrumb").children("li.active").text($("#"+treeID).children("span").text());
            hideLoading();
        });
    }

    function initPagination(page) {
        $("#page").val(page);
        list_sub_form($("#page").closest('form').attr("id"));
    }

    function sub_form(fromID){
        var $form = $("#"+fromID);
        $.post('${ctxPath}'+$form.attr('action'), $form.serialize(),function(data){
            if(data && data.code == 1){
                openPage(data.treeID,data.ext);
            }else{
                alert("系统异常");
            }
        },"json");
    }

    function list_sub_form(fromID){
        showLoading();
        var $form = $("#"+fromID);
        console.log($form.attr('action'));
        $(".content").load('${ctxPath}'+$form.attr('action')+"?"+$form.serialize(),function(){
            hideLoading();
        });
    }

    function sub_form_data(fromID){
        showLoading();
        var $form = $("#"+fromID);
        var form_data = new FormData($form[0]);
        $.ajax({
            url: '${ctxPath}'+$form.attr('action'),
            type: 'POST',
            data: form_data,
            cache: false,
            dataType: 'JSON',
            contentType: false, //不可缺
            processData: false, //不可缺
            success: function(data) {
                if(data && data.code == 1){
                    openPage(data.treeID,data.ext);
                }else{
                    if(data && data.message != null){
                        alert(data.message);
                    }else{
                        alert("系统异常");
                    }
                    hideLoading();
                }
            }
        });
    }

    function loadUrl(divID,url){
        showLoading();
        $("#"+divID).load('${ctxPath}'+url,function(){
            hideLoading();
        });
    }

</script>