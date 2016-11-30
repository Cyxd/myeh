<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Facebook Login Form</title>
<link rel="stylesheet" href="<c:url value="/static/facade/css/"/>style.css">
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<c:url value="/j_spring_security_check/" var="loginUrl" />
	<form action="${loginUrl}" method="post" class="login">
		<h1>Facebook</h1>
		<span style="color: red;">${error}</span>
		<input type="tel" name="username" class="login-input"
			placeholder="Email Address" autofocus> <input type="password"
			name="password" class="login-input" placeholder="Password"> <input
			type="submit" value="Login" class="login-submit">
		<p class="login-help">
			<a href="/index.jsp">Forgot password?</a>
		</p>
	</form>

	<section class="about">
		<p class="about-links">
			<a href="http://www.cssflow.com/snippets/facebook-login-form"
				target="_parent">View Article</a> <a
				href="http://www.cssflow.com/snippets/facebook-login-form.zip"
				target="_parent">Download</a>
		</p>
		<p class="about-author">
			&copy; 2013 <a href="http://thibaut.me" target="_blank">Thibaut
				Courouble</a> - <a href="http://www.cssflow.com/mit-license"
				target="_blank">MIT License</a><br> Original PSD by <a
				href="http://dribbble.com/shots/808325-Facebook-Login-Freebie"
				target="_blank">Alex Montague</a>
		</p>
	</section>
</body>
</html>
