FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk11
COPY target/fhws22-rooms.war /opt/jboss/wildfly/standalone/deployments/

# see https://quay.io/repository/wildfly/wildfly