
# Day I

## Install & download

Precondition

* Java 11 or Java 17
* maven
* git
* IDE _Eclipse_  -->  Eclipse IDE for Enterprise Java and Web Developers  
https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2022-09/R/eclipse-jee-2022-09-R-win32-x86_64.zip
* Application server _Wildfly_ --> Wildfly 6.1.0.Final  
https://github.com/wildfly/wildfly/releases/download/26.1.0.Final/wildfly-preview-26.1.0.Final.zip
* Tooling _SysinternalSuite_ --> TCPView  
https://learn.microsoft.com/de-de/sysinternals/downloads/sysinternals-suite

## IDE Eclipse

* Install _Server_ 
* Redhat Community
* Wildfly 24+

## Test App Server Wildfly

_Windows_:

	cd <WILDFLY_HOME>\bin
	standalone.bat

Call in Browser

	http://localhost:8080

## Setup Java project from scratch 

Or skip and import _our_ git project. See next section

Generate by _maven archetype_:
```
mvn archetype:generate -DarchetypeGroupId=de.rieckpil.archetypes -DarchetypeArtifactId=javaee8 -DarchetypeVersion=1.0.2 -DgroupId=de.fhws -DartifactId=fhws22-rooms
```

Import into _Eclipse_

* File / Import / Existing Maven Projects
* Select folder

## Import _OUR_ project

```
git clone https://github.com/MatthiasReining/fhws22-rooms.git
```
Import into _Eclipse_

* File / Import / Existing Maven Projects
* Select folder _fhws22-rooms_



