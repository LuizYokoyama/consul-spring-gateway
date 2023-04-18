FROM alpine:3.2

RUN apk --update add nodejs git openssh ca-certificates && \
    rm -rf /var/cache/apk/* && \
    npm install git2consul@0.12.13 --global && \
    mkdir -p ./config

VOLUME /config

CMD
