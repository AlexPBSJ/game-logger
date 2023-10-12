run:
	docker compose build mysqldb; docker compose build app;
	docker compose up -d mysqldb; docker compose up -d app;

stop:
	docker compose down;