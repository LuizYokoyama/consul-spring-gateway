FROM alpine:3.12

RUN apk --update add bash && \
    rm -rf /var/cache/apk/*

ENV INIT_SLEEP_SECONDS=2

CMD /Gonsul/load-gonsul.sh

