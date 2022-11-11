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
ENV DB_URL=




ADD src/assembly/docker/config ${WILDFLY_HOME}/bin/
ADD src/assembly/docker/modules /tmp

USER root
RUN chmod a+x ${WILDFLY_HOME}/bin/docker-entrypoint.sh
USER jboss

RUN cd ${WILDFLY_HOME}/bin && ./jboss-cli.sh --file=custom-configurations.cli
RUN cd ${WILDFLY_HOME}/bin && ./jboss-cli.sh --file=add-datasources-offline.cli


COPY target/fhws22-rooms.war /opt/jboss/wildfly/standalone/deployments/

# the docker-entrypoint takes care for the right DB_URL environment variable
# this could be done also here. But in case you have different database provider
# you have different DB_URL syntax and you need a script to decide...

# Set the default entrypoint to run on boot
ENTRYPOINT ["/opt/jboss/wildfly/bin/docker-entrypoint.sh"]                                    

CMD ["-b", "0.0.0.0"]
