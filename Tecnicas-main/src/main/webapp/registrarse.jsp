<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Residencia Real</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="" />
    <meta name="keywords" content="">
    <meta name="author" content="Phoenixcoded" />
    <link rel="icon" href="assets/images/iconoPequeño.png" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
    <div class="auth-wrapper">
        <div class="auth-content text-center">
            <img src="assets/images/iconoInmobiliaria.png" alt="" class="img-fluid mb-4">
            <div class="card borderless">
                <div class="row align-items-center text-center">
                    <div class="col-md-12">
                        <div class="card-body">
                            <form action="registrarse" method="post">
                                <h4 class="f-w-400">Crear cuenta</h4>
                                <hr>
                                <div class="form-group mb-3">
                                    <input type="text" class="form-control" id="Nombre" name="nombre" placeholder="Nombre" required>
                                </div>
                                <div class="form-group mb-3">
                                    <input type="number" class="form-control" id="Cedula" name="cedula" placeholder="Cédula" required>
                                </div>
                                <div class="form-group mb-3">
                                    <input type="text" class="form-control" id="Celular" name="celular" placeholder="Celular" required>
                                </div>
                                <div class="form-group mb-3">
                                    <input type="email" class="form-control" id="Email" name="email" placeholder="Correo electrónico" required>
                                </div>
                                <div class="form-group mb-4">
                                    <input type="password" class="form-control" id="Contraseña" name="contraseña" placeholder="Contraseña" required>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block mb-4">Registrarme</button>
                                <hr>
                            </form>
                            <p class="mb-2">¿Ya tienes una cuenta? <a href="auth-signin.html" class="f-w-400">Iniciar Sesión</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
