<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>StudentPage</title>
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
            <button class="btn btn-success" onclick="window.location.href='${ctx}/addWaiter'">添加</button>
            <button class="btn btn-danger" type="button" onclick="deleteWaiter()">删除</button>
            <%--<button class="btn btn-info" data-toggle="modal" data-target="#myModal">导入</button>--%>
        </div>
        <form id="allStudents" action="${ctx}/deleteWaiter" method="post">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="num"></th>
                    <th class="name">ID</th>
                    <th class="name">编号</th>
                    <th class="operate">用户名</th>
                    <th class="node">姓名</th>
                    <th class="process">密码</th>
                    <th class="operate">操作</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach items="${students}" var="student">
                    <tr align="center">
                        <td><input type="checkbox" name="id" value="${student.id}"/></td>
                        <td>${fn:substring(student.id, 0, 10)}...</td>
                        <td>${student.studentNum}</td>
                        <td>${student.userName}</td>
                        <td>${student.realName}</td>
                        <td>${student.password}</td>
                        <td class="operate">
                            <a href="${ctx}/deleteWaiter?id=${student.id}" class="del">删除</a>
                            <a href="${ctx}/updateWaiter?id=${student.id}" class="del">编辑</a>
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
    function deleteWaiter() {
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