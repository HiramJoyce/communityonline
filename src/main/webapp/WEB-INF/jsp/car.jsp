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
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <style type="text/css">
        .layui-form-label {
            width: 100px;
        }
    </style>
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
                </div>
            </c:if>
            <c:if test="${sessionScope.id != null}">
                <div class="login">
                    <a href="${ctx}/logout">${sessionScope.realName}</a>
                </div>
            </c:if>
        </div>
    </div>
</div>


<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="母婴商城"> <!-- <img src="${ctx}/resource/ccpt_5_bbh/res/static/img/logo.png"> -->
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
        <div style="min-height: 600px; width: 600px; margin: auto; padding: 20px;">
            <h3>我的购物车</h3>
            <form id="allStudents" action="${ctx}/createTrade" method="post">
                <div style="margin-bottom: 10px;">
                    <button class="btn btn-danger" onclick="window.location.href='${ctx}/deleteCar'" type="button">清空</button>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="name" width="70">商品名</th>
                        <th class="name">单价</th>
                        <th class="node">数量</th>
                        <th class="node">总价</th>
                        <th class="operate">操作</th>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <c:forEach items="${goods}" var="good" varStatus="statu">
                        <tr align="center">
                            <td><input type="checkbox" name="id" value="${good.id}"/></td>
                            <td>${good.name}</td>
                            <td>${good.price}</td>
                            <td>${good.num}</td>
                            <td>${good.total}</td>
                            <td class="operate">
                                <a href="${ctx}/deleteCarGood?index=${statu.index}" class="del">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="layui-form-item">
                    <label class="layui-form-label">总价:</label>
                    <div class="layui-input-block">
                        <input type="text" name="place" required lay-verify="required" placeholder="请输入配送地址"
                               autocomplete="off" readonly value="${totalPrice}" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">配送地址:</label>
                    <div class="layui-input-block">
                        <input type="text" name="place" required lay-verify="required" placeholder="请输入配送地址"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-input-block">
                    <button ${totalPrice != null && totalPrice > 0 ? "" : "disabled"} class="layui-btn ${totalPrice != null && totalPrice > 0 ? "" : "layui-btn-disabled"}" lay-submit lay-filter="formDemo">提交订单</button>
                </div>
            </form>
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