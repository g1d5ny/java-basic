package static1;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count=" + Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println("B count=" + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("C count=" + Data3.count);

        // 추가
        Data3 data4 = new Data3("D");
        // 인스턴스를 통한 접근
        System.out.println(data4.count); // data4 -> Data3에 있는 static 영역의 count 가져옴, 권장 X
        // 클래스를 통한 접근
        System.out.println(Data3.count);

    }
}
