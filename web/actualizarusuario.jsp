<%-- 
    Document   : actualizarusuario
    Created on : 23/05/2021, 07:59:46 PM
    Author     : aza06
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Control.AccionesUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar cuenta</title>
    </head>
    <body>
        <h1>Ingresa los nuevos datos que quieras actualizar de tu cuenta.</h1>
        <br>
        <form method="post" name="actualizarusuario" action="actualizarUsuario">
                    <table border="2" >
                        <%
                            int id_usu = Integer.parseInt(request.getParameter("id_usu"));
                            
                            Usuario e = AccionesUsuario.buscarUsuarioById(id_usu);
                            %>
                        
                        <tr>
                            <td>Nombre:</td>
                            <td><input type="text" name="nom_usu2" size="30" value="<%=e.getNom_usu()%>"></td>        
                        </tr>
                        <tr>
                            <td>Contraseña:</td>
                            <td><input type="password" name="con_usu2" size="30" value="<%=e.getCon_usu()%>" ></td>        
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="email" name="ema_usu2" size="30" value="<%=e.getEma_usu()%>" ></td>        
                        </tr>

                        <tr>
                            <td colspan="2" ><input type="submit" 
                                                    value="Actualizar Usuario"></td>
                        </tr>        
                    </table>
                </form>
                        
              <a href="sesion.html" >Regresar</a>           
    </body>
</html>
