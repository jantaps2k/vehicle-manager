# Vehicle Manager

To Access API Specification:
http://localhost:8080/swagger-ui/index.html

<u>Get All Vehicles</u>: <br/>
curl --location --request GET 'http://localhost:8080/vehicle?size=5&page=0'

<u>Add Vehicle</u>: <br/>
curl --location --request POST 'http://localhost:8080/vehicle' \
--header 'Content-Type: application/json' \
--data-raw '{
"inventory_code" : "ax123",
"name" : "Honda",
"model" : "City",
"color" : "Red"
}'

<u>Update Vehicle</u>: <br/>
curl --location --request PUT 'http://localhost:8080/vehicle/x123' \
--header 'Content-Type: application/json' \
--data-raw '{
"name" : "Toyota",
"model" : "Vios",
"color" : "Black"
}'

<u>Delete Vehicle</u>: <br/>
curl --location --request DELETE 'http://localhost:8080/vehicle/x123'