echo "Pushing service docker images to docker hub ...."
docker login  -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker tag microservice/configservice:1.0 $DOCKER_USERNAME/configservice:$BUILD_NAME
docker tag microservice/eurekaservice:1.0 $DOCKER_USERNAME/eurekaservice:$BUILD_NAME
docker tag microservice/auth-server:1.0 $DOCKER_USERNAME/auth-server:$BUILD_NAME
docker tag microservice/organizationmicroservice:1.0 $DOCKER_USERNAME/organizationmicroservice:$BUILD_NAME
docker tag microservice/personmicroservice:1.0 $DOCKER_USERNAME/personmicroservice:$BUILD_NAME
docker tag microservice/turbinemicroservice:1.0 $DOCKER_USERNAME/turbinemicroservice:$BUILD_NAME
docker tag microservice/zuul-server:1.0 $DOCKER_USERNAME/zuul-server:$BUILD_NAME
docker tag microservice/springbootadmin:1.0 $DOCKER_USERNAME/spring-boot-admin-server:$BUILD_NAME

docker push $DOCKER_USERNAME/configservice:$BUILD_NAME
docker push $DOCKER_USERNAME/eurekaservice:$BUILD_NAME
docker push $DOCKER_USERNAME/auth-server:$BUILD_NAME
docker push $DOCKER_USERNAME/organizationmicroservice:$BUILD_NAME
docker push $DOCKER_USERNAME/personmicroservice:$BUILD_NAME
docker push $DOCKER_USERNAME/turbinemicroservice:$BUILD_NAME
docker push $DOCKER_USERNAME/zuul-server:$BUILD_NAME
docker push chandreshmishra/spring-boot-admin-server:$BUILD_NAME