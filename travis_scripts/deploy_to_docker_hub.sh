echo "Pushing service docker images to docker hub ...."
docker login docker.io -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker push chandreshmishra/microservice/eurekaservice:1.0
docker push chandreshmishra/microservice/configservice:1.0
docker push chandreshmishra/microservice/auth-server:1.0
docker push chandreshmishra/microservice/organizationmicroservice:1.0
docker push chandreshmishra/microservice/personmicroservice:1.0
docker push chandreshmishra/microservice/turbinemicroservice:1.0
docker push chandreshmishra/microservice/zuul-server:1.0