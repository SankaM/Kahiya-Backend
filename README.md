# kahiya
ePatient backend

# Docker
sudo docker build --tag kahiya:0.0.1 .

sudo docker images

sudo docker run -d -e DATABASE_SERVER=jdbc:h2:mem:testdb -p 3005:3005 kahiya:0.0.1

sudo docker container ps

gradlew bootJar

----