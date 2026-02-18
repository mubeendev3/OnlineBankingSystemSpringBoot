# Online Banking System - Spring Boot Application

A comprehensive RESTful API-based Online Banking System built with Spring Boot, providing core banking functionalities including user management, account management, and transaction processing.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Database Configuration](#database-configuration)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [Usage Examples](#usage-examples)
- [Database Schema](#database-schema)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This Online Banking System is a Spring Boot application that provides a robust backend API for managing banking operations. The system supports user registration and authentication, account creation and management, and various transaction types including deposits, withdrawals, and transfers.

## ✨ Features

### User Management
- **User Registration**: Create new user accounts with personal information
- **User Authentication**: Secure login functionality
- **Account Count**: Retrieve the number of accounts associated with a user

### Account Management
- **Account Creation**: Create CHECKING or SAVINGS accounts for users
- **Account Retrieval**: Get all accounts for a specific user
- **Account Deletion**: Remove accounts from the system

### Transaction Management
- **Fund Transfers**: Transfer funds between accounts
- **Transaction History**: Retrieve transaction history for specific accounts
- **Transaction Types**: Support for DEPOSIT, WITHDRAWAL, and TRANSFER operations

## 🛠 Technology Stack

- **Framework**: Spring Boot 3.3.4
- **Language**: Java 21
- **Build Tool**: Maven
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **API**: RESTful Web Services

### Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector/J
- Spring Boot DevTools (Development)
- Spring Boot Starter Test

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 21 or higher
- **Maven**: Version 3.6+ (or use the included Maven Wrapper)
- **MySQL**: Version 8.0+ (or compatible database server)
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (recommended)

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd OnlineBankingSystemSpringBoot
```

### 2. Database Setup

Create a MySQL database for the application:

```sql
CREATE DATABASE banking_db;
```

### 3. Configure Database Connection

Update the `src/main/resources/application.properties` file with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Build the Project

Using Maven Wrapper (recommended):

```bash
# Windows
mvnw.cmd clean install

# Linux/Mac
./mvnw clean install
```

Or using Maven directly:

```bash
mvn clean install
```

### 5. Run the Application

Using Maven Wrapper:

```bash
# Windows
mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

Or using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## 🗄 Database Configuration

The application uses Hibernate's `ddl-auto=update` mode, which automatically creates/updates database tables based on entity definitions. The following tables are created:

- `users`: Stores user information
- `accounts`: Stores account details linked to users
- `transactions`: Stores transaction records linked to accounts

## 📁 Project Structure

```
OnlineBankingSystemSpringBoot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── mubeendev3/
│   │   │           └── OnlineBankingSystem/
│   │   │               ├── OnlineBankingSystemApplication.java
│   │   │               ├── controllers/          # REST API Controllers
│   │   │               │   ├── UserController.java
│   │   │               │   ├── AccountController.java
│   │   │               │   └── TransactionController.java
│   │   │               ├── services/            # Business Logic Layer
│   │   │               │   ├── UserService.java
│   │   │               │   ├── AccountService.java
│   │   │               │   └── TransactionService.java
│   │   │               ├── repositories/         # Data Access Layer
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── AccountRepository.java
│   │   │               │   └── TransactionRepository.java
│   │   │               ├── entities/             # JPA Entities
│   │   │               │   ├── User.java
│   │   │               │   ├── Account.java
│   │   │               │   └── Transaction.java
│   │   │               └── dto/                  # Data Transfer Objects
│   │   │                   └── AccountCreationDto.java
│   │   └── resources/
│   │       └── application.properties           # Application Configuration
│   └── test/                                    # Test Files
│
├── pom.xml                                      # Maven Configuration
├── mvnw                                         # Maven Wrapper (Unix)
├── mvnw.cmd                                     # Maven Wrapper (Windows)
└── README.md                                    # Project Documentation
```

## 📚 API Documentation

### Base URL
```
http://localhost:8080
```

### User Endpoints

#### Register a New User
```http
POST /users/register
Content-Type: application/json

{
  "username": "john_doe",
  "password": "securePassword123",
  "fullName": "John Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1234567890"
}
```

**Response**: Returns the created User object with generated `userId`

#### User Login
```http
POST /users/login?username=john_doe&password=securePassword123
```

**Response**: Returns User object if credentials are valid, `null` otherwise

#### Get User Account Count
```http
GET /users/{userId}/accounts/count
```

**Response**: Returns the number of accounts associated with the user

### Account Endpoints

#### Create a New Account
```http
POST /accounts/create
Content-Type: application/json

{
  "userId": 1,
  "accountType": "CHECKING",
  "balance": 1000.00
}
```

**Account Types**: `CHECKING`, `SAVINGS`

**Response**: Returns the created Account object with generated `accountId`

#### Get Accounts by User ID
```http
GET /accounts/{userId}
```

**Response**: Returns a list of all accounts for the specified user

#### Delete an Account
```http
DELETE /accounts/{accountId}
```

**Response**: 200 OK (no content)

### Transaction Endpoints

#### Transfer Funds
```http
POST /transactions/transfer
Content-Type: application/json

{
  "account": {
    "accountId": 1
  },
  "transactionType": "TRANSFER",
  "amount": 500.00,
  "description": "Transfer to savings account"
}
```

**Transaction Types**: `DEPOSIT`, `WITHDRAWAL`, `TRANSFER`

**Response**: Returns the created Transaction object with `transactionDate` automatically set

#### Get Transactions by Account ID
```http
GET /transactions/{accountId}
```

**Response**: Returns a list of all transactions for the specified account

## 💡 Usage Examples

### Example 1: Complete User Registration and Account Creation Flow

```bash
# 1. Register a new user
curl -X POST http://localhost:8080/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "jane_smith",
    "password": "password123",
    "fullName": "Jane Smith",
    "email": "jane.smith@example.com",
    "phoneNumber": "+1987654321"
  }'

# Response will include userId (e.g., userId: 1)

# 2. Create a checking account for the user
curl -X POST http://localhost:8080/accounts/create \
  -H "Content-Type: application/json" \
  -d '{
    "userId": 1,
    "accountType": "CHECKING",
    "balance": 5000.00
  }'

# 3. Create a savings account for the user
curl -X POST http://localhost:8080/accounts/create \
  -H "Content-Type: application/json" \
  -d '{
    "userId": 1,
    "accountType": "SAVINGS",
    "balance": 10000.00
  }'

# 4. Get all accounts for the user
curl -X GET http://localhost:8080/accounts/1

# 5. Get account count for the user
curl -X GET http://localhost:8080/users/1/accounts/count
```

### Example 2: Transaction Operations

```bash
# 1. Create a deposit transaction
curl -X POST http://localhost:8080/transactions/transfer \
  -H "Content-Type: application/json" \
  -d '{
    "account": {
      "accountId": 1
    },
    "transactionType": "DEPOSIT",
    "amount": 1000.00,
    "description": "Salary deposit"
  }'

# 2. Create a withdrawal transaction
curl -X POST http://localhost:8080/transactions/transfer \
  -H "Content-Type: application/json" \
  -d '{
    "account": {
      "accountId": 1
    },
    "transactionType": "WITHDRAWAL",
    "amount": 200.00,
    "description": "ATM withdrawal"
  }'

# 3. Get transaction history for an account
curl -X GET http://localhost:8080/transactions/1
```

## 🗂 Database Schema

### Users Table
| Column | Type | Description |
|--------|------|-------------|
| user_id | INT (Primary Key, Auto Increment) | Unique user identifier |
| username | VARCHAR | Unique username |
| password | VARCHAR | User password |
| full_name | VARCHAR | User's full name |
| email | VARCHAR | User's email address |
| phone_number | VARCHAR | User's phone number |

### Accounts Table
| Column | Type | Description |
|--------|------|-------------|
| account_id | INT (Primary Key, Auto Increment) | Unique account identifier |
| user_id | INT (Foreign Key) | Reference to users table |
| account_type | ENUM | CHECKING or SAVINGS |
| balance | DECIMAL | Account balance |

### Transactions Table
| Column | Type | Description |
|--------|------|-------------|
| transaction_id | INT (Primary Key, Auto Increment) | Unique transaction identifier |
| account_id | INT (Foreign Key) | Reference to accounts table |
| transaction_date | DATETIME | Transaction timestamp |
| transaction_type | ENUM | DEPOSIT, WITHDRAWAL, or TRANSFER |
| amount | DECIMAL | Transaction amount |
| description | VARCHAR | Transaction description |

## 🔧 Development

### Running Tests

```bash
mvn test
```

### Building for Production

```bash
mvn clean package
```

The JAR file will be created in the `target/` directory.

### Running the JAR

```bash
java -jar target/OnlineBankingSystem-0.0.1-SNAPSHOT.jar
```

### Development Mode

The project includes Spring Boot DevTools for automatic restart during development. Changes to classpath files will trigger an automatic restart.

## 🔐 Security Considerations

⚠️ **Important**: This is a demo/development project. For production use, consider implementing:

- Password encryption/hashing (BCrypt, Argon2)
- JWT-based authentication
- Role-based access control (RBAC)
- Input validation and sanitization
- SQL injection prevention (already handled by JPA)
- HTTPS/SSL encryption
- Rate limiting
- Comprehensive error handling
- Transaction rollback mechanisms
- Account balance validation before withdrawals/transfers

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Mubeen Dev**

## 📞 Support

For support, email [your-email@example.com] or open an issue in the repository.

---

**Note**: This project is for educational and demonstration purposes. Ensure proper security measures are implemented before deploying to production environments.

