echo "Pushing service docker images to docker hub ...."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker push com.microservicePlayground/eurekaservice:1.0
docker push com.microservicePlayground/configservice:1.0
docker push com.microservicePlayground/auth-server:1.0
docker push com.microservicePlayground/organizationmicroservice:1.0
docker push com.microservicePlayground/personmicroservice:1.0
docker push com.microservicePlayground/turbinemicroservice:1.0
docker push com.microservicePlayground/zuul-server:1.0