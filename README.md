# SBB Traveller

## Overview
SBB Traveller is a Spring Boot application that interacts with the Swiss Federal Railway System (SBB CFF FFS) APIs to provide travel-related information and tools. This project is designed to demonstrate the use of open APIs to create a simple server that can fetch and process data related to train schedules, routes, and other travel information.

## Project Structure
```
sbbtraveller
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── mcpserver
│   │   │           └── sbbtraveller
│   │   │               ├── SbbtravellerApplication.java
│   │   │               ├── controller
│   │   │               │   └── ApiController.java
│   │   │               ├── service
│   │   │               │   └── ApiService.java
│   │   │               └── model
│   │   │                   └── ApiResponse.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│       └── java
│           └── com
│               └── mcpserver
│                   └── sbbtraveller
│                       └── SbbtravellerApplicationTests.java
├── Dockerfile
└── pom.xml
```

## Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd sbbtraveller
   ```

2. **Build the Project**
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   You can run the application using:
   ```bash
   mvn spring-boot:run
   ```

4. **Docker Setup**
   To build and run the application in a Docker container, use the following commands:
   ```bash
   docker build -t sbbtraveller .
   docker run -p 8080:8080 sbbtraveller
   ```

## Usage
Once the application is running, you can access the API endpoints defined in the `ApiController` class. The application will interact with the SBB CFF FFS APIs to provide real-time travel information.

## APIs Used
This project utilizes at least two open APIs from the SBB CFF FFS to fetch data related to train schedules and routes. The specific APIs and their usage will be documented in the `ApiService` class.

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.