export $(grep -v '^#' .env | xargs)
SPRING_PROFILES_ACTIVE=staging ./mvnw spring-boot:run