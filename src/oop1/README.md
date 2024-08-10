# 2. 객체 지향 프로그래밍

<br>

## 1. 절차 지향 프로그래밍
### 1. 절차 지향 프로그래밍 vs. 객체지향 프로그래밍
프로그램 방식은 크게 절차 지향 프로그래밍과 객체 지향 프로그래밍으로 나눌 수 있습니다.

#### 절차 지향 프로그래밍
- 절차 지향 프로그래밍은 이름 그대로 **절차**를 지향합니다.
- 실행 순서를 중요하게 생각하기 때문에 **프로그램의 흐름을 순차적으로** 따르며 처리하는 방식입니다.

#### 객체 지향 프로그래밍
- 객체 지향 프로그래밍은 이름 그대로 **객체**를 지향합니다.
- 실제 세계의 사물이나 사건을 객체로 보고, 이러한 **객체들 간의 상호작용**을 중심으로 프로그래밍 하는 방식.

두 프로그래밍 방식은 데이터 처리 방식에 있어 중요한 차이가 있습니다.
절차 지향은 데이터와 해당 데이터에 대한 처리 방식이 분리되어 있으나, 객체 지향은 데이터와 그 데이터에 대한 메서드가 하나의 객체 안에 포함 되어있다는 것입니다!!!!

바로 예시로 보겠습니다.

#### 예시

<div class="image-container">
  <img src="https://github.com/user-attachments/assets/ded0aa4d-b922-41c4-9920-df0b6b1592a3" />
  <img src="https://github.com/user-attachments/assets/bc5fda47-ee43-460b-8139-cbcd5bd00a89" />
</div>

<br>

고객이 카페 가서 커피를 주문하여 받는 과정을 프로그래밍의 관점으로 보겠습니다.

절차 지향 방식은 **상황을 중심으로** 순서대로 조합하는 방식입니다.

반면, 객체 지향 방식은 **객체를 중심으로** 프로그래밍 합니다. 커피 주문 상황에서 필요한 객체들에게(고객, 직원) 역할을 지정해놓고, 역할을 가진 각 객체들을 순서대로 조합하는 방식입니다.

<br>

## 2. 클래스와 메서드
클래스는 데이터인 멤버 변수 뿐 아니라 기능 역할을 하는 메서드도 포함할 수 있습니다. 위의 예시로 절차 지향 방식과 객체 지향 방식의 코드 차이를 알아봅시다.

먼저 절차 지향 방식부터 알아보겠습니다!

#### 절차 지향 방식 예시

```java
public class CafeData {
  int coffeeCount;
}
```

```java
public class CafeDataMain {
     public static void main(String[] args) {
         CafeData cafeData = new CafeData();
         add(cafeData);
         add(cafeData);
         add(cafeData);
         System.out.println("커피 개수=" + cafeData.coffeeCount);
     }

     static void add(CafeData cafeData) {
         cafeData.coffeeCount++;
         System.out.println("커피 개수 증가 coffeeCount=" + cafeData.coffeeCount);
      }
}
```

결과
```
커피 개수 증가 coffeeCount=1
커피 개수 증가 coffeeCount=2
커피 개수 증가 coffeeCount=3
커피 개수=3
```

절차 지향 방식은 **상황**을 순서대로 조합하는 방식이라고 하였죠? 코드를 하나하나 분석해봅시다. 🧐

1. coffeeData에 coffeeCount 멤버 변수가 존재합니다. // 메모리 주소는 예시입니다.
   
   <img src="https://github.com/user-attachments/assets/ad9e72df-e347-43ce-862c-1909fe231817" width="40%" />
   
2. 메인에 cafeData를 파라미터로 받아서, cafeData에서 coffeeCount를 꺼내어 증가시키는 메서드 add가 있습니다.
   
   <img src="https://github.com/user-attachments/assets/3eabaaea-a72b-4b05-8dad-24352afc386a" width="40%" />
   
4. 메인에서 **상황**(add)을 **순서대로** 호출하고 있습니다.
   
   <img src="https://github.com/user-attachments/assets/7be223d1-6f77-4bd3-ade8-cfd3df2ecf15" width="40%" />

<br>

과정

<img src="https://github.com/user-attachments/assets/218b1ff0-d8c7-4f94-bbd4-204898fff15d" width="20%" />

<br><br>

다음으로 객체 지향 방식을 알아보겠습니다!

#### 객체 지향 방식 예시

```java
public class CafeData {
  int coffeeCount;

  void add() {
    coffeeCount++;
    System.out.println("커피 개수 증가 coffeeCount=" + cafeData.coffeeCount);
  }
}
```

```java
public class CafeDataMain {
     public static void main(String[] args) {
         CafeData cafeData = new CafeData();
         cafeData.add();
         cafeData.add();
         cafeData.add();
         System.out.println("커피 개수=" + cafeData.coffeeCount);
     }
}
```

결과
```
커피 개수 증가 coffeeCount=1
커피 개수 증가 coffeeCount=2
커피 개수 증가 coffeeCount=3
커피 개수=3
```

객체 지향 방식은 역할을 가진 각 **객체들을 순서대로** 조합하는 방식이라고 하였죠? 코드를 하나하나 분석해봅시다. 🧐

1. cafeData에 coffeeCount 멤버 변수와 coffeeCount 개수를 늘리는 add 메서드가 존재합니다.
   cafeData는 coffeeCount 개수를 늘리는 **역할을 하는 객체**입니다.
   이 add에는 **자신의 멤버 변수에 접근하여** 계산하였다는 점이 절차 지향 방식과의 차이 입니다.

   <img src="https://github.com/user-attachments/assets/72bb63cd-750d-43fd-9684-a6e32a0627f5" width="40%" />
   
3. 메인에서 cafeData 객체에서 역할 add를 꺼내 호출합니다.
   절차 지향 방식과는 다르게 add에 의존하는 값이 없습니다. add 안에 멤버 변수가 있어, add만 순수하게 호출할 수 있습니다.

   <img src="https://github.com/user-attachments/assets/4e923e7d-3c2f-47aa-bdb6-7fb508222541" width="40%" />

과정

<img src="https://github.com/user-attachments/assets/83968734-a1cd-4d8d-b747-cf99b3bb74cb" width="40%" />

#### 정리
- 클래스에는 속성(멤버 변수)과 기능(메서드)을 정의할 수 있습니다.
- 객체는 자신의 메서드를 통해 자신의 멤버변수에 접근 할 수 있습니다.
  객체의 메서드 내부에서 접근하는 멤버 변수는 객체 자신의 멤버 변수입니다.

<br>

## 3. 객체 지향 프로그래밍


