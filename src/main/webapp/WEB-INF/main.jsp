<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019/7/18
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common/main-js.jsp"/>
</head>
<body>

        <div class="row clearfix">
                <div class="col-md-12 column">

                    <%--引入头部布局--%>
                    <jsp:include page="title/title-manager.jsp"/>

                    <div class="row clearfix">
                        <div class="col-md-2 column">
                            <div class="panel-group" id="panel-636556">
                                <div class="panel panel-primary">
                                    <div class="panel-heading">
                                        <h3 class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-636556" href="#">菜单列表</h3>
                                    </div>

                                    <div class="panel-body">
                                        <a class="panel-title collapsed" href="javascript:createTab('用户管理','/user/queryUserList','yonghu')">用户管理</a>
                                    </div>

                                    <div class="panel-footer">
                                        <a class="panel-title collapsed" href="javascript:createTab('角色管理','/role/queryRoleList','juese')">角色管理</a>
                                    </div>

                                    <div class="panel-body">
                                        <a class="panel-title collapsed" href="javascript:createTab('权限管理','/user/queryUserList','quanxian')">权限管理</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10 column">
                            <div class="tabbable" id="tabs-780218">
                                <ul class="nav nav-tabs" id="tabs-ui">
                                    <li class="active">
                                        <a href="#panel-544659" data-toggle="tab">首页</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane fade active" id="panel-544659">
                                        <p>
                                            这里是首页
                                        </p>
                                    </div>
                                    <div class="tab-pane fade" id="panel-959304">
                                        <p>
                                            Howdy, I'm in Section 2.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

</body>
<script>

    //创建新的选项卡
    function createTab(tabName,path,flag){

        //判断当前选项卡是否已经创建 如果创建切换即可
      var val =  $("#"+flag).val();

       if(val != undefined){

           //选中当前选项卡
           $("#"+flag).tab('show');
           return;
       }


        //获取页面
        $.ajax({
            type:'get',
            url:path,
            dataType:'html',
            success:function (page) {
                $("#panel-959304").html(page);


            }
        })


        var tab = " <li>\n" +
                    "<a id='"+flag+"' href='#panel-959304' data-toggle='tab'>"+tabName+"</a>\n" +
                  "</li>";

        //拿到tab
        $(".nav-tabs").append(tab);

        $("#"+flag).tab('show');


    }

</script>
</html>
