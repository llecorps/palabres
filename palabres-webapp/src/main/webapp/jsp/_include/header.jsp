<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>
    <s:if test="#session.utilisateur">
        Utilisateur connecté :
        <s:property value="#session.utilisateur.pseudo" />
        <s:a action="logout" ><s:text name="nav.goLout" /></s:a>
    </s:if>
    <s:else>
        Vous devez vous connecter!
    </s:else>

</header>


<s:actionerror/>
<s:actionmessage/>