FROM quay.io/wildfly/wildfly:26.1.2.Final

ENV WILDFLY_HOME=$JBOSS_HOME 

# see https://quay.io/repository/wildfly/wildfly

# here, we use the pre-configured image ...
ENV DB_DRIVER=postgresql
# host.docker.internal -> IP of my local Windows machine (see https://docs.docker.com/desktop/networking/)
ENV DB_HOST=host.docker.internal
ENV DB_PORT=5432
ENV DB_DATABASE=fhws
ENV DB_USER=fhws
# don't enter a password!
ENV DB_PASSWORD=fhws@123 
ENV DB_CONN_MAXACTIVE=25
ENV DB_CONN_MINIDLE=5

# works only for postgres
# ENV DB_URL="jdbc:$DB_DRIVER://$DB_HOST:$DB_PORT/$DB_DATABASE$DB_JDBC_DRIVER_APPENDIX"

ADD src/assembly/docker/config ${WILDFLY_HOME}/bin/
ADD src/assembly/docker/modules /tmp

COPY src/assembly/docker/config/docker-entrypoint.sh /opt/customizing/

USER root
RUN chmod a+x /opt/customizing/*.sh && chown jboss:jboss /opt/customizing/*
USER jboss


RUN cd ${WILDFLY_HOME}/bin && ./jboss-cli.sh --file=custom-configurations.cli
RUN cd ${WILDFLY_HOME}/bin && ./jboss-cli.sh --file=add-datasources-offline.cli

RUN rm -rf $WILDFLY_HOME/standalone/configuration/standalone_xml_history/*

COPY target/fhws22-rooms.war /opt/jboss/wildfly/standalone/deployments/

# the docker-entrypoint takes care for the right DB_URL environment variable
# this could be done also here. But in case you have different database provider
# you have different DB_URL syntax and you need a script to decide...

# Set the default entrypoint to run on boot

ENTRYPOINT ["/opt/customizing/docker-entrypoint.sh"]                  
CMD ["-b", "0.0.0.0"]
