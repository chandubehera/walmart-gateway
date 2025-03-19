Sample JWT Test Call via CURL
curl -X GET http://localhost:8080/api/products \
-H "Authorization: Bearer <your_jwt_token>"


If the token is valid and under rate limits, response:
Product List from Product Service

Service	            Sample Endpoint
Product Service	/api/products/**
Order Service	/api/orders/**
Payment Service	/api/payments/**
User Service	/api/users/**
CA Catalog Tools Web	/api/ca-catalog/**
Channel Advisor Service	/api/channel-advisor/**

