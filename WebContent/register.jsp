<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="gbk">
<title>用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script src="js/scrollReveal.js"></script>
</head>
<body>
<header>

  <div class="logo"><img src="images/logo.png"></div>
    <nav id="nav">
    <ul>
      <li style="float:left"><a href="index_in">博客主页</a></li>
      
      <li style="float:right"><a href="register_in">注册</a></li>
      <%
	Cookie[] cookies = request.getCookies();
	String name;
	boolean flag = true;
	for(Cookie cookie:cookies){
		name = cookie.getName();
		if(name.equals("username")){
			flag = false;
			%>
			<li style="float:left"><a href="myblog_in">我的博客</a></li>
      <li style="float:left"><a href="report_in">发表博客</a></li>
			<li style="float:right">
			<a href="logout.do">
			<% 
				out.print("[注销]");
			%>
			
			</a></li>
			<li style="float:right">
			
			<% 
			out.print("[用户："+cookie.getValue()+"]");%>
			
			</li>
			<%
			break;
		}
	}
	if(flag){
		%>
		<li style="float:right">
			<a href="login_in">
		<%
		out.print("请登录");
		%>
		</a>
			</li>
		<%
	}
%>
       </ul>
  </nav>
  <script>
window.onload = function ()
{
var obj=null;
var As=document.getElementById('nav').getElementsByTagName('a');
obj = As[0];
for(i=1;i<As.length;i++){if(window.location.href.indexOf(As[i].href)>=0)
obj=As[i];}
obj.id='selected'
}
function validate() {
	var pw1 = document.getElementById("pw1").value;
	var pw2 = document.getElementById("pw2").value;
	if(pw1 == pw2) {
	document.getElementById("tishi").innerHTML="<font color='green'></font>";
	document.getElementById("submit").disabled = false;
	}
	else {
	document.getElementById("tishi").innerHTML="<font color='red'>确认密码错误</font>";
	document.getElementById("submit").disabled = true;
	}
	}
</script> 
</header>
<h1 style="text-align: center;">注册界面</h1>
<div style=" margin: auto;width:400px;">
<div class="wdxc" style="padding-top:30px;padding-left:50px;text-align:center;width:300px;">
      
      <form  action="register_handle" method="post">
  <div style="width:90%;height:50px;padding-top:10px;text-align:left"><div style="width:80px">用户名</div><input type="text" name="name" style="font-size:18px"/></div>
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:160px">邮箱(账号)</div><input type="text" name="email" style="font-size:18px"/></div>
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:160px">密码</div><input type="password" name="password"id="pw1" style="font-size:18px"/></div>
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:80px">确认密码</div> <input type="password" name="password" id="pw2" onkeyup="validate()" style="font-size:18px"/><span id="tishi"></span></div>
  <div style="width:100%;height:60px;padding-top:10px;text-align:left"><div style="width:80px;height:30px;">出生年月</div><input type="text" name="birth" style="font-size:18px"/></div>
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:80px">电话</div><input type="text" name="phone" style="font-size:18px"/></div>
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:80px">毕业院校</div><input type="text" name="school" style="font-size:18px"/></div>
  <div style="width:300px;height:50px;text-align:right"><input type="submit" value="注册" style="font-size:18px"/></div>
</form>
      
      
    </div>

</div>



</body>
</html>
