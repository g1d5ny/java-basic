# 1. 기본형과 참조형
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
### 1) 기본형은 들어있는 값을 그대로 계산에 사용 가능
```JAVA
int a = 10, b = 20;
int sum = a + b;
```
### 2) 참조형은 들어있는 `참조값`을 그대로 사용 불가
주소지만 가지고는 할 수 있는게 없음.

```JAVA
Student s1 = new Student(); // s1 = ref.Student@a09ee92 (s1에는 주소값이 존재)
Student s2 = new Student(); // s2 = ref.Student@a09ee92 (s2에는 주소값이 존재)
System.out.println(s1 + s2); // ref.Student@a09ee92ref.Student@a09ee92 (계산할 값이 없음. 참조값 붙여 출력)
```

값은 주소지에 가야 확인할 수 있다.
 ```JAVA
Student s1 = new Student();
s1.grade = 100; // 값 확인

Student s2 = new Student();
s2.grade = 90; // 값 확인

int sum = s1.grade + s2.grade; // 값을 꺼내 계산함
```

<br>

## 2. 변수 대입

#### 💡 자바는 항상 변수의 값을 복사해서 대입한다.!!

자바에서 변수에 값을 대입하는 것은 변수에 들어있는 값을 복사해서 대입하는 것이다.

### 1) 기본형 대입
- 변수에 들어있는 실제 사용하는 값을 복사하여 대입한다.

```JAVA
int a = 10;
int b = a; // b에 a의 값인 10을 복사해서 대입.
```

결과: a = 10, b = 10

<img src="https://github.com/user-attachments/assets/03f284db-e8fc-4902-a265-ea335768c35d" width="50%"/>

### 2) 참조형 대입
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

메서드로 기본형 데이터를 전달하면 해당 값이 복사되어 전달된다.
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

메서드로 참조형 데이터를 전달하면 참조값(주소값)이 복사되어 전달된다.
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


