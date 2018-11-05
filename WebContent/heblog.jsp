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
  <div class="l_box">
    <div class="about_me">
      <h2>关于ta</h2>
      <ul>
        <i><img src="images/4.jpg"></i>
        <p><b></b>只要强迫自己散发热情，一旦需要热心参与某种活动，便能立刻感到这股热情的力量，进而勇往直前。</p>
      </ul>
    </div>
    <div class="wdxc">
     <c:forEach var="list" items="${requestScope.userlist}">
      <h2>个人信息</h2>
      <ul>
      <div style="width:100%;height:30px;padding-top:10px">姓名：${list.name }</div>
      <div style="width:100%;height:30px;padding-top:10px">邮箱：${list.email }</div>
       <div style="width:100%;height:30px;padding-top:10px">出生年月：${list.birth }</div>
       <div style="width:100%;height:30px;padding-top:10px">电话：${list.phone}</div>
       <div style="width:100%;height:30px;padding-top:10px">毕业院校:${list.school }</div>
       
      </ul>
      </c:forEach>
    </div>
   <div class="search">
      <form action="/e/search/index.php" method="post" name="searchform" id="searchform">
        <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字词" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字词'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字词'}" type="text">
        <input name="show" value="title" type="hidden">
        <input name="tempid" value="1" type="hidden">
        <input name="tbname" value="news" type="hidden">
        <input name="Submit" class="input_submit" value="搜索" type="submit">
      </form>
    </div>
    
    
    
    
  </div>
  <div class="r_box">
  <c:forEach var="list" items="${requestScope.finduserlist}">
  
  <li><i><a href="#"><img src="images/${list.image}"></a></i>
      <h3><a href="findarticle.do?idarticle=${list.id}">${list.title}</a></h3>
      <div style="width:500px;padding-bottom:10px;padding-top:10px">
         <div style="float:right;text-align:right;color:#222222;font-size:12px">浏览次数：[${list.look }] </div>
     	 
     	 <div style="float:right;text-align:left;color:#222222;font-size:12px;width:80px">点赞次数:[${list.like }] </div>
     	 <div style="float:left;text-align:right;color:#222222;font-size:12px;width:150px">发表日期：[${list.date }]</div>
     	 
      </div>
      
      <p>${list.content}</p>
    </li>
  
  </c:forEach>
  
    
    
   </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>


</body>
</html>
