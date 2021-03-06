<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>QuestionPage</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <style type="text/css">
        .form-group {
            height: 27px;
        }
    </style>
</head>
<body>
<div class="container" style="padding: 20px;">
    <a href="#" onclick="history.back()">返回</a>
    <div style="width: 500px; margin: auto;">
        <form  class="form-horizontal" action="${ctx}/updateGood" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${good.id}">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">商品名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name" value="${good.name}" placeholder="${good.name}">
                </div>
            </div>
            <div class="form-group">
                <label for="price" class="col-sm-2 control-label">价格</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="price" id="price" value="${good.price}" placeholder="${good.price}">
                </div>
            </div>
            <div class="form-group">
                <label for="img" class="col-sm-2 control-label">图片</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="img" id="img"/>
                </div>
            </div>
            <div class="form-group" style="text-align: center; margin-top: 50px;"><input class="btn btn-info" style="width: 150px;" type="submit" value="提交"></div>
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