set db_name=%1
set username=%2
set password=%3
del src\main\resources\application.properties
(
echo spring.datasource.url=jdbc:mysql://localhost:3306/%db_name%?useUnicode=yes^&characterEncoding=UTF-8
echo spring.datasource.username=%username%
echo spring.datasource.password=%password%
echo spring.jpa.database-platform=org.hibernate.dialect.MariaDB53Dialect
echo spring.jpa.hibernate.ddl-auto=create
echo spring.mvc.view.prefix: /WEB-INF/jsp/
echo spring.mvc.view.suffix: .jsp
echo server.port=8085
) > src\main\resources\application.properties
del src\main\resources\liquibase.properties
(
echo url=jdbc:mysql://localhost:3306/%db_name%?useUnicode=yes^&characterEncoding=UTF-8
echo username=%username%
echo password=%password%
echo driver=com.mysql.jdbc.Driver
echo changeLogFile=src/main/resources/db/liquibase-changelog.xml
) > src\main\resources\liquibase.properties
