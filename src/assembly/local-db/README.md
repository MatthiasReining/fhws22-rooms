
# Start database infrastructure

Details inside `docker-compose.yml`

Have a look to

* volumes (for persitance)
* environment variables

    docker compose up -d

Execute scripts inside the database

    docker compose exec db psql -U postgres -f /scripts/init-db.sql