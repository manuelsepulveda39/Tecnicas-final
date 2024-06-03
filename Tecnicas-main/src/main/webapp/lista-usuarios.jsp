<%@ page contentType="text/html; charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Lista de clientes</title>
  </head>
  <body>
    <h1>Lista de clientes</h1>

    <table border="1">
      <tr>
        <th>Nombre</th>
        <th>Cédula</th>
        <th>celular</th>
        <th>Email</th>
      </tr>
      <tbody>
        <c:forEach items="${clientes}" var="usuario">
          <tr>
            <td><c:out value="${usuario.nombre}" /></td>
            <td><c:out value="${usuario.cedula}" /></td>
            <td><c:out value="${usuario.celular}" /></td>
            <td><c:out value="${usuario.email}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <form action="lista-clientes" method="get">
      <input type="number" name="cedula" placeholder="Cédula" />
      <input type="submit" value="Buscar" class="button" />
    </form>
  </body>

  <style>
    body {
      display: flex;
      flex-direction: column;
      gap: 1rem;
      text-align: center;
      margin-top: 2rem;
      font-family: "Courier New", Courier, monospace;
      background-color: #171717;
    }

    h1 {
      font-weight: 800;
      font-size: 2rem;
      color: #8c8c8c;
    }

    table {
      border-collapse: collapse;
      width: 100%;
    }

    th{
      border: 1px solid #dddddd;
      padding: 8px;
      text-align: center;
      font-size: 1.5rem;
    }

    td{
      font-size: 2rem;
      font-weight: 600;
    }

    th {
      background-color: #4caf50;
      color: white;
      border: none;
    }

    td {
      color: #8c8c8c;
    }

    form {
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 1rem;
    }

    input:first-of-type {
      width: 150px;
      height: 40px;
      border-radius: 5px;
      border: 2px solid #000;
      background-color: #fff;
      box-shadow: 4px 4px #000000;
      font-size: 15px;
      font-weight: 600;
      color: #323232;
      padding: 5px 10px;
      outline: none;
      text-align: center;
    }

    .button {
      background: #4caf50;
      font-family: inherit;
      padding: 0.5em 1em;
      font-weight: 900;
      font-size: 18px;
      border: 2px solid black;
      border-radius: 0.4em;
      box-shadow: 0.1em 0.1em;
      cursor: pointer;
    }

    .button:hover {
      transform: translate(-0.05em, -0.05em);
      box-shadow: 0.15em 0.15em;
    }

    .button:active {
      transform: translate(0.05em, 0.05em);
      box-shadow: 0.05em 0.05em;
    }

    input[type="number"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
      -webkit-appearance: none;
      -moz-appearance: none;
      appearance: none;
      margin: 0;
    }
  </style>
</html>
