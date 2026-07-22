@echo off
set "PATH=C:\Users\Admin\AppData\Local\Programs\Microsoft\jdk-17.0.12.7-hotspot\bin;%PATH%"
mvn -version
mvn clean install -DskipTests
pause
