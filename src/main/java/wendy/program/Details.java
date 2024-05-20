package wendy.program;

public class Details extends EscapeRoom{
    String themename;
    String genre;
    int price;
    double difficulty;

    public Details(String region, String storename, String themename, String genre, int price, double difficulty) {
        super(region, storename);
        this.themename = themename;
        this.genre = genre;
        this.price = price;
        this.difficulty = difficulty;
    }

    public String getThemename() {
        return themename;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setThemename(String themename) {
        this.themename = themename;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
