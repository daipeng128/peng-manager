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
                    <tr class="${role.id %2 == 0?success:error}">
                        <td>${role.id}</td>
                        <td>${role.role}</td>
                        <td>${role.description}</td>
                        <td>
                                <a href="">删除</a>
                            |
                                <a href="">修改</a>
                            |
                            <a href="javascript:setAuthority(${role.id},'${role.role}')">分配权限</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <div id="authority-dialog"></div>


        </div>
    </div>


<script>

    function setAuthority(roleId,roleName){

            $('#authority-dialog').dialog({
                title: '给【'+roleName+'】角色分配权限',
                cache: false,
                href: '/authority/openAuthoritySetPage',
                modal: true,
                width:500,
                height:600,
                buttons:[{
                    text:'确定',
                    handler:function(){

                        var nodes = $('#authority-tree-set').tree('getChecked',['checked','indeterminate']);

                        //拿到所有被选中的权限id
                        console.info(nodes);



                    }
                }]
            });


    }


</script>
