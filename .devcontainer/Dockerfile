FROM registry.med.stanford.edu/irt-as/images/as-builder:jdk-11-tomcat-9-1.7.0

RUN apt-get update -y && apt-get -y install software-properties-common \
  && curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - 2>/dev/null \
  && add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian buster stable" \
  && apt-get update -y \
  && apt-get install -y docker-ce-cli python3 python3-pip \
  && pip3 install docker-compose \
  && /usr/local/project/start.sh
