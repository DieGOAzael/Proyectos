<%-- 
    Document   : index
    Created on : 18/05/2021, 01:57:41 AM
    Author     : DataJockey
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
    <title>Salud.Maps | Buscar</title>
</head>
<body>
    <header>
       <ul>
           <li><img src="img/logo_lateral_negro.png" alt="El logo del servicio."></li>
           <li><a href="#" class="active"><b>Buscar</b></a></li>
           <li><a href="sesion.html"><b>Identificarse</b></a></li>
           <li><a href="quienes.html"><b>Conocer</b></a></li>
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
        <p style="margin-left: 25px">Llena los filtros para realizar una búsqueda.<hr></p>
        <!--Aquí es la selección del tipo de lugar relacionado a la salud.-->
        <select name="mes" id="mes" style="margin-left: 25px; font-size: large;">
            <option value="0">Lugar</option>
            <option value="1">Centro de salud</option>
            <option value="2">Hospital</option>
            <option value="3">Funeraria</option>
        </select>
        <!--Aquí es la selección de las alcaldías.-->
        <select name="mes" id="mes" style="margin-left: 50px; font-size: large;">
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
        <button style="margin-left: 500px; font-size: large;">Buscar</button>
    </div>

    <div class="cuadro_lugares">
        <section>
            <!--for demo wrap-->
            <div class="tbl-header">
              <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                  <tr>
                    <th>Code</th>
                    <th>Company</th>
                    <th>Price</th>
                    <th>Change</th>
                    <th>Change %</th>
                  </tr>
                </thead>
              </table>
            </div>
            <div class="tbl-content">
              <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN COMPANY </td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </section>
    </div>
    
</body>
</html>