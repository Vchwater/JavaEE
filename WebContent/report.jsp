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
<h1 style="text-align: center;">博客发表</h1>
<div style=" margin: auto;width:600px;">
<div class="wdxc" style="padding-top:30px;padding-left:50px;text-align:center;width:500px;">
      
      <form  action="report_handle" method="post" id="aaa" enctype="multipart/form-data">
      <div style="height:30px;width:250px;font-size:20px">标题：<input type="text" name="name" height="30px" /></div>
      <div style="text-align:right;width:60px;float:right;padding-right:50px;padding-bottom:20px;padding-top:20px"><input type="submit" value="发表" style="font-size:18px"/></div>
      <div style="text-align:left;width:330px;float:left;padding-right:50px;padding-bottom:20px;padding-top:20px">(加张图片吧)<input type="file" name ="image" value="添加张图片吧"/></div>
  </form>
      <textarea name="content" style="height:300px;width:500px" form="aaa"></textarea>
      
    </div>

</div>



</body>
</html>
