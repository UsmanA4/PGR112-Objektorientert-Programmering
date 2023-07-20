package redoing.the.exam;

import java.lang.reflect.Type;


public abstract class Ball2  extends Equipment2{
    private boolean hasAir;

  public Ball2(int id){
        super(id);
        this.hasAir=false;
    }



    public boolean isHasAir() {
        return hasAir;
    }

    public void setHasAir(boolean hasAir) {
        this.hasAir = hasAir;
    }
    public static Ball2 chooseAppropriateBall(int id , String type){ /*må omgjøres til static for å arves*/
      String chooseType = type.toLowerCase();
      switch (chooseType){
          case "football"->{
              return new FootBall2(id);
          }
          case "handball"->{
              return new HandBall2(id);
          }
            case "basketball"->{
            return new BasketBall2(id);
        }
           case "volleyball"->{
              return new VolleyBall2(id);
           }
          default -> {
              throw new IllegalArgumentException("This is not a type"+chooseType);
          }
      }
    }
    public abstract String getType();






















    /**
    private boolean hasAir;
    public boolean isHasAir() {
        return hasAir;
    }

    public void setHasAir(boolean hasAir) {
        this.hasAir = hasAir;
    }



    public Ball2(int id) {
        super(id);
        this.hasAir=false;
    }
     public static Ball2 chooseAppropriateBall(int id, String type){
        String chooseBall = type.toLowerCase();
        switch (chooseBall){
            case "football"->{
                 return new FootBall2(id);
            }
            case "handball"->{
                return new HandBall2(id);
            }
            case "basketball"->{
                return new BasketBall2(id);
            }
            case "volleyball"->{
                return new VolleyBall2(id);
            }

            default -> {
                throw new IllegalArgumentException("This is an invalid input"+type);
            }
        }
     }

     public abstract String getType();


    /**
    private boolean hasAir;

    public Ball2(int id){
        super(id);
        this.hasAir=false;
    }

    public boolean isHasAir() {
        return hasAir;
    }

    public void setHasAir(boolean hasAir) {
        this.hasAir = hasAir;
    }
    public static Ball2 chooseAppropriateBall(int id , String type){
        String chooseType = type.toLowerCase();
        switch (chooseType){
            case "football"->{
              return new FootBall2(id);
            }
            case "handball" ->{
                return new HandBall2(id);
            }case "volleyball" ->{
                return new VolleyBall2(id);
            }
            case "basketball" ->{
                 return new BasketBall2(id);
            }
            default -> {
                throw new IllegalArgumentException("This in not valid " + type);








            }
        }
        }
        public abstract String getType();
     */
}