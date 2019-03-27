<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ServicePage</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
</head>
<body>
<div>
    <div class="container" style="padding: 20px;">
        <c:if test="${message != null}">
            <div class="alert alert-success alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <strong>Success!</strong> ${message}
            </div>
        </c:if>
        <c:if test="${error != null}">
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <strong>Error!</strong> ${error}
            </div>
        </c:if>
        <div style="margin-bottom: 10px;">
            <button class="btn btn-success" onclick="window.location.href='${ctx}/updateGood'">添加</button>
            <button class="btn btn-danger" type="button" onclick="deleteGood()">删除</button>
        </div>
        <form id="allStudents" action="${ctx}/deleteGood" method="post">
            <h3>全部商品</h3>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="num"></th>
                    <th class="name" width="70">展示图</th>
                    <th class="name">商品名</th>
                    <th class="node">价格</th>
                    <th class="operate">操作</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach items="${goods}" var="good">
                    <tr align="center">
                        <td><input type="checkbox" name="id" value="${good.id}"/></td>
                        <td><img src="${ctx}/resource/upload/${good.img}" style="width: 64px; height: 64px;" alt="">
                        </td>
                        <td>${good.name}</td>
                        <td>${good.price}</td>
                        <td class="operate">
                            <a href="${ctx}/deleteGood?id=${good.id}" class="del">下架</a>
                            <a href="${ctx}/updateGood?id=${good.id}" class="del">编辑</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script src="${ctx}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script>
    function deleteGood() {
        var ids = "";
        $("input:checkbox[name='id']:checked").each(function () {
            ids += $(this).val() + ",";
        });
        //判断最后一个字符是否为逗号，若是截取
        var id = ids.substring(ids.length - 1, ids.length);
        if (id === ",") {
            ids = ids.substring(0, ids.length - 1);
        }
        if (ids === "") {
            alert("请选择要删除的记录！");
            return;
        }
        $("#allStudents").submit();
    }

    //    function checkFile() {
    //        var excelFile = $("#excelFile").val();
    //        if (excelFile === "" || excelFile.length === 0) {
    //            alert("请选择文件路径！");
    //            return false;
    //        } else {
    //            return true;
    //        }
    //    }
</script>
</body>
</html>