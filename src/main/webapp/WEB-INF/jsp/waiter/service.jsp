<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>QuestionPage</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/ccpt_5_bbh/res/layui/css/layui.css">
    <style type="text/css">
        .layui-form-label {
            width: 100px;
        }
    </style>
</head>
<body>
<div class="container" style="padding: 20px;">
    <a href="#" onclick="history.back()">返回</a>
    <div style="width: 600px; margin: auto;">
        <form  class="form-horizontal" action="${ctx}/finishService" method="post">
            <input type="hidden" name="id" value="${service.id}">
            <div class="layui-form-item">
                <label class="layui-form-label">标题</label>
                <div class="layui-input-block">
                    <input type="text" name="title" required lay-verify="required" disabled value="${service.title}" placeholder="请输入标题"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">服务说明</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" name="content" class="layui-textarea" disabled>${service.content}</textarea>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <div class="layui-form-item">
                        <label class="layui-form-label">预约时间</label>
                        <div class="layui-input-inline" style="margin: 10px;">
                            <input type="text" class="layui-input" name="time" value="<fmt:formatDate value="${service.time}" pattern="yyyy-MM-dd"/>" disabled id="test1" placeholder="yyyy-MM-dd">
                        </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">预约地点</label>
                <div class="layui-input-block">
                    <input type="text" name="place" required lay-verify="required" value="${service.place}" disabled placeholder="请输入预约地点"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">价格</label>
                <div class="layui-input-block">
                    <input type="text" name="price" required lay-verify="required" value="${service.price}" disabled placeholder="请输入价格"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <c:if test="${service.state == '2' && sessionScope.role == 'waiter'}">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">结果</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" name="reply" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    </div>
                </div>
            </c:if>
            <c:if test="${service.state == '3'}">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">结果</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" name="reply" disabled class="layui-textarea">${service.reply}</textarea>
                    </div>
                </div>
            </c:if>
        </form>
    </div>
</div>
<script src="${ctx}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });
</script>
</body>
</html>