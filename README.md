# Trucker_REST
To explore more about the API EndPints go to the following link: 
[https://trucker-rest.herokuapp.com/swagger-ui.html#/](https://trucker-rest.herokuapp.com/swagger-ui.html#/)

if you are using postman or other tool you can use the following link :
[https://trucker.vishwaraj.dev/swagger-ui.html#/](https://trucker.vishwaraj.dev/swagger-ui.html#/)

This is Spring Boot REST API for the vehicle activity with the geolocation


Develop following REST endpoints 
Load vehicle details with put /vehicles endpoint
If VIN already exist update the record
Load vehicle reading with post /reading endpoint 
Create alerts with given priority when rule triggered
	
Rule
Priority 
EngineRpm > readingRpm
HIGH
fuleVolume < 10% of maxFuelVolume
Medium
Tire pressure of any tire < 32psi || > 36psi
Low 
engineCoolantLow= true || checkingEngineLightON = true
low

Develop REST endpoints for 
Fetch details of the vehicles like VIN, make, model, year etc.
Fetch High alerts when last 2 hours for all the vehicles and ability to sort the list of vehicles based on it 
Ability to list vehicle geolocation within the last 20 min on a map.
Ability to list vehicles all the historical alerts.
Launch one AWS VPC with subset and security group.
Configure Docker Sawm cluster on the AWS VPC


![](/img/ClassDig.png)
