<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />

<style type="text/css">
.bk1 {
	background: pink;
	height: 0.5cm;
}

.bk2 {
	background: lightGreen;
	height: 0.5cm;
}

.bk3 {
	background: lightBlue;
	height: 0.5cm;
}

.margin-top {
	margin-top: 0.5cm;
}
</style>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-1 bk1"></div>
			<div class="col-10 bk2"></div>
			<div class="col-1 bk3"></div>
		</div>
	</div>

	<div class="container margin-top">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10" style="text-align: center">

				<form action="<%=request.getContextPath()%>/LoginServlet" method="POST">

					<input type="hidden" name="action" value="doLogin">

					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">輸入e-mail</span>
						</div>
						<input type="text" class="form-control" name="email" placeholder="email" value="fuckyou@ctbcbank.com">
					</div>

					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">輸入密碼</span>
						</div>
						<input type="text" class="form-control" name="password" placeholder="Password" value="qweasdzxc123">
					</div>

					<div class="input-group mb-3" style="width: 100%">
						<div class="input-group-prepend">
							<span class="input-group-text">輸入驗證碼</span>
						</div>
						<input type="text" class="form-control" name="verifyCode" placeholder="驗證碼" value=""> <img id="codeimg" width="200" src="<%=request.getContextPath()%>/GenVerifyCodeServlet" style="margin-left: 0.5cm">
					</div>

					<button type="submit" class="btn btn-primary">登入</button>
					<button type="reset" class="btn btn-second">清空</button>
					<!-- 					<input type="reset" value='Reset' class="btn btn-second" /> -->
					<button type="button" class="btn btn-info" onclick="changeImg()">換一張</button>
				</form>

			</div>
			<div class="col-1"></div>
		</div>
	</div>

	<%@page import="java.util.Enumeration"%>
	<%
// 		Enumeration<?> enumeration = session.getAttributeNames();
// 		while (enumeration.hasMoreElements()) {
// 			String name = (String) enumeration.nextElement();
// 			Object val = session.getAttribute(name);
// 			System.out.println("in jsp" + name  + "<===>" + val);
// 		}
	%>

	<div class="container margin-top">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">參考資料：https://hk.saowen.com/a/9b3048dff7a3d0274ce46a29d2e5e127fd6f1712704dbf146fd9215cc9da012d</div>
			<div class="col-1"></div>
		</div>
	</div>

	<script type="text/javascript">
		//改變驗證碼事件
		function changeImg(){
			var img = document.getElementById('codeimg');
			// img.src = "${pageContext.request.contextPath}/GenVerifyCodeServlet?x=" + Math.floor( Math.random() * 100 );
			img.src = "${pageContext.request.contextPath}/GenVerifyCodeServlet?ggggg=" + Math.floor(Math.random() * 100);
		}
	</script>
</body>
</html>