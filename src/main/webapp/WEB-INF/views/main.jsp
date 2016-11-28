<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.mai.tcm.security.MenuEnum"%>
<%@include file="/resources/common/boot-header-lte.jsp" %>
<body class="skin-blue">
<!-- header logo: style can be found in header.less -->

<header class="header">
  <a href="/" class="logo">
    <!-- Add the class icon to your logo image or logo icon to add the margining -->
    中医药官网管理系统
  </a>
  <!-- Header Navbar: style can be found in header.less -->
  <nav class="navbar navbar-static-top" role="navigation">
    <!-- Sidebar toggle button-->
    <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </a>
    <div class="navbar-right">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <i class="glyphicon glyphicon-user"></i>
            <span><%=CurrentUser.getPersonName()%> <i class="caret"></i></span>
          </a>
          <ul class="dropdown-menu">
            <!-- User image -->
            <li class="user-header bg-light-blue">
              <%--<img src="${imgPath}/avatar5.png" class="img-circle" alt="User Image" />--%>
              <p>
                <%=CurrentUser.getPersonName()%>
                <small><%=CurrentUser.getRoleName()%></small>
              </p>
            </li>
            <li class="user-footer">
              <div class="pull-left">
                <a href="JavaScript:void(0);" id="userpwd" onclick="openPage($(this).attr('id'),'/w/user/updatePwd');" class="btn btn-default btn-flat">
                  <span>修改密码</span>
                </a>
              </div>
              <div class="pull-right">
                <a href="${ctxPath}/w/user/logout" class="btn btn-default btn-flat">退出</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <%--<div class="pull-left image">--%>
          <%--<img src="${imgPath}/avatar5.png" class="img-circle" alt="User Image" />--%>
        <%--</div>--%>
        <div class="pull-left info" style="text-align: center">
          <p>Hello, <%=CurrentUser.getPersonName()%></p>
        </div>
      </div>
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="treeview active">
          <a href="#">
            <i class="fa fa-bar-chart-o"></i>
            <span>轮播图管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="active">
              <a href="javaScript:void(0);" id="<%=MenuEnum.TREE_ID_CAROUSEL_LIST.getCode()%>" onclick="openPage($(this).attr('id'),'<%=MenuEnum.TREE_ID_CAROUSEL_LIST.getUrl()%>');">
                <i class="fa fa-angle-double-right"></i><span>轮播图列表</span>
              </a>
            </li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-bar-chart-o"></i>
            <span>新闻管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="active">
              <a href="javaScript:void(0);" id="<%=MenuEnum.TREE_ID_NEWS_LIST.getCode()%>" onclick="openPage($(this).attr('id'),'<%=MenuEnum.TREE_ID_NEWS_LIST.getUrl()%>');">
                <i class="fa fa-angle-double-right"></i><span>新闻资讯列表</span>
              </a>
            </li>
          </ul>
        </li>
          <li class="treeview">
              <a href="#">
                  <i class="fa fa-bar-chart-o"></i>
                  <span>导航栏目管理</span>
                  <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                  <li class="active">
                      <a href="javaScript:void(0);" id="<%=MenuEnum.TREE_ID_TOPCOLUMN_LIST.getCode()%>" onclick="openPage($(this).attr('id'),'<%=MenuEnum.TREE_ID_TOPCOLUMN_LIST.getUrl()%>');">
                          <i class="fa fa-angle-double-right"></i><span>一级栏目列表</span>
                      </a>
                  </li>
                  <li class="active">
                      <a href="javaScript:void(0);" id="<%=MenuEnum.TREE_ID_COLUMN_LIST.getCode()%>" onclick="openPage($(this).attr('id'),'<%=MenuEnum.TREE_ID_COLUMN_LIST.getUrl()%>');">
                          <i class="fa fa-angle-double-right"></i><span>二级栏目列表</span>
                      </a>
                  </li>
              </ul>
          </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Right side column. Contains the navbar and content of the page -->
  <aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        欢迎页面
        <%--<small>Control panel</small>--%>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">欢迎页面</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

    </section><!-- /.content -->
  </aside><!-- /.right-side -->
</div><!-- ./wrapper -->
<div id="cover" class="cover"></div>
<div id="backgroundprogressBar" class="backgroundprogressBar" style="display: none; "></div>

<%@include file="/resources/common/footer-js-lte.jsp"%>

</body>
</html>