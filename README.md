# Synonym backend application #

Synonym.java is a system that works as a synonym search tool with the following requirements:
 - The user is able to add new words with synonyms.
 -  The user is able to ask for synonyms for a word, and lookup works in both directions. For example, if "wash" is a synonym to "clean", then I should be able to look up both words and get the respective synonym. 
  
Also, the transitive rule has been implemented, i.e. if "B" is a synonym to "A" and "C" a synonym to "B", then "C" should automatically, by transitive rule, also be the synonym for "A"

### Requirements
  
  - Instaled Java 1.8 on your machine,
  - Spring boot  2.6.4,
  - Maven  3.8.7.

### Implementation
The app contains two endpoints:
- Add a new synonym with two parametars (the word and its synonym)
- Search synonyms for the requested word with one parameter (the word for which synonyms we want to be shown).

You can also run it in dev, prod and test
environment. When the application is started in test environment, integration tests are run. With JaCoCo we secured the application fails when code coverage is less than 85% at the package level. "CheckStyle.xml" has been
added to the pom file to fail the maven build if there are any violations or warnings in order to ensure clean and quality code.

 Swagger 2.7.0: http://localhost:8080/swagger-ui.html
 
 ### How to install and run application? ###
 1. Clone the project,
 2. Go into the root of the project and execute the command to build the jar file:
  ```bash
  mvn package
  ```
 2. Open cmd as administrator,
 3. Type: 
 ```bash
 java -jar /path/to/jar/file.jar
 ```
Jar file after "mvn package" is located in the "target" folder, which is also built with the same command, and you can locate it wherever you want.
 
 #### How to run application on dev environment? ####
 * Type in cmd: 
 ```bash
 java -jar -Dspring.profiles.active=dev /path/to/jar/file.jar
 ```
 
 #### How to run application on prod environment? ####
 * Type in cmd:
 ```bash
 java -jar -Dspring.profiles.active=prod /path/to/jar/file.jar
 ```
 
 #### How to run application on test environment? ####
 
 Type in cmd:
 
 ```bash
 java -jar -Dspring.profiles.active=test /path/to/jar/file.jar
 ```

### REST API 
The REST API to the app is described below.
#### Add synonym
##### Request:

```
POST /synonym/add
```

Request body:

```
{
  "word": "string",
  "word2": "string2"
}
```

##### Response:

Response body:
```
{
  "responseMessage": "Synonym added successfully"
}
```

Response status: 200

if word and it's synonym already exist in map:

```
{
  "responseMessage": "Synonym is already here! Try again."
}
```

if word and it's synonym are the same:

```
{
  "responseMessage": "The word and its synonym are the same! Try again."
}
```


If we send empty "word" or "word2" response status should be 400.

#### Search synonyms
##### Request:

```
POST /synonym/find
```

Request body:

```
{
  "word": "string"
}
```

##### Response:

Response body:
```
{
  "synonyms": [
  ]
}
```
Response status: 200



