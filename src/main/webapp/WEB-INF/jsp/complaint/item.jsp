<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <script type="text/javascript"
            src="${ctx}/resource/ccpt_5_bbh/res/layui/layui.js"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <style type="text/css">
        .layui-form-label {
            width: 100px;
        }
    </style>
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
                    <a href="${ctx}/">便利店在线</a> <a href="${ctx}/service"
                >预约服务</a> <a href="${ctx}/help">求助交流</a> <a
                        href="${ctx}/advice" class="active">投诉与建议</a>
                </div>
            </div>
        </div>
    </div>
    <div style="min-height: 600px; width: 600px; margin: auto; padding: 20px;">
        <a href="${ctx}/advice">返回</a>
        <div style="width: 700px; margin: auto;">
            <h3 class="media-heading">详情</h3>
        </div>
        <div style="width: 700px; margin: auto; border: 1px gray solid; border-radius: 5px;">
            <div style="padding: 5px 5px 5px 10px;">
                <span style="color: gray; font-size: 13px;" class="media-heading">${complaint.userId} - <fmt:formatDate
                        value="${complaint.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                <p>${complaint.content}</p>
                <c:if test="${complaint.img != null}">
                    <img style='width: 128px;' src='${ctx}/resource/uploadImg/${complaint.img}'>
                </c:if>
            </div>
            <div id="complaints">
                <c:forEach items="${complaints}" var="reply">
                    <div style="border-top: 1px gray solid;">
                        <table>
                            <tr>
                                <td style="width: 64px; vertical-align: top;">
                                    <div style="width: 64px; height: 64px; font-size: 50px; color: gray; text-align: center; padding-top: 5px;">
                                        <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span></div>
                                </td>
                                <td style="padding: 5px 0;">
                                    <span style="color: gray; font-size: 13px;" class="media-heading">${reply.realName} - <fmt:formatDate
                                            value="${reply.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    <p>${reply.content}</p>
                                    <c:if test="${reply.img != null}">
                                        <img style='width: 128px;' src='${ctx}/resource/uploadImg/${reply.img}'>
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
                <div style="clear: both;"></div>
            </div>
        </div>
        <div style="width: 700px; margin: auto; border: 1px gray solid; border-radius: 5px; padding: 20px; margin-top: 20px;">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">回复</button>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">回复信息</h4>
                        </div>
                        <form action="${ctx}/complaint/reply" method="post" enctype="multipart/form-data">
                            <div class="modal-body">
                                <input type="hidden" name="parentId" value="${complaint.id}" id="parentId">
                                <div class="form-group">
                                    <label for="content">回复内容</label>
                                    <textarea class="form-control" rows="3" name="content" id="content"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="img">图片</label>
                                    <input type="file" name="img" id="img">
                                    <p class="help-block">如有必要请上传图片</p>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button class="btn btn-primary" id="complaintSubmit">提交</button>
                            </div>
                        </form>
                    </div>
                </div>
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
<script src="${ctx}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
