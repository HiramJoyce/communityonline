<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/resource/ccpt_5_bbh/res/static/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resource/ccpt_5_bbh/res/layui/css/layui.css">
<script type="text/javascript"
	src="${ctx}/resource/ccpt_5_bbh/res/layui/layui.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body id="list-cont">
	<div class="site-nav-bg">
		<div class="site-nav w1200">
			<p class="sn-back-home">
				<i class="layui-icon layui-icon-home"></i> <a href="${ctx}/">首页</a>
			</p>
			<div class="sn-quick-menu">
                <c:if test="${sessionScope.id == null}">
                    <div class="login">
                        <a href="${ctx}/login">登录</a>
						<a href="${ctx}/register">注册</a>
                    </div>
                </c:if>
                <c:if test="${sessionScope.id != null}">
                    <div class="login">
						<a href="${ctx}/studentInfo">${sessionScope.realName}</a>
						<a href="${ctx}/logout">注销</a>
						<a href="${ctx}/car">购物车</a>
                    </div>
                </c:if>
			</div>
		</div>
	</div>

	<div class="header">
		<div class="headerLayout w1200">
			<div class="headerCon">
				<h1 class="mallLogo">
					<a href="#" title=""> <!-- <img src="${ctx}/resource/ccpt_5_bbh/res/static/img/logo.png"> -->
						<h3>社区</h3>
					</a>
				</h1>
				<div class="mallSearch">
					<form action="" class="layui-form" novalidate>
						<input type="text" name="title" required lay-verify="required"
							autocomplete="off" class="layui-input" placeholder="">
						<button class="layui-btn" lay-submit lay-filter="formDemo">
							<i class="layui-icon layui-icon-search"></i>
						</button>
						<input type="hidden" name="" value="">
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="content content-nav-base login-content">
		<div class="main-nav">
			<div class="inner-cont0">
				<div class="inner-cont1 w1200">
					<div class="inner-cont2">
						<a href="${ctx}/">便利店在线</a> <a href="${ctx}/service">预约服务</a>
						<a href="${ctx}/help">求助交流</a> <a href="${ctx}/advice">投诉与建议</a>
					</div>
				</div>
			</div>
		</div>
		<div class="login-bg">
			<div class="login-cont w1200">
				<div class="form-box" style="height: auto; top: 66px;">
					<form class="layui-form" action="${ctx}/studentRegister">
						<legend>用户注册</legend>
						<div class="layui-form-item">
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-username iphone-icon"></i> <input
										type="tel" name="userName" id="userName" lay-verify="required"
										placeholder="请输入用户名" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-auz iphone-icon"></i> <input
										type="tel" name="realName" id="realName" lay-verify="required"
										placeholder="请输入姓名" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-file-b iphone-icon"></i> <input
										type="tel" name="studentNum" id="student_num" lay-verify="required"
										placeholder="请输入用户编号" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
                                    <i class="layui-icon layui-icon-password iphone-icon"></i> <input
                                        id="pnum" type="password" name="password" lay-verify="required"
										placeholder="请输入密码" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-password iphone-icon"></i> <input
										id="pnum2" type="password" name="password2" lay-verify="required"
										placeholder="请确认密码" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-component iphone-icon"></i> <input
										id="chapter" type="text" name="chapter" lay-verify="required"
										placeholder="请输入楼号" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-location iphone-icon"></i> <input
										id="section" type="text" name="section" lay-verify="required"
										placeholder="请确认单元" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div class="layui-form-item login-btn">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit="" lay-filter="demo1"
									type="submit">注册</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="footer" style="padding: 0;">
		<div class="mod_help w1200">
			<p style="margin: 0; line-height: 100px;">
				<a href="javascript:;">关于我们</a> <span>|</span> <a
					href="javascript:;">帮助中心</a> <span>|</span> <a href="javascript:;">服务人员登录</a>
				<span>|</span> <a href="javascript:;">管理员登录</a>
			</p>
		</div>
	</div>
	<script type="text/javascript">
		layui.config({
			base : '${ctx}/resource/ccpt_5_bbh/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
		}).use([ 'mm', 'carousel' ], function() {
			var carousel = layui.carousel, mm = layui.mm;
			var option = {
				elem : '#test1',
				width : '100%' //设置容器宽度
				,
				arrow : 'always',
				height : '298',
				indicator : 'none'
			}
			carousel.render(option);
			// 模版引擎导入
			// var ins = carousel.render(option);
			// var html = demo.innerHTML;
			// var listCont = document.getElementById('list-cont');
			// // console.log(layui.router("#/about.html"))
			//  mm.request({
			//    url: '${ctx}/resource/ccpt_5_bbh/json/index.json',
			//    success : function(res){
			//      console.log(res)
			//      listCont.innerHTML = mm.renderHtml(html,res)
			//      ins.reload(option);
			//    },
			//    error: function(res){
			//      console.log(res);
			//    }
			//  })

		});
	</script>
</body>
</html>