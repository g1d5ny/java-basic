package pack;

import pack.a.User;

public class PackageMain3 {
    public static void main(String[] args) {
        User userA = new User();
        pack.b.User  userB = new pack.b.User(); // pack.a에도 User가 있기 때문
    }
}
