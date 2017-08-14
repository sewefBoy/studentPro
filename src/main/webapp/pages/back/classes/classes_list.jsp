<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>优乐在线教育图书管理系统</title>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<!--主体内容编写-->
<div id="page-wrapper">
    <div class="col-md-12">
        <div class="col-md-12">
            <!-- 标准的按钮 -->
            <button type="button" class="btn btn-primar" style="float: right" id="deleteByn">删除</button>
            <!-- 标准的按钮 -->
            <button type="button" class="btn btn-primar" style="float: right" id="updateByn">修改</button>
        </div>
        <table class="table table-bordered table-hover" id="classesTable">
            <tr>
                <th><input type="checkbox" id="allCheak"/></th>
                <th>班级编号</th>
                <th>班级名称</th>
                <th>班级简介</th>
            </tr>
        </table>
    </div>
</div>

<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/classes_list.js"></script>
</body>
</html>
