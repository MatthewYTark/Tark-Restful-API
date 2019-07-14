# Obtaining Year of Current NFL Season using a RESTful API

Author: Matthew Tark

Date: 7/13/2019

## Technical Components
1. Maven/JAR file - In Eclipse, I imported an existing Maven project. From there, after creting the Service, I compiled my code via command line using ``mvnw clean install -DskipTests`` in my project directory (C:\Users\Matt\NFLYearRest) which created the JAR file in the "/target" directory. I also added different dependencies to my pom.xml to use certain libraries.
2. Dockerfile - text file that contains the commands needed to create an image. In my Dockerfile, I pull from an open source Microsoft JRE for the base image. Since all my API needs is a Java environment to run, I thought getting the bare minimum would suffice. I then want to expose the port 8080 for my communication. After getting the base image, I want to create my own directory in the root using ``RUN mkdir /tark``. Then, I execute the ``COPY [NAME OF JAR] /tark`` to copy the jar from my local machine to the new directory. Finally, I use ``CMD java -jar /tark/[NAME OF JAR].jar`` to execute a specific command within the container. 
3. Creating the image - I executed the ``docker build -t [NAME TO GIVE IMAGE] .`` command in the location of the Dockerfile to create my image. I used "docker images" to confirm it was built.
4. Compose file - defines the application services in the YAML file "docker-compose.yml" such as image name and ports. I executed the ``docker-compose -p [PATH] up`` to create the docker container and start all services defined docker-compose.yml file. You could also go to the location of the YAML file and run ``docker-compose up`` only.
5. Pushing my image to Docker Hub - I wanted the process to run my service to be easycommitted my container using ``docker commit -m "MESSAGE" -a "NAME" [CONTAINER ID] [DOCKERHUB USERNAME]/[NAME TO GIVE IMAGE]``. Then, I logged into Docker Hub ``docker login``. Finally, I needed to push the image to Docker Hub ``docker push [USERNAME]/[NAME OF IMAGE]``
6. Running the service - At first, I installed Tomcat and tried to run my application over it, but I read somewhere that Spring Boot will detect that you have a controller and start up an embedded Tomcat instance for you.
7. Getting the year - Since the Year of the Current NFL season changes on July 1st, if the current date when the service is called is BEFORE July 1st, we use the previous year. Otherwise, add one to the year. Ex: If the service is called 6/30/2019, the year returned will be 2018; 7/2/2019 will return 2019.


## Steps to ...
1. Create the docker container and start all services defined docker-compose.yml file: ``docker-compose -f [PATH]/docker-compose.yml up``
2 In a browser, enter the following: ``localhost:8080/getCurrentSeason``
