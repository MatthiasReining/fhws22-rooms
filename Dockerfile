FROM quay.io/wildfly/wildfly:26.1.2.Final
COPY target/fhws22-rooms.war /opt/jboss/wildfly/standalone/deployments/

# see https://quay.io/repository/wildfly/wildfly