#
#FROM adoptopenjdk/openjdk11:alpine-jre-nightly
#RUN apk --update add openjdk11-jre
#COPY build/libs/dockergradle-1.2-plain.jar app.jar
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

# 基础镜像
FROM adoptopenjdk/openjdk11:alpine-jre-nightly
# 作者
LABEL maintainer="imavei@outlook.com"

# 修改源
RUN echo "http://mirrors.aliyun.com/alpine/latest-stable/main/" > /etc/apk/repositories && \
    echo "http://mirrors.aliyun.com/alpine/latest-stable/community/" >> /etc/apk/repositories
# 安装需要的软件，解决时区问题
RUN apk --update add curl bash tzdata && \
    rm -rf /var/cache/apk/*
# 修改镜像为东八区时间
ENV TZ Asia/Shanghai

# Copy application file.
COPY build/libs/dockergradle-1.2-plain.jar /opt/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/opt/app.jar"]

