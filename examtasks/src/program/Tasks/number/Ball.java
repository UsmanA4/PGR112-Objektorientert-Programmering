package program.Tasks.number;

import java.util.Locale;

public abstract class Ball extends Equipment {

    private boolean hasAir;
    public boolean isHasAir() {
        return hasAir;
    }

    public void setHasAir(boolean hasAir) {
        this.hasAir = hasAir;
    }

    public Ball(int id){
        super(id);
        this.hasAir=false;
    }

    public static Ball chooseAppropriateBall(int id, String type){
        String typeNoCase = type.toLowerCase();
        switch (typeNoCase){
            case "Football" ->{
                return new FootBall(id);
            } case "Basketball"->{
                return new BasketBall(id);
            } case "Handball"->{
                return new HandBall(id);
            } case "Volleyball"->{
                return new VolleyBall(id);
            }default -> {
                throw  new IllegalArgumentException("This is not a valid input..");
            }
        }

    }

    public abstract String getType();

    /**


    public static Ball chooseAppropriateBall(int id, String type) {
        String typeNoCase = type.toLowerCase();
        switch (typeNoCase) {
            case "football " -> {
                 return new FootBall(id);
            }
            default -> {
              throw new IllegalArgumentException("this is not a valid input or ball");
            }
        }


    }


    public abstract String getType(); */

}
