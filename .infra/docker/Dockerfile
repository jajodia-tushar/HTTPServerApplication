FROM java:8
COPY files/ /var/www/chattingApplication/files/
COPY build/libs/chatApplication.jar /var/www/chattingApplication/

WORKDIR /var/www/chattingApplication/
EXPOSE 8888
RUN chmod 777 chatApplication.jar
CMD ["java","-jar","chatApplication.jar"]

