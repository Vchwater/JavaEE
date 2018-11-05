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
  
</header>
<h1 style="text-align: center;">登录界面</h1>

<div class="wdxc" style="margin: auto;padding-top:30px;text-align:center;width:300px;">
      
      <form  action="login_handle" method="post">
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:160px">账号(邮箱)</div>
 	 <input type="text" name="email" />
  </div>
  <div style="width:100%;height:50px;padding-top:10px;text-align:left"><div style="width:160px">密码</div>
 	 <input type="password" name="password" />
  </div>
<div style="width:100%;height:50px;padding-top:30px;text-align:right"><div style="width:200px">
	<input type="checkbox" name="checkbox" />记住密码
	<input type="submit" value="登录" style="font-size:15px" />
</div>
 	  
  </div>
  <div style="width:50%;height:50px;text-align:right;">
 	 
  </div>
</form>
      
      
    </div>





</body>
</html>
