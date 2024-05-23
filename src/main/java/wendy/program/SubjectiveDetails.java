package wendy.program;

public class SubjectiveDetails extends EscapeRoom {
    double subjectiveDifficulty;
    double starRate;
    int playMember;

    public SubjectiveDetails(String region, String storename, String themename, String genre, int price, double difficulty, double subjectiveDifficulty, double starRate, int playMember) {
        super(region, storename, themename, genre, price, difficulty);
        this.subjectiveDifficulty = subjectiveDifficulty;
        this.starRate = starRate;
        this.playMember = playMember;
    }

    public double getSubjectiveDifficulty() {
        return subjectiveDifficulty;
    }

    public double getStarRate() {
        return starRate;
    }

    public int getPlayMember() {
        return playMember;
    }
}
