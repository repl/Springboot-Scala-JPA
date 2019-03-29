# Springboot-Scala-JPA
Sample project for a microservice written with Springboot and JPA using Scala and SBT

curl -XGET 'http://localhost:8080/api/v1/hotels'

curl -i -X POST 'http://localhost:8080/api/v1/hotels' \
   -H "Content-Type:application/json" \
   -d \
'{
  "name": "Hotel California",
  "address": "999 1st Ave. N.E.",
  "zip": "50555"
}'



curl -XGET 'http://localhost:8080/api/v1/courses'  

curl -i -X POST 'http://localhost:8080/api/v1/courses' \
   -H "Content-Type:application/json" \
   -d \
'{
  "name": "Functional Programming in Scala"
}'

curl -XGET 'http://localhost:8080/api/v1/students'

curl -i -X POST 'http://localhost:8080/api/v1/students' \
   -H "Content-Type:application/json" \
   -d \
'{
  "name": "john honai"
}
'
