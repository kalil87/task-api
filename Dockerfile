FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
ENV JAVA_OPTS="-Xmx512m"
CMD ["sh", "-c", "java $JAVA_OPTS -jar target/*.jar"]