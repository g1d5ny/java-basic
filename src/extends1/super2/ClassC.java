package extends1.super2;

public class ClassC extends ClassB{
    public ClassC() {
        super(10, 20); // 내가 정의한 생성자의 파라미터 인자에 값 추가
        System.out.println("ClassC 생성자");
    }
}