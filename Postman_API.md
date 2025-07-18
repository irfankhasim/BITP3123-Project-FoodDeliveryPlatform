    FDP API Tests         

Example Response

×

API Documentation

[](#)

FDP API Tests

API Testing for Food Delivery Platform - Authentication Testing - Restaurant Modules Testing - Order Modules Testing - Payment Modules Testing

POST Login

http://localhost:8080/api/auth

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{     "action" : "restaurantlogin", //customerlogin //restaurantlogin     "username" : "restaurantowner",//Customer, newuser// Restaurant, restaurantowner     "password" : "securepassword123"//Customer, newpassword123//Restaurant securepassword123 }`
                                                  
                                              

Example Request

Login

*   Login

                                                ` POST http://localhost:8080/api/auth  {     "action" : "restaurantlogin", //customerlogin //restaurantlogin     "username" : "restaurantowner",//Customer, newuser// Restaurant, restaurantowner     "password" : "securepassword123"//Customer, newpassword123//Restaurant securepassword123 }`
                                            

POST RegisterCustomer

http://localhost:8080/api/auth

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{     "action": "customerregister",     "username": "newuser",     "email": "test1@test.com",     "password": "newpassword123",     "role": "CUSTOMER",     "fullName": "New User",     "phone": "1234567890",     "address": "123 New Street" }`
                                                  
                                              

Example Request

RegisterCustomer

*   RegisterCustomer

                                                ` POST http://localhost:8080/api/auth  {     "action": "customerregister",     "username": "newuser",     "email": "test1@test.com",     "password": "newpassword123",     "role": "CUSTOMER",     "fullName": "New User",     "phone": "1234567890",     "address": "123 New Street" }`
                                            

POST RegisterRestaurant

http://localhost:8080/api/auth

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{     "action": "restaurantregister",     "username": "restaurantowner",     "address": "123 Restaurant St",     "email": "restaurant@test.com",     "fullName": "Restaurant Owner",     "password": "securepassword123",     "phone": "1234567890",     "role" : "RESTAURANT",     "closingTime": "22:00",     "deliveryRadius": 5,     "description": "Best restaurant in town",     "logoUrl": "http://example.com/logo.png",     "name": "Best Restaurant",     "openingTime": "10:00", }`
                                                  
                                              

Example Request

RegisterRestaurant

*   RegisterRestaurant

                                                ` POST http://localhost:8080/api/auth  {     "action": "restaurantregister",     "username": "restaurantowner",     "address": "123 Restaurant St",     "email": "restaurant@test.com",     "fullName": "Restaurant Owner",     "password": "securepassword123",     "phone": "1234567890",     "role" : "RESTAURANT",     "closingTime": "22:00",     "deliveryRadius": 5,     "description": "Best restaurant in town",     "logoUrl": "http://example.com/logo.png",     "name": "Best Restaurant",     "openingTime": "10:00", }`
                                            

GET RegisterDeliveryPartner

Example Request

RegisterDeliveryPartner

*   RegisterDeliveryPartner

                                                `GET` 
                                            

GET getAllRestaurants

http://localhost:8080/api/restaurants

HEADERS

* * *

Cache-Control

no-cache

None

Postman-Token

<calculated when request is sent>

None

Host

<calculated when request is sent>

None

User-Agent

PostmanRuntime/7.39.1

None

Accept

\*/\*

None

Accept-Encoding

gzip, deflate, br

None

Connection

keep-alive

None

Content-Type

application/json

None

BODY raw

* * *

Example Request

getAllRestaurants

*   getAllRestaurants

                                                `GET http://localhost:8080/api/restaurants`

                                            

GET getAllFoodItems

Example Request

getAllFoodItems

*   getAllFoodItems

                                                `GET` 
                                            

POST addFoodItems

http://localhost:8080/api/fooditems

HEADERS

* * *

Cache-Control

no-cache

None

Postman-Token

<calculated when request is sent>

None

Content-Length

0

None

Host

<calculated when request is sent>

None

User-Agent

PostmanRuntime/7.39.1

None

Accept

\*/\*

None

Accept-Encoding

gzip, deflate, br

None

Connection

keep-alive

None

Content-Type

application/json

None

BODY raw

* * *

                                                  `{     "category" : "Pizza",     "description" : "Chicken",     "imageUrl" : "random.com",     "is_available" : 1,     "name" : "Chicken Pizza",     "price" : 25.00,     "restaurantId" : 1 }`
                                                  
                                              

Example Request

addFoodItems

*   addFoodItems

                                                ` POST http://localhost:8080/api/fooditems  {     "category" : "Pizza",     "description" : "Chicken",     "imageUrl" : "random.com",     "is_available" : 1,     "name" : "Chicken Pizza",     "price" : 25.00,     "restaurantId" : 1 }`
                                            

PUT New request

http://localhost:8080/api/fooditems

HEADERS

* * *

Cache-Control

no-cache

None

Postman-Token

<calculated when request is sent>

None

Content-Length

0

None

Host

<calculated when request is sent>

None

User-Agent

PostmanRuntime/7.39.1

None

Accept

\*/\*

None

Accept-Encoding

gzip, deflate, br

None

Connection

keep-alive

None

Content-Type

application/json

None

BODY raw

* * *

                                                  `{         "food_Id": 2,         "category": "Pizza",         "imageUrl": "random.com",         "description": "Chicken",         "is_available": true,         "name": "Chicken Pizza",         "price": 35.0,         "restaurantId": 1 }`
                                                  
                                              

Example Request

New request

*   New request

                                                ` PUT http://localhost:8080/api/fooditems  {         "food_Id": 2,         "category": "Pizza",         "imageUrl": "random.com",         "description": "Chicken",         "is_available": true,         "name": "Chicken Pizza",         "price": 35.0,         "restaurantId": 1 }`
                                            

GET New request

Example Request

New request

*   New request

                                                `GET` 
                                            

POST Create New Order

{{base\_url}}/api/orders

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{   "createdAt": "2023-05-15",   "deliveryAddress": "123 Main St, City",   "status": "PENDING",   "totalAmount": 25.99,   "customerId": 1,   "restaurantId": 1 }`
                                                  
                                              

Example Request

Successful Creation

*   Successful Creation

                                                ` POST  {   "createdAt": "2023-05-15",   "deliveryAddress": "123 Main St, City",   "status": "PENDING",   "totalAmount": 25.99,   "customerId": 1,   "restaurantId": 1 }`
                                            

Example Response

201 - Created

                                                    ` {   "orderId": 1,   "createdAt": "2023-05-15",   "deliveryAddress": "123 Main St, City",   "status": "PENDING",   "totalAmount": 25.99,   "customerId": 1,   "restaurantId": 1 }`
                                                

GET Get All Orders

{{base\_url}}/api/orders

Example Request

Successful Retrieval

*   Successful Retrieval

                                                `GET` 
                                            

Example Response

200 - OK

                                                    ` [   {     "orderId": 1,     "createdAt": "2023-05-15",     "deliveryAddress": "123 Main St, City",     "status": "PENDING",     "totalAmount": 25.99,     "customerId": 1,     "restaurantId": 1   } ]`
                                                

GET Get Order by ID

{{base\_url}}/api/orders/1

Example Request

Successful Retrieval

*   Successful Retrieval

                                                `GET` 
                                            

Example Response

200 - OK

                                                    ` {   "orderId": 1,   "createdAt": "2023-05-15",   "deliveryAddress": "123 Main St, City",   "status": "PENDING",   "totalAmount": 25.99,   "customerId": 1,   "restaurantId": 1 }`
                                                

PUT Update Order Status

{{base\_url}}/api/orders/1

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{   "status": "ACCEPTED",   "deliveryAddress": "123 Main St, City" }`
                                                  
                                              

Example Request

Successful Update

*   Successful Update

                                                ` PUT  {   "status": "ACCEPTED",   "deliveryAddress": "123 Main St, City" }`
                                            

Example Response

200 - OK

                                                    ` {   "orderId": 1,   "createdAt": "2023-05-15",   "deliveryAddress": "123 Main St, City",   "status": "ACCEPTED",   "totalAmount": 25.99,   "customerId": 1,   "restaurantId": 1 }`
                                                

DELETE Delete Order

{{base\_url}}/api/orders/1

Example Request

Successful Deletion

*   Successful Deletion

                                                `DELETE` 
                                            

Example Response

204 - No Content

POST Create Order Item

{{base\_url}}/api/order-items

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{   "pricePerUnit": 9.99,   "quantity": 2,   "specialInstructions": "No onions please",   "foodItemId": 1,   "orderId": 1 }`
                                                  
                                              

Example Request

Successful Creation

*   Successful Creation

                                                ` POST  {   "pricePerUnit": 9.99,   "quantity": 2,   "specialInstructions": "No onions please",   "foodItemId": 1,   "orderId": 1 }`
                                            

Example Response

201 - Created

                                                    ` {   "orderItemId": 1,   "pricePerUnit": 9.99,   "quantity": 2,   "specialInstructions": "No onions please",   "foodItemId": 1,   "orderId": 1 }`
                                                

GET Get All Order Items

{{base\_url}}/api/order-items

Example Request

Successful Retrieval

*   Successful Retrieval

                                                `GET` 
                                            

Example Response

200 - OK

                                                    ` [   {     "orderItemId": 1,     "pricePerUnit": 9.99,     "quantity": 2,     "specialInstructions": "No onions please",     "foodItemId": 1,     "orderId": 1   } ]`
                                                

GET Get Order Items by Order ID

{{base\_url}}/api/orders/1/items

Example Request

Successful Retrieval

*   Successful Retrieval

                                                `GET` 
                                            

Example Response

200 - OK

                                                    ` [   {     "orderItemId": 1,     "pricePerUnit": 9.99,     "quantity": 2,     "specialInstructions": "No onions please",     "foodItemId": 1,     "orderId": 1   } ]`
                                                

PUT Update Order Item

{{base\_url}}/api/order-items/1

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{   "quantity": 3,   "specialInstructions": "Extra cheese, no onions" }`
                                                  
                                              

Example Request

Successful Update

*   Successful Update

                                                ` PUT  {   "quantity": 3,   "specialInstructions": "Extra cheese, no onions" }`
                                            

Example Response

200 - OK

                                                    ` {   "orderItemId": 1,   "pricePerUnit": 9.99,   "quantity": 3,   "specialInstructions": "Extra cheese, no onions",   "foodItemId": 1,   "orderId": 1 }`
                                                

DELETE Delete Order Item

{{base\_url}}/api/order-items/1

Example Request

Successful Deletion

*   Successful Deletion

                                                `DELETE` 
                                            

Example Response

204 - No Content

POST Create Payment

{{base\_url}}/api/payments

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{   "amount": 25.99,   "createdAt": "2023-05-15",   "paymentMethod": "CARD",   "status": "COMPLETED",   "transactionId": "txn_123456789",   "orderId": 1 }`
                                                  
                                              

Example Request

Successful Creation

*   Successful Creation

                                                ` POST  {   "amount": 25.99,   "createdAt": "2023-05-15",   "paymentMethod": "CARD",   "status": "COMPLETED",   "transactionId": "txn_123456789",   "orderId": 1 }`
                                            

Example Response

201 - Created

                                                    ` {   "paymentId": 1,   "amount": 25.99,   "createdAt": "2023-05-15",   "paymentMethod": "CARD",   "status": "COMPLETED",   "transactionId": "txn_123456789",   "orderId": 1 }`
                                                

GET Get All Payments

{{base\_url}}/api/payments

Example Request

Successful Retrieval

*   Successful Retrieval

                                                `GET` 
                                            

Example Response

200 - OK

                                                    ` [   {     "paymentId": 1,     "amount": 25.99,     "createdAt": "2023-05-15",     "paymentMethod": "CARD",     "status": "COMPLETED",     "transactionId": "txn_123456789",     "orderId": 1   } ]`
                                                

GET Get Payment by Order ID

{{base\_url}}/api/orders/1/payment

Example Request

Successful Retrieval

*   Successful Retrieval

                                                `GET` 
                                            

Example Response

200 - OK

                                                    ` {   "paymentId": 1,   "amount": 25.99,   "createdAt": "2023-05-15",   "paymentMethod": "CARD",   "status": "COMPLETED",   "transactionId": "txn_123456789",   "orderId": 1 }`
                                                

PUT Update Payment Status

{{base\_url}}/api/payments/1

HEADERS

* * *

Content-Type

application/json

None

BODY raw

* * *

                                                  `{   "status": "FAILED",   "transactionId": "txn_123456789_failed" }`
                                                  
                                              

Example Request

Successful Update

*   Successful Update

                                                ` PUT  {   "status": "FAILED",   "transactionId": "txn_123456789_failed" }`
                                            

Example Response

200 - OK

                                                    ` {   "paymentId": 1,   "amount": 25.99,   "createdAt": "2023-05-15",   "paymentMethod": "CARD",   "status": "FAILED",   "transactionId": "txn_123456789_failed",   "orderId": 1 }`
                                                

GET New request

Example Request

New request

*   New request

                                                `GET` 
                                            

GET New request

Example Request

New request

*   New request

                                                `GET` 
                                            

var data = \[{'text': 'Auth API Test', 'nodes': \[{'text': 'Login', 'href': '#1', 'method': 'POST'}, {'text': 'RegisterCustomer', 'href': '#2', 'method': 'POST'}, {'text': 'RegisterRestaurant', 'href': '#3', 'method': 'POST'}, {'text': 'RegisterDeliveryPartner', 'href': '#4', 'method': 'GET'}\], 'icon': 'fas fa-folder', 'selectable': 'false'}, {'text': 'Restaurant API Tests', 'nodes': \[{'text': 'getAllRestaurants', 'href': '#5', 'method': 'GET'}, {'text': 'getAllFoodItems', 'href': '#6', 'method': 'GET'}, {'text': 'addFoodItems', 'href': '#7', 'method': 'POST'}, {'text': 'New request', 'href': '#8', 'method': 'PUT'}, {'text': 'New request', 'href': '#9', 'method': 'GET'}\], 'icon': 'fas fa-folder', 'selectable': 'false'}, {'text': 'Order API Tests', 'nodes': \[{'text': 'Create New Order', 'href': '#10', 'method': 'POST'}, {'text': 'Get All Orders', 'href': '#11', 'method': 'GET'}, {'text': 'Get Order by ID', 'href': '#12', 'method': 'GET'}, {'text': 'Update Order Status', 'href': '#13', 'method': 'PUT'}, {'text': 'Delete Order', 'href': '#14', 'method': 'DELETE'}\], 'icon': 'fas fa-folder', 'selectable': 'false'}, {'text': 'OrderItem API Tests', 'nodes': \[{'text': 'Create Order Item', 'href': '#15', 'method': 'POST'}, {'text': 'Get All Order Items', 'href': '#16', 'method': 'GET'}, {'text': 'Get Order Items by Order ID', 'href': '#17', 'method': 'GET'}, {'text': 'Update Order Item', 'href': '#18', 'method': 'PUT'}, {'text': 'Delete Order Item', 'href': '#19', 'method': 'DELETE'}\], 'icon': 'fas fa-folder', 'selectable': 'false'}, {'text': 'Payment API Tests', 'nodes': \[{'text': 'Create Payment', 'href': '#20', 'method': 'POST'}, {'text': 'Get All Payments', 'href': '#21', 'method': 'GET'}, {'text': 'Get Payment by Order ID', 'href': '#22', 'method': 'GET'}, {'text': 'Update Payment Status', 'href': '#23', 'method': 'PUT'}\], 'icon': 'fas fa-folder', 'selectable': 'false'}, {'text': 'Delivery API Tests', 'nodes': \[{'text': 'New request', 'href': '#24', 'method': 'GET'}, {'text': 'New request', 'href': '#25', 'method': 'GET'}\], 'icon': 'fas fa-folder', 'selectable': 'false'}\] $('#tree').treeview({ data: data, levels: 10, expandIcon: 'fas fa-caret-right', collapseIcon: 'fas fa-caret-down', enableLinks: true, showIcon: true, showMethod: true });
