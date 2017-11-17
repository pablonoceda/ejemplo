<%@page import="com.proyectomercadolibre.prototipo1.util.ConfigReadWrite"%>
<%@page import="com.proyectomercadolibre.prototipo1.adapter.implement.RestMercadoAdapter"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <title>Settings</title>
        <meta charset="utf-8">        
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/site.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css" type="text/css"/>
    </head>
    <body>
        <jsp:include page="toolbar.jsp" />
        
        <div class="north">
            <div class="page-header">
                <h1>Configuraciones</h1>
            </div>
        </div>    
        <div class="west" style="top: 10px !important;">
            <form action="<c:url value='/checkSettings'/>" method="post" class="form-horizontal">
                <label class="control-group"><input type="checkbox" id="demo" name="demo" />  Mostrar Demo</label>
                <label class="control-group"><input type="checkbox" id="accessControl" name="accessControl" value="ON" />  Acceder al Control</label>
                <label class="control-group"><input type="checkbox" id="modifySettings" name="modifySettings" value="ON" />  Modificar en Settings</label>
                <div class="database_ip">
                    <div class="control-group">
                        <label class="offset1 subtitulo" >REST Server</label>
                        <label class="control-label">Ip</label>
                        <div class="controls"> 
                            <input type="text" name="databaseIp" value="<%
                                RestMercadoAdapter sep = new RestMercadoAdapter();
                                out.print(sep.getNOTIFICATION_SERVER_IP());
                                   %>" />
                        </div>
                        <label class="control-label">Port</label>
                        <div class="controls"> 
                            <input type="text" name="databasePort" value="<%
                                out.print(sep.getNOTIFICATION_SERVER_PORT());
                                   %>" />
                        </div>
                    </div>
                     <br/><br/> <br/> <br/> 
                    <a class="btn" href="<c:url value='/'/>">Cancel</a> <input id="Save" type="submit" class="btn btn-success " value="Save" />
                </div>

            </form>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script>
            $(document).ready(function () {

                $("#Save").click(function (event) {
                    var Enabled = [];
                    $("input[type=checkbox][name='settings[]']:checked").each(function () {
                        Enabled.push($(this).val());
                    });
                });

                check_settings();

            });

            function check_settings() {
                var accessControl = '${accessControl}';
                var demo = '${demo}';
                var modifySettings = '${modifySettings}';
                if (accessControl === "enabled") {
                    $('#accessControl').attr("checked", true);
                }
                if (demo === "enabled") {
                    $('#demo').attr("checked", true);
                }
                if (modifySettings === "enabled") {
                    $('#modifySettings').attr("checked", true);
                }
            }
        </script>
    </body>
</html>
