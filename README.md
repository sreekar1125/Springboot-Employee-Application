# Springboot-Employee-Application
 A SpringBoot MVC project that manages employees in an organization <br>
 For more info -> [Problem Statement.pdf](https://github.com/sreekar1125/Springboot-Employee-Application/files/12208761/Problem.Statement.pdf)


## Run project
   
     Extract the project 
     Open in any IDE like STS or Eclipse etc.. 
     Right click and select Run as 
     Select Spring Boot Starter 
     Open localhost:8080


## Database Setup
	
	 Open MongoDb compass -> create a database "sreekar" -> create a collection "employees"

 
Structure of document while inserting data -> POST : "localhost:8080/v1/addEmployee"
	
	{
		"name" : "Shiva",
		"phone" : "7660815",
		"email" : "Shiva@gmail.com",
		"reportsTo" : "2c983dfa-613f-40b4-a2eb-2830d10304ea",
		"image" : "https://media.licdn.com/dms/image/C5603AQHOeatHfjLymw/profile-displayphoto-shrink_800_800/0/1638463445803?e=2147483647&v=beta&t=Ui9uEReSp9CVcobWfAASMyE6gMIpyl1VY8AicktPe38"
	}


GET : localhost:8080/v1/getAllEmployees

DELETE : localhost:8080/v1/deleteEmployee/{id}

PUT : localhost:8080/v1/updateEmployee/{id}


## Intermediate Level :

GET : localhost:8080/v1/getNthManager/{id}/{n}

GET : localhost:8080/v1/getAllEmployees/{field}  -> Sort using a field like name or email etc...

GET : localhost:8080/v1/getAllEmployees/pageNo={pageNo}/pageSize={pageSize}/sortBy={field}   -> Sort and pagination


## Advanced level
	-> EMail is implemented in createEmployee

## Please go through all the screenshots

![addEmployee(1)](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/c0208547-4299-4ad9-a3cb-4e997e0a7c3f) <br><br><hr><br>
![addEmployeeResult](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/0f3c3c24-31d9-42a6-b435-2c6d60af447c) <br><br><hr><br>
![getAllEmployees](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/f7a9d196-ddaa-4dc1-9f95-dccd1a6496b6) <br><br><hr><br>
![delete](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/1fd4d92c-95dc-4d58-9d52-9484066c8f21) <br><br><hr><br>
![getNthManager(1)](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/80407ae9-6c24-45b0-beb8-e239fbd84955) <br><br><hr><br>
![getNthManager(2)](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/cbf882b7-d261-4884-af27-71315a4dbfe9) <br><br><hr><br>
![getNthManager(3)](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/c38d6897-a34a-4ee6-a96b-f9876badd29e)<br><br><hr><br>
![paging Sorting](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/df06fd4f-f466-4ce3-ad50-5e421a391e54) <br><br><hr><br>
![sortByEmail](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/d5d75b52-6ae5-4110-aaf0-917f5ed3405b) <br><br><hr><br>
![sortByName](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/921edf8b-91ed-46ee-85f2-7df80444e607) <br><br><hr><br>
![update](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/1aa9b5f6-6c23-43d7-9efc-f98f69694fc4) <br><br><hr><br>
![SendMail](https://github.com/sreekar1125/Springboot-Employee-Application/assets/105200465/e2183e22-d620-4112-8fb6-38fd8402a644)
