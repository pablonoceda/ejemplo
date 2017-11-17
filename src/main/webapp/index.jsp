<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Home</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/global.css" rel="stylesheet">        
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="toolbar.jsp" />

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <jsp:include page="MenuCode.jsp" />  
                        </ul>
                    </div>
                </div>
                <div class="span9">
                    <div class="well hero-unit">
                        <h1>Demo</h1>
                    </div>
                </div>
            </div>
        </div>         
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>
