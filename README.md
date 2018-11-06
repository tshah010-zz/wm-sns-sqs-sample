# Sample AWS SNS-SQS Integration Service
 
 
Shows how AWS SDK can be used to publish a message to pre-configured SNS and how they message can be sent to SMS and SQS.
 
## Getting Started
 
### Prerequisites
 
* Java 8
* Maven 3.3.9
 
### Running Locally
 
```
mvn clean package spring-boot:run
```
 
  
## More Info
Login into AWS Console and change Region to Oregon to SNS Topic 'tshahtest1' used in this sample and its subscriptions. GET http://localhost:8080/?name=Mickey will also publish a message to the Topic.
  
## Maintainers
Content Platform - [#Web & Mobile - Content Platform](mailto:WebMobileContentPlatform@blizzard.com)