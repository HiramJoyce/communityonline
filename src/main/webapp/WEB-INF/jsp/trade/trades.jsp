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
        <form id="allStudents" action="${ctx}/deleteTrade" method="post">
            <h3>全部订单</h3>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="num"></th>
                    <th class="name" width="70">内容</th>
                    <th class="name">总价</th>
                    <th class="node">配送地址</th>
                    <th class="node">支付码</th>
                    <th class="node">状态</th>
                    <th class="operate">操作</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach items="${trades}" var="trade">
                    <tr align="center">
                        <td><input type="checkbox" name="id" value="${trade.id}"/></td>
                        <td><a href="${ctx}/passTrade?id=${trade.id}">${trade.content}</a></td>
                        <td>${trade.totalPrice}</td>
                        <td>${trade.place}</td>
                        <td><c:if test="${trade.payImg != null}"><img src="${ctx}/resource/uploadImg/${trade.payImg}" style="width: 64px; height: 64px;"></c:if></td>
                        <td>${trade.state == "0" ? "待接单" : trade.state == "1" ? "待支付" : trade.state == "2" ? "待确认" : trade.state == "3" ? "配送中" :"已完成"}</td>
                        <td class="operate">
                            <c:if test="${trade.state == '0'}">
                                <a href="${ctx}/passTrade?id=${trade.id}" class="del">接单</a>
                            </c:if>
                            <c:if test="${trade.state == '2'}">
                                <a href="${ctx}/sendTrade?id=${trade.id}" class="del">配送</a>
                            </c:if>
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