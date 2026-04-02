FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./mvnw clean install -DskipTests
CMD ["java", "-jar", "target/*.jar"]
ENV JAVA_OPTS="-Xmx512m"
CMD java $JAVA_OPTS -jar target/*.jar