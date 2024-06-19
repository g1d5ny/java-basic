package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    // 추가
    MemberConstruct(String name, int age) {
        this(name, age, 50);
        System.out.println("11 생성자 호출 name = " + name + ", age = " + age);
    }

    // 생성자명과 클래스명이 같아야함
    MemberConstruct(String name, int age, int grade) {
        System.out.println("22 생성자 호출 name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
