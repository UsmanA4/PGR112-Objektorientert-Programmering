package redoing.the.exam;

public class TableTennisRacket2 extends Equipment2{
   private final String TYPE ="TableTennisRacket";
    private boolean newFace;

    public boolean isNewFace() {
        return newFace;
    }

    public void setNewFace(boolean newFace) {
        this.newFace = newFace;
    }
    public TableTennisRacket2(int id){
        super(id);
        this.newFace=false;
    }

}

