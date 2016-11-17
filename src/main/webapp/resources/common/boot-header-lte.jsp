<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.mai.tcm.util.CurrentUser" %>
<%@include file="/resources/common/common-base.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>中医药官网管理系统</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <link href="${cssPath}/bootstrap/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${cssPath}/bootstrapValidator.min.css" rel="stylesheet">--%>

    <link href="${cssPath}/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="${cssPath}/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="${cssPath}/ionicons.min.css" rel="stylesheet" type="text/css" />
    <link href="${cssPath}/bootstrap/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${cssPath}/AdminLTE.css" rel="stylesheet" type="text/css" />
    <style>
        .cover {
            position:fixed; top: 0px; right:0px; bottom:0px;filter: alpha(opacity=60); background: rgba(255, 255, 255, 0.7);
            z-index: 1002; left: 0px; display:none;
            /*opacity:0.7; -moz-opacity:0.5;*/
        }
        .backgroundprogressBar
        {  position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 1020;
            background: transparent url('${imgPath}/ajax-loader.gif') 50% 50% no-repeat;
        }
    </style>
    <script>
        function StringBuffer() {
            this.buffer = [];
            if(arguments[0]) this.append(arguments[0]);
        }
        StringBuffer.prototype.append = function() {
            this.buffer.push(arguments[0]);
            return this;
        }
        StringBuffer.prototype.toString = function() {
            return this.buffer.join("");
        }
        StringBuffer.prototype.release = function() {
            this.buffer = [];
        }
    </script>
</head>