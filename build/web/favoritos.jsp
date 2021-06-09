<%-- 
    Document   : favoritos
    Created on : 2/06/2021, 01:46:03 AM
    Author     : aza06
--%>

<%@page import="Modelo.FavLugar"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%
    String usuario = "";
    HttpSession sesionuok = request.getSession();
    if(sesionuok.getAttribute("usuario")==null){
    
    %>
    
    <jsp:forward page="index.jsp">
        <jsp:param name="error" value="Es obligatorio Identificarse" />
        
    </jsp:forward>
    
    <%
    
    }else{
        usuario = (String)sesionuok.getAttribute("usuario");
    }
    %>
<!DOCTYPE html>
<html>
    <head><meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/png">
    <link rel="stylesheet" href="style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Favoritos</title>
    </head>
    
    <body>
        <header>
       <ul>
           <li><img src="img/logo_lateral_negro.png" alt="El logo del servicio."></li>
           <li><a href="index.jsp"><b>Buscar</b></a></li>
           <li><a href="#"><b>Identificarse</b></a></li>
           <li><a href="quienes.html"><b>Conócenos</b></a></li>
           <li><a href="#" class="active"><b>Favoritos</b></a></li>
       </ul> 
    </header>  
        
        <%
              /*obtener primero el carrito
            Vector<FavLugar> vectorFavorito = 
                    (Vector<FavLugar>)sesionuok.getAttribute("detalleVenta");
            for(FavLugar e : vectorFavorito){
                */
            %>
            
            <div class="cuadro_lugares">
                <h1>Página en construcción.</h1>
                <h3>Página de Favoritos en proceso.</h3>
                <%--
                <div class="tbl-content">
              <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                  <tr>
                    <td><%=e.getNom_lugf()%></td>
                    <td><%=e.getSt_lugf()%></td>
                    <td><%=e.getTel_lugf()%></td>
                    <td><%=e.getCal_lugf()%></td>
                    <td>Agregar a Favoritos</td>
                  </tr>
                
                </tbody>
              </table>
            </div>
          --%>
    </div>
            
            <%    
            /*}
                */
            %>
            
    </body>
</html>
