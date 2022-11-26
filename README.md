# 미션 - 페어매칭관리 애플리케이션

## 🚀 기능 요구사항
- 우테코의 미션은 페어 프로그래밍으로 진행된다.
- 미션을 함께할 페어를 관리해주는 애플리케이션을 완성하시오.

### 도메인 설명
- 우테코에서 운영하는 과정은 현재 백엔드 과정과 프론트엔드 과정이 있다.
- 각 과정은 5단계로 나누어 진행이 되는데 이를 레벨이라고 한다.
- 미션을 수행하며 각 레벨에서 전달하고자 하는 내용을 학습하는데 이 과정을 페어 프로그래밍으로 진행한다.
- 미션을 시작하기 전 페어를 매칭하는데 다양한 페어를 만나기 위해서 같은 레벨 동안은 같은 페어를 만나지 않는다.

### 페어 매칭 기능
- 페어 매칭 조건
```
- 미션을 함께 수행할 페어를 두명씩 매칭한다.
- 페어 매칭 대상이 홀수인 경우 한 페어는 3인으로 구성한다. 
- 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없다.
```

- 페어 매칭 구현 방법
```
- 크루들의 이름 목록을 List<String> 형태로 준비한다.
- 크루 목록의 순서를 랜덤으로 섞는다. 이 때 `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용해야 한다.
- 랜덤으로 섞인 페어 목록에서 페어 매칭을 할 때 앞에서부터 순서대로 두명씩 페어를 맺는다.
- 홀수인 경우 마지막 남은 크루는 마지막 페어에 포함시킨다.
- 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 된다면 크루 목록의 순서를 다시 랜덤으로 섞어서 매칭을 시도한다.
- 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력한다.
```

```kotlin
> 코드 예시
        
val crewNames: List<String> // 파일에서 로드한 크루 이름 목록
val shuffledCrew: List<String> = Randoms.shuffle(crewNames) // 섞인 크루 이름 목록

// 페어 매칭 & 검증

...
```

- 페어 재매칭 시도
```
- 안내 문구를 출력 후 매칭을 진행한다.
- 아니오를 선택할 경우 코스, 레벨, 미션을 다시 선택한다.
```

### 페어 조회 기능
- 과정, 레벨, 미션을 선택하면 해당 미션의 페어 정보를 출력한다.
- 매칭 이력이 없으면 매칭 이력이 없다고 안내한다.

```
[ERROR] 매칭 이력이 없습니다.
```
---

## 💾 사전 제공 정보
- 크루 정보는 src/resources 하위에 md 파일로 제공되며 변경이 가능하다.
- 과정, 레벨, 미션 정보는 아래에 제공하는 그대로 사용해야 한다.
 
```
## 과정
- 백엔드
- 프론트엔드

## 레벨
- 레벨1
- 레벨2
- 레벨3
- 레벨4
- 레벨5

## 미션
### 레벨1
- 자동차경주
- 로또
- 숫자야구게임

### 레벨2
- 장바구니
- 결제
- 지하철노선도

### 레벨3(없음)

### 레벨4
- 성능개선
- 배포

### 레벨5 (없음)
```

---
## ✍🏻 입출력 요구사항

### 파일 입출력
- 페어 매칭에 필요한 크루들의 이름을 파일 입출력을 통해 불러온다.
- `src/main/resources/backend-crew.md`과 `src/main/resources/frontend-crew.md` 파일을 이용한다.
- 두 파일의 내용은 수정이 가능하다. 수정 시 크루들의 이름은 중복될 수 없다.
- 파일 입출력 방법은 `코틀린 파일 읽기`나 `코틀린 파일 입출력`과 같은 키워드로 구글링해서 찾을 수 있다.

### 에러 처리
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

### 기능 선택
- 프로그램을 시작하면 기능의 종류를 출력하고 그 중 하나의 입력을 받는다.
```
기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
```

### 페어 매칭
- 과정와 미션을 출력하고 매칭하고자 하는 과정, 레벨, 미션을 입력 받는다.
```
#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
```

- 매칭이 정상적으로 수행되면 결과가 출력된다.
- 출력되는 페어의 순서는 `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드의 결과 순서로 정렬한다.

```
페어 매칭 결과입니다.
용팔 : 대만
대협 : 덕규
치수 : 준호
태웅 : 백호
달재 : 태산
한나 : 수겸
태섭 : 대남
준섭 : 소연
현준 : 호열
구식 : 경태
```

### 프로그래밍 실행 결과 예시

```
기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
1

#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주

페어 매칭 결과입니다.
다비 : 신디
쉐리 : 덴버
제키 : 로드
라라 : 윌터
니콜 : 이브
린다 : 시저
보노 : 제시 : 제키

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
1

#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주

매칭 정보가 있습니다. 다시 매칭하시겠습니까?
네 | 아니오
아니오

과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주
매칭 정보가 있습니다. 다시 매칭하시겠습니까?
네 | 아니오
네

페어 매칭 결과입니다.
이브 : 윌터
보노 : 제키
신디 : 로드
제시 : 린다
시저 : 라라
니콜 : 다비
리사 : 덴버 : 제키

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
2

#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주

페어 매칭 결과입니다.
이브 : 윌터
보노 : 제키
신디 : 로드
제시 : 린다
시저 : 라라
니콜 : 다비
리사 : 덴버 : 제키

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
3

초기화 되었습니다. 

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
Q
```

---

## 🎱 프로그래밍 요구사항

- Kotlin 1.6.20에서 실행 가능해야 한다. **Kotlin 1.6.20에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가된 요구 사항

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else를 지양한다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 `test/kotlin/pairmatching/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `shuffle()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


---
## ❗️ 힌트
- 아래의 힌트를 참고하여 진행해도 좋다.
- 반드시 아래의 힌트를 따라해야하는 것은 아니며 사용하지 않아도 되고 수정도 가능하다.

### 과정
```kotlin
enum class Course(val value: String) {
  
  BACKEND("백엔드"),
  FRONTEND("프론트엔드"),;

  // 추가 기능 구현
}
```

### 레벨
```kotlin
enum class Level(val value: String) {

  LEVEL1("레벨1"),
  LEVEL2("레벨2"),
  LEVEL3("레벨3"),
  LEVEL4("레벨4"),
  LEVEL5("레벨5"),;

  // 추가 기능 구현
}
```

### 크루
```kotlin
class Crew(
    private val course: Course,
    private val name: String,
)
```

(아래 `Crew`는 기존 java 미션에 있는 코드입니다. 이렇게 생겼으니 참고하세요(성록))
```java
public class Crew {
    private Course course;
    private String name;
}
```

---

## 📝 License

This project is [MIT](https://github.com/no1msh/precourse-study-pair-matching/blob/main/LICENSE.md) licensed.
