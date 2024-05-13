#!/bin/bash

# Stop script execution if any command fails
set -e

# Variables
TARGET="../target"
APP="./app"
DOCKER_COMPOSE_FILE="docker-compose.yml"

# Build the application
build_application() {
    echo "Building the application..."
    mvn -f ../ clean package -Dmaven.test.skip=true
}

# Find the JAR file
find_jar_file() {
    echo "Finding JAR file in $TARGET directory..."
    APP_JAR=$(ls "$TARGET" | grep ".jar$")
    echo "Found JAR file: $APP_JAR"
}

# Copy the JAR file to app directory
copy_jar_file() {
    echo "Copying JAR file to $APP directory..."
    cp "$TARGET/$APP_JAR" "$APP/app.jar"
}

# Change directory to app directory
change_directory() {
    echo "Changing directory to $APP..."
    cd "$APP"
}

# Stop and destroy the current application Docker stack
stop_and_destroy_docker_stack() {
    echo "Stopping and destroying the current application Docker stack..."
    docker-compose down
}

# Rebuild Docker image
rebuild_docker_image() {
    echo "Rebuilding Docker image..."
    docker-compose build
}

# Remove empty Docker images
remove_empty_docker_images() {
    echo "Removing empty Docker images..."
    docker rmi -f $(docker images | grep "<none>" | awk "{print \$3}") || true
}

# Main function
main() {
    build_application
    find_jar_file
    copy_jar_file
    change_directory
    stop_and_destroy_docker_stack
    rebuild_docker_image
    remove_empty_docker_images
    echo "DONE"
}

# Execute main function
main
