<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--引入easyuijs--%>
<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.11.3.min.js"></script>
<!-- 引入easyui -->
<script  src="<%=request.getContextPath()%>/js/jquery-easyui/jquery.easyui.min.js" ></script>
<!-- 引入easyui  css样式  只需引入easyui.css   其中就包含了其他的内容-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/default/easyui.css">
<!-- 引入小图标 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/icon.css">
<!-- 样式转化为中文 -->
<script  src="<%=request.getContextPath()%>/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/icon.css">



    <ul id="authority-tree"></ul>


<%--// 绑定右击菜单--%>
<div id="mm" class="easyui-menu" style="width:120px;">
    <div onclick="append()" data-options="iconCls:'icon-add'">新增权限</div>
    <div onclick="append()" data-options="iconCls:'icon-add'">修改权限</div>
    <div onclick="remove()" data-options="iconCls:'icon-remove'">删除权限</div>
</div>

<!-- 样式转化为中文 -->
<script  src="<%=request.getContextPath()%>/js/authority/authority-tree.js"></script>
