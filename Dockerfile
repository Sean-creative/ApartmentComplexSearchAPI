# 기본 이미지 설정
FROM openjdk:17-jdk-alpine

# 포트 설정
EXPOSE 8080

# 애플리케이션 파일 복사
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# 실행 명령 설정
ENTRYPOINT ["java","-jar","/app.jar"]
