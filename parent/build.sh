#!/usr/bin/env bash
docker-compose -f ../docker-compose.yml down
docker-compose -f ../redis/docker-compose.yml down
docker rmi eureka:1.0 calservice:1.0 consumerservice:1.0
docker rmi redis-demo:latest redis-sentinel-demo:latest
docker network rm spring-cloud-demo
docker network create -d bridge spring-cloud-demo
mvn -T4 clean package
docker-compose -f ../redis/docker-compose.yml up -d
docker-compose -f ../docker-compose.yml up -d