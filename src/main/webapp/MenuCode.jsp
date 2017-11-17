<%@page import="com.proyectomercadolibre.prototipo1.util.ConfigReadWrite"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    ConfigReadWrite properties = new ConfigReadWrite();
    if (properties.getPropValues("demo") != null && properties.getPropValues("demo").equals("enabled")) {%>
<li><a href='<c:url value='/demo'/>'>Demo </a></li>    <% }
    %>
