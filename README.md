# PetStore Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you. This project uses Quarkus, the Supersonic Subatomic Java Framework. If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Packaging and running the application

To run the application:

    java -jar build/petstore-runner.jar

The application can be also packaged using simple:

    ./gradlew build

> **_NOTE:_**  If you are a WindowsOS user you can use this command: gradlew.bat build

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it is not an _??ber-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

To launch the test page, open your browser at the following URL: http://localhost:8080/index.html

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Creating a native executable

Mind having GRAALVM_HOME set to your Mandrel or GraalVM installation.

You can create a native executable using:

    ./gradlew build -Dquarkus.package.type=native

Or, if you don't have [Mandrel](https://github.com/graalvm/mandrel/releases/) or
[GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases) installed, you can run the native executable
build in a container using:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Or to use Mandrel distribution:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:20.3-java11

You can then execute your native executable with:

    ./build/petstore-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Deploying Application

To deploy the demo app on a docker-compose please visit [./deploy](https://github.com/rasika/petstore/tree/master/deploy)

## Run the test suite

Run the test cases in PetResourceTest.java and PteTypeResourceTest.java files.

Execute the test suite manually as JUnit Test in Eclipse.

    ./gradlew test
    
Then test report can be get using this command

    start ./build/reports/tests/test/index.html   

## Run a CURL/WGET command to test the APIs once deployed

View all the pets or pet types

    curl --location --request GET 'http://localhost:8080/api/pets'
    curl --location --request GET 'http://localhost:8080/api/petTypes'

View a pet or a pet type using ID

    curl --location --request GET 'http://localhost:8080/api/pets/id/1'
    curl --location --request GET 'http://localhost:8080/api/petTypes/id/1'

View a pet or a pet type using type

    curl --location --request GET 'http://localhost:8080/api/pets/type/dog'
    curl --location --request GET 'http://localhost:8080/api/petTypes/type/dog'
    
View a pet or a pet type using name

    curl --location --request GET 'http://localhost:8080/api/pets/name/kiraa'
    
Add a new pet or pet type

    curl --location --request POST 'http://localhost:8080/api/pets/' --header 'Content-Type: application/json' --data-raw '{"petName": "Kiraa","petAge": 4,"petType": "Dog", "petId": 1}'
    curl --location --request POST 'http://localhost:8080/api/petTypes/' --header 'Content-Type: application/json' --data-raw '{"petTypeName":"Dog", "petTypeId": 1}'
    
Update an exsisting pet or pet type

    curl --location --request PUT 'http://localhost:8080/api/pets/1' --header 'Content-Type: application/json' --data-raw '{"petName": "Tommy","petAge": 3,"petType": "fish", "petId": 1}'
    curl --location --request PUT 'http://localhost:8080/api/petTypes/1' --header 'Content-Type: application/json' --data-raw '{"petTypeName":"fish", "petTypeId": 1}'
    
Delete an exsisting pet or pet type

    curl --location --request DELETE 'http://localhost:8080/api/pets/1'
    curl --location --request DELETE 'http://localhost:8080/api/petTypes/1'
