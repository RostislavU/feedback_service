# Feedback service

- java
- spring
- postgresql
- hibernate
- maven

---
Установка зависимостей
```shell
make env
```

## Локальный запуск
Запуск приложения:
```shell
make run
```

Остановка приложения:
```shell
make stop
```

---
## Запуск в контейнере

### Инфо
- База данных на localhost:8001
- Данные для подключения к БД в файле docker-compose.yml
- Приложение на localhost:8000

### Запуск
Собрать jar-ник с программой и перенести его в src/main/docker:
```shell
make package
```
Запустить сборку и запуск образа:

```shell
make run_container 
```

Пересборка с изменениями в исходном коде и одновременный запуск в контейнере (+ очистка БД):
```shell
make rebuild_container
```

Пересборка с изменениями в исходном коде и одновременный запуск в контейнере (сохраняет БД):
```shell
make rebuild_container_with_saving
```

Остановка контейнера (сохраняет БД):
```shell
make stop_container
```



