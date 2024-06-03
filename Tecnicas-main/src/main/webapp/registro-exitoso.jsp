<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Registro Exitoso</title>
    <script>
      // Función para redireccionar a la página principal
      function redireccionar() {
        setTimeout(function () {
          window.location.href = "index.jsp";
        }, 5000); // El tiempo se mide en ms, por lo que 5000 ms = 5 segundos
      }

      // Se llama a la función de redireccionar cuando la página se cargó completamente
      window.onload = redireccionar;
    </script>
  </head>
  <body>
    <h2>Registro Exitoso</h2>
    <p>El usuario ha sido registrado exitosamente. ✅</p>
    <p>Serás redirigido a la página principal en unos momentos...</p>
  </body>

  <style>
    body {
      text-align: center;
      margin-top: 2rem;
      font-family: "Courier New", Courier, monospace;
      background-color: #171717;
      color: #8c8c8c;
    }

    h2 {
      font-weight: 800;
      font-size: 2rem;
    }

    p:first-of-type{
      font-size: 1.5rem;
      color: #4caf50;
    }

    p{
      font-size: 1.2rem;
      color: red;
      font-weight: 800;
    }
  </style>
</html>
