
# 김선우 아키스케치 codingtest
-- --
## Project Spec
- Spring Boot: 3.2.4
- Kotlin: 1.9.23 (Java 17)
- Spring Data JPA

## Package Structure
- 폴더구조
    - controller : HTTP 요청을 처리
    - dto : 데이터 전송 객체
    - entity : 데이터베이스 테이블과 매핑되는 엔티티
    - config : security, exception 처리 핸들러
    - repository : 데이터베이스 연산을 처리
    - service : 비즈니스 로직을 처리

- Resources
  - application.yml : 애플리케이션 구성 파일 
  - erd.png : DB erd image
  - archisketch.postman_collection.json : API postman json
 

## Install & Run
### Install
```
$ git clone https://github.com/Sean-creative/ApartmentComplexSearchAPI.git
```
### Build
```
$ ./gradlew clean
$ ./gradlew build 
```

### Run
```
$ java -jar ./build/libs/apartment-complex-search-api-0.0.1-SNAPSHOT.jar
```
