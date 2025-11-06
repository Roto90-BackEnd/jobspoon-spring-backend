# 🥄 Jobspoon - Spring Backend

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-green)](https://spring.io/projects/spring-boot)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/Roto90-BackEnd/jobspoon-spring-backend)
[![License](https://img.shields.io/badge/license-MIT-blue)](./LICENSE)
[![Project Period](https://img.shields.io/badge/Project%20Period-2025.07%20~%202025.10-informational)](https://github.com/Roto90-BackEnd/jobspoon-spring-backend)

Jobspoon은 IT 취업 준비생을 위한 **AI 면접 솔루션 및 스터디 플랫폼**입니다.
본 레포지토리는 Jobspoon 서비스의 Spring Boot 기반 백엔드 API 서버입니다.


## ✨ 4대 핵심 기능 (Features)

Jobspoon은 4개의 핵심 도메인을 중심으로 유기적으로 연결되어 있습니다.

### 1. 🤖 AI 모의면접 (Main Service)
> "AI로 검증하는 면접 솔루션"

AI를 통해 사용자의 면접을 분석하고 피드백을 제공하는 핵심 서비스입니다.
* [e.g., 면접 세트(질문) 생성 및 관리]
* [e.g., 면접 영상/음성 데이터 S3 업로드 API]
* [e.g., AI 분석 결과(STT 텍스트, 점수) 저장 및 조회]
* [e.g., 면접 유형(CS, 직무, 인성)별 질문 관리]

### 2. 🧑‍🤝‍🧑 스터디 모임 (Retention)
> "함께 성장하는 스터디 커뮤니티"

학습 리텐션을 유도하고 커뮤니티를 활성화하는 서브 도메인입니다.
* 스터디 그룹 생성, 검색, 참여 및 관리
* 스터디별 공지사항 및 캘린더 기반 **일정 관리**
* 스터디 리더를 위한 **신청 관리** (가입 승인/거절)
* 일정별 **출석 관리** (멤버별 출석/결석/대기 상태 처리)

### 3. 🧠 스푼워드 (Learning)
> "매일매일 학습하는 IT 지식 퀴즈"

지속적인 학습 동기를 부여하는 퀴즈 및 학습 콘텐츠입니다.
* [e.g., 일일/주간 CS/직무 퀴즈 제공]
* [e.g., 사용자 답변 제출 및 정답 처리]
* [e.g., 퀴즈 기반 학습 점수 및 랭킹 시스템]

### 4. 📊 마이페이지 (Profile & Stats)
> "한눈에 보는 나의 성장 기록"

모든 서비스의 활동 데이터를 통계로 관리하고 프로필을 제공합니다.
* 사용자 프로필(닉네임, 프로필 이미지) 수정
* 서비스별(면접, 스푼워드) 획득 점수 및 통계 데이터 집계
* 나의 스터디 현황 및 학습 캘린더(일정, 출석 현황) 조회

## 🛠️ 기술 스택 (Tech Stack)

| Category | Stack | Description |
| :--- | :--- | :--- |
| **Language** | Java [17] | |
| **Framework** | Spring Boot [3.5.3] | |
| **Security** | Spring Security | 커스텀 필터 기반 토큰 인증/인가 |
| **In-Memory** | Redis | 인증 토큰 저장소(Opaque Token), 랭킹, 캐시관리 |
| **Database** | MySQL | 메인 데이터베이스 |
| **ORM** | Spring Data JPA | |
| **Build** | [Gradle] | |
| **API Docs** | SpringDoc OpenAPI 3.0 | ` /swagger-ui.html ` |
| **Etc** | Lombok | |
| | [AWS S3] | [e.g., 프로필 이미지, 신고 파일 등] |

## 🚀 로컬 실행 방법 (Getting Started)

### 1. 전제 조건 (Prerequisites)

* Java `[17]` (JDK 17)
* `[Gradle]`
* `[MySQL]`
* `[Redis]`
* `IDE (IntelliJ)`

### 2. 실행 가이드 (Running Locally)

1.  **레포지토리 클론**
    ```bash
    git clone [https://github.com/Roto90-BackEnd/jobspoon-spring-backend.git](https://github.com/Roto90-BackEnd/jobspoon-spring-backend.git)
    cd jobspoon-spring-backend
    ```

2.  **보안 설정 파일 생성 (`.env`)**

    본 프로젝트는 모든 민감 정보(DB비밀번호, API키 등)를 `.env` 파일로 관리합니다.
    레포지토리에 포함된 **`.env.example`** 파일을 **`.env`** 파일로 복사하세요.

    ```bash
    cp .env.example .env
    ```

3.  **`.env` 파일 수정**

    방금 생성한 `.env` 파일을 열어, 본인의 로컬 개발 환경에 맞게 `[ ]`로 표시된 값들을 채워주세요. (e.g., 로컬 DB 비밀번호, Kakao/GitHub API 키 등)

    ```ini
    # .env
    SPRING_DATABASE_USER=my_local_db_user
    SPRING_DATABASE_PASSWORD=my_local_db_password
    SPRING_DATA_REDIS_PASSWORD=my_local_redis_password
    KAKAO_CLIENT_ID=abcdefg...
    ...
    ```

4.  **빌드 및 실행**
    ```bash
    ./gradlew build
    java -jar build/libs/[생성된_jar_파일_이름].jar
    ```
    *또는 IDE에서 `JobspoonSpringBackendApplication` 클래스를 직접 실행합니다.*

5.  **확인**
    * 서버가 `http://localhost:8080` (기본값)에서 실행됩니다.
    * API 문서는 `http://localhost:8080/swagger-ui.html` 에서 확인합니다.

## 📖 API 문서 (API Documentation)

프로젝트 실행 후, 아래 엔드포인트에서 API 명세(Swagger)를 실시간으로 확인할 수 있습니다.

* **Swagger UI:** `http://localhost:8080/swagger-ui.html`

## 🏛️ 데이터베이스 스키마 (Database Schema)

[ERD 다이어그램 이미지를 여기에 삽입하세요. (Notion, draw.io 등)]

*(ERD 예시: 스터디 모임 도메인)*
```mermaid
erDiagram
    MEMBER ||--o{ STUDY_MEMBER : "참여"
    STUDY_ROOM ||--|{ STUDY_MEMBER : "포함"
    STUDY_ROOM ||--|{ STUDY_SCHEDULE : "일정"
    STUDY_SCHEDULE ||--|{ SCHEDULE_ATTENDANCE : "출석"
    STUDY_MEMBER ||--|{ SCHEDULE_ATTENDANCE : "대상"

    MEMBER {
        Long id PK
        String email
        String nickname
    }
    STUDY_ROOM {
        Long id PK
        String title
        Long leader_id FK
    }
    STUDY_MEMBER {
        Long id PK
        Long member_id FK
        Long study_room_id FK
        String role
    }
    STUDY_SCHEDULE {
        Long id PK
        Long study_room_id FK
        String title
        Timestamp start_time
    }
    SCHEDULE_ATTENDANCE {
        Long id PK
        Long schedule_id FK
        Long member_id FK
        String status
    }
