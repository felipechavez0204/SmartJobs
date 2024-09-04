flujo api smarjobs:

-El cliente envía una solicitud HTTP POST al microservicio de usuarios.
-El controlador REST recibe la solicitud y la envía al servicio de negocio.
-El servicio valida los datos, genera un token y solicita al repositorio que persista los datos.
-El repositorio interactúa con la base de datos y guarda el usuario.
El servicio devuelve una respuesta al cliente con la información del usuario, incluyendo el token.
-
