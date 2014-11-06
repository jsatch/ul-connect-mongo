<%-- 
    Document   : registro
    Created on : Nov 4, 2014, 5:16:20 PM
    Author     : hquintana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UL Connect</title>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Registro</h1>
        <form role="form" method="POST" action="RegistrarServlet">
            <div class="form-group">
                <label for="txt_codigo">Codigo</label>
                <input type="number" class="form-control" id="txt_codigo" name="txt_codigo" placeholder=" Ingrese c&oacute;digo">
            </div>
            <div class="form-group">
                <label for="txt_password">Password</label>
                <input type="password" class="form-control" id="txt_password" name="txt_password" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="txt_nombre">Nombre</label>
                <input type="text" class="form-control" id="txt_nombre" name="txt_nombre" placeholder="Nombre">
            </div>
            <div class="form-group">
                <label for="sel_perfiles">Perfiles</label>
                <select name="sel_perfiles">
                    <c:forEach var="perfil" items="${perfiles}">
                        <option value="${perfil.id}">${perfil.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="sel_carreras">Carreras</label>
                <select name="sel_carreras">
                    <c:forEach var="carrera" items="${carreras}">
                        <option value="${carrera.id}">${carrera.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit" class="btn btn-default">Registro</button>
            </div>
            
        </form>
    </body>
</html>
