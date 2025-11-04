FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache curl bash
RUN curl -L https://github.com/com-lihaoyi/mill/releases/download/0.12.0/0.12.0 > /usr/local/bin/mill && \
    chmod +x /usr/local/bin/mill

WORKDIR /app

COPY build.mill ./build.mill
COPY app ./app

EXPOSE 8080

CMD ["mill", "-w", "app.runBackground"]