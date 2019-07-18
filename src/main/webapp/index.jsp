<%@page language="java" contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>欢迎登陆</title>
    <jsp:include page="WEB-INF/common/main-js.jsp"/>
</head>
<body>

    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
        <div class="navbar-header">
            <center><h4 class="navbar-brand" >欢迎登陆</h4></center>
        </div>
    </nav>

    <div class="container" style="margin:150px 0 0 20%">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <%-- 提交登陆表单--%>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label"><font color="red" size="1">*</font>用户名</label>
                            <div class="col-sm-10">
                                <input onblur="checkName()" class="form-control" id="name" placeholder="用户名/手机号/邮箱" style="width:250px;overflow-x:visible;overflow-y:visible;"/>
                                <font size="1" id="name-error" color="red" style="display:none">请输入用户名</font>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label"><font color="red" size="1">*</font>密码</label>
                            <div class="col-sm-10">
                                <input type="password" onblur="checkPassword()" class="form-control" id="password" placeholder="请输入密码" style="width:250px;overflow-x:visible;overflow-y:visible;"/>
                                <font size="1" color="red" id="pass-error" style="display:none">请输入密码</font>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10"><br/><br/>
                                <button type="button" class="btn btn-default" onclick="return loginCheck()" style="width:250px;overflow-x:visible;overflow-y:visible;">登陆</button>
                            </div>
                        </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>

    function checkName() {
        var name = $("#name").val();

        if(name == ""){
            //用户名匹配不成功
            $("#name-error").show();
            return false;
        }
    }

    function checkPassword() {
        var pass = $("#password").val();

        if(pass == ""){
            //用户名匹配不成功
            $("#pass-error").show();
            return false;
        }
    }


    function loginCheck() {
        //用户名非空
        var nameBool = checkName();
        //密码非空
        var regPass = checkPassword();

        if(nameBool == false || regPass == false){
            return false;
        }

        //通过以后 进行用户名密码匹配
        $.ajax({
            type: "POST",
            url: "/login/loginUser",
            data: {name:$("#name").val(),password:$("#password").val()},
            dataType: "json",
            success: function(data){
                if(data.success){
                    var d = dialog({
                        title:'登陆提示',
                        content:data.data,
                        cancel:false});
                    d.showModal();
                    setTimeout(function(){
                        d.close().remove();
                        location.href = '/';
                    },500);


                }else {
                    var d = dialog({
                        title:'登陆提示',
                        content:data.data,
                        cancel:false,
                        okValue:"确定",
                        ok:function(){
                            if(data.success){
                                location.href = '/index.jsp';
                            }
                        }
                    });
                    d.showModal();


                }
            }
        });
    }
</script>
</html>