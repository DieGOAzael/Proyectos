<%-- 
    Document   : registroUsuario
    Created on : 23/05/2021, 01:17:29 AM
    Author     : aza06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--Este jsp no se muy bien que hace
        -->
        <h1>Registro de Empleado Exitoso</h1>
        <%
            HttpSession sesionCliente = request.getSession();
            
            //si es de una bd el metodo de verificarusuario(String user, Strig pass)
            //haces una instancias del usuario
                                                  //e.usuario  
            sesionCliente.setAttribute("Usuario", "e.usuario");
            %>
        <br>
        Bienvenido: <% out.println(sesionCliente.getAttribute("Usuario"));  %>
        <br>
        <a href="index.jsp" >Regresar al Menu Principal</a>
    </body>
</html>
