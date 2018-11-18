<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Login</title>

    <link href="<c:url value="/jsp/assets/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/jsp/assets/js/jquery.js" />"></script>
    <script src="<c:url value="/jsp/assets/js/bootstrap.min.js" />"></script>



</head>
<body>
<%@ include file="../menu.jsp" %>


<div class="container" >
    <%@ include file="../_include/header.jsp" %>
    <h2><s:text name="nav.messages" /></h2>
<div class="row">
    <div class="col-2">
        <s:a action="message_list" class="btn btn-primary">
           <s:text name="nav.refresh" />
        </s:a>

     </div>
    <div class="col-10">
    <ul class="list-group list-group-flush">
    <s:iterator value="listMessage">
        <li class="list-group-item d-flex justify-content-between align-items-center">
            <span class="badge badge-primary badge-pill">
            <s:property value="author"/>
            </span>
            <s:property value="message"/>

        </li>


    </s:iterator>

    </ul>
</div>
</div>
</div>
</body>
</html>
