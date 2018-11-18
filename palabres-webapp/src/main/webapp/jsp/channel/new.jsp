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
    <h2><s:text name="nav.newChannel" /></h2>

    <s:if test="#session.utilisateur">



        <s:form action="channel_new">

            <s:textfield name="channel.name" label="Nom du Channel" requiredLabel="true" />


            <s:submit value="OK"/>



        </s:form>
    </s:if>
    <s:else>
        <s:a action="login">Vous devez vous connecter!</s:a>
    </s:else>




</div>
</body>
</html>