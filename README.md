# LojaDesignPattern
Loja Design Pattern
## Ambiente para Execução de Containers CI

#### 1. Docker dind: 
sudo docker run --name jenkins-docker --rm --detach   --privileged --network jenkins --network-alias docker   --env DOCKER_TLS_CERTDIR=/certs   --volume jenkins-docker-certs:/certs/client   --volume jenkins-data:/var/jenkins_home   --publish 3000:3000 --publish 2376:2376   docker:dind --storage-driver overlay2

#### 2. Jenkins:
sudo docker run --name jenkins-blueocean --detach   --network jenkins --env DOCKER_HOST=tcp://docker:2376   --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1   --publish 8080:8080 --publish 50000:50000   --volume jenkins-data:/var/jenkins_home   --volume jenkins-docker-certs:/certs/client:ro   --volume "$HOME":/home   --restart=on-failure   --env JAVA_OPTS="-Dhudson.plugins.git.GitSCM.ALLOW_LOCAL_CHECKOUT=true"   joaopaulopbjp/myjenkins-blueocean:2.356-jdk11.1

#### 3. Plugin do Jenins:
Instalar o plugin 'Docker'

#### 4. Jenkins File:
Criar um arquivo Jenkinsfile na raiz do projeto do Git para descrição da pipeline a partir do SCM
