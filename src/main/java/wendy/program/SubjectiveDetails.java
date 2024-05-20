package wendy.program;

public class SubjectiveDetails extends Details {
    int subjectiveDifficulty;
    int starRate;
    int countPlay;

    public SubjectiveDetails(String region, String storename, String themename, String genre, int price, int difficulty, int subjectiveDifficulty, int starRate, int countPlay) {
        super(region, storename, themename, genre, price, difficulty);
        this.subjectiveDifficulty = subjectiveDifficulty;
        this.starRate = starRate;
        this.countPlay = countPlay;
    }

    public int getSubjectiveDifficulty() {
        return subjectiveDifficulty;
    }

    public int getStarRate() {
        return starRate;
    }

    public int getCountPlay() {
        return countPlay;
    }

    public void setSubjectiveDifficulty(int subjectiveDifficulty) {
        this.subjectiveDifficulty = subjectiveDifficulty;
    }

    public void setStarRate(int starRate) {
        this.starRate = starRate;
    }

    public void setCountPlay(int countPlay) {
        this.countPlay = countPlay;
    }
}
