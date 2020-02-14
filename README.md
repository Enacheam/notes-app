### SimpliNote App Service
This spring-boot RESTful web service app which is the backend for notes app.

#### How to run the app
After checking out the code, execute the following command to install dependencies and run the app

```
mvn install
mvn clean spring-boot:run
```
The first command can be executed only once to install all the dependencies needed. The second command 
can be used for running the app in development. 

#### Available APIs
To see the exposed/available APIs, run the app as described above and point your browser to 
http://localhost:8080/swagger-ui.html to see the Swagger documentation