package wendy.program;

public class ThemeDetail extends EscapeRoom{
    String genre;
    String price;
    int difficulty;
    String region;

    public ThemeDetail(String themename, String themecontent, String storename, String genre, String price, int difficulty, String region) {
        super(themename, themecontent, storename);
        this.genre = genre;
        this.price = price;
        this.difficulty = difficulty;
        this.region = region;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getRegion() {
        return region;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
