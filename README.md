## DOCUMENTATION

###Prerequisite
Mysql

#Initial Data Load

Execute ./src/main/resources/data.sql in mysql after server startup


###Run Project
``` bash
mvnw spring-boot:run
```

###Api
Kindly import Skill-O-Villa.postman_collection.json to Postman for testing purpose

### Table Description
#####Country - 
1) For country supported by our system
2) IsDefault is for countryOfOperation

#####Charge -
1) Charges Throughout the system
2) isDefault is for default charges if course don't have there charges
2) isCountryWise is for whether the charge is for country related.

#####Strategy -
1) Strategy Throughout the system
2) isDefault id for default strategy if course don't have there strategy

#####CourseCharges -
1) CourseCharges is for charges attached to that course.
2) If no charges then it will be mapped to default from charge table

#####CoursesStrategy -
1) CoursesStrategy is for strategy attached to that course.
2) If no CoursesStrategy then it will be mapped to default from Strategy table

#####Course -
1) Consist details of course.

#####CountryCharges -
1) Consist of charged attached to that country.


