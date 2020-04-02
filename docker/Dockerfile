
# Originally was using opencadc/tomcat, but need better debugging tools
# so had to switch to using the official tomcat base images and copying in
# the CADC modifications.
FROM tomcat:8.5-jdk8

ENV JAVA_OPTS "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5000 -Djava.security.egd=file:/dev/./urandom -Djsse.enableSNIExtension=false"

# For debugging
EXPOSE 5000

# Modifications for our specific build
RUN rm -rf webapps/*
ADD *.war webapps/

# ENTRYPOINT ["/entrypoint.sh"]


