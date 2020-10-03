FROM jenkins/jenkins:lts
# if we want to install via apt
USER root
RUN apt-get update && \
    apt-get -y --no-install-recommends install apt-transport-https \
      ca-certificates \
      curl \
      gnupg2 \
      software-properties-common && \
    curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg > /tmp/dkey; apt-key add /tmp/dkey && \
    add-apt-repository \
      "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
      $(lsb_release -cs) \
      stable" && \
   apt-get update && \
   apt-get -y --no-install-recommends install docker-ce && \
   apt-get clean && \
   usermod -aG docker jenkins
#&& apt-get install -y maven \
#&& apt-get install -y ansible
# drop back to the regular jenkins user - good practice
USER jenkins

#just info about who created this
MAINTAINER Liran Farage (email)

#get rid of admin password setup
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

#automatically installing all plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

#adding scripts
COPY groovy/* /usr/share/jenkins/ref/init.groovy.d/

USER root

# RUN curl -o /tmp/filebeat-7.6.1-amd64.deb https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.6.1-amd64.deb && \
#     dpkg -i /tmp/filebeat-7.6.1-amd64.deb &&  apt-get install

# COPY filebeat.yml /etc/filebeat/filebeat.yml

COPY ["entrypoint.sh", "/"]

RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/bin/bash","-c","./entrypoint.sh"]
