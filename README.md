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

How to Access Claims / User Info in Your Controller
@GetMapping("/products")
public ResponseEntity<String> getProducts(@AuthenticationPrincipal Jwt jwt) {
String userId = jwt.getClaimAsString("sub"); // User ID from token
String userRole = jwt.getClaimAsString("roles"); // Optional if roles are present

    return ResponseEntity.ok("User ID: " + userId + ", Role: " + userRole);
}


JWT Validation Flow Diagram
[ Mobile App / Browser ]
|
| (1) Get JWT Token after Login (from Keycloak/Auth Server)
|------------------------------------------>
|  Authorization: Bearer eyJhbGciOi...
|
| (2) Call Product API / Cart API with Token
|------------------------------------------>
[ Spring Boot Resource Server (Your API) ]
|
| (3) Extract & Validate JWT:
|     - Decode token
|     - Validate Signature using public key (fetched from issuer-uri)
|     - Check Expiry
|     - Extract Claims (userId, roles, etc.)
|
| (4) If valid, process the request
|     Else, 401 Unauthorized
