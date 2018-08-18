FROM openjdk:8u181-jdk

MAINTAINER suresh26272@yahoo.com

# setup group and user, initialize home
RUN addgroup -gid 30002 everflow-news && \
	adduser --gid 30002  --system --disabled-login --home /app --shell /sbin/nologin -u 30002 everflow-news

COPY everflow-news.jar /app

RUN chown -R everflow-news /app

EXPOSE 8080

USER everflow-news

WORKDIR app

ENTRYPOINT exec java $JAVA_OPTS -jar ./everflow-news.jar