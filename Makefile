create_maven:
	mvn -N io.takari:maven:wrapper

install:
	./mvnw clean dependency:resolve

run:
	./mvnw spring-boot:run

stop:
	./mvnw spring-boot:stop