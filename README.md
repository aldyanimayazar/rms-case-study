# RMS
Study case project using various technology stack for building Resource Management System

## rms-servlet-web
It is implementing MVC pattern using only Servlet and JSP, combine with plain JDBC to handle databae operation.

It uses tomcat7-maven-plugin to spin up embedded tomcat 7, therefore no need to install tomcat 7 on your local machine. 

To run the application, execute maven command `mvn tomcat7:run` and browse http://localhost:8080/rms-servlet-web/index.jsp