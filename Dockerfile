FROM openjdk:21
WORKDIR /app
VOLUME /tmp
EXPOSE 8080
COPY target/products-backend-1.0.0.jar /app/product-app.jar
ENTRYPOINT ["java","-jar","./product-app.jar"]