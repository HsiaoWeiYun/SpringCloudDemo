#!/usr/bin/env bash
docker-compose -f ../docker-compose.yml down
docker rmi eureka:1.0 calservice:1.0
mvn -T4 clean package
docker-compose -f ../docker-compose.yml up -d