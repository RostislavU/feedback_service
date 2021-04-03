create_maven:
	mvn -N io.takari:maven:wrapper

install:
	./mvnw clean dependency:resolve

run:
	./mvnw spring-boot:run

stop:
	./mvnw spring-boot:stop

package:
	./mvnw clean package -DskipTests
	cp target/feedback_service.jar src/main/docker

# Docker
build:
	cd src/main/docker/ && docker-compose up

stop:
	cd src/main/docker/ && docker-compose down

rebuild:
	cd src/main/docker/ && docker-compose down && docker rmi feedback-service:latest && docker-compose up