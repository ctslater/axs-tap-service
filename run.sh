#!/bin/bash

CATALINA_OPTS=" -Dtapuser.jdbc.username= -Dtapuser.jdbc.password= -Dtapuser.jdbc.driverClassName=org.apache.hive.jdbc.HiveDriver -Dtapuser.jdbc.url=jdbc:hive2://docker.for.mac.localhost:10000/ "
# CATALINA_OPTS="-Dqservuser.jdbc.username=qsmaster -Dqservuser.jdbc.password= -Dqservuser.jdbc.driverClassName=org.apache.hive.jdbc.HiveDriver -Dqservuser.jdbc.url=jdbc:mysql://mock-qserv:3306/ -Dtapuser.jdbc.username= -Dtapuser.jdbc.password= -Dtapuser.jdbc.driverClassName=org.apache.hive.jdbc.HiveDriver -Dtapuser.jdbc.url=jdbc:mysql://tap-schema-db:3306/ -Dca.nrc.cadc.reg.client.RegistryClient.local=true -Duws.jdbc.username=postgres -Duws.jdbc.driverClassName=org.postgresql.Driver -Duws.jdbc.url=jdbc:postgresql://uws-db/"
      
docker run --rm -i -e CATALINA_OPTS="${CATALINA_OPTS}" -p 5555:5555 -p 8080:8080 ctslater/spark-tap-service
