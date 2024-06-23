package pack;
import pack.a.*; // package.a 내에 있는 모든 클래스 사용 가능

public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data();
        User user = new User(); // import 사용으로 패키지명 생략 가능
        User2 user2 = new User2(); // import 사용으로 패키지명 생략 가능
    }
}
