#!/bin/sh

export DB_URL="jdbc:${DB_DRIVER}://${DB_HOST}:${DB_PORT}/${DB_DATABASE}${DB_JDBC_DRIVER_APPENDIX}"

echo "  - DB_HOST: $DB_HOST"
echo "  - DB_PORT: $DB_PORT"
echo "  - DB_DATABASE: $DB_DATABASE"
echo "  - DB_USER: $DB_USER"
echo "  - DB_PASSWORD: *****"
echo "  - DB_DRIVER: $DB_DRIVER"
echo "  - DB_JDBC_DRIVER_APPENDIX: ${DB_JDBC_DRIVER_APPENDIX}"
echo "  - DB_URL_PATTERN: ${DB_URL_PATTERN}"
echo "  - DB_URL: ${DB_URL}"
echo " "


CMD="${WILDFLY_HOME}/bin/standalone.sh"

echo "=> Starting WildFly server"

exec ${CMD} "$@"
