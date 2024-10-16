# 계산기를 만들어보자!
자바를 이용하여 사칙연산 수행이 가능한 계산기 구현

---
### 요구 사항 기능
* Level1
  
   * 양의 정수(0 포함) 2개 입력받기
   * 사칙 연산 기호(+, -, *, /) 입력받기
   * 결과 값 출력
   * exit 명령어를 입력받아 계산 종료

* Level2

  * 사칙 연산 수행 후, 결과 값 저장하는 컬렉션 타입 필드 가진 Calculator 클래스 생성
  * Lv1 와 동일한 기능 수행
  * getter, setter 사용하여 캡슐화
  * 컬렉션 이용하여 가장 먼저 저장된 계산 결과 삭제하는 기능 구현
 
* Level3

  * Enum 사용하여 연산 타입 관리
  * 제네릭 사용하여 입력받은 타입으로 연산 처리
  * 람다, 스트림 사용하여 저장된 연산 결과 중 입력 받은 값보다 큰 값들 조회

---
#### 추가 구현 사항
1. 입력 받은 숫자가 정수, 실수가 아닌 다른 값이 들어오면 에러 문구 출력 후 기능 재개
2. 입력 받은 연산자가 (+, -, *, /)가 아닌 다른 값이 들어오면 에러 문구 출력 후 기능 재개
---
#### 추가 필요 사항
1. 괄호가 있는 계산식 입력받아 연산하는 기능 구현 -> 개선 필요 : 계산식 사이에 공백이 없으면 에러 발생 (https://devheat.tistory.com/3 참고함)
2. 제곱근과 제곱 같은 연산 기능
---
##### Trouble Shooting
1. [Enum 사용하기](https://withsumyeom.tistory.com/14)
2. [Generic 사용](https://withsumyeom.tistory.com/15)
