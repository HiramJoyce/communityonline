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
        <form  class="form-horizontal" action="${ctx}/setState" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${trade.id}">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">内容</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" name="content" class="layui-textarea" disabled>${trade.content}</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">配送地点</label>
                <div class="layui-input-block">
                    <input type="text" name="place" required lay-verify="required" value="${trade.place}" disabled placeholder="请输入预约地点"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">总价</label>
                <div class="layui-input-block">
                    <input type="text" name="totalPrice" required lay-verify="required" value="${trade.totalPrice}" disabled placeholder="请输入价格"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">支付码</label>
                <div class="layui-input-block">
                    <c:if test="${trade.payImg == null}">
                        <input type="file" name="img" required lay-verify="required" autocomplete="off" class="layui-input">
                    </c:if>
                    <c:if test="${trade.payImg != null}">
                        <img src="${ctx}/resource/uploadImg/${trade.payImg} " style="height: 128px; width: 128px;"/>
                    </c:if>
                </div>
            </div>
            <c:if test="${trade.state == '0' && sessionScope.role == 'shop'}">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">设置完成</button>
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