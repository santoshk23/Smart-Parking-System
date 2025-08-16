# Smart Parking System

A web-based application for managing parking spaces, built with Java Spring Boot (backend) and React (frontend).

## Features

- JWT-based authentication and authorization
- Role-based access control (Admin, Manager, User)
- RESTful API for parking management
- CORS configuration for frontend-backend integration

## Tech Stack

- **Backend:** Java, Spring Boot, Gradle
- **Frontend:** JavaScript, React, npm
- **Security:** Spring Security, JWT

## Getting Started

### Prerequisites

- Java 17+
- Node.js & npm
- Gradle

### Backend Setup

1. Clone the repository:
- git clone https://github.com/santoshk23/Smart-Parking-System.git
2. Build the backend:
   ```bash
    ./gradlew build
    ```
3. Run the backend:
    ```bash
    ./gradlew bootRun
    ```
4. Access the backend at `http://localhost:8080`.
5. Create an admin user:
   - Use the `UserController` to create a new user with role `ROLE_ADMIN`.
   - Example:
     ```json
     {
       "username": "admin",
       "password": "admin123",
       "role": "ROLE_ADMIN"
     }
     ```
### Frontend Setup
1. Navigate to the `frontend` directory:
   ```bash
   cd smart-parking-frontend
   ```
2. Install dependencies:
   ```bash
    npm install
    ```
3. Start the frontend:
4. ```bash
   npm start
   ```
5. Access the frontend at `http://localhost:3000`.
6. Login with the admin user created in the backend setup.
7. Explore the application features such as managing parking spaces, viewing bookings, and user management.
8. ### Testing
9. Run tests for the backend:
   ```bash
   ./gradlew test
   ```
10. Run tests for the frontend:
    ```bash
    npm test
    ```
## API Endpoints

- `/auth/**` \- Authentication (login, register)
- `/admin/**` \- Admin operations (requires ADMIN role)
- `/manager/**` \- Manager operations (requires MANAGER role)
- Other endpoints require authentication

## Configuration

- CORS is enabled for `http://localhost:3000`
- JWT authentication filter secures API endpoints
### Deployment
For deployment, you can package the backend as a JAR file and deploy it on a server. The frontend can be built and served using a static file server or integrated into the backend.
### Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.
### License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
### Contact
For any questions or issues, please open an issue on the GitHub repository or contact the project maintainer.
### Acknowledgements
Thanks to the open-source community for the libraries and tools used in this project. Special thanks to the contributors who have helped improve this application.
### Screenshots
![Login Page](screenshots/login.png)
![Dashboard](screenshots/dashboard.png)