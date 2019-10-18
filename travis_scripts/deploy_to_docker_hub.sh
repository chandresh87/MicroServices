echo "Pushing service docker images to docker hub ...."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker push chandreshmishra/microservice:microservice/eurekaservice:1.0
docker push chandreshmishra/microservice:microservice/configservice:1.0
docker push chandreshmishra/microservice:microservice/auth-server:1.0
docker push chandreshmishra/microservice:microservice/organizationmicroservice:1.0
docker push chandreshmishra/microservice:microservice/personmicroservice:1.0
docker push chandreshmishra/microservice:microservice/turbinemicroservice:1.0
docker push chandreshmishra/microservice:microservice/zuul-server:1.0