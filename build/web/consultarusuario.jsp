<%-- 
    Document   : consultarEmpleados
    Created on : 14/05/2021, 06:29:44 PM
    Author     : DataJockey
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Control.AccionesUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Seccion que como administradores podemos controlar</title>
    </head>
    <body>
        <h1>Tabla de Todos los Usuarios</h1>
        <br>
        <table border="2" >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Contraseña</th>
                    <th>Email</th>
                    <th></th>
                    <th></th>
                </tr>        
            </thead>
            <tbody>
                <%
                    List<Usuario> lista = AccionesUsuario.getAllUsuario();
                    for(Usuario e : lista){
                    %>
                    <tr>
                        <td> <%=e.getId_usu()%> </td>
                        <td> <%=e.getNom_usu()%> </td>
                        <td> <%=e.getEma_usu()%> </td>
                        <td> <%=e.getCon_usu()%> </td>
                        <td> <a href="editarempleado.jsp?id=<%=e.getId_usu()%>" >Editar</a> </td>
                        <td> <a href="borrarempleado?id=<%=e.getId_usu()%>" >Borrar</a> </td>
                    </tr>    
                    <%
                    }
                    %>
            </tbody>
        </table>
        <br>
        <a href="controlAdmin.html" >Regresar a los controles</a>
    </body>
</html>
