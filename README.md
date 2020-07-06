# AndroidPacDesarrollo
Repositorío para la práctica de la asignatura de Programación multimedia y dispositivos móviles (Ciclo superior DAM)

Ejercicio:

Crea un nuevo proyecto con Android Studio, el cual contará con tres Activities, todas ellas deberán tener un Constraint Layout bien definido y debe poder visualizarse correctamente en diferentes pantallas sin problemas.

Puntos importantes:

• Todos los strings deberán estar externalizados como mínimo en 2 idiomas por lo que NO está permitido el uso de strings hardcodeados (incrustados en el código).
• La aplicación contendrá una base de datos SQLite, con la que gestionar los datos.
• Durante el diseño de toda la aplicación se deberán utilizar elementos drawable para darle un diseño mucho más profesional a nuestra aplicación.

Activities:

• Activity1: Tendrá una imagen de bienvenida y texto de bienvenida y dos botones que nos permitirán:
o Iniciar sesión
o Registrarnos en la aplicación.

• Activity 2: Activity destinado al registro del usuario en la aplicación deberá solicitar sus datos:
o Nombre
o Apellido
o Nombre de usuario
o Contraseña
o Email.

Una vez el usuario haya introducido todos los datos este se guardará en la BD y finalizará el activity de forma automática e irá al Activity3 donde podremos iniciar sesión.
Para realizar dicha acción podéis implementar un botón de registro.

• Activity 3: Destinado al inicio de sesión del usuario en la aplicación. Deberá solicitar sus datos de:
o Nombre de usuario
o Contraseña

Una vez tenga los datos comprobará si se trata de los mismos que están en la BD, si es así irá al Activity4.
En caso contrario mostrará un mensaje informando que no se ha podido iniciar sesión en la aplicación.

• Activity 4: Contendrá toda la información del usuario que ha iniciado sesión.
o Contendrá dos botones:
o Uno para reproducir una canción
o Otro para detener la reproducción.
