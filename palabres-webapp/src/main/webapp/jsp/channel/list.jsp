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

    <h2><s:text name="nav.listChannel" /></h2>
    <s:if test="#session.utilisateur">

    Utilisateur connecté :
    <s:property value="#session.utilisateur.pseudo" />
    <s:a action="logout" ><s:text name="nav.goLout" /></s:a>

    <div class="row">

        <div class="col-md-4">
            <div class="card">
                <div class="card-body">

    <ul class="list-group list-group-flush">
        <h5 class="card-title">Liste</h5>
        <p class="card-text">Les channels existants</p>
        <s:iterator value="listChannel">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <s:a action="message_list">
                <s:param name="name" value="name" />
                <s:property value="name"/>
                </s:a>
            </li>


        </s:iterator>
    </ul>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Nouveau Channel</h5>
                    <p class="card-text">Pour crèer un nouveau channel</p>
                    <s:a action="channel_new" class="btn btn-primary"><s:text name="nav.addChannel" /></s:a>
                </div>
            </div>
        </div>


    </div>


    </s:if>
    <s:else>
        Vous devez vous connecter!
    </s:else>
</div>
</body>
</html>