FROM alpine:3.12

RUN apk --update add bash git openssh && \
    rm -rf /var/cache/apk/* && \
    mkdir -p ~/.ssh/ &&\
    ssh-keyscan -H github.com >> ~/.ssh/known_hosts
# Create a non-root user to run the gonsul process
RUN addgroup -S gonsul && adduser --home /home/gonsul -S gonsul -G gonsul

ENV INIT_SLEEP_SECONDS=2


CMD /Gonsul/load-gonsul.sh

