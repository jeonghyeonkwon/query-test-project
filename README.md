# Query-test-project

### 유튜브나 블로그 글을 보고 제가 배운 기술들의 모르는 부분들을 눈으로 확인 하기 위해 만든 프로젝트 입니다.

### <span style="color:grey">_.env 파일 추가_</span>

- mysql에서 query-test-project 라는 SCHEMA 생성 또는 원하시는 이름을 정한후 생성후 spring.datasource.url의 명을 변경해 주세요

```YAML
server:
  port: 8080

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/query-test-project?serverTimezone=Asia/Seoul
    username: # mysql 계정
    password: # mysql 비밀전호
  jpa:
    hibernate:
      ddl-auto: create
    open-in-view: true
    properties:
      hibernate:
        format_sql: true
        default_batch_fetch_size: 100
        use_sql_comments: true


```