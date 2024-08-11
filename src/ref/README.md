# 기본형과 참조형
### ⭐️ 자바에서 참조형을 제대로 이해하는 것은 정말 중요️ ⭐
자바는 기본형을 제외한 나머지는 모두 참조형이다.

<br>

## 1. 기본
### 1) 기본형
- 자바가 기본으로 제공하는 데이터 타입으로, 변수에 사용하는 값을 직접 넣을 수 있는 데이터 타입.
- 개발자가 새로 정의 불가

#### 💡 기본형은 모두 소문자로 시작한다고 이해하면 편할듯!!

ex) `int`, `long`, `double`, `boolean`

### 2) 참조형
- 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입
- 개발자가 정의하는 모든 클래스는 참조형
- `String`: 자바에서 `String`은 클래스이므로, 참조형임.
  그런데 문자는 매우 자주 다루기 때문에, 자바에서 기본형처럼 문자 값을 바로 대입 가능하도록 편의 기능을 제공한다.

#### 💡 참조형은 모두 대문자로 시작한다고 이해하면 편할듯!!

ex) `String`, `객체`, `배열` 

<br>

## 2. 계산
### 1) 기본형
기본형은 들어있는 값을 그대로 계산에 사용 가능
```JAVA
int a = 10, b = 20;
int sum = a + b;
```
### 2) 참조형
참조형은 들어있는 `참조값`을 그대로 사용 불가
주소지만 가지고는 할 수 있는게 없음.

```JAVA
Student s1 = new Student(); // s1 = ref.Student@a09ee92 (s1에는 주소값이 존재)
Student s2 = new Student(); // s2 = ref.Student@30f39991 (s2에는 주소값이 존재)
System.out.println(s1 + s2); // error
```

값은 주소지에 가야 확인할 수 있다.
 ```JAVA
Student s1 = new Student();
s1.grade = 100; // 값 지정

Student s2 = new Student();
s2.grade = 90; // 값 지정

int sum = s1.grade + s2.grade; // 값을 꺼내 계산함
```

<br>

## 3. 변수 대입

#### 💡 자바는 항상 변수의 값을 복사해서 대입한다.!!

자바에서 변수에 값을 대입하는 것은 변수에 들어있는 값을 복사해서 대입하는 것이다.

### 1) 기본형
- 변수에 들어있는 실제 사용하는 값을 복사하여 대입한다.

```JAVA
int a = 10;
int b = a; // b에 a의 값인 10을 복사해서 대입.
```

결과: a = 10, b = 10

<img src="https://github.com/user-attachments/assets/03f284db-e8fc-4902-a265-ea335768c35d" width="50%"/>

### 2) 참조형
- 실제 사용하는 객체가 아니라 객체의 위치를 가리키는 참조값(주소값)을 복사하여 대입

```JAVA
Student s1 = new Student(); // s1 = ref.Student@a09ee92 (s1 주소값 예시)
Student s2 = s1; // s2에 s1의 주소값인 a09ee92 복사하여 대입
```

결과: s1 = ref.Student@a09ee92, s2 = ref.Student@a09ee92
s1, s2 모두 같은 주소값인 a09ee92를 바라보게 된다.

<img src="https://github.com/user-attachments/assets/8c725cd3-1717-41b0-b505-2dd4b0e6f0dd" width="50%" />

<br>

## 3. 메서드 호출

#### 💡 자바는 항상 변수의 값을 복사해서 대입한다.!!

메서드를 호출할 때 사용하는 매개변수(파라미터)도 변수이다. 따라서 메서드를 호출할 때 매개변수에 값을 전달하는 것도 값을 복사하여 전달하는 방식이다.

### 1) 기본형 메서드 호출

메서드로 기본형 데이터를 전달하면 **해당 값** 이 복사되어 전달된다.
이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도 호출자의 변수 값에는 영향이 없다.

```JAVA
int a = 10;
changeNumber(a); // a = 10

void changeNumber(int x) { // 1. x = a (x = 10)
  x = 20; // 2. x = 20
}
```

1. changeNumber의 파라미터에 a 대입
   x에 a 값인 10 대입 (x = 10)
2. x에 20 대입 (x = 20)

결과
a = 10

### 2) 참조형 메서드 호출

메서드로 참조형 데이터를 전달하면 **참조값(주소값)** 이 복사되어 전달된다.
이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 값을 변경하면 호출자의 객체도 변경된다.

```JAVA
Student s1 = new Student(); // s1 = ref.Student@a09ee92 (s1 주소값 예시)
s1.grade = 100;
changeGrade(s1); // s1.grade = 90

void changeGrade(Student studentS) { // 1. studentS = ref.Student@a09ee92 (student1, studentS 모두 같은 주소값 바라봄)
  studentS.grade = 90; // 2. s1.grade = 90;
}
```

1. changeGrade의 파라미터에 s1 객체 대입
   studentS에 s1의 주소값인 a09ee92 대입 (s1 = a09ee92, studentS = a09ee92)

   <img src="https://github.com/user-attachments/assets/19de0ec2-b6a4-429d-9cff-77f83db8d682" width="50%" />

2. studentS.grade에 90 대입
   a09ee92에 grade 찾아서 90으로 변경
   s1은 studentS와 같은 주소값을 바라보므로, s1.grade도 90으로 변경
   
결과
s1.grade = 90

<br>

## 4. 변수와 초기화
### 1) 변수의 종류
- 멤버 변수(필드)
  - 클래스에 선언

  #### 예시
  ```JAVA
  public class Student {
    String name; // 멤버 번수(필드)
    int age; // 멤버 변수(필드)
    int grade;  // 멤버 번수(필드)
  }
  ```
  
- 지역 변수
  - 메서드에 선언 (메서드가 끝나면 제거됨)
  - 특정 지역에서만 사용되는 변수
  - 매개변수도 지역 변수의 한 종류

  #### 예시
  ```JAVA
   public class StudentMain {
       public static void main(String[] args) {
           int a = 1; // 지역 변수
           Student student1; // 지역 변수
           student1 = new Student();
           Student student2 = new Student(); // 지역변수
    }
  }
  ```

### 2) 변수의 값 초기화
- 멤버 번수(필드) : 자동 초기화
  - 인스턴스를 생성할 때 자동으로 초기화된다.
  ex) `int = 0`, `boolean = false`, `참조형 = null`
  - 개발자가 초기값 직접 지정 가능
  ```
  public class Student {
    String name; // 초기화 안했으므로 null로 초기화 됨
    int age; // 초기화 안했으므로 0으로 초기화 됨
    int grade = 90;  // 90으로 직접 초기화
  }
  ```
    
- 지역 변수 : 수동 초기화
  - 개발자가 항상 직접 초기화해야 한다.
  ```JAVA
   public class StudentMain {
       public static void main(String[] args) {
           Student student = new Student();
           System.out.println(student.name); // null
           System.out.println(student.age); // 0
           System.out.println(student.grade); // 90
    }
  }
  ```

### 3) null
멤버 번수(필드)의 참조형 변수는 `null`로 초기화 한다고 하였다.
#### `null`은 아직 가리키는 대상이 없다, 존재하지 않는, 혹은 없다는 뜻이다.
```JAVA
public class Data {
  int value;
}
```

#### 예시
아래와 같은 코드가 있다.
```JAVA
   public class DataMain {
       public static void main(String[] args) {
           Data data = null; // 1.
           data = new Data(); // 2.
           data = null; // 3.
    }
  }
```

한줄한줄 자세히 살펴보며 메모리에 어떻게 적재되는지 살펴보자.

1. ```JAVA
   Data data = null; // null
   ```
   1. Data라는 타입을 가진 객체의 이름을 data로 선언
   2. data의 객체에 null 값으로 초기화

    <br>
    <img src="https://github.com/user-attachments/assets/6fe437ce-8052-4893-9164-8edb11e4587f" width="30%" />

2. ```JAVA
   data = new Data(); // ref.Data@a09ee92 (data 주소값 예시)
   ```
   1. data의 타입을 가진 참조형 변수에 Data 인스턴스 지정
   2. data는 참조형 변수이므로, data에는 데이터에 접근하기 위한 Data 인스턴스의 참조(주소)값을 저장 // 참조(주소)값 예시: @a09ee92)
   3. Data 안에는 value가 있다. (value는 자동 초기화로 인해 0으로 초기화 됨)

    <br>
    <img src="https://github.com/user-attachments/assets/d23fcca1-aeca-4c03-8ae5-95dcb9ae660b" width="30%" />

3. ```JAVA
   data = null; // null
   ```

   1. data가 기존에 참조하고 있던 Data 인스턴스를 참조 해제 **(⭐️ data는 더이상 Data 인스턴스를 참조하지 않는다. ⭐️)**
   2. data의 객체에 null 할당
  
   <br>
   <img src="https://github.com/user-attachments/assets/2953903e-9b9c-4344-95d1-e743b3187731" width="30%" />

#### Garbage Collection : 쓰레기 수집기

<img src="https://github.com/user-attachments/assets/3f39a6a2-7c21-4761-abf0-8a3a1d00776e" width="30%" />

위 3번에서 data는 더이상 Data 인스턴스를 참조하지 않는다고 하였다. 

이 부분을 자세히 들여다보자.
data에 null을 할당하면서 data는 Data의 인스턴스의 참조를 해제하였다. 
이렇게 아무것도 참조하지 않게 되면 Data의 인스턴스는 갈 길을 잃었다...🥲🥲

자바에서 객체는 해당 객체를 참조하는 곳이 있으면 JVM이 종료할 때까지 계속 생존한다.
그런데 중간에 **⭐️해당 객체를 참조하는 곳이 모두 사라지면 그떄 JVM은 필요 없는 객체로 판단하고 GC(Grabage Collection)를 사용해서 제거한다.⭐️** 

그래서 ref.Data@a09ee92 참조값을 가지는 Data 인스턴스는 JVM의 GC에 의해 제거되었다.

### 4) NullPointerException
만약 참조값 없이 객체를 찾아가면 어떤 문제가 발생할까? 이 경우 `NullPointerException` 이라는 예외가 발생한다.
`NullPointerException` 은 이름 그대로 `null` 을 가리키다(Pointer)라는 의미이다. **`null` 은 없다는 뜻이므로, 결국 주소가 없는 곳을 찾아갈 때 발생하는 예외이다.**

참조형 변수에 `.` (dot)을 사용하면 해당 객체를 찾아갈 수 있다. 만약 참조형 변수가 `null`을 가리킨다면 값이 없다는 뜻이므로, 찾아갈 수 있는 객체(인스턴스)가 없다.
`NullPointerException` 은 이처럼 `null` 에 `.` (dot)을 찍었을 때 발생한다.

#### 예시
아래와 같은 코드가 있다.
```JAVA
   public class DataMain {
       public static void main(String[] args) {
           Data data = null;
           System.out.println("data.value = " + data.value); // NullPointerException
    }
  }
```

위에서 data는 null을 할당받은 참조형 변수이다. null 값에 value 객체를 꺼내려고 하니 `NullPointerException` 예외가 발생하고, 프로그램이 종료된다.

결과
```
Exception in thread "main" java.lang.NullPointerException: Cannot read field "value1" because "data" is null
	at ref.initMain.main(initMain.java:8) // NullPointerException 발생

Process finished with exit code 1 // 프로그램 종료
```
