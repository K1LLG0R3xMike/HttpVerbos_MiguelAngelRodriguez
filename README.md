# HttpVerbos_MiguelAngelRodriguez
 
Aquí tienes una guía para el archivo `README.md` que describe tu proyecto y cumple con los requisitos de la actividad:

---

# Proyecto: MiguelAngel_Rodriguez_VerbosHttp

Este proyecto tiene como objetivo demostrar el uso de los verbos HTTP en un servicio web utilizando Spring Boot y MongoDB. El servicio web expone operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre un modelo de datos llamado `GroceryItem` y se despliega en el puerto 8090.

## Tecnologías utilizadas
- **Spring Boot**
- **Java 8 o superior**
- **Maven**
- **Tomcat**
- **MongoDB** (NoSQL)

## Estructura del proyecto

### Capas del proyecto
1. **Controller:** Define los endpoints HTTP que interactúan con la capa de servicio.
2. **Service:** Contiene la lógica de negocio y se comunica con la capa de repositorio.
3. **Repository:** Interactúa directamente con la base de datos MongoDB.

### Verbos HTTP implementados
1. **GET**: Recupera todos los elementos de la base de datos.
2. **POST**: Inserta un nuevo elemento en la base de datos.
3. **PUT**: Actualiza un elemento existente basado en su ID.
4. **DELETE**: Elimina un elemento por su ID.
5. **PATCH**: Actualiza parcialmente un elemento por su ID, permitiendo cambiar valores específicos como `name`, `category`, y `quantity`.
6. **HEAD**: Verifica si existen elementos en la base de datos sin retornar el cuerpo de la respuesta.

## Definiciones de los verbos HTTP

1. **GET**:
   - **Descripción:** Se utiliza para solicitar datos de un recurso específico.
   - **Uso en el proyecto:** El método `getAll()` obtiene todos los `GroceryItem` de la base de datos.

2. **POST**:
   - **Descripción:** Se utiliza para enviar datos al servidor para crear un nuevo recurso.
   - **Uso en el proyecto:** El método `insert()` agrega un nuevo `GroceryItem` a la base de datos.

3. **PUT**:
   - **Descripción:** Se utiliza para actualizar un recurso existente o crear uno si no existe.
   - **Uso en el proyecto:** El método `update()` actualiza todos los campos de un `GroceryItem` existente.

4. **DELETE**:
   - **Descripción:** Se utiliza para eliminar un recurso existente.
   - **Uso en el proyecto:** El método `deleteItem()` elimina un `GroceryItem` por su ID.

5. **PATCH**:
   - **Descripción:** Se utiliza para aplicar cambios parciales a un recurso.
   - **Uso en el proyecto:** El método `updateData()` actualiza uno o más campos de un `GroceryItem`.

6. **HEAD**:
   - **Descripción:** Similar a GET, pero solo devuelve los encabezados de la respuesta, sin el cuerpo.
   - **Uso en el proyecto:** El método `handleHeadRequest()` verifica la existencia de elementos sin retornar los datos.

## Definiciones de anotaciones en Spring Boot

1. **@RestController**:
   - **Descripción:** Combina las anotaciones `@Controller` y `@ResponseBody`, lo que hace que todos los métodos en la clase devuelvan datos directamente en lugar de una vista.
   
2. **@RequestMapping("item")**:
   - **Descripción:** Mapea las solicitudes HTTP a los métodos del controlador. En este caso, define que todas las rutas en el controlador `ItemController` comienzan con `/item`.
   
3. **@Autowired**:
   - **Descripción:** Permite inyectar automáticamente las dependencias de los componentes, como servicios o repositorios, en las clases donde se utilizan.

## Clase `GroceryItem`

### Propiedades de la clase:
- `String id`: Identificador único del ítem.
- `String name`: Nombre del ítem.
- `int quantity`: Cantidad del ítem en inventario.
- `String category`: Categoría a la que pertenece el ítem.

### Métodos importantes:
- **Getters y Setters:** Permiten obtener y modificar las propiedades de la clase.
- **toString()**: Sobrescribe el método `toString` para proporcionar una representación legible del objeto `GroceryItem`.

### Uso de la anotación `@Override`:
- **Descripción:** Indica que un método está sobrescribiendo un método de una superclase. En este caso, `toString()` sobrescribe el método `toString` de la clase `Object`, proporcionando una salida personalizada del objeto `GroceryItem`.

## Configuración del proyecto

### Dependencias Maven
Incluye las siguientes dependencias en el archivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
</dependencies>
```

### Configuración de MongoDB y Tomcat

En el archivo `application.properties`, agrega lo siguiente:

```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<database>?retryWrites=true&w=majority
server.port=8090
```

**Nota:** Reemplaza `<username>`, `<password>`, `<cluster-url>`, y `<database>` con tus propios valores.

---

Este `README.md` debería cubrir todos los aspectos requeridos en tu proyecto y guiar a cualquier usuario que desee comprender o contribuir al desarrollo.
