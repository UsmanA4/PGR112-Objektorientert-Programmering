package Tasks;

public class Game {
    private int id;
    private String title;
    private int releaseYear;
    private GGenre genre;

    public Game(int id, String title , int releaseYear, GGenre genre){
        this.id=id;
        this.title=title;
        this.releaseYear=releaseYear;
        this.genre=genre;
    }
    public  Game(String title , int releaseYear , GGenre genre){
        this.title=title;
        this.releaseYear=releaseYear;
        this.genre=genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public GGenre getGenre() {
        return genre;
    }

    public void setGenre(GGenre genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Game{" + "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", releaseYear=" + this.releaseYear +
                ", genre=" + this.genre +
                '}';
    }
}
