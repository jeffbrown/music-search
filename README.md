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
browser to [localhost:3000](http://localhost:3000/)
to access the UI.

## Build A Self Contained Executable .jar

The `assembleServerAndClient` Gradle task will create
a self contained executable .jar file which contains
both the backend service and the UI.

    ./gradlew assembleServerAndClient

Once the .jar is created it may be executed.

    java -jar music-service/build/libs/music-service-0.6.jar

That will start the server on port 8080.    

## Running With Docker

A [Docker](http://docker.com) image has been published which includes a version of this application.  To 
install the image and start the container the first time run the following:

    docker run --name mn_music_search -d -p 8086:8080 micronautsamples/music-search:0.6
    
Note that the argument after `-p` is a pair of port numbers.  The second number is the port inside the 
container and that needs to be 8080.  The first number is the port in the host environment that you would 
like mapped to the second port.  For example, if you use `-p 8086:8080` then port 8086 in your host
environment will be mapped to port 8080 in the container so http://localhost:8086/ could be used to
access the app in the host environment.

To stop the container:

    docker stop mn_music_search
    
To start the container (after having installed and run it the first time with the first `docker` command above):

    docker start mn_music_search

