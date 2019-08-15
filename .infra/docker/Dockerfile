FROM java:8
COPY src/ /var/www/chattingApplication/scr/
COPY files/ /var/www/chattingApplication/files/
COPY build/libs/chatApplication.jar /var/www/chattingApplication/

WORKDIR /var/www/chattingApplication/
EXPOSE 8888
CMD ["java","-jar","chatApplication.jar"]

