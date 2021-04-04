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

# Docker
run_container:
	cd src/main/docker/ && docker-compose up

stop_container:
	cd src/main/docker/ && docker-compose down

rebuild_container:
	cd src/main/docker/ && docker-compose down && docker rmi feedback-service:latest && docker-compose up