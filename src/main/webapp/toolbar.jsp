<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>                
            </a>
           
            <div class="nav-collapse">
                <ul class="nav">
                    <li><a href="<c:url value='/'/>">Inicio</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Paginas <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <jsp:include page="MenuCode.jsp" />
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Ayuda <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value='/settings'/>">Configuraciones</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>