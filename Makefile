# Установка зависимостей
env:
	mvn clean compile

# Локальный запуск Spring Boot (упадет без базы на порту 5432)
run:
	mvn spring-boot:run

stop:
	mvn spring-boot:stop

# Упаковка приложения и перемещение в директорию с Docker для последующей сборки образа
package:
	mvn package spring-boot:repackage
	yes | cp -rf target/feedback_service.jar src/main/docker/feedback_service.jar

# Docker
run_container:
	cd src/main/docker/ && docker-compose up

stop_container:
	cd src/main/docker/ && docker-compose down

rebuild_container:
	mvn package spring-boot:repackage && \
	yes | cp -rf target/feedback_service.jar src/main/docker/feedback_service.jar && \
	cd src/main/docker/ && docker-compose down && docker rmi feedback-service:latest && docker-compose up
