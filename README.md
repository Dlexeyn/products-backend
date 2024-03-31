## Запуск приложения
- склонируйте данный репозиторий:
```bash
git clone https://github.com/Dlexeyn/products-backend -b develop &&
cd products-backend
```
- создайте файл `.env` c помощью `.env.origin`, заполнив нужными параметрами для базы данных
``` .env 
POSTGRES_DB=db

POSTGRES_USER=admin

POSTGRES_PASSWORD=admin

POSTGRES_EXTERNAL_PORT=5435

POSTGRES_INNER_PORT=5432

SPRING_APP_EXTERNAL_PORT=8001

SPRING_APP_INNER_PORT=8080
```
- С помощью `docker-compose` разверните приложение:
```bash
docker-compose up
```