#base image
FROM google/cloud-sdk:alpine

WORKDIR /app

#copy code, for security purposes, avoiding having git credentials entered. however, should probably publish this code somewhere public so can unzip it, so as to not randomly get code.
ADD . /app

# dependencies

RUN apk add --update --no-cache openjdk8 curl tar bash

# this is really only if i need to deploy, which i guess isn't needed right now, but could be useful later
RUN gcloud components install app-engine-java

CMD ["./gradlew", "test"]
