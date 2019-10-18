echo "Pushing service docker images to docker hub ...."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker push microservice/eurekaservice:1.0
docker push microservice/configservice:1.0
docker push microservice/auth-server:1.0
docker push microservice/organizationmicroservice:1.0
docker push microservice/personmicroservice:1.0
docker push microservice/turbinemicroservice:1.0
docker push microservice/zuul-server:1.0