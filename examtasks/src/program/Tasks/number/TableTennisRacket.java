package program.Tasks.number;

public class TableTennisRacket extends Equipment{


    private boolean newFace;


    public TableTennisRacket(int id) {
        super(id);
        this.newFace =false;
    }
    public boolean isNewFace() {
        return newFace;
    }

    public void setNewFace(boolean newFace) {
        this.newFace = newFace;
    }

}
