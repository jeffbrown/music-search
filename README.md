# Micronaut Music Search

## Overview

This project contains a simple 
[Micronaut](https://micronaut.io) service and a 
[Vue.js](https://vuejs.org) front end for searching
the iTunes Music Store.  The Micronaut service is
defined in the `music-service` subproject and the
Vue.js front end is defined in the `music-client`
subproject.

## Running The Application

### Start The Server

    ./gradlew music-service:run
    
### Start The UI

    ./gradlew music-client:run
    
### Start Both The Server And The UI

    ./gradlew run --parallel

Once both pieces are up and running point your
browser to [localhost:8081](http://localhost:8081/)
to access the UI.

## Build A Self Contained Executable .jar

The `assembleServerAndClient` Gradle task will create
a self contained executable .jar file which contains
both the backend service and the UI.

    ./gradlew assembleServerAndClient
    
Once the .jar is created it may be executed.

    java -jar music-service/build/libs/music-service-0.1-all.jar
    
That will start the server on port 8080.    
    
    