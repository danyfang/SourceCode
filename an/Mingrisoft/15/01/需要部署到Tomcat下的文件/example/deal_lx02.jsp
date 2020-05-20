<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
 String user="";
 if(request.getParameter("user")!=null){
 	user=request.getParameter("user");//获取输入用户名
	user=new String(user.getBytes("iso-8859-1"),"utf-8");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	if(!"".equals(pwd) && !"".equals(email)){
		out.println("注册信息提交成功！");
		out.println("用户名为："+user+"\nE-mail为："+email);
	}else{
		out.println("您输入的用户注册信息不完整！");
	}
 }
%>