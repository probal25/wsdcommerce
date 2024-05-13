How to run application
----------------------

1. Go to `docker` location
2. Run Bash script to build Docker-Compose images: `./build-docker.sh`
3. Go to `docker/app` location (where `docker-compose.yml` is located)
4. Run Docker-Compose command to create and start application and database: `docker-compose up -d`
5. Run Docker-Compose command to stop and destory application and database: `docker-compose down`