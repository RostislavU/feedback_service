create_maven:
	mvn -N io.takari:maven:wrapper

run:
	./mvnw spring-boot:run

stop:
	./mvnw spring-boot:stop