package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    void initMember(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // 자바가 기본 생성자 만들어줌
    MemberInit() {

    }
}
