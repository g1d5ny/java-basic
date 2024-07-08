package extends1.ex;

public class Album extends Item {
    String author;

    public Album(String name, int price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    void print() {
        super.print();
        System.out.println("- 아티스트: " + author);
    }
}
