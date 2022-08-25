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
    <title>Registrar persona</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRAR PERSONA</div><!--Formulario para la creacion de la persona en la BD -->
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="add-persona" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="persona">Nombre</label>
                                            <input name="name" id="persona" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="surname">Apellido</label>
                                            <input name="surname" id="surname" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="curp">CURP</label>
                                            <input name="curp" id="curp" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="button" class="btn btn-danger btn-sm">
                                                Cancelar
                                            </button>
                                            <button type="submit" class="btn btn-success btn-sm">Guardar</button>
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
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRAR COCHE</div><!--Formulario para la creacion de la persona en la BD -->
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="add-coche" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="coche">Modelo</label>
                                            <input name="modelo" id="coche" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="matricula">Matricula</label>
                                            <input name="matricula" id="matricula" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="id_persona">id_Persona</label>
                                            <input name="id_persona" id="id_persona" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="button" class="btn btn-danger btn-sm">
                                                Cancelar
                                            </button>
                                            <button type="submit" class="btn btn-success btn-sm">Guardar</button>
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