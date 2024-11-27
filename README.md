
# **Library Management System - Spring Boot CRUD Application**

## **Overview**
This project is a simple **CRUD (Create, Read, Update, Delete)** application built using Spring Boot. It demonstrates how to manage library books, including adding, retrieving, updating, and deleting books in a MySQL database.

---

## **Features**
- **Create:** Add new books to the database.
- **Read:** Retrieve a list of books or search for books by attributes (e.g., name, author).
- **Update:** Modify the details of an existing book.
- **Delete:** Soft delete or permanently delete a book from the database.

---

## **Technologies Used**
- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For database operations.
- **PostgreSQL**: Database to store book records.
- **Hibernate**: ORM for mapping Java objects to database tables.
- **Maven**: Build automation tool.
- **Postman**: API testing.
- **H2 Database**: Optional in-memory database for testing.

---

## **Prerequisites**
1. **Java Development Kit (JDK)** (version 11 or higher).
2. **Maven**: Ensure it's installed and configured.
3. **PostgreSQL**: A running PostgreSQL database instance.
4. **IDE**: IntelliJ IDEA, Eclipse, or your preferred IDE.

---

## **Setup and Installation**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repository-url/library-management-system.git
   cd library-management-system
   ```

2. **Configure PostgreSQL Database**:
   - Create a PostgreSQL database named `library`.
   - Update the `application.properties` file located in `src/main/resources`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/(database_name)
     spring.datasource.username=yourusename
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**:
   - The application runs on [http://localhost:9092](http://localhost:9092).

---

## **REST API Endpoints**
Below are the available endpoints for managing books:

### **1. Add a Book**
- **Endpoint**: `POST /api/v1/library/add`
- **Request Body**:
  ```json
  {
    "bookName": "Effective Java",
    "bookAuthor": "Joshua Bloch",
    "bookPublisher": "Addison-Wesley",
    "bookISBN": 9780134685991,
    "bookQuantity": 10,
    "softDelete": 0
  }
  ```

---

### **2. Get All Books**
- **Endpoint**: `GET /api/v1/library/all`
- **Response**:
  ```json
  [
    {
      "bookID": 1,
      "bookName": "Effective Java",
      "bookAuthor": "Joshua Bloch",
      "bookPublisher": "Addison-Wesley",
      "bookISBN": 9780134685991,
      "bookQuantity": 10,
      "softDelete": 0
    }
  ]
  ```

---

### **3. Get Book by ID**
- **Endpoint**: `GET /api/v1/library/book/{id}`
- **Example**: `GET /api/books/1`

---

### **4. Update a Book**
- **Endpoint**: `PUT /api/v1/library/updateBook/{id}`
- **Request Body**:
  ```json
  {
    "bookName": "Clean Code",
    "bookAuthor": "Robert C. Martin",
    "bookPublisher": "Prentice Hall",
    "bookISBN": 9780132350884,
    "bookQuantity": 5,
    "softDelete": 0
  }
  ```

---

### **5. Delete a Book**
- **Endpoint**: `DELETE /api/v1/library/delete/{id}`

---

## **Database Schema**
Table: `bookcollection`

| Column Name       | Type     | Description                  |
|-------------------|----------|------------------------------|
| `book_id`         | INT      | Primary Key, Auto-Increment. |
| `book_name`       | VARCHAR  | Name of the book.            |
| `book_author_name`| VARCHAR  | Name of the author.          |
| `book_publisher`  | VARCHAR  | Publisher name.              |
| `book_isbn_number`| DOUBLE   | ISBN number.                 |
| `book_quantity`   | INT      | Quantity available.          |
| `soft_delete`     | INT      | 0 for active, 1 for deleted. |

---

## **Error Handling**
- **404 Not Found**: If a book with the specified ID is not found.
- **400 Bad Request**: For invalid input data.
- **500 Internal Server Error**: For server-side issues.
