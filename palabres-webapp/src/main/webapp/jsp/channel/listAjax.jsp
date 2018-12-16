<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html>
<head>

    <%@ include file="../_include/head.jsp" %>


</head>
<body>
<%@ include file="../_include/header.jsp" %>


<div class="container" >
    <h2><s:property value="channel.name"  /></h2>
    <s:set var="Channel" value="channel.name" />
    <s:hidden name="channel" value="%{Channel}" id="leChannel" />

    <div id="channel-messages">
        <div class="media mb-3 message">
            <ul id="listMessage" class="media-body">
                <h5 class="mt-1 mb-0 user" ></h5>
                <span class="text" id="idMessage"></span>
            </ul>
        </div>
    </div>

    <div class="row" class="jumbotron" >

        <div class="col col-lg-5">
            <form action="#" method="post">
                <input type="text" id="leMessage" size="27"/>
                <button  id="envoyer"  class="btn btn-primary">Post</button>
            </form>
        </div>

        <div class="col col-lg-3">
            <button onclick="reloadListMessage()" class="btn btn-primary">Refresh</button>
            <span>Auto-refresh</span>
            <input type="checkbox" name="autoRefresh" value="true" id="xx_checkMe"/>
        </div>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

    $(function() {
        reloadListMessage();

        $('#envoyer').click(function() {

            var channel = {
                channel: jQuery("Random").val()
            };
            var message = {
                message: jQuery("test").val()
            };
 alert('channel:' + channel +'message:'+message);

            var url = "<s:url action="action_ajax_addMessage"/>";
            $.post(url, {
                channel,
                message
            }, reloadListMessage);
        });

        function reloadListMessage() {
            // URL de l'action AJAX
            var url = "<s:url action="action_ajax_getListMessage"/>";

            // Paramètres de la requête AJAX
            var params = {
                channel: jQuery("#leChannel").val()
            };
            alert('channel:' + channel);
            // Action AJAX en POST

            jQuery.post(
                    url,
                    params,
                    function (data) {
                        var $listMessage = jQuery("#listMessage");
                        $listMessage.empty();
                        jQuery.each(data, function (key, val) {

                            $listMessage.append(
                                    jQuery("<i class='far fa-user fa-2x m-1 mr-3'/>" +
                                            "<br>")
                                            .append('<strong>'+" "+val.author.pseudo+" : "+'</strong>')
                                            .append(val.message)


                            );
                        });
                        $('i').css('font-size','1em');
                    })
                    .fail(function () {
                        alert("Une erreur s'est produite.");
                    });
        }



        //setInterval(reloadListMessage, 4000);
    });







</script>
<script>
    function reloadListMessage() {
        // URL de l'action AJAX
        var url = "<s:url action="action_ajax_getListMessage"/>";

        // Paramètres de la requête AJAX
        var params = {
            channel: jQuery("#leChannel").val()
        };

        // Action AJAX en POST

        jQuery.post(
                <s:url action="action_ajax_getListMessage"/>,
                params,
                function (data) {
                    var $listMessage = jQuery("#listMessage");
                    $listMessage.empty();
                    jQuery.each(data, function (key, val) {

                        $listMessage.append(
                                jQuery("<i class='far fa-user fa-2x m-1 mr-3'/>" +
                                        "<br>")
                                        .append('<strong>'+" "+val.author.pseudo+" : "+'</strong>')
                                        .append(val.message)


                        );
                    });
                    $('i').css('font-size','1em');
                })
                .fail(function () {
                    alert("Une erreur s'est produite.");
                });
    }
</script>


</body>
</html>