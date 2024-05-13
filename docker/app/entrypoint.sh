#!/bin/bash

# Define Java options
JAVA_OPTS=""

# Define sleep time for DB startup
DB_STARTUP_DELAY=50

# Function to wait for the database to start
wait_for_db() {
    echo "Waiting for the database to start..."
    sleep "$DB_STARTUP_DELAY"
}

# Function to clean and repair the database schema with Flyway
#clean_and_repair_db() {
#    echo "Cleaning and repairing the database schema with Flyway..."
#    flyway clean
#    flyway repair
#}

# Function to start the Java application
start_app() {
    echo "Starting the Java application..."
    java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
}

# Main function
main() {
#    clean_and_repair_db
    wait_for_db
    start_app
}

# Execute main function
main "$@"