# springWebApp

La práctica propuesta consiste en realizar una aplicación web de tres pantallas:

1. Alta de Usuarios
2. Ventana de autenticación
3. Listado de Usuarios dados de alta

# Orden de ejecución

1. Utilizar MySql para crear una base de datos llamada datos
2. Entrar en application.properties y poner spring.jpa.hibernate.ddl-auto como create, para crear la tabla dentro de la base de datos
3. Poner spring.datasource.username y spring.datasource.password según las credenciales de datos
4. Si queremos que no se borren nuestros datos cambiamos spring.jpa.hibernate.ddl-auto a none