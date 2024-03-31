FROM openjdk:17
WORKDIR /app
VOLUME /tmp
EXPOSE 8080
COPY target/products-backend-0.0.1-SNAPSHOT.jar /app/product-app.jar
ENTRYPOINT ["java","-jar","./product-app.jar"]