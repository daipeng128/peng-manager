<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <jsp:include page="../common/main-js.jsp"/>
</head>
<body>

<%--引入头部布局--%>
    <jsp:include page="../title/title-manager.jsp"/>
<div class="span12" style="margin: 50px 0 0 0">
    <ul class="breadcrumb">
        <li>
            <a href="#">主页</a> <span class="divider">/</span>
        </li>
        <li>
            <a href="#">类目</a> <span class="divider">/</span>
        </li>
        <li class="active">
            用户管理列表
        </li>
    </ul>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>用户名称</th>
                    <th>用户手机号</th>
                    <th>用户生日</th>
                    <th>用户邮箱</th>
                    <th>用户头像</th>
                    <th>注册时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user">
                    <tr class="success">
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.phone}</td>
                        <td>${user.birthday}</td>
                        <td>${user.email}</td>
                        <td>${user.portraitUrl}</td>
                        <td>${user.createTime}</td>
                        <td>${user.updateTime}</td>
                        <td>
                            <button type="button" class="btn btn-default">按钮</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>