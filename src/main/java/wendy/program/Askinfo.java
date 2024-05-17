package wendy.program;

public class Askinfo {
    String name;
    int PlayCount;

    public Askinfo(int playCount, String name) {
        PlayCount = playCount;
        this.name = name;
    }

    public Askinfo(int playCount) {
        this.name = "익명";
        PlayCount = playCount;
    }
}
