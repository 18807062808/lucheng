<%--
  Created by IntelliJ IDEA.
  User: aabc
  Date: 2019/12/6
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<h1>
    路成JAVA服务<sup>V2017</sup></h1>
    <div id="web_qr_login">
        <!--登录-->
        <div id="web_login">
            <form action="user" accept-charset="UTF-8"
            id="login_from" method="post">
                <input type="hidden" name="method" value="login">
                <div id="uinArea">
                    <label for="u">账号:</label>
                    <div id="uArea">
                        <input type="text" id="u" name="user" value="${cookie.user.value}">
                    </div>
                </div>
                <div id="pwdArea">
                    <label for="p">密码</label>
                    <div id="pArea">
                        <input id="p" type="password" name="password" value="${cookie.password.value}">
                    </div>
                </div>
                <div>
                    <input style="vertical-align: middle;" type="checkbox" value="yes" name="remember">记住密码<br/>
                </div>

                <div style="padding-left: 50px; margin-top: 20px;">
                    <input type="submit" value="登 录" style="width: 150px;">
                </div>

            </form>
        </div>

        <!--登录END-->
    </div>

</body>
</html>
