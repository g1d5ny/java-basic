package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        String[] names = {"학생1", "학생2"};
        int[] age = {15, 16};
        int[] grade = {90, 80};

        for (int i = 0; i < names.length; i++) {
            System.out.println("이름: " + names[i] + " 나이: " + age[i] + " 성적: " + grade[i]);

        }
    }
}
