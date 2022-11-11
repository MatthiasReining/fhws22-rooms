@echo off
REM call mvn clean package
REM call docker build -t de.fhws/fhws22-rooms -t ghcr.io/matthiasreining/fhws/fhws22-rooms .
call docker build -t de.fhws/fhws22-rooms .
call docker rm -f fhws22-rooms
call docker run --rm -p 8080:8080 -p 4848:4848 --name fhws22-rooms de.fhws/fhws22-rooms