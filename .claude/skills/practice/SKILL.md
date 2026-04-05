---
name: practice
description: 현재 풀고 있는 알고리즘 문제에서 사용되는 핵심 Java 문법/자료구조를 연습할 수 있는 Practice 클래스를 생성한다. "연습", "문법 연습", "practice" 등을 요청할 때 사용.
argument-hint: [주제 - 생략 시 현재 작업 중인 문제에서 자동 판단]
allowed-tools: WebFetch Read Write Bash Glob Grep
---

# 문법 연습 클래스 생성

주제: $ARGUMENTS

## 프로세스

1. **주제 파악**:
   - 인자가 있으면 해당 주제로 연습 클래스를 만든다 (예: PriorityQueue, HashMap, Stack 등)
   - 인자가 없으면 현재 작업 중인 파일을 확인하여 관련 문법/자료구조를 파악한다
   - git status, 최근 수정 파일 등을 확인하여 현재 풀고 있는 문제를 유추한다

2. **연습 클래스 생성**:
   - 위치: `src/pratice/` 디렉토리 (기존 패키지명 유지)
   - 파일명: `{주제}Practice.java` (예: `PriorityQueuePractice.java`)
   - 기존 `src/pratice/` 파일들의 스타일을 참고하여 일관성 유지

3. **클래스 구조**: 아래 패턴을 따른다:

```java
package pratice;

// 필요한 import문

public class {주제}Practice {

    public static void main(String[] args) {
        System.out.println("=== Q1: 설명 ===");
        q1();

        System.out.println("\n=== Q2: 설명 ===");
        q2();
        // ... 5~7개 문제
    }

    // Q1: 문제 설명
    // 기대 결과: 예상 출력
    static void q1() {
        // 초기 데이터 세팅
        // TODO: 여기에 구현하세요.
    }

    // Q2: ...
}
```

## 규칙

- 문제는 5~7개, 쉬운 것에서 어려운 순으로 배치한다.
- 각 문제에 기대 결과를 주석으로 명시한다.
- 기본 사용법 → 응용 → 알고리즘 문제에서 자주 쓰는 패턴 순서로 구성한다.
- TODO 주석을 남겨서 사용자가 직접 작성하도록 한다.
- 데이터 초기화 코드는 미리 작성해둔다.
- 현재 풀고 있는 문제와 직접적으로 연관된 패턴을 포함한다.
- 이미 같은 이름의 파일이 존재하면 사용자에게 알리고 덮어쓸지 확인한다.