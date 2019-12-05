<%--
  Created by IntelliJ IDEA.
  User: aabc
  Date: 2019/12/6
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>
    路成JAVA服务<sup>V2017</sup></h1>
<div id="web_qr_login">
    <!--登录-->
    <div id="web_login">
        <form action="user" accept-charset="UTF-8"
              id="regUser" method="post">
            <input type="hidden" name="method" value="register">
            <div id="uinArea">
                <label for="u">账号:</label>
                <div id="uArea">
                    <input type="text" id="u" name="user">
                </div>
            </div>
            <div id="pwdArea">
                <label for="p">密码</label>
                <div id="pArea">
                    <input id="p" type="password" name="password">
                </div>
            </div>
            <div id="pwdAreaa">
                <label for="p1">确认密码</label>
                <div id="pAreaa">
                    <input id="p1" type="password" name="password1">
                </div>
            </div>
            <div id="nwdAreaa">
                <label for="n">姓名</label>
                <div id="nAreaa">
                    <input id="n" type="text" name="name">
                </div>
            </div>

            <div id="pddAreaa">
                <label for="o">电话</label>
                <div id="pdnAreaa">
                    <input id="o" type="text" name="phone">
                </div>
            </div>

            <div class="inputArea">

                <input type="submit" id="reg"
                       style="margin-top: 10px; margin-left: 85px;"
                       class="button_blue" value="同意协议并注册"/> <a href="#"
                                                                target="_blank.">注册协议</a>
            </div>

        </form>
    </div>

    <!--登录END-->
</div>
</body>
</html>
