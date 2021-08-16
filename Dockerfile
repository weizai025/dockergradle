FROM openjdk:8-alpine
LABEL maintainer "724290768@qq.coom"

# A timestamp to disable cached files.
ENV REFRESHED_AT 2018-09-03
#RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g" /etc/apk/repositories \
#      && apk add tzdata
# Change timezone.
#RUN apk add tzdata
ENV TZ Asia/Shanghai

# Copy application file.
COPY app.jar /opt/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/opt/app.jar"]
