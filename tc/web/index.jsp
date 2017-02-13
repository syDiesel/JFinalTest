<%--
  Created by IntelliJ IDEA.
  User: VinDiesel
  Date: 2017/2/9
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <h1>登录</h1>
      <table>
        <form method="get" action="/tc/user/login">
          <input type="text" name="username" value=""><br>
          <input type="password" name="password" value=""><br>
          <input type="submit" value="登录">
        </form>
      </table>
      <form method="post" action="/tc/user/image" enctype="multipart/form-data">
        <input type="file" name="img" value=""><br>
        <input type="submit" value="上传">
      </form>
  </body>
</html>
