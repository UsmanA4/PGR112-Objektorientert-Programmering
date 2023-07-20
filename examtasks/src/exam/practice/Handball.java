package exam.practice;

public class Handball extends Ball {
    private final String TYPE = "Handball";

    public Handball(int id) {
        super(id);
    }

    public String getTYPE() {
        return TYPE;
    }
}
