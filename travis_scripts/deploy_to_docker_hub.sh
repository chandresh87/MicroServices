echo "Pushing service docker images to docker hub ...."
docker login docker.io -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker tag microservice/configservice:1.0 configservice:$BUILD_NAME
docker push configservice:$BUILD_NAME