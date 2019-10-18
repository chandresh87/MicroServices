echo "Pushing service docker images to docker hub ...."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker push chandreshmishra/eurekaservice:$BUILD_NAME
docker push chandreshmishra/configservice:$BUILD_NAME
docker push chandreshmishra/auth-server:$BUILD_NAME
docker push chandreshmishra/organizationmicroservice:$BUILD_NAME
docker push chandreshmishra/personmicroservice:$BUILD_NAME
docker push chandreshmishra/turbinemicroservice:$BUILD_NAME
docker push chandreshmishra/zuul-server:$BUILD_NAME