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
<%@ include file="menu.jsp" %>


<div class="container" >
    <%@ include file="_include/header.jsp" %>
    <h2>Connexion</h2>



    <s:form action="login" class="form-group">

        <s:textfield name="Login" label="Identifiant" requiredLabel="true" id="nameFieldId"/>

        <s:submit value="Connexion"/>
    </s:form>

</div>
</body>
</html>