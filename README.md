<div align="center">
  <img src="images/logo.png" width="300" height="300">
   <h1 align="center">

`Health-Pharmacy` </br>
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Java Version](https://img.shields.io/badge/Java-22-brightgreen.svg)](https://www.oracle.com/br/java/technologies/downloads/)

</h1>
</div>

## Table of Contents

- [About](#about)
- [Features](#features)
- [Diagrams](#diagram)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [Authors](#authors)
- [License](#license)

## About

Health-Pharmacy is a Java-based application designed to streamline pharmacy operations and healthcare management. It provides user management, inventory control, online ordering, and analytics tools to improve efficiency and patient care.

## Features

- **User Management**: Role-based access for administrators, pharmacists, and patients.
- **Inventory Control**: Track stock levels, add new products, and receive low-stock alerts.
- **Online Ordering**: Secure patient orders with delivery or pickup options.
- **Reporting & Analytics**: Generate sales, inventory, and health metrics reports.
- **Logging & Monitoring**: Integrated with Logback for application logging.

## Diagram
<details>
  <summary>Entity Structure</summary>

  ![Project1](images/estrutura.png)
</details>
<details>
  <summary>APP Diagram</summary>

  ![Project2](images/diagrama.png)
</details>
<details>
  <summary>Class Diagram</summary>

  ![Project3](images/diagramaDeClasse.png)
</details>


## Technology Stack

- Java 22
- Maven
- JPA / Hibernate
- MySQL 8
- Logback

## Prerequisites

- Java Development Kit (JDK) 22 or later
- Apache Maven 3.6+
- MySQL Server 8.0+
- Git

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/brunoliratm/health-pharmacy.git
   ```
2. Navigate to the project directory:
   ```sh
   cd health-pharmacy
   ```
3. Build the project with Maven:
   ```sh
   mvn clean install
   ```

## Configuration

1. Open `src/main/resources/META-INF/persistence.xml`.
2. Update the database connection URL, username, and password:
   ```xml
   <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/healthpharmacy"/>
   <property name="javax.persistence.jdbc.user" value="root"/>
   <property name="javax.persistence.jdbc.password" value="password"/>
   ```
3. Adjust logging settings in `src/main/resources/logback.xml` (optional).

## Database Setup

```sql
CREATE DATABASE healthpharmacy;
USE healthpharmacy;
-- The application will create all necessary tables on first run.
```

## Running the Application

Start the application using Maven:

```sh
mvn exec:java
```

## Project Structure

```plaintext
├── src
│   └── main
│       ├── java       # Application source code
│       └── resources  # Config files (persistence.xml, logback.xml)
├── images             # Logo and diagrams
├── pom.xml            # Maven configuration
└── README.md          # Project documentation
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add YourFeature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a Pull Request.

## Authors

- **BrunoMagno** ([brunoliratm](https://github.com/brunoliratm))
- **P4ULOjr** ([P4UL0Jr](https://github.com/P4UL0Jr))

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
