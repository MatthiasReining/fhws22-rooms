FROM quay.io/wildfly/wildfly
COPY target/fhws22-rooms.war /opt/jboss/wildfly/standalone/deployments/

# see https://quay.io/repository/wildfly/wildfly