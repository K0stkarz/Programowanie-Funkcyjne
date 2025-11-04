FROM ubuntu:latest

RUN apt-get update

RUN apt-get install -y openjdk-8-jdk
RUN apt-get install -y python3
RUN apt-get install -y scala
RUN apt-get install -y curl
RUN mkdir /opt/sbt && \
    curl -L -o /opt/sbt/sbt.tgz https://github.com/sbt/sbt/releases/download/v1.11.7/sbt-1.11.7.tgz && \
    tar -xzf /opt/sbt/sbt.tgz -C /opt/sbt --strip-components=1 && \
    rm /opt/sbt/sbt.tgz
RUN apt-get install -y vim

ENV PATH="/opt/sbt/bin:${PATH}"

CMD ["/bin/bash"]