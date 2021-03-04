# Projeto da disciplina de DAC - 2020.2 - grupo 5
## Sistema Corporativo de uma Loja de Livros on line


### Prerequisites
- **Web Version**
Browser
Internet Connection

- **Local Version**
	Operating System: 
			Linux

	Resources: 
			Docker
			Docker Compose
			

If you already have this stuff jump to [Usage](#usage), otherwise follow the steps bellow
	
- **Docker**
	- Installation guide 
	
			$ sudo apt-get update
 			$ sudo apt-get install docker-ce docker-ce-cli containerd.io
	- Check installation
			
			$ docker --version
in case of any problems find help on this [link](https://docs.docker.com/engine/install/)
		
- **Docker-Compose**
	- Installation guide 
	
			$ sudo curl -L "https://github.com/docker/compose/releases/download/1.28.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

 			$ sudo chmod +x /usr/local/bin/docker-compose containerd.io
	- Check installation
			
			$ docker-compose --version
in case of any problems find help on this [link](https://docs.docker.com/compose/install/)


### Usage
- ### Web online version
- Access the Swagger-UI docs at [http://apis.bookzzz.tk/books/v1/docs](http://apis.bookzzz.tk/books/v1/docs)

- ### Localhost version
- Start the terminal in this folder
- On terminal simply type
		
		   ~/$ cd api
		~/api$ docker-compose up 
this two commands starts both the MySQL database and Spring Application (the application starts on port 80)
- Access the Swagger-UI docs at [http://localhost/books/v1/docs](http://localhost/books/v1/docs)
- Additionally you can open the [MySQL Workbench](https://www.mysql.com/products/workbench/) or a Generic Workbench (which supports MySQL like [Beekeeper Studio](https://www.beekeeperstudio.io/)) and connect to database over 

		host: localhost:3306
		user: myuser
		password: pass
		default database: bookzzz




