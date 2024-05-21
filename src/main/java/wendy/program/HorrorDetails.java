package wendy.program;

public class HorrorDetails extends Details{
    double fearIndex;
    public HorrorDetails(String region, String storename, String themename, String genre, int price, double difficulty, double fearIndex) {
        super(region, storename, themename, genre, price, difficulty);
        this.fearIndex = fearIndex;
    }

    public double getFearIndex() {
        return fearIndex;
    }
}
