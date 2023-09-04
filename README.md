
## Impact Hub

# Docker File 

# DataBase Schema 

# Features


















## Development

During development it is recommended to use the profile `local`. In IntelliJ, `-Dspring.profiles.active=local` can be added in the VM options of the Run Configuration after enabling this property in "Modify options".

Update your local database connection in `application.properties` or create your own `application-local.properties` file to override settings for development.

After starting the application it is accessible under `localhost:8080`.

## Build

The application can be built using the following command:

```
gradlew clean build
```

The application can then be started with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./build/libs/impacthub-0.0.1-SNAPSHOT.jar
```

