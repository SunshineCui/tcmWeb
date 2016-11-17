<%@ page import="com.mai.tcm.model.News,com.mai.tcm.security.MenuEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/pagination.tld" %>
<c:set var="STATUS_RELEASED" value="<%=News.STATUS_RELEASED%>"/>
<c:set var="STATUS_OFFLINE" value="<%=News.STATUS_OFFLINE%>"/>
<c:set var="STATUS_DELETE" value="<%=News.STATUS_DELETE%>" />

<%--
  Created by IntelliJ IDEA.
  User: denghao
  Date: 16/4/24
  Time: 下午12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<div class="col-xs-12">
  <div class="box">
    <form action="/w/news/list" id="news_form" name="news_form" method="post">
      <input type="text" style="display: none">
      <input type="hidden" name="page" id="page" value="${page}"/>
        <h3 class="box-title">新闻资讯列表</h3>      <div class="box-header" style="padding-bottom: inherit; padding-top: 10px">

      <div class="box-tools">

          <div class="btn-group pull-right" role="group" aria-label="...">
            <div class="input-group">
              <button class="btn btn-default" type="button" onclick="openPage('<%=MenuEnum.TREE_ID_NEWS.getCode()%>','<%=MenuEnum.TREE_ID_NEWS.getUrl()%>');">新增</button>
            </div>
          </div>
          <div class="btn-group pull-right" role="group" style="margin-right: 10px">
            <div class="input-group">
              <input type="text" value="${newsTitle}" placeholder="请输入新闻名称" name="newsTitle" class="form-control" id="newsTitle" style="width: 350px">
              <button class="btn btn-default" type="button" onclick="list_sub_form('news_form');">搜索</button>
            </div>
          </div>
        </div>
      </div><!-- /.box-header -->
      <div class="box-body table-responsive">
        <table class="table table-bordered table-striped dataTable" id="table1" aria-describedby="table1_info">
          <thead>
          <tr role="row">
            <th role="columnheader" tabindex="0" aria-controls="table1" rowspan="1" colspan="1" style="width: 177px;">权重</th>
            <th role="columnheader" tabindex="0" aria-controls="table1" rowspan="1" colspan="1" style="width: 261px;">上传时间</th>
            <th role="columnheader" tabindex="0" aria-controls="table1" rowspan="1" colspan="1" style="width: 261px;">新闻名称</th>
            <th role="columnheader" tabindex="0" aria-controls="table1" rowspan="1" colspan="1" style="width: 261px;">状态</th>
            <th role="columnheader" tabindex="0" aria-controls="table1" rowspan="1" colspan="1" style="width: 233px;">操作</th>
          </tr>
          </thead>
          <tbody role="alert" aria-live="polite" aria-relevant="all">
          <c:forEach  items="${newslist}" var="news" varStatus="_index">
            <tr class="${_index.count%2==0?"odd":"even"}" id="${news.newsID}_tr">
              <td class=" ">${news.sortNO}</td>
              <td class=" ">${news.showCreateTime}</td>
              <td class=" ">${news.title}</td>
              <td class=" " id="${news.newsID}_newsStatus">
                <c:choose>
                  <c:when test="${news.status == STATUS_RELEASED}">
                    <label style="color: blue">上线</label>
                  </c:when>
                  <c:when test="${news.status == STATUS_OFFLINE}">
                    <label style="color: red">下线</label>
                  </c:when>
                  <c:otherwise>
                    未知
                  </c:otherwise>
                </c:choose>
              </td>
              <td class=" ">
                <a href="javaScript:void(0);" onclick="openPage('<%=MenuEnum.TREE_ID_NEWS.getCode()%>','<%=MenuEnum.TREE_ID_NEWS.getUrl()%>?newsID=${news.newsID}');">编辑</a>
                ｜
                  <span id="${news.newsID}_btn">
                    <c:choose>
                      <c:when test="${news.status == STATUS_RELEASED}">
                        <a href="javaScript:void(0);" id="${news.newsID}_editnewsBtn" onclick="updatenewsStatus('${news.newsID}',${STATUS_OFFLINE})">下线</a>
                      </c:when>
                      <c:when test="${news.status == STATUS_OFFLINE}">
                        <a href="javaScript:void(0);" id="${news.newsID}_editnewsBtn" onclick="updatenewsStatus('${news.newsID}',${STATUS_RELEASED})">上线</a>
                        ｜
                        <a href="javaScript:void(0);" id="${news.newsID}_deletenewsBtn" onclick="updatenewsStatus('${news.newsID}',${STATUS_DELETE})">删除</a>
                      </c:when>
                    </c:choose>
                  </span>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <div>
          <div class="col-xs-6">
            <div class="dataTables_info" id="table1_info">共${totalsize}条</div>
          </div>
          <div class="col-xs-6">
            <div class="dataTables_paginate paging_bootstrap">
              <pagination:pagination param="max=${pageMaxSize}&total=${totalsize}&page=${page}"/>
            </div>
          </div>
        </div>
      </div><!-- /.box-body -->
    </form>
  </div><!-- /.box -->

</div>
</body>
</html>
<script>
  function updatenewsStatus(newsID,newsStatus){
    $.post('${ctxPath}/w/news/updateStatus', {newsID:newsID,newsStatus:newsStatus}, function(data) {
      if(data < -1){
        alert("系统错误，请与管理员联系！");
        return false;
      }else if(data == ${STATUS_RELEASED}){
        $("#"+newsID+"_btn").empty();
        $("#"+newsID+"_btn").append("<a href=\"javaScript:void(0);\" id=\""+newsID+"_editnewsBtn\" onclick=\"updatenewsStatus('"+newsID+"',${STATUS_OFFLINE})\">下线</a>");
        $("#"+newsID+"_newsStatus").html("<label style=\"color: blue\">上线</label>");
      }else if(data == ${STATUS_OFFLINE}){
        $("#"+newsID+"_btn").empty();
        $("#"+newsID+"_btn").append("<a href=\"javaScript:void(0);\" id=\""+newsID+"_editnewsBtn\" onclick=\"updatenewsStatus('"+newsID+"',${STATUS_RELEASED})\">上线</a>｜");
        $("#"+newsID+"_btn").append("<a href=\"javaScript:void(0);\" id=\""+newsID+"_deletenewsBtn\" onclick=\"updatenewsStatus('"+newsID+"',${STATUS_DELETE})\">删除</a>");
        $("#"+newsID+"_newsStatus").html("<label style=\"color: red\">下线</label>");
      }else if(data == ${STATUS_DELETE}){
        $("#"+newsID+"_tr").remove();
      }else{
        $("#"+newsID+"_newsStatus").text("未知");
      }
    });
  }
</script>