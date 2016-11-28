<%--
  Created by IntelliJ IDEA.
  User: denghao
  Date: 16/4/30
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        修改密码
      </h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form role="form" method="post" action="/w/user/updatePassW" id="user_form"  name="user_form">
      <div class="box-body">
        <div class="form-group">
          <label for="oldpass" class="col-sm-2 control-label">旧密码</label>
            <input type="password" class="form-control" style="display:inline-block;width:250px;" id="oldpass" placeholder="Old Password"><div id="oldpassTip" style="padding-left:10px;display:none;color:red;">ASD</div>
        </div>
        <div class="form-group">
          <label for="newpass" class="col-sm-2 control-label">新密码</label>
            <input type="password" class="form-control" style="display:inline-block;width:250px;" id="newpass" placeholder="New Password"><span id="newpassTip" style="padding-left:10px;display:none;color:red;"></span>
        </div>
        <div class="form-group">
          <label for="newpassAgain" class="col-sm-2 control-label">再次确认新密码</label>
            <input type="password" class="form-control" style="pdisplay:inline-block;width:250px;" id="newpassAgain" placeholder="Again New Password"><span id="newpassAgainTip" style="padding-left:10px;display:none;color:red;"></span>
        </div>
      </div><!-- /.box-body -->

      <div class="box-footer">
        <button class="btn btn-primary" type="button" onclick="sub_form_pwd('user_form')">提交</button>
      </div>
    </form>
  </div><!-- /.box -->
</div>
</body>
</html>
<script>
  function showError(formSpan, errorText) {
    $("#" + formSpan).css({"border-color":"red"});
    $("#" + formSpan + "Tip").empty();
    $("#" + formSpan + "Tip").append(errorText);;
    $("#" + formSpan + "Tip").css({"display":"inline-block"});
  }

  function sub_form_pwd(){
    var oldpass = $("#oldpass").val();
    var newpass = $("#newpassAgain").val();
    $.post('${ctxPath}/w/user/updatePassW', {oldpass:oldpass, newpass:newpass}, function(data) {
      if(data == 1){
        window.location.href = "${ctxPath}/w/user/logout";
      }else{
        showError('oldpass', '密码错误');
      }
    });
  }
</script>
