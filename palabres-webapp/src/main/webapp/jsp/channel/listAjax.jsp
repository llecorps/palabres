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

    <h2><!s:property value="channel.name"  /></h2>

        <s:set var="Channel" value="channel.name" />

    </ul>


        <s:textfield name="channel" value="%{Channel}" id="leChannel" />

        <div id="channel-messages">
            <ul id="listMessage">
                <div class="media mb-3 message">


                </div>
            </ul>
        </div>
        <button onclick="reloadListMessage()" class="btn btn-primary">Refresh</button>
    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
                    url,
                    params,
                    function (data) {
                        var $listMessage = jQuery("#listMessage");
                        $listMessage.empty();
                        jQuery.each(data, function (key, val) {
                            $listMessage.append(
                                    jQuery("<i class='far fa-user fa-2x m-1 mr-3'>")
                                            .append("<div class='media-body'>")
                                            .append("<h5 class='mt-1 mb-0 user'>")
                                            .append(val.author.pseudo+" :</h5>")

                                            .append("</i>")
                                            .append("<span class='text'>")
                                            .append("<h6>")
                                            .append(val.message)
                                            .append("</h6>")
                                            .append("</span>")
                                            .append("</div>")

                            

                            );
                        });
                    })
                    .fail(function () {
                        alert("Une erreur s'est produite.");
                    });
        }
    </script>
    <s:debug />
</body>
</html>