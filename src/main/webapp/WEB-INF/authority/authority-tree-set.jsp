<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 引入jQuery -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.11.3.min.js"></script>
<%--引入easyuijs--%>
<script  src="<%=request.getContextPath()%>/js/jquery-easyui/jquery.easyui.min.js" ></script>
<!-- 引入easyui  css样式  只需引入easyui.css   其中就包含了其他的内容-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/default/easyui.css">
<!-- 引入小图标 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/icon.css">
<!-- 样式转化为中文 -->
<script  src="<%=request.getContextPath()%>/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/icon.css">



    <ul id="authority-tree-set"></ul>



<script>

    //动态回显树
    $('#authority-tree-set').tree({
        url:'/authority/queryAuthorityTree',
        checkbox:true
    })

</script>