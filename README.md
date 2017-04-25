# festivities Core RESTful API

[![engine](https://img.shields.io/badge/JDK-v1.8+-yellow.svg)]()
[![gradle](https://img.shields.io/badge/gradle-v2.13+-blue.svg)]()

---

> `blogs Core RESTful API` 

---

## Sub-projects

* [blog-commons]()
* [blog-core-entity]()
* [blog-core-repository]()
* [blog-core-service]()
* [blog-core-api]()
* [blog-core-starter]()

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [Java](https://java.com/en/download/)

## Installation

I use [Gradle](http://www.gradle.org), a cross-platform build automation tool that help with our full development flow. If you prefer [install Gradle](http://www.gradle.org/installation) or use a [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) inside this project.

* `git clone https://github.com/doradodev/blog-core-api.git` this repository
* change into the new directory `blog-CORE-API`

## Build

```bash
./gradlew clean build
```

Take a look on generated artifacts, for instance `blog-core-starter` subproject:

```bash
ls -1 blog-core-starter/build/libs/

blog-core-starter.jar
blog-core-starter-javadoc.jar
blog-core-starter-sources.jar
```


### Generate Javadoc

```bash
./gradlew javaDoc
```

## Distribution

`blog Core RESTful API` facilitates creating an executable JVM application. It makes it easy to start the application locally during development, and to packaging the application as ZIP including operating system specific start scripts. 

### Locally

```bash
./gradlew clean :blog-core-starter:distZip
```

Take a look on generated dist zipped file:

```bash
ls -1 blog-core-starter/build/distributions

blog-core-starter.tar
blog-core-starter.zip
```

## Configuration

### Database

`blog Core RESTful API` uses a [H2](http://www.h2database.com/html/main.html) database embedded to store its data.

The database configuration starts while starting `blog Core RESTful API`.


## Run

### Running Core from command line using Gradle

To override default gradle config, please take a look on run task on  [core/blog-core-starter/build.gradle](core/blog-core-starter/build.gradle) subproject build file.

```bash
tail -n 20 blog-core-starter/build.gradle

run {   
    
    environment 'COM_PRODIGIUS_API_PORT', '8080'

    environment 'COM_PRODIGIUS_ENV', 'DEV'
}
```

After that:

```bash
./gradlew clean :blog-core-starter:run
```

Visit `blog Core RESTful API` at [http://localhost:8080/api/*](http://localhost:8080/api).

Visit `blog Core RESTful API` Documentation at [http://localhost:8080/docs/index.html](http://localhost:8080/docs/index.html).

## Further reading / Useful links

* [Gradle](http://gradle.org/)
* [Getting started with Gradle](http://gradle.org/getting-started-jvm/)

## Current version

 - 1.0.0

## Getting help

For more info/help, please send email to: *cdorado330@gmail.com*

*Happy coding!*
