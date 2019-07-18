<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="span12">
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
    <div class="row clearfix">
        <div class="col-md-12 column">

            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>角色名称</th>
                    <th>角色描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${roleList}" var="role">
                    <tr class="success">
                        <td>${role.id}</td>
                        <td>${role.role}</td>
                        <td>${role.description}</td>
                        <td>
                            <button type="button" class="btn btn-default">按钮</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
