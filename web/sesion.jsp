<%-- 
    Document   : sesion
    Created on : 10/06/2021, 12:58:26 AM
    Author     : aza06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/png">
    <link rel="stylesheet" href="style.css">
    <title>Salud.Maps | Identificarse</title>
    
</head>
    <body>
        <header>
       <ul>
           <li><img src="img/logo_lateral_negro.png" alt="El logo del servicio."></li>
            <%
    String usuario = "";
    HttpSession sesionuok = request.getSession();
    if(sesionuok.getAttribute("usuario")==null){
    
    %> 
           <li><a href="index.jsp"><b>Buscar</b></a></li>
           <li><a href="#" class="active"><b>Identificarse</b></a></li>
           
            <%
    
    }else{
     %>
           <li><a href="index.jsp"><b>Buscar</b></a></li>
           <li><a href="favoritos.jsp"><b>Favoritos</b></a></li>
           <li><a href="sesiondelusuario.jsp"><b>Tu cuenta</b></a></li>
           <%
    }
    %>
       </ul> 
    </header>  
        
        <!--Registro -->
            <div class="cuadro_identificarse" >
                <form method="post" name="registrarUsuario" action="guardarUsuario">
                    <h3>Registro</h3>
                    <div class="container">
                        <input type="text" placeholder="Nombre de usuario" name="nom_usu" pattern=".{8,35}"  required title="6 a 35 caracteres, por favor"  onkeypress="return soloLetras(event)">
                    </div>
                    <div class="container">
                        <input type="email" placeholder="Correo electrónico" name="ema_usu" required onsubmit="return validarEmail(event)">
                    </div>
                    <div class="container">
                        <input type="password"  placeholder="Contraseña" name="con_usu" pattern=".{8,32}"  required title="8 a 32 caracteres, por favor"  onkeypress="return validar_clave(event)">
                    </div>
                    <input type="submit" value="Registrarse">    
                </form>
            </div>
        
        <!--Inicio de sesión -->
        <div class="cuadro_identificarse" >
                <form method="post" action="verificarUsuario" name="login">
                    <h3>Inicio de Sesión</h3>
                    <div class="container">
                        <input type="text" placeholder="Nombre de usuario" name="txtUsuario" id="txtUsuario" pattern=".{8,35}"  required title="8 a 35 caracteres, por favor"  onkeypress="return soloLetras(event)">
                    </div>
                    
                    <div class="container">
                        <input type="password"  placeholder="Contraseña" name="txtPassword" id="txtPassword" pattern=".{8,32}" required title="8 a 32 caracteres, por favor"  onkeypress="return validar_clave(event)">
                    </div>
                    <input type="submit" value="Iniciar sesión" name="enviar">       
                </form>
            </div>
        <script src="validacion.js"></script>
<footer>
       
      <div class="container-footer-all">
       
           <div class="container-body">

               <div class="colum1">
                   <h1>Mas informacion de la compañia</h1>

                   <p>Para poder tener nustra informacion ir al siguiente link:.</p>
                        <a href="./quienes.html">Quienes somos?</a>
               </div>

               <div class="colum2">

                   <h1>Redes Sociales</h1>

                   <div class="row2">
                       <img src="img/facebook.png">
                       <label>Siguenos en Facebook</label>
                   </div>
                   <div class="row2">
                       <img src="img/twitter.png">
                       <label>Siguenos en Twitter</label>
                   </div>
                   <div class="row2">
                       <img src="img/instagram.png">
                       <label>Siguenos en Instagram</label>
                   </div>
                   <div class="row2">
                       <img src="img/google-plus.png">
                       <label>Siguenos en Google Plus</label>
                   </div>
                   <div class="row2">
                       <img src="img/pinterest.png">
                       <label>Siguenos en Pinterest</label>
                   </div>


               </div>

               <div class="colum3">

                   <h1>Informacion Contactos</h1>

                   <div class="row2">
                       <img src="img/house.png">
                       <label>Centro de Estudios Cientificos y Tecnologicos
                             N 9° "Juan De Dios Batiz"
                       </label>
                   </div>

                   <div class="row2">
                       <img src="img/smartphone.png">
                       <label>+52 1 55 7895 2487</label>
                   </div>

                   <div class="row2">
                       <img src="img/contact.png">
                        <label>equipodosmasuno@gmail.com</label>
                   </div>

               </div>

           </div>
       
       </div>
       
       <div class="container-footer">
              <div class="footer">
                   <div class="copyright">
                       © 2021 Todos los Derechos Reservados | <a href="">DataJockey</a>
                   </div>

                   <div class="information">
                       <a href="">Informacion Compañia</a> | <a href="">Privacion y Politica</a> | <a href="">Terminos y Condiciones</a>
                   </div>
               </div>

           </div>
       
   </footer>
    </body>
</html>
