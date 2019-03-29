<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
<div class="content content-nav-base">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="${ctx}/" class="active">便利店在线</a> <a href="${ctx}/service"
                >预约服务</a> <a href="${ctx}/help">求助交流</a> <a
                        href="${ctx}/advice">投诉与建议</a>
                </div>
            </div>
        </div>
    </div>

    <div>
        <div style="min-height: 600px; width: 800px; margin: auto; padding: 20px;">
            <h3>订单详情</h3>
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">内容</h3>
                        <p>
                            ${trade.content}
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">配送地址</h3>
                        <p>
                            ${trade.place}
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">总价</h3>
                        <p>
                            ￥${trade.totalPrice}
                        </p>
                    </div>
                </li>
                <c:if test="${trade.payImg != null}">
                    <h3>支付码：<img src="${ctx}/resource/uploadImg/${trade.payImg}"
                                 style="width: 128px; height: 128px;"></h3>

                    <li class="layui-timeline-item">
                        <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                        <div class="layui-timeline-content layui-text">
                            <h3 class="layui-timeline-title">支付码</h3>
                            <p>
                                <img src="${ctx}/resource/uploadImg/${trade.payImg}"
                                     style="width: 128px; height: 128px;">
                            </p>
                        </div>
                    </li>
                </c:if>
            </ul>
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
        base: '${ctx}/resource/ccpt_5_bbh/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'carousel'], function () {
        var carousel = layui.carousel, mm = layui.mm;
        var option = {
            elem: '#test1',
            width: '100%' //设置容器宽度
            ,
            arrow: 'always',
            height: '298',
            indicator: 'none'
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