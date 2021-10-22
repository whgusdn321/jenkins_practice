FROM openjdk:8u302-jre-buster
# COPY ./wait-for-it.sh ./wait-for-it.sh
# COPY utils/wait-for-it.sh wait-for-it.sh
COPY ./wait-for-it.sh wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# WORKDIR /app
COPY productreview/build/libs/*SNAPSHOT.jar ./pr-server.jar
CMD ["./wait-for-it.sh" , "localhost:3306" , "--timeout=30" , "--" , "java", "-jar", "pr-server.jar"]
