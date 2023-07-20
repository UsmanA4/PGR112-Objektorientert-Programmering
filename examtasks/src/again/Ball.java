package again;

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

    public static Ball chooseAppropiateBall(int id , String ballType){
        String type = ballType.toLowerCase();
        switch (type){
            case "football"->{
                return new Football(id);
            }
            case "volleyball"->{
                return new Volleyball(id);
            }
            case "basketball"->{
                return new Basketball(id);
            }
            case "handball"->{
                return new Handball(id);
            }
            default -> {throw new IllegalArgumentException("Something went wrong!");}

        }
    }



}
