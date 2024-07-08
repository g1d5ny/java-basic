package extends1.ex;

public class Movie extends Item {
    String author;
    String director;

    public Movie(String name, int price, String author, String director) {
        super(name, price);
        this.author = author;
        this.director = director;
    }

    @Override
    void print() {
        super.print();
        System.out.println("- 감독: " + author + ", 배우: " + director);
    }

}
