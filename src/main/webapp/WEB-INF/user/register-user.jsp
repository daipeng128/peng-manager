<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <jsp:include page="../common/main-js.jsp"/>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="navbar-header">
            <center><h4 class="navbar-brand" >欢迎注册</h4></center>
    </div>
</nav>

<div class="container" style="margin:100px 0 0 20%">
    <div class="row clearfix">
        <div class="col-md-12 column">

                <%--注册表单--%>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label"><font color="red" size="1">*</font>用户名</label>
                            <div class="col-sm-10">
                                <input onblur="checkName()" class="form-control" id="name" placeholder="请输入用户名" style="width:250px;overflow-x:visible;overflow-y:visible;"/>
                                <font size="1" id="name-error" color="red" style="display:none">用户名长度在4-20位字符之间</font>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label"><font color="red" size="1">*</font>密码</label>
                            <div class="col-sm-10">
                                <input type="password" onblur="regPassword()" class="form-control" id="password" placeholder="建议至少你用两种字符组成" style="width:250px;overflow-x:visible;overflow-y:visible;"/>
                                <font size="1" color="red" id="pass-error" style="display:none">长度只能在8-20个字符之间,不能包含空格</font>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="checkPassword" class="col-sm-2 control-label"><font color="red" size="1">*</font>确认密码</label>
                            <div class="col-sm-10">
                                <input type="password" onblur="checkPass()" class="form-control" id="checkPassword" placeholder="请输入密码" style="width:250px;overflow-x:visible;overflow-y:visible;"/>
                                <font size="1" id="pass-error-2" color="red" style="display:none">两次输入的密码不一致请确认后输入</font>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label"><font color="red" size="1">*</font>手机号</label>
                            <div class="col-sm-10">
                                <input class="form-control" onblur="checkPhone()" id="phone" placeholder="请输入手机号" style="width:250px;overflow-x:visible;overflow-y:visible;"/>
                                <font size="1" id="phone-error" color="red" style="display:none">请输入正确的手机号</font>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <p class="help-block">
                                    以阅读并同意 <a>用户注册协议</a>
                                </p>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" class="btn btn-default" onclick="return checkAll()" style="width:250px;overflow-x:visible;overflow-y:visible;">注册</button>
                            </div>
                        </div>
                    </form>
                    <a id="modal-238715" href="#modal-container-238715" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>

                    <div class="modal fade" id="modal-container-238715" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                    <h4 class="modal-title" id="myModalLabel">
                                        注册提示
                                    </h4>
                                </div>
                                <div class="modal-body" id="reg-content">

                                </div>
                                <div class="modal-footer">
                                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                                        <button type="button" class="btn btn-primary">去登陆</button>
                                </div>
                            </div>

                        </div>

                    </div>
        </div>
    </div>
</div>

</body>

    <script>

        //校验用户名正则
        function checkName() {
            var name = $("#name").val();
            var nameReg = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]{4,20}$/
            var bool = nameReg.test(name);
            if(!bool){
                //用户名匹配不成功
                $("#name-error").show();
                return false;
            }

            //用户名匹配成功 隐藏错误提示 ajax 异步校验用户名是否重复
            $("#name-error").hide();

            $.ajax({
                type: "GET",
                url: "/login/checkUserNameOrPhone",
                data: {userNameOrPhone:name},
                dataType: "json",
                success: function(data){
                    if(data.success){

                        if(data.code == 200){
                            $("#name-error").css('color','green');
                        }else {
                            //数据库已存在
                            $("#name-error").css('color','red');
                        }
                        $("#name-error").text(data.data);
                        $("#name-error").show();
                    }
                }
            });

        }


        //密码正则校验
        function regPassword() {

            var passReg = /^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;'\.<>,\\\\[\\\\]){8,20}$/

            var pass = $("#password").val();

            if(!passReg.test(pass)){
                $("#pass-error").show();
                return false;
            }

            $("#pass-error").hide();


        }
        
        //确认密码校验
        function checkPass() {
            var pass = $("#password").val();
            var checkPass = $("#checkPassword").val();

            if(pass == "" || pass != checkPass){
                $("#pass-error-2").show();
                return false;
            }
            $("#pass-error-2").hide();
        }


        //校验手机号
        function checkPhone(){
            var phone = $("#phone").val();
            var phoneReg = /^1[34578]\d{9}$/
            if(!phoneReg.test(phone)){
                //手机号匹配不成功
                $("#phone-error").show();
                return false;
            }

            //手机号匹配成功 隐藏错误提示 ajax 异步校验用户名是否重复
            $("#phone-error").hide();

            $.ajax({
                type: "GET",
                url: "/login/checkUserNameOrPhone",
                data: {userNameOrPhone:phone},
                dataType: "json",
                success: function(data){
                    if(data.success){
                        if(data.code == 200){
                            $("#phone-error").css('color','green');
                        }else {
                            //数据库已存在
                            $("#phone-error").css('color','red');
                        }
                        $("#phone-error").text(data.data);
                        $("#phone-error").show();
                    }
                }
            });
        }

        
        //表单提交 校验所有
        function checkAll() {
            //校验用户名正则
            var nameBool = checkName();
            //密码正则校验
            var regPass = regPassword();
            //确认密码校验
            var passBool =  checkPass();
            //校验手机号
            var phoneBool = checkPhone();
            if(nameBool == false || regPass == false ||
                passBool == false || phoneBool == false){
                return false;
            }


            //通过以后 获取信息注册用户到数据库
            $.ajax({
                type: "POST",
                url: "/login/registerUser",
                data: {name:$("#name").val(),password:$("#password").val(),phone:$("#phone").val()},
                dataType: "json",
                success: function(data){
                    var okValue;
                    if(data.success){
                        okValue = '跳转登陆页面';
                    }else{
                        okValue = "确定";
                    }
                    var d = dialog({
                                title:'注册提示',
                                content:data.data,
                                cancel:false,
                                okValue:okValue,
                                ok:function(){
                                    if(data.success){
                                        location.href = '/index.jsp';
                                    }
                                }
                            });
                    d.showModal();
                }
            });



            
        }
    </script>

</html>