# Projeto da disciplina de DAC - 2020.2 - grupo 5
## Sistema Corporativo de uma Loja de Livros on line


### Prerequisites
	Operating System: 
			Linux

	Resources: 
			Docker
			Docker Compose
			Some Rest API Client

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
			
			$ docker --version
in case of any problems find help on this [link](https://docs.docker.com/compose/install/)
- **API Rest Client** 
	- Try [Insomnia Core](https://insomnia.rest/download/core/?&ref=) or [Postman](https://www.postman.com/downloads/)

### Usage
- ### Web online version
- Open your Api Rest Client and import the [bookzzz_tk_requests](./bookzzz_tk_requests) file to test the application. (The [routes](#online-routes) are also described bellow for you to copy and paste)

- ### Localhost version
- Start the terminal in this folder
- On terminal simply type
		
		   ~/$ cd api
		~/api$ docker-compose up 
this two commands starts both the MySQL database and Spring Application (the application starts on port 80)
- Open your Api Rest Client and import the [requests](./requests) file to test the application. (The [routes](#localhost-routes) are also described bellow for you to copy and paste)
- Additionally you can open the [MySQL Workbench](https://www.mysql.com/products/workbench/) or a Generic Workbench (which supports MySQL like [Beekeeper Studio](https://www.beekeeperstudio.io/)) and connect to database over 

		host: localhost:3306
		user: myuser
		password: pass
		default database: bookzzz

### Online Routes
- Author
	- Create Author

			type: POST
			link: http://api.bookzzz.tk/authors
			body: {
					"name": "Authors Name"
				  }
	- Get Authors

			type: GET
			link: http://api.bookzzz.tk/authors
			
	- Get Author

			type: GET
			link: http://api.bookzzz.tk/authors/{authorId}
			


- Book
	- Create Book

			type: POST
			link: http://api.bookzzz.tk/books
			body: {
					"title": "Book Title",
					"subtitle": "Book Subtitle",
					"authorsIds": [1, 2],
					"year": 2000,
					"price": 40.50
				  }
	
	- Get Books

			type: GET
			link: http://api.bookzzz.tk/books
	
	- Get Books Page

			type: GET
			link: http://api.bookzzz.tk/books/page/{pgNumber}

	- Update Book

			type: PUT
			link: http://api.bookzzz.tk/books/{bookId}
			body: {
					"title": "Updated Book Title",
					"subtitle": "Updated Book Subtitle",
					"authorsIds": [1, 2, 3],
					"year": 1900,
					"price": 100.25
				  }
	- Delete Book

			type: DELETE
			link: http://api.bookzzz.tk/books/{bookId}

### Localhost Routes
- Author
	- Create Author

			type: POST
			link: http://localhost/authors
			body: {
					"name": "Authors Name"
				  }
	- Get Authors

			type: GET
			link: http://localhost/authors
			
	- Get Author

			type: GET
			link: http://localhost/authors/{authorId}
			


- Book
	- Create Book

			type: POST
			link: http://localhost/books
			body: {
					"title": "Book Title",
					"subtitle": "Book Subtitle",
					"authorsIds": [1, 2],
					"year": 2000,
					"price": 40.50
				  }
	
	- Get Books

			type: GET
			link: http://localhost/books
	
	- Get Books Page

			type: GET
			link: http://localhost/books/page/{pgNumber}

	- Update Book

			type: PUT
			link: http://localhost/books/{bookId}
			body: {
					"title": "Updated Book Title",
					"subtitle": "Updated Book Subtitle",
					"authorsIds": [1, 2, 3],
					"year": 1900,
					"price": 100.25
				  }
	- Delete Book

			type: DELETE
			link: http://localhost/books/{bookId}




