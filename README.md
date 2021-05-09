# simplecurd

stack built with spring boot use Conditional bean to switch the database and performs push and pop operations

### Steps to run containers

##### Manual: 
	• gradlew build
	
	• docker network create persistentStore
	
	• docker container run --name mysqldb --network persistentStore -e MYSQL_ROOT_PASSWORD=Somanchi@98 -e MYSQL_DATABASE=myschema -d mysql:8
	
	• docker image build -t simplecurdappservice .

	• docker container run --network persistentStore --name simplecurdapp -p 8080:8080 -d simplecurdapp

##### Using docker compose
Create docket newtork ```docker network create persistentStore```

build application ```gradlew build ``` 

create docker image ```docker image build -t simplecurdappservice```

Run container ```docker-compose up```

##### Minkube deployment steps:

	• kubectl apply -f \Deployments\secrets.yaml
	
	• kubectl apply -f \Deployments\deployment-mysql.yaml
	 
	• kubectl apply -f \Deployments\service-mysql.yaml
	
	• kubectl apply -f \Deployments\deployment-spring.yaml
	
	• kubectl apply -f \Deployments\service-spring.yaml