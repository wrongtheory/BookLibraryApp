# Spring Boot BookLibrary Web Application

BookLibrary is a small web application that can be used in a Book Library to maintain electronic all books that Library has, all readers(clients) that come to borrow books

# Technologies

- Spring Data JPA
- Thymeleaf
- H2 in-memory database
- Project Lombok
- Spring MVC


## Running BookLibrary locally

BookLibrary is a Spring Boot application built using Maven. You can build a jar file and run it from the command line:

```bash
git clone https://github.com/wrongtheory/BookLibraryApp.git
cd BookLibraryApp
./mvnw package
java -jar target/*.jar

```
You can then access Book Library here: http://localhost:8080/

![libraryreader](https://user-images.githubusercontent.com/7270827/68534412-af276a00-0334-11ea-83cb-4b35ba747c88.png)
![librarybooks](https://user-images.githubusercontent.com/7270827/68534461-16451e80-0335-11ea-8166-0f08f56d23b3.png)

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```
