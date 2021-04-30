# Project e1900281_northwind

## Installation
Use package manager [maven](https://maven.apache.org/) to install backend server, also install [Spring initializr](https://start.spring.io/)
Download the zip file, unzip it and save to working directory. Then run these command to start working
`mvn install`
To craete .jar file, run:
`mvn package`

## Project process
First, add plugin tag to `pom.xml` file and create entity class by this command:
`mvn jpa-entity-generator:generateAll`
Save them to [a folder](src/createAutomaticallyFile)
Create a [java file](https://git.vamk.fi/e1900281/e1900281_northwind/src/branch/master/src/main/java/fi/vamk/e1900281/finalProject/CreateRepositories.java) which receives file name in that folder and add repository class and controller to them. Then save in the same folder.

## Added features
### Swagger
Swagger have been added. You can visit this page `http://localhost:8443/swagger-ui.html`
