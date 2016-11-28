<%--
  Created by IntelliJ IDEA.
  User: denghao
  Date: 16/4/30
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mai.tcm.security.MenuEnum,com.mai.tcm.model.TopColumn" %>
<c:set var="STATUS_OFFLINE" value="<%=TopColumn.STATUS_OFFLINE%>"/>
<c:set var="STATUS_RELEASED" value="<%=TopColumn.STATUS_RELEASED%>"/>
<%--
<c:set var="TARGET_TYPE_URL" value="<%=topColumn.TARGET_TYPE_URL%>" />
<c:set var="TARGET_TYPE_EXAM" value="<%=topColumn.TARGET_TYPE_EXAM%>" />
<c:set var="TARGET_TYPE_EVA" value="<%=topColumn.TARGET_TYPE_EVA%>" />
<c:set var="TARGET_TYPE_SCRIPT" value="<%=topColumn.TARGET_TYPE_SCRIPT%>" />--%>

<html>
<head>
    <title></title>
</head>
<body>
<div class="col-md-10">
    <!-- general form elements -->
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">
                <c:choose>
                    <c:when test="${topColumn.topColumnID != null}">修改一级栏目</c:when>
                    <c:otherwise>新增一级栏目</c:otherwise>
                </c:choose>
            </h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form role="form" method="post" action="${ctxPath}/w/topColumn/addOrUpdateTopColumn" id="topColumn_form" name="topColumn_form"
              >
            <input type="hidden" name="topColumnID" value="${topColumn.topColumnID}">
            <input type="hidden" id="topColumnStatus" name="status" value="${topColumn.status}">

            <div class="box-body">
                <div class="form-group">
                    <label for="title">名称</label>
                    <input type="text" name="title" value="${topColumn.title}" placeholder="名称" id="title"
                           class="form-control">
                </div>

                <div class="form-group">
                    <label for="sortNO">权重值</label>
                    <input type="number" class="form-control" placeholder="权重" id="sortNO"
                           value="${topColumn.sortNO==null?0:topColumn.sortNO}"
                           name="sortNO" min="0" max="100">
                </div>


                <%--<div class="form-group" id="tpDIV">--%>
                    <%--<label for="targetParameter">跳转URL</label>--%>
                    <%--<input type="text" class="form-control" id="targetParameter" name="targetParameter"--%>
                           <%--placeholder="栏目跳转URL"--%>
                           <%--value="${topColumn.targetParameter}">--%>
                    <%--<input type="hidden" id="targetType" name="targetType" value="4">&lt;%&ndash;跳转类型,跳转外网路径&ndash;%&gt;--%>
                <%--</div>--%>

               <%-- <div class="form-group" id="tpDIV">
                    <label for="abstracts">摘要</label>
                    <input type="text" class="form-control" id="abstracts" name="abstracts" placeholder="新闻摘要"
                           value="${topColumn.abstracts}">
                </div>--%>

                <%--<div class="form-group" id="tpDIV">
                    <label for="content">内容</label>
                    <input type="text" class="form-control" id="content" name="content" placeholder="新闻内容"
                           value="${topColumn.content}">
                </div>--%>
            </div>
            <!-- /.box-body -->

            <div class="box-footer">
                <button class="btn btn-primary" type="button" onclick="sub_topColumn('topColumn_form',${STATUS_RELEASED})">保存并发布
                </button>
                <button class="btn btn-primary" type="button" onclick="sub_topColumn('topColumn_form',${STATUS_OFFLINE})">保存
                </button>
                <button class="btn btn-primary" type="button"
                        onclick="openPage('<%=MenuEnum.TREE_ID_TOPCOLUMN_LIST.getCode()%>','<%=MenuEnum.TREE_ID_TOPCOLUMN_LIST.getUrl()%>');">
                    取消
                </button>
            </div>
        </form>
    </div>
    <!-- /.box -->
</div>
</body>
</html>
<script>


    function sub_topColumn(formID, status) {
        $("#topColumnStatus").val(status);
        sub_form_data(formID);
    }


</script>