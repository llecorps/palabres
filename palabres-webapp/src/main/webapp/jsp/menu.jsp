<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Menu</title>

    <link href="<c:url value="/jsp/assets/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/jsp/assets/js/jquery.js" />"></script>
    <script src="<c:url value="/jsp/assets/js/bootstrap.min.js" />"></script>



</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Palabres</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            
            <li class="nav-item active">

                <s:a action="index" class="nav-link"><s:text name="nav.index" /></s:a> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <s:a action="channel_list" class="nav-link"><s:text name="nav.channel" /></s:a> <span class="sr-only">(current)</span></a>
            </li>
<!--
            <li class="nav-item">
                <s:if test="#session.utilisateur">
                    <s:a action="logout" class="nav-link">Logout</s:a>
                </s:if>
                <s:else>
                    <s:a action="login" class="nav-link">Login</s:a>
                </s:else>
                <span class="sr-only">(current)</span></a>
            </li>

-->

        </ul>




    </div>
</nav>

</body>
</html>