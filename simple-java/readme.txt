## execute

java -cp target/classes my.App

java -cp target/basic-01-compiler-plugin-1.0-SNAPSHOT.jar my.App

## verify Java version used to compile code - method 1

javap -v target/classes/my/App.class | grep major

Java 5 uses major version 49
Java 6 uses major version 50
Java 7 uses major version 51
Java 8 uses major version 52
Java 9 uses major version 53

## verify Java version used to compile code - method 2

mvn help:effective-pom -Doutput=effective.xml
