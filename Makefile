# Установка зависимостей
install:
	mvn clean dependency:resolve

# Локальный запуск
run:
	mvn spring-boot:run

stop:
	mvn spring-boot:stop

# Упmakcаковка программы
package:
	mvn package spring-boot:repackage
	yes | cp -rf target/feedback_service.jar src/main/docker/feedback_service.jar

# Docker
run_container:
	cd src/main/docker/ && docker-compose up

stop_container:
	cd src/main/docker/ && docker-compose down

rebuild_container:
	cd src/main/docker/ && docker-compose down && docker rmi feedback-service:latest && docker-compose up