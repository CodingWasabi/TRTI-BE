# TRTI
```개인 성향 기반 그룹 여행 합의 웹 서비스```


안녕하세요  
TRTI BACK END 입니다.  

## 추구하는 개발
### 일관된 Commit Message
### Clean Code
### 지속적인 version 관리

## Spring Dependencies
|dependencies|버전|
|:---:|:---:|
|Lombok|1.18.22|
|Spring Web|5.3.14|
|Spring Security|5.6.1|
|Spring Data JPA|2.6.0|
|MySQL|8.0.27|
|Validation|2.6.2|
|RestDocs|2.0.5.RELEASE|

## 기술 스텍
|기술|버전|
|:---:|:---:|
|Spring Boot|2.6.2|
|Java|11|
|docker|2.10.12|
|Junit5||
|MySQL|8.0.27|

## branch
<details>
<summary>자세히 보기</summary>
<div markdown="1">
    <p>
    <ul>
        <li><code>deploy</code> : 배포시 사용하는 브랜치</li>
        <li><code>develop</code> : 다음 출시 버전을 개발하는 브랜치 <ul>
                <li>다음 릴리즈를 위해 언제든 배포될 수 있는 상태</li>
                <li>하나의 기능 구현이 끝나면, develop 브랜치로 병합할 것</li>
            </ul>
        </li>
        <li><code>feature</code> : 기능을 개발하는 브랜치<ul>
                <li>기능을 완성할 때 까지 유지하며, 완성시 <code>develop</code>브랜치로 merge</li>
                <li><code>feature</code>는 이슈번호를 기준으로 생성</li>
                <li>Ex) <code>feature-2/example</code></li>
            </ul>
        </li>
        <li><code>refactoring</code> : 리펙토링을 진행하는 브랜치</li>
        <li><code>hotfix</code> : 배포 버전에서 생긴 문제로 긴급한 트러블 슈팅이 필요할 때 개발이 진행되는 브랜치</li>
        <li><code>test</code> : 테스트를 진행하는 브랜치</li>
    </ul>
    <p align="center">
        <img src="https://user-images.githubusercontent.com/46064193/124911385-a74b2c00-e027-11eb-982d-a96e6c40d5b3.png" alt="Branch Strategy" width="500">
    </p>
</div>

</details>


## commit
<details>
<summary>자세히 보기</summary>

|type|content|
|:---:|:---:|
|🌞INIT|최초 생성|
|🔥FEAT|기능 구현|
|📁LIB|라이브러리 추가|
|📈UPDATE|코드 수정|
|🔧FIX|오류 수정|
|💨MOVE|파일 이동|
|🖍RENAME|이름 변경|
|🌪️REF|리팩토링|
|🌚TIDY|코드 삭제|
|💣REMOVE|파일 삭제|
|📖TEST|테스트|
|⚠️EMG|긴급 작업|
|📜DOCS|문서화|


### Commit Message의 7가지 약속 (from NHN)
1. 제목과 본문을 한 줄 띄워 분리하기
2. 제목은 영문 기준 50자 이내로
3. 제목 첫글자를 대문자로
4. 제목 끝에 . 금지
5. 제목은 명령조로
6. 본문은 영문 기준 72자마다 줄 바꾸기
7. 본문은 어떻게보다 무엇을, 왜에 맞춰 작성하기

</details>

## Convention
https://naver.github.io/hackday-conventions-java

## reference
[Spring Dependencies version]
https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html#dependency-versions

[NHN Cloud - 좋은 커밋 메시지를 작성하기 위한 7가지 약속]  
https://meetup.toast.com/posts/106  

[커밋 메시지 가이드]  
https://github.com/RomuloOliveira/commit-messages-guide/blob/master/README_ko-KR.md

[우아한 형제들 기술 블로그 - 우린 Git-flow를 사용하고 있어요]
https://techblog.woowahan.com/2553/