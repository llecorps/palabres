<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>

<body>
<%@ include file="menu.jsp" %>
<s:actionerror/>
<s:actionmessage />

<div class="container">

    <%@ include file="_include/header.jsp" %>




    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Login</h5>
                    <p class="card-text"> Tu as déjà ton pseudo.</p>
                    <s:a action="login" class="btn btn-primary"><s:text name="nav.goChannel" /></s:a>




                </div>
            </div>
        </div>


        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Compte</h5>
                    <p class="card-text">Créer ton pseudo </p>
                    <s:a action="addLogin" class="btn btn-primary"><s:text name="nav.goChannel" /></s:a>




                </div>
            </div>
        </div>

    </div>


</div>

</body>
</html>
