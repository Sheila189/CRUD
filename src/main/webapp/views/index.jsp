<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 24/08/2022
  Time: 01:54 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
  <title>Lista de Personas</title>
  <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<div class="container mt-5">
  <div class="row">
    <div class="col-12">
      <c:if test="${param['result']}">
        <p><c:out value="${param['message']}"></c:out></p>
      </c:if>
      <div class="card">
        <div class="card-header">
          <div class="row">
            <div class="col-6">PERSONAS</div> <!--Muestra el registro de las personas de la BD -->
            <div class="col-6 text-end">
              <a href="create-persona" class="btn btn-outline-success btn-sm">
                Registrar persona
              </a>
            </div>
          </div>
        </div>
        <div class="card-body">
          <table class="table table-striped"><!--Los mostrara por orden de su id y de ahi mostrara los datos del usuario -->
            <thead>
            <th>#</th>
            <th>Name</th>
            <th>Surname</th>
            <th>CURP</th>
            <th>Coche_Modelo</th>
            <th>Coche_Matricula</th>
            <th>Acciones</th>
            </thead>
            <tbody>
            <c:forEach var="persona" items="${personas}" varStatus="status">
              <tr>
                <td>
                  <c:out value="${status.count}"></c:out>
                </td>
                <td>
                  <c:out value="${persona.name}"></c:out>
                </td>
                <td>
                  <c:out value="${persona.surname}"></c:out>
                </td>
                <td>
                  <c:out value="${persona.curp}"></c:out>
                </td>
                <td>
                  <c:out value="${coche.modelo}"></c:out>
                </td>
                <td>
                  <c:out value="${coche.matricula}"></c:out>
                </td>
                <td>
                  <a href="get-persona?id=${persona.id}" class="btn btn-warning
                                    btn-sm">EDITAR</a>
                  <form action="delete-persona" method="post" class="d-inline">
                    <input type="hidden" value="${persona.id}" name="id"/>
                    <button type="submit" class="btn btn-danger btn-sm">
                      ELIMINAR
                    </button>
                  </form>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../templates/footer.jsp"/>
</body>
</html>