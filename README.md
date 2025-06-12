# Order Management System

A Spring Boot project to manage customers, products, and orders with reporting features.

## ✅ Features Covered
1. **Customer Management**
  - Add, update, and fetch customer details
2. **Product Management**
  - Add, update, and fetch product details with stock
3. **Order Placement**
  - Place orders with multiple products and quantities
  - Automatically calculate total amount
  - Deduct product stock after ordering
4. **Reporting**
  - Show total orders placed per customer
  - List top 5 customers by number of orderss

## 🛠 Tech Stack

- Java 
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman (for API testing)
 

📂 Source code: `src/main/java/com/assignment/order_management_system`

## 🔗 Project Link
GitHub: https://github.com/Gourang-Agrawal/Order-Management-System.git

## How to Run
- Create a MySQL database named `order_management`
- Update your `application.properties` with DB credentials
- Run the project using your IDE.
  
## API Testing
Use Postman to test endpoints like:
- `POST /api/customers`
- `POST /api/products`
- `POST /api/orders`

📦 Sample order request:
```json
{
 "customerId": 1,
 "products": [
   { "productId": 1, "quantity": 2 },
   { "productId": 2, "quantity": 1 }
 ]
}
