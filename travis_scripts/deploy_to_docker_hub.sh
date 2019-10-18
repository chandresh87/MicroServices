echo "Pushing service docker images to docker hub ...."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker push com.microservicePlayground/eurekaservice:$BUILD_NAME
docker push com.microservicePlayground/configservice:$BUILD_NAME
docker push com.microservicePlayground/auth-server:$BUILD_NAME
docker push com.microservicePlayground/organizationmicroservice:$BUILD_NAME
docker push com.microservicePlayground/personmicroservice:$BUILD_NAME
docker push com.microservicePlayground/turbinemicroservice:$BUILD_NAME
docker push com.microservicePlayground/zuul-server:$BUILD_NAME