
DROP DATABASE IF EXISTS fhws;
DROP USER IF EXISTS fhws;

CREATE USER fhws WITH PASSWORD 'fhws@123';
CREATE DATABASE fhws OWNER fhws;
