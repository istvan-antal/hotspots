#!/bin/bash	
JAVA_HOME=$(/usr/libexec/java_home -v 1.8) MAVEN_OPTS=-noverify mvn package spring-boot:repackage
