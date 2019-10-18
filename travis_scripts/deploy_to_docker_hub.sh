echo "Pushing service docker images to docker hub ...."
docker login  -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker tag microservice/configservice:1.0 chandreshmishra/configservice:$BUILD_NAME
docker push chandreshmishra/configservice:$BUILD_NAME