package exam.practice;

public class Ball extends Equipment {
    private boolean isAir;

    public Ball(int id) {
        super(id);
        this.isAir=false;
    }

    public boolean isAir() {
        return isAir;
    }

    public void setAir(boolean air) {
        isAir = air;
    }

    public static Ball chooseAppropiateBall(int id , String type){
        String chooseType = type.toLowerCase();
        switch (chooseType){
            case "football"->{
              return new Football(id);
            }
            case "handball"->{
                return new Handball(id);
            }
            case "volleyball"->{
                return new Volleyball(id);
            }
            case "basketball"->{
                return new Basketball(id);
            }
            default -> {
                throw new IllegalArgumentException("This is not a valid input");
            }
        }
    }

}
