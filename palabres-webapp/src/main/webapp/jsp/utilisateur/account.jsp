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
    <!%@ include file="../_include/header.jsp" %>
    <h2><s:text name="nav.account" /></h2>

    <s:if test="#session.utilisateur">
        <s:a action="logout">Vous êtes déja connectés !</s:a>
    </s:if>
    <s:else>

        <s:form action="account">

            <s:textfield name="utilisateur.pseudo" label="Pseudo" requiredLabel="true" />

            <s:submit value="OK"/>

        </s:form>
    </s:else>


</div>
</body>
</html>