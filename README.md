# bimspot-test project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .


The application uses the API IUCN Red List of Threatened Species (http://apiv3.iucnredlist.org/api/v3/docs).
In order to make the calls to the API, there needs to be a token present, as a query parameter.
The token has to be provided as an environment variable with key `IUCN_API_TOKEN`.
For testing purposes, the token provided for the examples in the documentation has been used.

Also, for local testing, swagger is available at `http://localhost:8080/swagger-ui/`.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `bimspot-test-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/bimspot-test-1.0.0-SNAPSHOT-runner.jar`.

# RESTEasy JAX-RS

Guide: https://quarkus.io/guides/rest-json


