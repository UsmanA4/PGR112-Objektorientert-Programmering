package exam.practice;

public class Football extends Ball {
    private final String TYPE = "Football";

    public Football(int id) {
        super(id);
    }

    public String getTYPE() {
        return TYPE;
    }
}
