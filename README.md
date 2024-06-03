## **Estructura del proyecto** 📁
```css
nombre-proyecto/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── udea/
│       │           ├── dao/
│       │           │   └── UsuarioDAO.java
│       │           ├── model/
│       │           │   └── Usuario.java
│       │           ├── servlets/
│       │           │   └── RegistrarseServlet.java
│       │           └── utils/
│       │               └── ClaseUtil.java
│       └── webapp/
│           ├── WEB-INF/
│           ├── assets/
│           └── index.jsp
├── target/
├── .gitignore
├── pom.xml
└── README.md
```

## **Compilación del proyecto** 📦
Para compilar el proyecto usando maven, debes seguir los siguientes pasos:

### **En Visual Studio Code** 🔹
1. En la barra de menús hay una opción `Terminal` > `Nueva Terminal`

2. Asegurate de estar en la ruta raíz de tu proyecto, por ejemplo: 
`\Users\Esteban\Proyectos\Tecnicas`. En tu caso será diferente
3. Ejecutar el comando Maven:

```powershell
mvn clean install
```

### **En NetBeans** 🧊
1. Ve al menú `Ventana` y selecciona `Output` para abrir la ventana de salida de NetBeans, donde también puedes ingresar comandos de Maven.

2. Navegar al Directorio del Proyecto **(si es necesario)**

3. Ejecutar el comando Maven:

```powershell
mvn clean install
```

4. **[Optional]** Dirígete al proyecto en la ventana de proyectos, haz clic derecho en el nombre del proyecto y selecciona `Build with Dependencies` **(Construir con dependencias)**. Esto ejecutará internamente `mvn clean install`.

## **Despliegue del proyecto en servidor Tomcat** 🐱

### **En Visual Studio Code** 🔹
- Instalar la extensión de `Community Server Connector`, en el menú de la izquierda donde está la estructura de tu proyecto, en la esquina inferior izquierda verás una pestaña `Servers`
- Click derecho en `Community Server Connector`, luego en `Create New Server`
- Download server? `Yes`
- Buscar el servidor de Tomcat en la versión que quieras utilizar, te recomienda la versión `10.1.X`
- Aceptas las licencias y se habrá descargador el servidor
1. Luego, compilas el proyecto usando los comandos de maven. Se creará una carpeta con nombre `target`
2. Dentro habrá un archivo con extensión `.war`
3. Click derecho en ese archivo y luego en `Run on Server`.
4. Eliges el servidor de tomcat que descargaste y luego das click en `No`.
5. Una vez hecho esto, puedes ingresar desde el navegar a la URL `localhost:8080/X` donde 'X' es el nombre de tu proyecto.

> [!IMPORTANT]
> Debes reproducir los pasos 1 al 5, cada vez que haces un cambio en la lógica del front o back para que se vea reflejado.

### **En NetBeans** 🧊
- Solo necesitar ejecutar tu proyecto apretando F5 o dandole al bóton de play '▶️'  en la barra de menús. 

## **Anotaciones** 📄

- **private**: El campo es accesible solo dentro de la clase en la que se declara.
- **static**: El campo pertenece a la clase en sí, en lugar de a instancias específicas de la clase.
- **final**: El valor del campo no puede cambiar una vez que ha sido asignado.
- **long**: El tipo de datos del campo es long, que es un tipo de datos primitivo en Java que representa un valor numérico de 64 bits.

> [!WARNING]
> Si tienes problemas con la versión de la dependencia `jstl` te recomiendo esta solución en [StackOverflow](https://stackoverflow.com/questions/4928271) 

