# Ecommerce with Spring Boot and JPA

This project consists of a Java back-end application that implements the business logic for an e-commerce system. However, it's important to clarify that this project does not represent a complete e-commerce system. It primarily focuses on the logic of relationships between entities and the persistence of entity attributes in the database.

The project's entities include products, categories, orders, and users, and the system manages these entities through well-defined classes and relationships. The goal is to provide a foundation for e-commerce operations, ensuring data integrity and transaction efficiency.

Additionally, the project includes a front-end application whose only purpose is to serve as an interface for executing persistence methods. This allows for testing and visualizing server responses to requests, providing a practical environment for verifying the functioning of back-end processes.

Therefore, the current scope of the project, developed with Spring Boot, Spring MVC, and Spring Data JPA, covers domain modeling, implementation of services and REST resources, and data persistence logic.

## Repository Structure
This project is structured into two separate repositories, one for the back-end and another for the front-end. This decision was based on the following factors:

**Decoupling:** The front-end and back-end can evolve independently. This allows updates and improvements to be made to the user interface without necessarily changing the server logic, and vice versa. This separation also makes it easier to track changes and identify issues, as each repository has its own commit history.

**Different Technologies:** The front-end and back-end use different technologies and have different build and deployment requirements. By separating them into different repositories, we can simplify and clarify the build and deployment processes for each part of the project. This also allows each part of the project to have its own dependencies, reducing the risk of dependency conflicts.

This repository structure helps keep the project organized and facilitates the development and maintenance of the code. Each repository can be managed independently, allowing for greater flexibility and efficiency in development.

**Back-end:**
https://github.com/gamtcode/ecommerce-spring-boot-jpa-backend  
Commits to this repository on GitHub are automatically deployed to AWS Elastic Beanstalk via GitHub Actions.

**Front-end:**
https://github.com/gamtcode/ecommerce-spring-boot-jpa-frontend  
Commits to this repository on GitHub are automatically updated to the AWS S3 bucket via GitHub Actions.

## Logical Layers
This project follows a layered architecture to enhance modularity, maintainability, and scalability. Here’s an overview of each layer:

#### 1) Application Layer:
- The topmost layer responsible for user interaction and system entry points.
- Communicates directly with the Resource Layer.
- Contains high-level application logic and orchestrates requests.

#### 2) Resource Layer (REST Controllers):
- Sits below the Application Layer.
- Manages REST endpoints and acts as an intermediary between the application and other layers.
- Handles incoming HTTP requests, validates input, and delegates to the Service Layer.
- Provides a clean API for external clients.

#### 3) Service Layer:
- Houses the core business logic.
- Receives requests from the Resource Layer and processes them.
- Implements business rules, validations, and transformations.
- Interacts with the Data Access Layer for data retrieval and updates.

#### 4) Data Access Layer (Data Repositories):
- Responsible for data persistence and retrieval.
- Contains repositories (e.g., JPA repositories) that interact with the database.
- Isolated from business logic, ensuring separation of concerns.
- Provides CRUD operations for entities.

#### 5) Entities:
- Represent domain models or business objects.
- Correspond to database tables or collections.
- Define the structure of data and relationships.
- Directly related to the Service Layer for data processing.

By adhering to this layered architecture, the project achieves a clear separation of concerns, making it easier to maintain, extend, and evolve over time. Developers can focus on specific layers without affecting others, promoting a robust and well-organized codebase.

![image](https://github.com/gamtcode/ecommerce-spring-boot-jpa-backend/assets/155624580/55db929f-733e-4526-be46-4acc126b1dc8)

## Domain Model

This domain model represents the data architecture of a Java backend application for an e-commerce system. The entities are designed to reflect business operations and user interaction with the platform.

### Entities and Relationships

- **Product**: Each product is identified by a unique ID and has attributes such as name, description, price, and imgUrl. Products are categorized to facilitate user navigation and discovery.

- **Category**: A category has an ID and a name, and is associated with multiple products. This relationship is essential for grouping similar products under the same category, allowing for efficient filters and personalized recommendations.

- **OrderItem**: Represents the line detail of each order, containing quantity and price. The subTotal() function calculates the total cost based on quantity and unit price. OrderItem has a direct relationship with Product, indicating which products were selected, and with Order, indicating to which order the item belongs.

- **Order**: Stores the order details, including ID, moment of the order, and status. The order status is managed by the OrderStatus enum, which reflects the order's lifecycle from creation to delivery. Orders are associated with users, establishing a customer-order relationship that allows tracking the origin of each transaction.

- **User**: Keeps records of users with ID, name, email, phone, and password. The relationship between User and Order is vital for personalizing the shopping experience, managing permissions, and ensuring account security.

### Enumeration

- **OrderStatus**: Defines the possible states of an order, such as WAITING_PAYMENT, PAID, SHIPPED, DELIVERED, and CANCELED, allowing for clear flow control and timely notifications to users.

With these entities and their clearly defined relationships, our Java backend application is capable of managing complex e-commerce transactions with efficiency and precision.

![image](https://github.com/gamtcode/ecommerce-spring-boot-jpa-backend/assets/155624580/7477c9c6-0d26-4a03-9450-6b5d4d59185d)

## Technologies
### Back-end
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- JPA / Hibernate
- PostgreSQL

### Front-end
- HTML
- Tailwind CSS
- JavaScript
- TypeScript
  
### Build and Deployment
- Maven
- Node
- GitHub Actions

### Cloud
- AWS VPC
- AWS Elastic Beanstalk
- AWS EC2
- AWS RDS
- AWS S3
- AWS CloudFront

This application is hosted in the AWS Cloud via AWS Elastic Beanstalk, leveraging resources such as AWS RDS (Relational Database Service) with PostgreSQL, AWS EC2 (Elastic Compute Cloud), AWS S3 (Simple Storage Service), CloudFront distributions, Security Groups, Policies and Roles of AWS IAM (Identity and Access Management), ACM (AWS Certificate Manager) for SSL certificates, among others.

## How to use

To clone and run this application, you'll need Git, Java 17 or higher, Node.js (which includes npm), TypeScript, Maven and PostgreSQL installed on your computer.

This is a step-by-step guide to setting up and running this project in your local environment. From your command line:

### Back-end
```bash
# clone repository
git clone https://github.com/gamtcode/ecommerce-spring-boot-jpa-backend

# enter the back-end project folder
cd ecommerce-spring-boot-jpa-backend

# run the project
./mvnw spring-boot:run
```

### Front-end
```bash
# clone repository
git clone https://github.com/gamtcode/ecommerce-spring-boot-jpa-frontend

# enter the front-end project folder
cd ecommerce-spring-boot-jpa-frontend

# install dependencies
npm install

# navigate to the src folder
cd src

# compile TypeScript to JavaScript
npx tsc

# go back to the front-end folder
cd ..

# run the project with lite-server
npm run start
```

## Author
The back-end project was developed during the Java development course with Professor Nelio Alves. I would like to express my deepest gratitude to him for the valuable content conveyed.
The front-end project and the entire deployment on AWS Cloud were developed and configured by [Guilherme Teixeira](https://www.linkedin.com/in/dev-guilherme-teixeira/).
