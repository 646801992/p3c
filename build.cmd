set JAVA_HOME=C:\jdk-11.0.13+8\
cd ./p3c-pmd
call ./mvnw clean install -Dmaven.javadoc.skip=false -e -X
cd ../
cd ./idea-plugin

cd ./p3c-common
call ../gradlew clean publishToMavenLocal
cd ../

cd ./p3c-idea
call ../gradlew clean publishToMavenLocal buildPlugin
cd ../

cd ../
