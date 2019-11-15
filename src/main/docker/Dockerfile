FROM java:8
VOLUME /tmp
ADD /application/jenkins/deploy/target/service-users-1.0-SNAPSHOT.jar service-users.jar
ENTRYPOINT ["java","-Xms200m","-Xmx300m","-jar","/service-users.jar"]