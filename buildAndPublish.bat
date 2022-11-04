@echo off
call mvn clean package
call docker build -t de.fhws/fhws22-rooms -t ghcr.io/matthiasreining/fhws/fhws22-rooms .
call docker push ghcr.io/matthiasreining/fhws/fhws22-rooms