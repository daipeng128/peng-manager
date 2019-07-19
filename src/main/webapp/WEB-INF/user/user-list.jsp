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
                    <th>用户名称</th>
                    <th>用户手机号</th>
                    <%--<th>用户生日</th>--%>
                    <%--<th>用户邮箱</th>--%>
                    <%--<th>用户头像</th>--%>
                    <%--<th>注册时间</th>--%>
                    <%--<th>修改时间</th>--%>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user" >
                    <tr class="${user.id %2 == 0?success:error}">
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.phone}</td>
                        <%--<td>${user.birthday}</td>--%>
                        <%--<td>${user.email}</td>--%>
                        <%--<td>${user.portraitUrl}</td>--%>
                        <%--<td>${user.createTime}</td>--%>
                        <%--<td>${user.updateTime}</td>--%>
                        <td>
                                <c:if test="${user.yn==0}">
                                    启用
                                </c:if>
                                <c:if test="${user.yn==1}">
                                    禁用
                                </c:if>


                        </td>
                        <td>
                            <c:if test="${user.yn==0}">
                                <a href="">禁用</a>
                            </c:if>
                            <c:if test="${user.yn==1}">
                                <a href="">启用</a>
                            </c:if>
                            |
                            <a href="javascript:setRoles(${user.id},'${user.name}')">分配角色</a>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <script>

        function setRoles(userId,userName){


            //异步加载角色
            $.ajax({
                type: "POST",
                url: "/role/queryRoleList4Data",
                dataType: "json",
                async:false,
                success: function(data){

                    //拿到所有的角色
                    var roleAll = data;

                    //拿到用户所拥有的角色
                    $.ajax({
                        type: "POST",
                        url: "/role/queryRoleListByUserId",
                        data:{'userId':userId},
                        dataType: "json",
                        async:false,
                        success: function(data){
                            //拿到所有的角色
                           var userRoles = data;

                            var newUserRoleHtml = '<form id="ff">' +
                                                    '<input name="userId" value="'+userId+'" type="hidden"/>';

                            for (var i=0;i<roleAll.length;i++){
                                var role = roleAll[i];

                                var bool = false;
                                for(var y=0;y<userRoles.length;y++){
                                    var userRole =  userRoles[y];
                                    if(userRole.roleId == role.id){
                                        bool = true;
                                    }
                                }

                                if(bool){
                                    //用户拥有当前角色
                                    newUserRoleHtml += '<div class="checkbox">\n' +
                                        '    <label><input type="checkbox" name="roleIds" checked="true" value="'+role.id+'">'+role.role+'</label>\n' +
                                        '</div>';
                                }else{
                                    newUserRoleHtml += '<div class="checkbox">\n' +
                                        '    <label><input type="checkbox" name="roleIds" value="'+role.id+'">'+role.role+'</label>\n' +
                                        '</div>';
                                }
                            }

                            newUserRoleHtml += "</form>";
                            //回显角色

                            var d = dialog({
                                title:'给【'+userName+'】分配角色',
                                content:newUserRoleHtml,
                                cancel:false,
                                okValue:"确定",
                                ok:function(){

                                  var al = $("#ff").serialize();

                                  console.info(al);

                                    //添加用户角色
                                    $.get("/role/setRolesToUser",al,function(msg){
                                        console.info(msg);
                                        var d2 = dialog({content:msg});
                                            d2.showModal();
                                            setTimeout(function(){d2.close().remove()},1000);

                                        });

                                }
                            });
                            d.showModal();


                        }
                    });

                }
            });





        }



    </script>
