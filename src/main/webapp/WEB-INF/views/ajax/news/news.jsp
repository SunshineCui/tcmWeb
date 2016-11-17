<%--
  Created by IntelliJ IDEA.
  User: denghao
  Date: 16/4/30
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mai.tcm.security.MenuEnum,com.mai.tcm.model.News" %>
<c:set var="STATUS_OFFLINE" value="<%=News.STATUS_OFFLINE%>"/>
<c:set var="STATUS_RELEASED" value="<%=News.STATUS_RELEASED%>"/>
<%--
<c:set var="TARGET_TYPE_URL" value="<%=news.TARGET_TYPE_URL%>" />
<c:set var="TARGET_TYPE_EXAM" value="<%=news.TARGET_TYPE_EXAM%>" />
<c:set var="TARGET_TYPE_EVA" value="<%=news.TARGET_TYPE_EVA%>" />
<c:set var="TARGET_TYPE_SCRIPT" value="<%=news.TARGET_TYPE_SCRIPT%>" />--%>

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
                    <c:when test="${news.newsID != null}">修改新闻资讯</c:when>
                    <c:otherwise>新增新闻资讯</c:otherwise>
                </c:choose>
            </h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form role="form" method="post" action="${ctxPath}/w/news/addOrUpdateNews" id="news_form" name="news_form"
              >
            <input type="hidden" name="newsID" value="${news.newsID}">
            <input type="hidden" id="newsStatus" name="status" value="${news.status}">

            <div class="box-body">
                <div class="form-group">
                    <label for="title">名称</label>
                    <input type="text" name="title" value="${news.title}" placeholder="名称" id="title"
                           class="form-control">
                </div>

                <div class="form-group">
                    <label for="sortNO">权重值</label>
                    <input type="number" class="form-control" placeholder="权重" id="sortNO"
                           value="${news.sortNO==null?0:news.sortNO}"
                           name="sortNO" min="0" max="100">
                </div>


                <div class="form-group" id="tpDIV">
                    <label for="targetParameter">跳转URL</label>
                    <input type="text" class="form-control" id="targetParameter" name="targetParameter"
                           placeholder="新闻跳转URL"
                           value="${news.targetParameter}">
                    <input type="hidden" id="targetType" name="targetType" value="4"><%--跳转类型,跳转外网路径--%>
                </div>

                <div class="form-group" id="tpDIV">
                    <label for="abstracts">摘要</label>
                    <input type="text" class="form-control" id="abstracts" name="abstracts" placeholder="新闻摘要"
                           value="${news.abstracts}">
                </div>

                <%--<div class="form-group" id="tpDIV">
                    <label for="content">内容</label>
                    <input type="text" class="form-control" id="content" name="content" placeholder="新闻内容"
                           value="${news.content}">
                </div>--%>
            </div>
            <!-- /.box-body -->

            <div class="box-footer">
                <button class="btn btn-primary" type="button" onclick="sub_news('news_form',${STATUS_RELEASED})">保存并发布
                </button>
                <button class="btn btn-primary" type="button" onclick="sub_news('news_form',${STATUS_OFFLINE})">保存
                </button>
                <button class="btn btn-primary" type="button"
                        onclick="openPage('<%=MenuEnum.TREE_ID_NEWS_LIST.getCode()%>','<%=MenuEnum.TREE_ID_NEWS_LIST.getUrl()%>');">
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


    function sub_news(formID, status) {
        $("#newsStatus").val(status);
        sub_form_data(formID);
    }


</script>