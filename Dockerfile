# Build stage
FROM maven as build
WORKDIR /build
COPY . /build
RUN mvn -f /build/pom.xml clean -U package

# Publish stage 
FROM openjdk:8-jre-alpine
ENV APP_FILE picpay-clone-0.0.1.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
COPY --from=build /build/target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]