<%-- 
    Document   : index
    Created on : 18/05/2021, 01:57:41 AM
    Author     : DataJockey
--%>

<%@page import="Control.AccionesLugar"%>
<%@page import="Modelo.Lugar"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/png">
    <link rel="stylesheet" href="style.css">
    
    <title>Salud.Maps | Buscar</title>
</head>
<body>
    <header>
       <ul>
           <li><img src="img/logo_lateral_negro.png" alt="El logo del servicio."></li>
           <li><a href="#" class="active"><b>Buscar</b></a></li>
           <li><a href="sesion.html"><b>Identificarse</b></a></li>
           <li><a href="quienes.html"><b>Conócenos</b></a></li>
           <li><a href="favoritos.jsp"><b>Favoritos</b></a></li>
           <li><a href="controlAdmin.html"><b>Administrador</b></a></li>
           
       </ul> 
    </header>
    <div class="intro-header">
      <div class="bg-overlay">
        <div class="container">
  

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>Salud.Maps</h1>
                        <hr class="intro-divider">
                        <h3>El sitio donde ves todo lo relacionado a la salud en un clic.</h3>
                        <ul class="list-inline intro-social-buttons">
                        </ul>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
      </div>
    </div>

        
    <div class="cuadro_busqueda">
        <p style="margin-left: 25px">Llena los filtros para realizar una búsqueda.<hr>
        <!--Aquí es la selección del tipo de lugar relacionado a la salud.-->
        <form action="">
        <select name="tipo" id="id_tip" style="margin-left: 25px; font-size: large;">
            <option value="0">Lugar</option>
            <option value="1">Centro de salud</option>
            <option value="2">Hospital</option>
            <option value="3">Funeraria</option>
        </select>
        <!--Aquí es la selección de las alcaldías.-->
        <select name="alcaldia" id="id_alc" style="margin-left: 50px; font-size: large;">
            <option value="0">Alcaldía</option>
            <option value="1">Azcapotzalco</option>
            <option value="2">Benito Juárez</option>
            <option value="3">Coyoacán</option>
            <option value="4">Cuajimalpa de Morelos</option>
            <option value="5">Cuauhtémoc</option>
            <option value="6">Gustavo A. Madero</option>
            <option value="7">Iztacalco</option>
            <option value="8">Iztapalapa</option>
            <option value="9">La Magdalena Contreras</option>
            <option value="10">Álvaro Obregón</option>
            <option value="11">Miguel Hidalgo</option>
            <option value="12">Milpa Alta</option>
            <option value="13">Tlalpan</option>
            <option value="14">Tláhuac</option>
            <option value="15">Venustiano Carranza</option>
            <option value="16">Xochimilco</option>
        </select>
        <input type="submit" value="Buscar" style="margin-left: 500px; font-size: large;">
        </form>
    </div>
    <%
        /*
        String id_tip, id_alc;
            
            id_tip = request.getParameter("id_tip");
            id_alc = request.getParameter("id_alc");
*/
        %>

     <%
            //todos los lugares
            List<Lugar> lista = new AccionesLugar().getAllLugar();
            
            %>
            
            <div class="cuadro_lugares">
        
            <!--Encabezado-->
            <div class="tbl-header">
              <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                  <tr>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Calificación</th>
                    <th>Abrir lugar</th>
                    <th>Agregar a favoritos</th>
                  </tr>
                </thead>
              </table>
            </div>
        
            </div>
        
            
            <%
            //recorrer el vector del producto
            for(Lugar lugar : lista){
            //voy imprimiendo producto por producto
            
            %>
        
            <!--Empieza la tabla de los lugares-->
            <div class="cuadro_lugares">
                
                <div class="tbl-content">
              <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                  <tr>
                    <td><%=lugar.getNom_lug()%></td>
                    <td><%=lugar.getSt_lug()%></td>
                    <td><%=lugar.getTel_lug()%></td>
                    <td><%=lugar.getCal_lug()%></td>
                    <td><!--Pop up -->
                        <div class="contenedor">
                            <article>
                                <button id="btn-abrir-popup" class="btn-abrir-popup">Abrir lugar</button>

                            </article>

                            <div class="overlay" id="overlay">
                                <div class="popup" id="popup">
                                    <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
                                    <h3>SUSCRIBETE</h3>
                                    <h4>Información del Lugar</h4>
                                    <div class="tbl-content">
                                    <table cellpadding="0" cellspacing="0" border="0">

                                    <tr>
                                    <td>hola</td>
                                    <td>AUSTRALIAN COMPANY </td>
                                    <td>$1.38</td>
                                    <td>+2.01</td>
                                    <td>-0.36%</td>
                                    </tr>              
                                    </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </td>
                    <td>Agregar a Favoritos</td>
                  </tr>
                
                </tbody>
              </table>
            </div>
          
    </div>
            </div>
            
                    <%
                        }
                    %>
    <script type="text/javascript" src="popup.js"></script>
</body>
</html>