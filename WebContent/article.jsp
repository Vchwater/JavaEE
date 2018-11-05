<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="gbk">
<title>我的博客</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
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
</script> 
</header>

<article>
  <c:forEach var="list" items="${requestScope.articlelist}">
  	 <c:set value="${list.id }" var="id" ></c:set>
  
  <div>
  
   <div style="text-align:center"> <h2 >${list.title}</h2></div>
    <div style="padding-top:10px;">
  		<div style="width:200px;height:50px;text-align:center;float:left">发表日期  :${list.date }</div>
  		<div style="width:100px;height:50px;text-align:center;float:left"> <a href="finduser.do?email=${list.name}">[去访问博主]</a></div>
  		<div style="width:100px;height:50px;text-align:center;float:left"> 点赞数:${list.like}</div>
  		<div style="width:100px;height:50px;float:right">
  		<%
  			if(session.getAttribute(request.getParameter("idarticle"))!=null){
				
  				if(session.getAttribute(request.getParameter("idarticle")).equals("alreadylike"))
  					
  					
  					%>
  					已点赞
  					<% 
  				
  					
  			}else{
  				
  				%>
  				<a href="addlike.do?idarticle=${list.id}"> 点赞 </a>
  				<%
  			}
  		%>
  	                
  		</div>
    	<div style="width:100px;height:50px;float:right">评论</div>
    </div>
    <div style="width:100%;height:50px;"></div>
    <div style="width:650px;height:300px;font-size:18px;padding-left:175px;">
      	${list.content}
    </div>
    </c:forEach>
     <div style="text-align:center"> <h2 >评论区</h2></div>
     	
     
    </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>


</body>
</html>
