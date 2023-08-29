FROM alpine:3.12

ADD /gonsul /

ADD /load-gonsul.sh /

ENV INIT_SLEEP_SECONDS=6

CMD /load-gonsul.sh