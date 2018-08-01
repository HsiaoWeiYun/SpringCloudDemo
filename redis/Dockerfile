FROM redis:latest
RUN apt-get update && apt-get -y upgrade
COPY redis.conf /usr/local/etc/redis/redis.conf
RUN mkdir /usr/local/etc/redis/log/
RUN apt-get update && apt-get install -y net-tools iputils-ping
CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]