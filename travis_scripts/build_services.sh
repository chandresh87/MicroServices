echo "Building with travis commit of $BUILD_NAME ..."
gradle clean build buildDocker -x test
