### Maven commands to run this app
```
mvn clean && mvn assembly:assembly -DdescriptorId=jar-with-dependencies && java -jar target\eoc-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```