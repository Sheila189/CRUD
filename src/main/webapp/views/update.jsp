<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 24/08/2022
  Time: 01:54 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar Persona</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">ACTUALIZAR PERSONA</div> <!--Aqui podemos modificar los datos de la persona -->
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="save-persona" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="persona">Nombre</label><!--Ingresa el nuevo nombre si asi lo desea -->
                                            <input name="name" id="persona" required
                                                   class="form-control" value="${persona.name}"/><!--Guarda el nombre de la persona y muestra el nombre que se registro en un principio -->
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                            <input type="hidden" name="id" value="${persona.id}"/>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="surname">Surname</label>
                                            <input name="surname" id="surname" required
                                                   class="form-control" value="${persona.surname}"/><!--Lo mismo que el nombre pero con el apellido -->
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="curp">CURP</label>
                                            <input name="curp" id="curp" required
                                                   class="form-control" value="${persona.curp}"/> <!--Es el mismo procedimiento pero aqui se guardara el curp del usuario -->
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                            <button type="submit" class="btn btn-warning btn-sm">Actualizar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>