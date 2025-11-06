# 🥄 Jobspoon - Spring Backend

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/Roto90-BackEnd/jobspoon-spring-backend)
[![License](https://img.shields.io/badge/license-MIT-blue)](./LICENSE)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-green)](https://spring.io/projects/spring-boot)

**[Jobspoon은 IT 취업 준비생들을 위한 스터디 관리 및 모의 면접 플랫폼입니다.]**

본 레포지토리는 Jobspoon 서비스의 Spring Boot 기반 백엔드 API 서버입니다.

## ✨ 주요 기능 (Features)

* **🧑‍🤝‍🧑 스터디 관리:** 스터디 그룹 생성, 참여, 검색 및 관리 기능
* **📅 일정 관리:** 스터디별 일정 등록 및 캘린더 연동 (e.g., Google Calendar)
* **🔖 출석 관리:** [e.g., 스터디 리더가 일정별 멤버의 출석/결석을 관리]
* **💼 모의 면접:** [e.g., CS/직무 질문 기반의 모의 면접 세트 생성 및 관리]
* **✍️ 신청 관리:** [e.g., 스터디 리더가 가입 신청을 수락/거절]
* **[추가 기능 1]**: [e.g., 사용자 인증 (JWT 기반)]
* **[추가 기능 2]**: [e.g., 공지사항 및 게시판]

## 🛠️ 기술 스택 (Tech Stack)

| Category | Stack |
| :--- | :--- |
| **Language** | Java [17] |
| **Framework** | Spring Boot [3.x.x], Spring Security |
| **Database** | [PostgreSQL / MySQL / H2] |
| **ORM** | Spring Data JPA (Hibernate) |
| **Build** | [Gradle / Maven] |
| **Auth** | JWT (JSON Web Token) |
| **API Docs** | SpringDoc OpenAPI (Swagger UI) |
| **Etc** | [e.g., Lombok, AWS S3, Redis, ...] |

## 🚀 시작하기 (Getting Started)

### 1. 전제 조건 (Prerequisites)

* Java `[17]` (JDK 17)
* `[Gradle]`
* `[PostgreSQL]` (or `MySQL`)
* IDE (e.g., IntelliJ, VSCode)

### 2. 로컬에서 실행하기 (Running Locally)

1.  **레포지토리 클론**
    ```bash
    git clone [https://github.com/Roto90-BackEnd/jobspoon-spring-backend.git](https://github.com/Roto90-BackEnd/jobspoon-spring-backend.git)
    cd jobspoon-spring-backend
    ```

2.  **설정 파일 생성 (`application.yml`)**

    `src/main/resources/` 경로에 `application.yml` 파일을 생성합니다.
    (보안을 위해 `application.yml`은 .gitignore에 포함되어야 합니다. `application.yml.example` 파일을 만들어두는 것을 권장합니다.)

    **`application.yml` 예시:**
    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/[DB_NAME]
        username: [DB_USER]
        password: [DB_PASSWORD]
        driver-class-name: org.postgresql.Driver

      jpa:
        hibernate:
          ddl-auto: [update / validate / none] # (로컬 개발 시 'update' 또는 'create')
        properties:
          hibernate:
            format_sql: true
            show_sql: true
        defer-datasource-initialization: true
      
    # JWT 시크릿 키 (필수)
    jwt:
      secret: [base64로_인코딩된_시크릿_키]
      
    # Swagger (SpringDoc)
    springdoc:
      swagger-ui:
        path: /swagger-ui.html
      api-docs:
        path: /v3/api-docs
