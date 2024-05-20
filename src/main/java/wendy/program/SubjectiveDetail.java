package wendy.program;

public class SubjectiveDetail extends ThemeDetail{
    int subjectiveDifficulty;
    int starRate;
    int countPlay;

    public SubjectiveDetail(String themename, String themecontent, String storename, String genre, String price, int difficulty, String region, int subjectiveDifficulty, int starRate, int countPlay) {
        super(themename, themecontent, storename, genre, price, difficulty, region);
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
