FROM anapsix/alpine-java:8_server-jre_unlimited


RUN mkdir -p /blade

WORKDIR /ruoyi

EXPOSE 8090

ADD ./ruoyi-admin/target/ruoyi-admin.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

