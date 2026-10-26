# Spring Boot Jenkins project

A small Java application for the public-repository midterm and private-repository Homework 7.

Requirements: Java 21 and Maven. Run `mvn clean verify`, then `java -jar target/devops-demo-1.0.0.jar`.
The `/` route returns a greeting. `/health` returns `{"status":"UP"}`.

The Jenkins job must use **Pipeline script from SCM**, Git, branch `*/main`, and script path `Jenkinsfile`.
For the public repository use its HTTPS URL. For the private repository use its SSH URL and a Jenkins SSH private-key credential. `checkout scm` uses the repository and credential configured in the job.

Stages: Checkout, Test, Build Fat JAR, Archive. The Spring Boot Maven plugin packages dependencies under `BOOT-INF/lib` into the executable JAR.
