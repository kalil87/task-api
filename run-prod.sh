export $(grep -v '^#' .env | xargs)
SPRING_PROFILES_ACTIVE=prod ./mvnw spring-boot:run