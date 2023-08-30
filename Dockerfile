FROM alpine:3.12

RUN apk --update add bash && \
    rm -rf /var/cache/apk/*

ADD /gonsul /
ADD /gonsul.conf /
ADD /load-gonsul.sh /
ADD /id_ed25519 /
ENV INIT_SLEEP_SECONDS=2

CMD /load-gonsul.sh

