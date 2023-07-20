package exam.practice;

public class Basketball extends Ball {
    private final String TYPE ="Basketball";

    public Basketball(int id) {
        super(id);
    }

    public String getTYPE() {
        return TYPE;
    }
}
