#!/usr/bin/env bash


if [[ ! -d jenkins/downloads ]]; then
    mkdir -p jenkins/downloads
    curl -o jenkins/downloads/openjdk-13.0.2_linux-x64_bin.tar.gz https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_linux-x64_bin.tar.gz
    curl -o jenkins/downloads/openjdk-9_linux-x64_bin.tar.gz https://download.java.net/java/GA/jdk9/9/binaries/openjdk-9_linux-x64_bin.tar.gz
    curl -o jenkins/downloads/apache-maven-3.6.3-bin.tar.gz http://apache.spd.co.il/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
    chmod 777 -R .
fi

docker-compose up -d --build
