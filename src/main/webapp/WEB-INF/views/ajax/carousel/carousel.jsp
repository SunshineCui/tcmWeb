<%--
  Created by IntelliJ IDEA.
  User: denghao
  Date: 16/4/30
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mai.tcm.security.MenuEnum,com.mai.tcm.model.Carousel" %>
<c:set var="STATUS_OFFLINE" value="<%=Carousel.STATUS_OFFLINE%>" />
<c:set var="STATUS_RELEASED" value="<%=Carousel.STATUS_RELEASED%>" />

<c:set var="TARGET_TYPE_URL" value="<%=Carousel.TARGET_TYPE_URL%>" />
<c:set var="TARGET_TYPE_EXAM" value="<%=Carousel.TARGET_TYPE_EXAM%>" />
<c:set var="TARGET_TYPE_EVA" value="<%=Carousel.TARGET_TYPE_EVA%>" />
<c:set var="TARGET_TYPE_SCRIPT" value="<%=Carousel.TARGET_TYPE_SCRIPT%>" />

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
          <c:when test="${carousel.carouselID != null}">修改轮播图</c:when>
          <c:otherwise>新增轮播图</c:otherwise>
        </c:choose>
      </h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form role="form" method="post" action="/w/carousel/addOrUpdateCarousel" id="carousel_form"  name="carousel_form" enctype="multipart/form-data">
      <input type="hidden" name="carouselID" value="${carousel.carouselID}">
      <input type="hidden" id="carouselStatus" name="status" value="${carousel.status}">
      <div class="box-body">
        <div class="form-group">
          <label for="title">名称</label>
          <input type="text" name="title" value="${carousel.title}" placeholder="名称" id="title" class="form-control">
        </div>

        <div class="form-group">
          <label for="sortNO">权重值</label>
          <input type="number" class="form-control" placeholder="权重" id="sortNO" value="${carousel.sortNO==null?0:carousel.sortNO}"
                 name="sortNO" min="0" max="100">
        </div>

        <div class="form-group">
          <label for="Filedata">轮播图</label>
          <c:if test="${carousel.picUrl != null && carousel.picUrl != ''}">
            <div class="col-md-3" style="float: none">
              <a href="${carousel.picUrl}" target="_blank" class="thumbnail">
                <img src="${carousel.picUrl}" style="max-height: 200px"/>
              </a>
            </div>
          </c:if>
          <div>
            <input type="file" id="Filedata" name="Filedata"/>
          </div>
        </div>

        <%--<div class="form-group">
              <label>跳转类型</label>
              <select name="targetType" id="targetType" style="display: block">
                  <option value="${TARGET_TYPE_URL}" <c:if test="${carousel.targetType == TARGET_TYPE_URL}">selected</c:if>>URL跳转</option>
                  <option value="${TARGET_TYPE_EVA}" <c:if test="${carousel.targetType == TARGET_TYPE_EVA}">selected</c:if>>测评</option>
                  <option value="${TARGET_TYPE_EXAM}" <c:if test="${carousel.targetType == TARGET_TYPE_EXAM}">selected</c:if>>考试</option>
                <option value="${TARGET_TYPE_SCRIPT}" <c:if test="${carousel.targetType == TARGET_TYPE_SCRIPT}">selected</c:if>>脚本调用</option>
              </select>
        </div>--%>

        <%--<div class="form-group" id="evaDIV">
          <label>测评选择</label>
          <select name="evaIDs" id="evaIDs" style="display: block">

          </select>
        </div>--%>

        <div class="form-group" id="tpDIV">
          <label for="targetParameter">轮播图跳转URL</label>
          <input type="text" class="form-control" id="targetParameter" name="targetParameter" placeholder="轮播图跳转URL"
                 value="${carousel.targetParameter}">
        </div>
      </div><!-- /.box-body -->

      <div class="box-footer">
        <button class="btn btn-primary" type="button" onclick="sub_carousel('carousel_form',${STATUS_RELEASED})">保存并发布</button>
        <button class="btn btn-primary" type="button" onclick="sub_carousel('carousel_form',${STATUS_OFFLINE})">保存</button>
        <button class="btn btn-primary" type="button" onclick="openPage('<%=MenuEnum.TREE_ID_CAROUSEL_LIST.getCode()%>','<%=MenuEnum.TREE_ID_CAROUSEL_LIST.getUrl()%>');">取消</button>
      </div>
    </form>
  </div><!-- /.box -->
</div>
</body>
</html>
<script>

  $(function(){
    $('#evaIDs').on('change', function () {
      console.log($(this).val());
      $("#targetParameter").val($(this).val());
    });

    <c:choose>
      <c:when test="${carousel.targetType == TARGET_TYPE_EVA}">
        $("#tpDIV").hide();
        showLoading();
        $.post('${ctxPath}/w/evaluation/selectEvaLst', function(data) {
          $("#evaIDs").empty();
          if(data && data.length > 0){
            var sb = new StringBuffer('<option value="">请选择测评</option>');
            $.each(data, function(index, eva){
              if($("#targetParameter").val() == eva.evaluationID){
                sb.append('<option value="'+eva.evaluationID+'" selected>'+eva.evaluationTitle+'</option>');
              }else{
                sb.append('<option value="'+eva.evaluationID+'">'+eva.evaluationTitle+'</option>');
              }
            });
            $("#evaIDs").append(sb.toString());
          }
          hideLoading();
        },"json");

      </c:when>
      <c:when test="${carousel.targetType == TARGET_TYPE_EXAM}">
        $("#tpDIV").hide();
        $("#evaDIV").hide();
      </c:when>
    <c:otherwise>
    $("#evaDIV").hide();
    </c:otherwise>
    </c:choose>

    $("#targetType").change(function(){
        if($(this).val() == ${TARGET_TYPE_EXAM}){
          $("#targetParameter").val("/w/exam/index");
          $("#tpDIV").hide();
          $("#evaDIV").hide();
        }else if($(this).val() == ${TARGET_TYPE_EVA}){
          $("#targetParameter").val("");
          $("#tpDIV").hide();
          $("#evaDIV").show();
          showLoading();
          $.post('${ctxPath}/w/evaluation/selectEvaLst', function(data) {
            $("#evaIDs").empty();
            if(data && data.length > 0){
              var sb = new StringBuffer('<option value="">请选择测评</option>');
              $.each(data, function(index, eva){
                if($("#targetParameter").val() == eva.evaluationID){
                  sb.append('<option value="'+eva.evaluationID+'" selected>'+eva.evaluationTitle+'</option>');
                }else{
                  sb.append('<option value="'+eva.evaluationID+'">'+eva.evaluationTitle+'</option>');
                }
              });
              $("#evaIDs").append(sb.toString());
            }
            hideLoading();
          },"json");
        }else{
          $("#evaDIV").hide();
          $("#targetParameter").val("");
          $("#tpDIV").show();
        }
    });
  });

  function sub_carousel(formID,status){

    if($("#targetType").val() == ${TARGET_TYPE_EVA} && $("#targetParameter").val() == ""){
        alert("请选择测评");
      return false;
    }

    $("#carouselStatus").val(status);
    sub_form_data(formID);
  }


</script>